package TestingCookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCookie")
public class AddCookie extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String data1 = request.getParameter("firstName");
        String data2 = request.getParameter("lastName");

        if (data1 == null) data1 = "";
        if (data2 == null) data2 = "";

        Cookie cookie1 = new Cookie("FirstCookie", data1);
        Cookie cookie2 = new Cookie("SecondCookie", data2);

        cookie1.setMaxAge(60 * 60); // 1 hour
        cookie2.setMaxAge(60 * 60);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head><title>Servlet AddCookie</title></head>");
        pw.println("<body>");
        pw.println("<b>Cookies have been set:</b><br>");
        pw.println("First Name: " + data1 + "<br>");
        pw.println("Last Name: " + data2);
        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
