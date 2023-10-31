import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

@WebServlet("/HolaMundoServlet")
public class ServletJSP.java extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Hola Mundo</title></head><body>");
        out.println("<h1>Hola Mundo desde un servlet</h1>");
        out.println("</body></html>");
        out.close();
    }
}
