package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.listener.InitialApplicationListener;
import bitcamp.util.Prompt;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientApp {

    List<ApplicationListener> listeners = new ArrayList<>();
    ApplicationContext appCtx = new ApplicationContext();

    public static void main(String[] args) {
        ClientApp app = new ClientApp();

        //애플리케이션이 시작되거나 종료될 때 알림 받을 객체의 연락처를 등록한다.
        app.addApplicationListener(new InitialApplicationListener());

        app.execute();
    }

    private void addApplicationListener(ApplicationListener listener) {
        listeners.add(listener);
    }

    private void removeApplicationListener(ApplicationListener listener) {
        listeners.remove(listener);
    }

    void execute() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            //자바 객체를 바이트 스트림으로 변환하여 출력 스트림으로  보낸다.. 직렬화
            //소켓의 출력 스트림에 객체를 쓸 수 있도록 ObjectOutputStream을 생성, 객체를 네트워크로 전송
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //바이트 스트림을 자바 객체로 변환. 역직렬화
            //네트워크로부터 객체를 받는다.
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            appCtx.setAttribute("outputStream", out);
            appCtx.setAttribute("inputStream", in);

            // 애플리케이션이 시작될 때 리스너에게 알린다.
            for (ApplicationListener listener : listeners) {
                try {
                    listener.onStart(appCtx);
                } catch (Exception e) {
                    System.out.println("리스너 실행 중 오류 발생!");
                }
            }

            System.out.println("[프로젝트 관리 시스템]");

            appCtx.getMainMenu().execute();

            out.writeUTF("quit");
            out.flush();
        } catch (Exception ex) {
            System.out.println("실행 오류!");
            ex.printStackTrace();
        }


        System.out.println("종료합니다.");

        Prompt.close();

        // 애플리케이션이 종료될 때 리스너에게 알린다.
        for (ApplicationListener listener : listeners) {
            try {
                listener.onShutdown(appCtx);
            } catch (Exception e) {
                System.out.println("리스너 실행 중 오류 발생!");
            }
        }
    }
}
