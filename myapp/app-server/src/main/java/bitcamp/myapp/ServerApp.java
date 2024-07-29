package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.dao.skel.UserDaoSkel;
import bitcamp.myapp.listener.InitialApplicationListener;
import bitcamp.util.Prompt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerApp {

    List<ApplicationListener> listeners = new ArrayList<>();
    ApplicationContext appCtx = new ApplicationContext();

    public static void main(String[] args) {
        ServerApp app = new ServerApp();

        app.addApplicationListener(new InitialApplicationListener());
        app.execute();
    }

    private void addApplicationListener(ApplicationListener listener) {
        listeners.add(listener);
    }

    private void removeApplication(ApplicationListener listener) {
        listeners.remove(listener);
    }


    void execute() {
        //애플리케이션이 시작될 때 리스너에게 알린다.
        for (ApplicationListener listener : listeners) {
            try {
                listener.onStart(appCtx);
            } catch (Exception e) {
                System.out.println("리스너 실행 중 오류 발생!");
            }
        }

        //서버에서 사용할 Dao Skeletone 객체 준비
        UserDaoSkel userDaoSkel= (UserDaoSkel) appCtx.getAttribute("userDaoSkel");



        System.out.println("[서버 프로젝트 관리 시스템 시작!]");

        //(포트 번호(통신 식별번 호),대기열 크기(client 최대 접속 수)) 대기열 안넣으면 Default 값 선택
        try (ServerSocket serverSocket = new ServerSocket(8888);){
            System.out.println("서버 실행 중...");

            try(Socket socket = serverSocket.accept();) {
                System.out.println("클라이언트와 연결되었음!");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                String dataName = in.readUTF();

                switch (dataName) {
                    case "users" :
                        userDaoSkel.service(in,out);
                        break;
                    case "projects":
                        break;
                    case "boards":
                        break;
                    default:

                }
            }
        } catch (Exception e) {
            System.out.println("통신 중 오류 발생");
            e.printStackTrace();
        }

        System.out.println("종료합니다.");

        Prompt.close();
        //애플리케이션이 종료될 때 리스너에게 알린다.
        for (ApplicationListener listener : listeners) {
            try {
                listener.onShutdown(appCtx);
            } catch (Exception e) {
                System.out.println("리스너 실행 중 오류 발생!");
            }
        }
    }
}
