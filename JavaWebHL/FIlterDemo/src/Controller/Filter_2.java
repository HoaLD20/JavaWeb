package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hoald
 */
//@WebFilter(filterName = "Filter_2", urlPatterns = "/MyServlet")
public class Filter_2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String s = (String) req.getAttribute("name");
        s += "- <a href='#'>Logout</a>";
        req.setAttribute("name", s);
        //muon xu li cai gi thi viet truoc cai chain nay nhe
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
