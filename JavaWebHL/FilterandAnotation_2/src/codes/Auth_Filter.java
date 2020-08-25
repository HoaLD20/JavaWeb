package codes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


import java.io.IOException;

/**
 * @author hoald
 */
@WebFilter(filterName = "Auth_Filter")
public class Auth_Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        RequestWrapper wrappedRequest = new RequestWrapper ((HttpServletRequest) request);
        ResponseWrapper wrappedResponse = new ResponseWrapper ((HttpServletResponse) response);

        HttpServletRequestWrapper

        doBeforeProcessing(wrappedRequest, wrappedResponse);
        Throwable problem = null;
        try {
            HttpServletRequest req = (HttpServletRequest) wrappedRequest;
            HttpServletResponse res = (HttpServletResponse) wrappedResponse;
            HttpSession session = req.getSession();
            String requestURL = req.getRequestURI();

            if (session.getAttribute("login") != null
                    || requestURL.endsWith("login.jsp")
                    || requestURL.contains("/action/")) {
                chain.doFilter(wrappedRequest, wrappedResponse);
            } else {
                if (requestURL.contains("/protected/")) {
                    String loginURL = req.getScheme()+"://"+
                            req.getServerName()+":"+req.getServerPort()
                            +"/Lab04_Authenticate_UserRequest_TomcatUser/login.jsp";
                    res.sendRedirect(loginURL+"?returnURL="+requestURL);
                }else
                {
                    chain.doFilter(wrappedRequest, wrappedResponse);
                }
            }
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(wrappedRequest, wrappedResponse);

        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
