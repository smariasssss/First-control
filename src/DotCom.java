import java.util.ArrayList;

public class DotCom {

    // переменные экземпляра класса DotCom
    private ArrayList<String> locationCells; // ArrayList с ячейками, описывающими местоположение
    private String name; // имя "сайта"

    // сеттер, который обновляет местоположение "сайта" (случайный адрес, предоставляемый методом placeDotCom() из класса GameHelper)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput); // метод indexof() из ArrayList в действии. Если ход пользователя совпал с одним из элементов ArrayList, то метод indexOf() вернёт его местоположение. Если нет, то indexOf() вернёт -1.
        if (index >= 0) {
            locationCells.remove(index); // метод из  ArrayList для удаления элемента

            if (locationCells.isEmpty()) { // метод isEmpty() для проверки, были ли разгаданы адреса
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + " :( "); // сообщение о потоплении сайта
            } else {
                result = "Попал";
            }
        }
        return result; // возвращаем "Мимо", "Попал" или "Потопил"
    }
}
