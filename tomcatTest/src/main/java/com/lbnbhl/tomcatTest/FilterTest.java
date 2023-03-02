package com.lbnbhl.tomcatTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 多个Filter的执行顺序
 *         上面我们配置了2个过滤器，那么我们怎么知道那个过滤器先执行呢？其实大家可以直接使用代码进行验证，培养独立思考的习惯，这里我就直接给出答案了。
 *
 * 如果我们是在web.xml中配置的过滤器，那么过滤器的执行顺序就是<filter-mapping>在web配置的顺序，配置在上面那么就会先执行。
 * 如果我们是使用@WebFilter进行配置的，那么执行顺序就是字符比较顺序来执行，例如有2个过滤器，一个是AFilter，一个是BFilter，那么AFilter就会先执行。
 * 如果注解和xml混用，那么在web.xml中配置的会先执行。
 * @autor wwl
 * @date 2022/9/3-16:55
 */
@WebFilter(urlPatterns = "/servletTest")
public class FilterTest implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println(filterConfig.getFilterName());
//        Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("hhhhhhhhhhh");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
