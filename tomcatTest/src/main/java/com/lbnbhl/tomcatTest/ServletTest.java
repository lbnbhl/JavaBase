package com.lbnbhl.tomcatTest;


import javax.servlet.Filter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @autor wwl
 * @date 2022/9/3-15:18
 */
public class ServletTest extends HttpServlet {
//    1、执行 Servlet 构造器方法
//    2、执行 init 初始化方法
//    第一、二步，是在第一次访问，的时候创建 Servlet 程序会调用。
//    3、执行 service 方法
//    第三步，每次访问都会调用。
//    4、执行 destroy 销毁方法
//    第四步，在 web工程停止时调用
    public ServletTest(){
        System.out.println("我是一个构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是初始化方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getInitParameter("username"));
        ServletContext servletContext = getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        System.out.println(initParameterNames.nextElement());
        System.out.println(servletContext.getInitParameter("password"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是service方法");
        String method = req.getMethod();
        if ("Get".equalsIgnoreCase(method)){
            doGet(req,resp);
        }
        System.out.println(req.getRequestURI());
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("少小离家老大回");
        resp.sendRedirect("https://www.baidu.com/");
    }

    @Override
    public void destroy() {
        System.out.println("我是销毁方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求是get请求");
    }

//    ServletConfig 类的三大作用
//1、可以获取 Servlet 程序的别名 servlet-name 的值
//2、获取初始化参数 init-param
//3、获取 ServletContext

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

}
