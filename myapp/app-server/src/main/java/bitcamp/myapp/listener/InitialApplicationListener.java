package bitcamp.myapp.listener;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.HistoryCommand;
import bitcamp.myapp.command.board.*;
import bitcamp.myapp.command.project.*;
import bitcamp.myapp.command.user.*;
import bitcamp.myapp.dao.*;
import bitcamp.myapp.dao.skel.UserDaoSkel;

public class InitialApplicationListener implements ApplicationListener {
    UserDao userDao;
    ProjectDao projectDao;
    BoardDao boardDao;

    @Override
    public void onStart(ApplicationContext ctx) {
        userDao = new ListUserDao("data.xlsx");
        boardDao = new ListBoardDao("data.xlsx");
        projectDao = new ListProjectDao("data.xlsx", userDao);

        UserDaoSkel userDaoSkel = new UserDaoSkel(userDao);

        ctx.setAttribute("userDaoSkel", userDaoSkel);


    }

    @Override
    public void onShutdown(ApplicationContext ctx) {
        try {
            ((ListUserDao) userDao).save();
        } catch (Exception e) {
            System.out.println("회원 데이터 저장 중 오류 발생!");
            e.printStackTrace();
            System.out.println();
        }

        try {
            ((ListBoardDao) boardDao).save();
        } catch (Exception e) {
            System.out.println("게시글 데이터 저장 중 오류 발생!");
            e.printStackTrace();
            System.out.println();
        }

        try {
            ((ListProjectDao) projectDao).save();
        } catch (Exception e) {
            System.out.println("프로젝트 데이터 저장 중 오류 발생!");
            e.printStackTrace();
            System.out.println();
        }
    }
}
