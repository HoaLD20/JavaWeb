package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hoald
 */
@WebFilter(filterName = "MD5Filter", urlPatterns = "/LoginServlet")
public class MD5Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encpas = req.getParameter("txtpassword");
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(encpas.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            req.setAttribute("pass", hashtext);
            chain.doFilter(req, resp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

        public void init(FilterConfig config) throws ServletException {

    }

}
