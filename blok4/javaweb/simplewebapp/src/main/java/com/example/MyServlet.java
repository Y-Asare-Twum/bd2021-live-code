package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    private String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("DO GET CALLED");

        readFromRequest(req); // http://localhost:8082/my?name=john
        writeToResponse(req, resp);
    }

    private void readFromRequest(HttpServletRequest req) {
        this.name = req.getParameter("name");
        System.out.printf("Name = %s %n", name);
    }

    private void writeToResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Write to the response, for example either:

        // 1) text
        resp.getWriter().write("Hello " + (name != null ? name : ""));

        // 2) json
        // resp.getWriter().write("{\"message\": \"Hello\"}");

        // 3) HTML
        // resp.getWriter().write(
        //         "<html>\n" +
        //                 "    <body>\n" +
        //                 "        <h2>Hello!</h2>\n" +
        //                 "        <a href=\"index.jsp\">Back</a>\n" +
        //                 "    </body>\n" +
        //                 "</html>");

        // 4) HTML with text blocks (Java 15+)
        // String title = "Hello text blocks!";
        // resp.getWriter().write("""
        //         <html>
        //             <body>
        //                 <h2>$title</h2>
        //                 <a href="index.jsp">Back</a>
        //             </body>
        //         </html>
        //         """.replace("$title", title));

        // 5) Using a jsp
        // req.getRequestDispatcher("myservlet.jsp").forward(req, resp);
    }

}
