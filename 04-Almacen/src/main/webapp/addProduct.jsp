<%@ page import="com.almacen.model.Product"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Agregar o Modificar Producto</title>
</head>
<body>
	<h1>Agregar o Modificar Producto</h1>
	<form action="products" method="get">
		<input type="hidden" name="action" value="edit"> Buscar producto por nombre: <input type="text" name="name" required>
		<input type="submit" value="Buscar">
	</form><br>
	<!--Buscamos el valor, si lo encuentra cogemos la informacion y la mostramos en los campos para poder modificarla o simplemente verla-->
	<%
	Boolean found = (Boolean) request.getAttribute("found");
	if (found != null && found) {
		Product product = (Product) request.getAttribute("product");
	%><p>Producto encontrado:
		<%=product.getName()%></p>
	<%
	} else if (found != null && !found) {
	%>
	<p>Producto no encontrado.</p>
	<%}%>
	<form action="products" method="post">
		<input type="hidden" name="action" value="add"> Nombre: <input
			type="text" name="name"
			value="<%=(request.getAttribute("product") != null) ? ((Product) request.getAttribute("product")).getName() : ""%>"
			required><br> Categoría: <input type="text"
			name="category"
			value="<%=(request.getAttribute("product") != null) ? ((Product) request.getAttribute("product")).getCategory() : ""%>"
			required><br> Precio: <input type="text" name="price"
			value="<%=(request.getAttribute("product") != null) ? ((Product) request.getAttribute("product")).getPrice() : ""%>"
			required><br> Stock: <input type="text" name="stock"
			value="<%=(request.getAttribute("product") != null) ? ((Product) request.getAttribute("product")).getStock() : ""%>"
			required><br> <br><input type="submit" value="Guardar">
	</form>
	<br><a href="products?action=list">Cancelar</a>
</body>
</html>

