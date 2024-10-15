<%@ page import="com.almacen.model.Product" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
</head>
<body>
    <h1>Lista de Productos</h1>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            for (Product product : products) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getCategory() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getStock() %></td>
            <td>
                <!-- eliminar el producto -->
                <form action="products" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="name" value="<%= product.getName() %>">
                    <input type="submit" value="Eliminar">
                </form>
                <!--enlace para modificar el producto y que aparezca la informacion rellenada, usamos el nombre como id-->
                <a href="products?action=edit&name=<%= product.getName() %>">Modificar</a>
            </td>
        </tr>
        <%}%>
    </table><br>
    <a href="index.jsp">Volver</a>
</body>
</html>

