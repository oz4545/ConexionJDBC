import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletGetPost extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodo = request.getMethod(); // Obtiene el método HTTP (GET, POST, etc.)

        if ("GET".equals(metodo)) {
            // Manejar solicitudes GET
            procesarGet(request, response);
        } else if ("POST".equals(metodo)) {
            // Manejar solicitudes POST
            procesarPost(request, response);
        } else {
            // Otros métodos HTTP
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }

    private void procesarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Solicitud GET</title></head><body>");
        out.println("<h1>Manejando una solicitud GET</h1>");
        out.println("</body></html>");
    }

    private void procesarPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Solicitud POST</title></head><body>");
        out.println("<h1>Manejando una solicitud POST</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        // Este método se llama cuando el servlet se destruye o se despliega.
        // Puedes realizar tareas de limpieza, como cerrar conexiones de bases de datos.
    }
}
