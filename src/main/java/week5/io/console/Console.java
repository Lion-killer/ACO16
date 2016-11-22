package week5.io.console;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by gorobec on 06.11.16.
 */
public class Console {

    private static final String LOCATION = "C:\\Users\\bilousyv\\IdeaProjects\\ACO16\\src\\main\\resources";

    public static void main(String[] args) throws MyErrorInExpression, IOException {

        ConsoleCommands cc = new ConsoleCommands(LOCATION);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(cc.pwd() + ":$ ");

            String command = sc.nextLine();

            String[] words = command.split(" ");

            if (words.length == 0) continue;

            String commandName = words[0];

            switch (commandName){
                case "pwd":
                    System.out.println(cc.pwd());
                    break;
                case "ls":
                    cc.ls(words);
                    break;
                case "cd":
                    cc.cd(words);
                    break;
                case "mkdir":
                    cc.mkdir(words);
                    break;
                case "touch":
                    cc.touch(words);
                    break;
                case "cp":
                    cc.cp(words);
                    break;
                case "mv":
                    cc.mv(words);
                    break;
                case "rm":
                    cc.rm(words);
                    break;
                case "tree":
                    cc.tree();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Command not found.");
            }
        }
    }
}
