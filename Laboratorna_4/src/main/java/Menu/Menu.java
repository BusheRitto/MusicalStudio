package Menu;

import Command.Command;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.printLine;

public class Menu {
    private ArrayList<Command> commands = new ArrayList<>();


    public void addCommand(Command command) {
        commands.add(command);
    }

    public void showMenu() {
        printLine(70);
        System.out.println("\t\t\t\t\t\t\tМеню");
        printLine(70);
        int option = 1;
        for (Command command : commands) {
            System.out.println(option + ". " + command.getDescription());
            option++;
        }
        System.out.println(option + ". Вихід");
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            showMenu();
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice < commands.size() + 1) {
                Command selectedCommand = commands.get(choice - 1);
                selectedCommand.execute();
            } else if (choice == commands.size() + 1) {
                run = false;

            } else {
                System.out.println("Некоректний вибір.");
            }
        }
    }


}