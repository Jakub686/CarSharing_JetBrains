import java.util.Scanner;
import View.View;

public class MenuLoggedIn {
    public static void loggedIn() {
        Scanner scanner = new Scanner(System.in);
        boolean endCondition = true;

        //Menu when logged in
        do {
            View.showCompanyList();
            View.showCreateACompany();
            View.showBack();

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    IsTableEmpty.isTableEmpty();
                    ReadTable.readTable();
                    break;
                case "2":
                    InsertTable.insertTable();
                    break;
                case "0":
                    endCondition = false;
                    break;
            }
        } while (endCondition);
    }
}
