public class dicecraps {
    public static void main(String[] args) {
        int gameNumber = 0;

        while (true) {
            gameNumber+=1;
            System.out.println("Starting dice game #" + gameNumber);

            int rollCount = 0;
            int point = 0;

            rollCount += 1;
            int roll1 = (int) (Math.random() * 6 + 1);
            int roll2 = (int) (Math.random() * 6 + 1);
            int sum = roll1 + roll2;
            System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum);

            if (sum == 7 || sum == 11) {
                System.out.println("You win!");
                System.out.println("Game over. Total rolls: " + rollCount);
                continue;
            }

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You lose!");
                System.out.println("Game over. Total rolls: " + rollCount);
                continue;
            }

            point = sum;
            System.out.println("Point is set to: " + point);

            while (true) {
                rollCount += 1;
                roll1 = (int) (Math.random() * 6 + 1);
                roll2 = (int) (Math.random() * 6 + 1);
                sum = roll1 + roll2;
                System.out.println("You rolled a " + roll1 + " and a " + roll2 + " for a total of " + sum);

                if (sum == point) {
                    System.out.println("You win!");
                    break;
                }

                if (sum == 7) {
                    System.out.println("You lose!");
                    break;
                }
            }

            System.out.println("Game over. Total rolls: " + rollCount);
        }
    }
}
