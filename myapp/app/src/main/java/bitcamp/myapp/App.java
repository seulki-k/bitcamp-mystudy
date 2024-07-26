package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.listener.InitialApplicationListener;
import bitcamp.util.Prompt;

import java.util.ArrayList;
import java.util.List;

public class App {

    List<ApplicationListener> listeners = new ArrayList<>();
    ApplicationContext appCtx = new ApplicationContext();
    public static void main(String[] args) {
        App app = new App();

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
        try {
            appCtx.getMainMenu().execute();

        } catch (Exception ex) {
            System.out.println("실행 오류!");
            ex.printStackTrace();

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
