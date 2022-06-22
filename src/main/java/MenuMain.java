
import java.util.Scanner;

import View.View;


public class MenuMain {
    public static void mainMenu() {
        boolean endCondition = true;
        Scanner scanner = new Scanner(System.in);

        //Main menu
        do {
            View.showLogInAsAManager();
            View.showExit();

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    MenuLoggedIn.loggedIn();
                    break;
                case "0":
                    endCondition = false;
                    break;
            }
        } while (endCondition);
    }
}

