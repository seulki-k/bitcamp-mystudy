package bitcamp.myapp.servlet.auth;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/form")
public class LoginFormServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/header").include(req, res); // HeaderServlet의 Service()를 호출
        PrintWriter out = res.getWriter();
        out.println("<h1>로그인</h1>");
        out.println("<form action='/auth/login'>");
        out.println("이메일 : <input name='email' type='email'><br>");
        out.println("암호 : <input name='password' type='password '><br>");
        out.println("<input type='submit' value='로그인'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
