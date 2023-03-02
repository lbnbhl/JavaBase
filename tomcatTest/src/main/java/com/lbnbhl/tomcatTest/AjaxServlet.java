package com.lbnbhl.tomcatTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor wwl
 * @date 2022/9/3-20:40
 */
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hhhhhhh");
        if (req.getMethod().equalsIgnoreCase("Post")) {
            resp.getWriter().print("{name:wwl,"+"age"+":18}");
        }
    }
}
