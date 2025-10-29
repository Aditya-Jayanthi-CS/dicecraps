public class dicecraps {
    public static void main(String[] args) {
        int round = 1;
        boolean gameover = false;

        System.out.println("Starting dice game #" + round);

        int rollCount = 1;
        int roll1 = (int) (Math.random() * 6 + 1);
        int roll2 = (int) (Math.random() * 6 + 1);
        int sum = roll1 + roll2;

        asciiDice(roll1);
        asciiDice(roll2);
        System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum);

        if (sum == 7 || sum == 11) {
            System.out.println("You win!");
            System.out.println("Game over. Total rolls: " + rollCount);
            gameover = true;
        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose!");
            System.out.println("Game over. Total rolls: " + rollCount);
            gameover = true;
        }

        int point = sum;
        System.out.println("Point is set to: " + point + "\n");

        while (!gameover) {
            rollCount++;
            roll1 = (int) (Math.random() * 6 + 1);
            roll2 = (int) (Math.random() * 6 + 1);
            sum = roll1 + roll2;

            asciiDice(roll1);
            asciiDice(roll2);
            System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum + "\n");

            if (sum == point) {
                System.out.println("You win!");
                gameover = true;
            } else if (sum == 7) {
                System.out.println("You lose!");
                gameover = true;
            }
        }

        System.out.println("Game over. Total rolls: " + rollCount);
    }

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
