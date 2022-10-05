import java.util.ArrayList;

public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        DotCom theDotCom = new DotCom();

        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        ArrayList<String> locationsTwo = new ArrayList<String>();
        for (int i = 0; i < locations.length; i++) {
            locationsTwo.add(i, String.valueOf(locations[i]));
        }

        theDotCom.setLocationCells(locationsTwo);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;

            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
