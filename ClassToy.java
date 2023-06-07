import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Класс с методами, реализующими функционал программы
public class ClassToy {
    private ArrayList<Toy> toys = new ArrayList<>();
    private ArrayList<Toy> prizeToys = new ArrayList<>();
    private Random random = new Random();

    public ClassToy() {
    }

    // метод добавления игрушек
    public void addToy(int toyID, String title, int quantity, double dropRate) {
        toys.add(new Toy(toyID, title, quantity, dropRate));
    }

    // метод изменения веса игрушки
    public void changeDropRate(int toyID, double newDropRate) {
        for (Toy t : toys) {
            if (t.getToyID() == toyID) {
                t.setDropRate(newDropRate);
            }
        }
    }

    // метод выбора призовой игрушки и записи ее или их в массив
    public void prizeToySelection() {
        for (Toy t : toys) {
            if (random.nextInt() <= t.getDropRate())
                prizeToys.add(t);
        }
        System.out.println("добавление в массив призовой игрушки  " + prizeToys);
    }

    // метод получения призовой игрушки и удаления ее из массива
    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null;
        } else {
            Toy prizeToy = prizeToys.get(0);
            prizeToys.remove(prizeToy);
            return prizeToy;
        }
    }

    // метод вывода на экран массива призовых игрушек
    public void printPrizeToyArray() {
        System.out.println("массив после удаления призовой игрушки:  " + prizeToys);
    }

    // метод записи призовой игрушки в файл
    public void writePrizeToyToFile(Toy t) {
        // создание файла
        File file = new File("prize_toys.txt");

        // проверка на существование файла
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // запись игрушки в файл
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(t.getToyID() + "," + t.getTitle() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
