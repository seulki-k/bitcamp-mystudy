package bitcamp.myapp.servlet.user;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import bitcamp.net.Prompt;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/view")
public class UserViewServlet extends GenericServlet {


    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        // 서블릿 컨테이너 --> init(ServletConfig) --> init() 호출한다.
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html >");
        out.println("<html lang>");
        out.println("<head >");
        out.println("<meta charset = 'UTF-8' >");
        out.println("<title > Title_User </title >");
        out.println("<link rel='stylesheet' href='/css/common.css'>");
        out.println("</head >");
        out.println("<body >");

        try {
            out.println("<header >");
            out.println("<a href = '/' ><img src = '/images/home.png'></a >");
            out.println("<span > 프로젝트 관리 시스템</span >");
            out.println("</header >");

            out.println("<h1>회원 조회</h1>");

            int userNo = Integer.parseInt(req.getParameter("no"));


            User user = userDao.findBy(userNo);
            if (user == null) {
                out.println("<p>없는 회원입니다.</p>");
                out.println("</body >");
                out.println("</html >");
                return;
            }

            out.printf("<form action='/user/update'>");
            out.printf("번호 : <input name='no' readonly type='text' value='%d'><br>\n",user.getNo());
            out.printf("이름 : <input name='name' type='text' value='%s'><br>\n",user.getName());
            out.printf("이메일 : <input name='email' type='email' value='%s'><br>\n",user.getEmail());
            out.println("암호 : <input name='password' type='password'><br>\n");
            out.printf("연락처 : <input name='tel' type='tel' value='%s'><br>\n",user.getTel());
            // type 생략하면 button type = submit
            out.println("<button>변경</button>");
            out.printf("<button type='button' onclick='location.href=\"/user/delete?no=%d\"'>삭제</button>\n",user.getNo()); // type 을 생략하면 submit 이 디폴트
            out.printf("</form>");

        } catch (Exception e) {
            out.println("<p>조회 중 오류 발생!</p>");
        }
        out.println("</body >");
        out.println("</html >");
    }
}
