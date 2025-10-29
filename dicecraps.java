import java.util.Scanner;

public class dicecraps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 100.0;
        int round = 1;

        System.out.println("Welcome to Dice Craps!");
        System.out.println("Warning: Betting doesn't just take your money, it waits until you're sure you'll win, then takes your soul.");
        System.out.println("You start with $" + balance + ". Bet wisely...");

        // game loop
        while (balance > 0) {
            System.out.println("\nStarting dice game #" + round);
            System.out.print("Enter your bet amount: $");
            double bet = scanner.nextDouble();

            if (bet > balance || bet <= 0) {
                System.out.println("Invalid bet. Try again.");
                continue;
            }

            boolean gameover = false;
            int rollCount = 1;

            // initial dice roll
            int roll1 = (int) (Math.random() * 6 + 1);
            int roll2 = (int) (Math.random() * 6 + 1);
            int sum = roll1 + roll2;

            asciiDice(roll1);
            asciiDice(roll2);
            System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum);

            // come-out roll
            if (sum == 7 || sum == 11) {
                System.out.println("You win!");
                balance += bet;
                gameover = true;
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You lose!");
                balance -= bet;
                gameover = true;
            }

            int point = sum;
            if (!gameover) {
                System.out.println("Point is set to: " + point + "\n");
            }

            // point phase loop
            while (!gameover) {
                rollCount+=1;
                roll1 = (int) (Math.random() * 6 + 1);
                roll2 = (int) (Math.random() * 6 + 1);
                sum = roll1 + roll2;

                asciiDice(roll1);
                asciiDice(roll2);
                System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum + "\n");

                // win/loss check
                if (sum == point) {
                    System.out.println("You win!");
                    balance += bet;
                    gameover = true;
                } else if (sum == 7) {
                    System.out.println("You lose!");
                    balance -= bet;
                    gameover = true;
                }
            }

            System.out.println("Game over. Total rolls: " + rollCount);
            System.out.println("Your current balance is: $" + balance);

            if (balance <= 0) {
                System.out.println("You're out of money. Game over!");
                break;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

            round+=1;
        }

        System.out.println("Thanks for playing! Final balance: $" + balance);
        scanner.close();
    }

    // dice ascii art
    public static void asciiDice(int value) {
        if (value == 1) {
            System.out.println("+-------+");
            System.out.println("|       |");
            System.out.println("|   o   |");
            System.out.println("|       |");
            System.out.println("+-------+");
        } else if (value == 2) {
            System.out.println("+-------+");
            System.out.println("| o     |");
            System.out.println("|       |");
            System.out.println("|     o |");
            System.out.println("+-------+");
        } else if (value == 3) {
            System.out.println("+-------+");
            System.out.println("| o     |");
            System.out.println("|   o   |");
            System.out.println("|     o |");
            System.out.println("+-------+");
        } else if (value == 4) {
            System.out.println("+-------+");
            System.out.println("| o   o |");
            System.out.println("|       |");
            System.out.println("| o   o |");
            System.out.println("+-------+");
        } else if (value == 5) {
            System.out.println("+-------+");
            System.out.println("| o   o |");
            System.out.println("|   o   |");
            System.out.println("| o   o |");
            System.out.println("+-------+");
        } else if (value == 6) {
            System.out.println("+-------+");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println("+-------+");
        }
    }
}

//Answers to Questions:

/*
1. There are two dice used to play craps. The first roll is known as the come-out roll. If the number is 7 or 11, the player wins right away. If the number is 2, 3, or 12, the player loses right away. If the number is 4, 5, 6, 8, 9, or 10, that number becomes the point. The player continues to roll until he rolls the point again and wins, or rolls 7 and loses.
2. Two ways a player can win. First, by rolling either a 7 or 11 on the come-out roll. Second, by rolling the point number again before rolling a 7 during the point phase.
2a. In addition to this, you will need to have a function to roll two dice, come-out roll logic to evaluate, and a loop to handle the point phase.
2b. DeMorgan's Law is used while simplifying logical statements. For example, instead of using not (roll == 7 or roll == point), you can use (roll != 7 and roll != point). This reduces the complexity of the logic and avoids nested conditions.

2c.
FirstRoll	Win	        Lose        PointSet
2	        0	        1	        0
3	        0	        1	        0
4	        0	        0	        1
5	        0	        0	        1
6	        0	        0	        1
7	        1	        0	        0
8	        0	        0	        1
9	        0	        0	        1
10	        0	        0	        1
11	        1	        0	        0
12	        0	        1	        0
 */
