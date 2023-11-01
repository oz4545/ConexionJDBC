import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class HttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar los datos del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");

        // Realizar algún procesamiento con los datos (en este caso, simplemente los mostramos)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Respuesta del Formulario</title></head><body>");
        out.println("<h1>Datos del Formulario</h1>");
        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Correo Electrónico: " + correo + "</p>");
        out.println("</body></html>");
    }
}
