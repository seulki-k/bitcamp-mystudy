/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;
        ProjectMenu project = new ProjectMenu();

        ProjectMenu.project();

        while (choice) {
            String menu = scanner.next();
            choice = ProjectMenu.menu(menu);
        }
    }
}
