package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elena on 12.07.2016.
 */
public class ZeroToHeroServlet extends HttpServlet {
    private String handleRequest (HttpServletRequest req) {
        String resp;
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        return resp = "Hello <b>" + firstName + " " + lastName + "</b>! Enjoy Zero To Hero!!!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(handleRequest(req));
    }
}
