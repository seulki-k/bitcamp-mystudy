package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project/form3")
public class ProjectForm3Servlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) this.getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //form1,form2 에서 입력한 값을 Project 객체에 담는다.
        try {
            Project project = (Project) req.getSession().getAttribute("project");

            String[] memberNos = req.getParameterValues("member");
            if (memberNos != null) {
                ArrayList<User> members = new ArrayList<>();
                for (String memberNo : memberNos) {
                    User user = userDao.findBy(Integer.parseInt(memberNo));
                    members.add(user);
                }
                project.setMembers(members);
            }

            res.setContentType("text/html;charset=UTF-8");
            req.getRequestDispatcher("/project/form3.jsp").include(req, res);
        } catch (Exception e) {

            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);

        }
    }

}
