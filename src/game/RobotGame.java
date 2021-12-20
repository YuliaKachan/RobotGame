package game;

import game.robot.Robot;

import java.util.Iterator;
import java.util.Scanner;

public class RobotGame {

    public static void main(String[] args) {
        Robot robot1 = new Robot();
        Robot robot2 = new Robot();
        setRobotName(robot1, robot2);

        RobotGame robotGame = new RobotGame();
        robotGame.playGame(robot1, robot2);
    }

    public void playGame(Robot robot1, Robot robot2) {
        while (robot1.isAlive() && robot2.isAlive()) {
            fight(robot1);
            fight(robot2);
            System.out.println("-----------------");
            System.out.println(String.format("Robot %s health %s ", robot1.getName(), robot1.getHealth()));
            System.out.println(String.format("Robot %s health %s ", robot2.getName(), robot2.getHealth()));
            System.out.println("-----------------");
        }
        checkHealth(robot1);
        checkHealth(robot2);
    }

    public void checkHealth(Robot robot) {
        if (robot.getHealth() <= 0) {
            System.out.println("The Game is finished");
            System.out.println(String.format("Robot %s lost", robot.getName()));
        }
    }

    public static void setRobotName(Robot robot1, Robot robot2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1st robot name ");
        String robot1Name = scanner.nextLine();
        System.out.println("Enter 2nd robot name ");
        String robot2Name = scanner.nextLine();
        robot1.setName(robot1Name);
        robot2.setName(robot2Name);
    }

    public static void printMenu(Robot robot) {
        System.out.println("Shoot at robot: " + robot.getName());
        System.out.println("Press any key (QWEASDZXC)");
        System.out.println("For exit press L");
    }

    public static char getCharFromUser() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.length() > 1) {
            System.out.println("Entered more than 1 symbols, the game have read just first symbol " + userInput.toCharArray()[0]);
        }
        if (userInput.length() == 0) {
            return ' ';
        }
        return userInput.toCharArray()[0];
    }

    public void fight(Robot robot) {
        printMenu(robot);
        char userInput = getCharFromUser();

        if (userInput == 'l' || userInput == 'L') {
            System.out.println("exiting");
            System.exit(0);
        } else if (isUserInputCorrect(userInput)) {
            if (!robot.getDamageKeys().contains(Character.toUpperCase(userInput))) {
                System.out.println("Button is not active");
            } else {
                Iterator<Character> iterator = robot.getDamageKeys().iterator();
                while (iterator.hasNext()) {
                    Character damageKey = iterator.next();
                    if (String.valueOf(damageKey).equalsIgnoreCase(String.valueOf(userInput))) {
                        robot.setHealth(robot.getHealth() - 20);
                        iterator.remove();
                        System.out.println("Good shot!!! \nrobot health is " + robot.getHealth());
                    }
                }
            }
        } else {
            System.out.println("Enter any of QWEASDZXC or L for exit");
            fight(robot);
        }
    }

    public static boolean isUserInputCorrect(char userInput) {
        String correctSymbols = "QWEASDZXC";
        for (char c : correctSymbols.toCharArray()) {
            if (String.valueOf(c).equalsIgnoreCase(String.valueOf(userInput))) {
                return true;
            }
        }
        return false;
    }
}
