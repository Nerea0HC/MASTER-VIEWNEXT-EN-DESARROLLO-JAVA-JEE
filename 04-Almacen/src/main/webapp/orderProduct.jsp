<%@ page import="com.almacen.model.Product"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Realizar Pedido</title>
</head>
<body>
    <h1>Realizar Pedido</h1>

    <!--mensajes de éxito o error tras realizar el pedido-->
    <%
        String message = (String) request.getAttribute("message");
        Boolean orderSuccess = (Boolean) request.getAttribute("orderSuccess");
        if (message != null) {
            if (orderSuccess != null && orderSuccess) {
                out.println("<p style='color: green;'>" + message + "</p>");
            } else {
                out.println("<p style='color: red;'>" + message + "</p>");
            }
        }
    %>
    <form action="products" method="post">
        <input type="hidden" name="action" value="order"> 
        Seleccionar producto: 
        <select name="name" required>
            <option value="">Seleccione un producto</option>
            <!--desplegable con los productos que hay guardados -->
            <%
                List<Product> products = (List<Product>) request.getAttribute("products");
                for (Product product : products) {
            %>
                <option value="<%=product.getName()%>">
                    <%=product.getName()%> (Stock: <%=product.getStock()%>)
                </option>
            <%}%>
        </select>
        <br><br>
        Cantidad: <input type="number" name="quantity" min="1" required><br><br>
        <input type="submit" value="Realizar Pedido">
    </form>
    <a href="index.jsp">Cancelar</a>
</body>
</html>
