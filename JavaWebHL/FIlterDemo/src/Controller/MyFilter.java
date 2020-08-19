package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hoald
 */
@WebFilter(filterName = "MyFilter", urlPatterns = "/MyServlet")
public class MyFilter implements Filter {
    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //lay ho ten nguoi dung nhap vao va gui len servlet
        String s = req.getParameter("txtname");
        s = "xin chao , " + s;
        //tao ra 1 bien de qua servlet lay bien nay ra
        req.setAttribute("name", s);
        //muon xu li cai gi thi viet truoc cai chain nay
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
