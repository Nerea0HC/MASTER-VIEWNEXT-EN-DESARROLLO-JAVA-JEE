package com.almacen.controller;

import com.almacen.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet Controlador
 */
public class ProductCONTROL extends HttpServlet {
	private List<Product> products = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		/**
		 * Comprobamos la petición del usuario y navegamos a la pantalla
		 */
		if ("list".equals(action)) {
			request.setAttribute("products", products);
			request.getRequestDispatcher("listProducts.jsp").forward(request, response);
		} else if ("addForm".equals(action)) {
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);
		}
		/**
		 * Si el usuario ha buscado un producto, la acción será "edit" y nos pasará el
		 * nombre, llamamos al método para encontrar el producto y mostramos
		 */
		else if ("edit".equals(action)) {
			String name = request.getParameter("name");
			Product product = findProductByName(name);
			if (product != null) {
				request.setAttribute("product", product);
				request.setAttribute("found", true);
			} else {
				request.setAttribute("found", false);
			}
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);
		}
		/**
		 * Si el usuario quiere realizar un pedido, cogemos la lista con los productos y
		 * pasamos a la pantalla para realizar el pedido
		 */
		else if ("orderForm".equals(action)) {
			request.setAttribute("products", products);
			request.getRequestDispatcher("orderProduct.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		/**
		 * Comprobamos y añadimos productos
		 */
		if ("add".equals(action)) {
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			double price = Double.parseDouble(request.getParameter("price"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			Product product = findProductByName(name);
			if (product != null) {
				product.setCategory(category);
				product.setPrice(price);
				product.setStock(stock);
			} else {
				products.add(new Product(name, category, price, stock));
			}
			response.sendRedirect("products?action=list");
		} else if ("delete".equals(action)) {
			String name = request.getParameter("name");
			products.removeIf(product -> product.getName().equals(name));
			response.sendRedirect("products?action=list");
		}
		/**
		 * Realizar pedido comprobando si hay stock, si hay stock se resta la cantidad y si no hay suficiente lo notificamos. 
		 * Si no encuentra el producto también notifica
		 */
		else if ("order".equals(action)) {
			String name = request.getParameter("name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			Product product = findProductByName(name);
			if (product != null) {
				if (product.getStock() >= quantity) {
					product.setStock(product.getStock() - quantity);
					request.setAttribute("orderSuccess", true);
					request.setAttribute("message", "Pedido realizado con éxito.");
				} else {
					request.setAttribute("orderSuccess", false);
					request.setAttribute("message", "No hay suficiente stock para el pedido.");
				}
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("orderProduct.jsp").forward(request, response);
		}
	}

	/**
	 * Método simple para buscar productos por nombre
	 */
	private Product findProductByName(String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}
}
