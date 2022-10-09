import java.util.ArrayList;

public class DotComBust {

    // объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>(); // создали ArrayList только для объектов DotCom
    private int numOfGuesses = 0;

    private void setUpGame() {
        // создадим несколько "сайтов" и присвоим им адреса
        // создаём 3 объекта DotCom, даём им имена и помещаем в ArrayList

        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("eToys.com");

        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        // выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить три 'сайта'.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList) { // повторяем с каждым объектом DotCom в списке
            ArrayList<String> newLocation = helper.placeDotCom(3); // запрашиваем у вспомогательного объекта адрес "сайта"
            dotComToSet.setLocationCells(newLocation); // вызываем сеттер из объекта DotCom, чтобы передать ему местоположение, которое только что получил от вспомогательного объекта
        }
    }

    private void startPlaying() {

        while (!dotComList.isEmpty()) { // до тех пор, пока список объектов DotCom не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход"); // пользовательский ввод
            checkUserGuess(userGuess); // вызов метода checkUserGuess
        }
        finishGame(); // вызов метода finishGame
    }

    private void checkUserGuess(String userGuess) {

        numOfGuesses++; // инкрементируем количество попыток, которые сделал пользователь
        String result = "Мимо"; // подразумеваем промах, пока не выяснили обратного

        for (DotCom dotComToTest : dotComList) { // повторяем для всех объектов DotCom в списке
            result = dotComToTest.checkYourself(userGuess); // просим DotCom проверить ход пользователя, ищем попадание/потопление

            if (result.equals("Попал")) {
                break; // выбираемся из цикла раньше времени, нет смысла проверять другие "сайты"
            }

            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest); // ему пришёл конец, удаляем его из списка "сайтов" и выходим из цикла
                break;
            }
        }
        System.out.println(result); // выводим результат
    }

    private void finishGame() {
        // выводим сообщение о том, как пользователь прошёл игру
        System.out.println("Все 'сайты' ушли ко дну! Ваши акции теперь ничего не стоят.");

        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust(); // создаём игровой объект
        game.setUpGame(); // говорим игровому объекту подготовить игру
        game.startPlaying(); // говорим игровому объекту начать главный игровой цикл (продолжаем запрашивать пользовательский ввод и проверять полученные данные
    }
}
