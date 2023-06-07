import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Основной класс, представляющий приложение для животных
public class AnimalApp {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Scanner scanner = new Scanner(System.in);
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Определять животное в правильный класс");
            System.out.println("3. Увидеть список команд, которое выполняет животное");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Выход");

            System.out.print("Введите цифру: ");
            String choice = scanner.next();

            try (counter) {
                switch (choice) {
                    case "1":
                        System.out.print("Введите имя животного: ");
                        String name = scanner.next();
                        System.out.print("Введите дату рождения животного (ГГГГ-MM-ДД): ");
                        String birthDateStr = scanner.next();
                        System.out.print(
                                "Введите тип животного (1. собака, 2. кот, 3. хомяк, 4. лошадь, 5. верблюд, 6. осел): ");
                        String animalType = scanner.next();
                        if (name.isEmpty() != true && birthDateStr.isEmpty() != true && animalType.isEmpty() != true) {
                            counter.add();
                        } else {
                            counter.close();
                        }

                        LocalDate birthDate = LocalDate.parse(birthDateStr);

                        switch (animalType) {
                            case "1":
                                animal = new Dog(name, birthDate);
                                animals.add(animal);
                                break;
                            case "2":
                                animal = new Cat(name, birthDate);
                                animals.add(animal);
                                break;
                            case "3":
                                animal = new Hamster(name, birthDate);
                                animals.add(animal);
                                break;
                            case "4":
                                animal = new Horse(name, birthDate);
                                animals.add(animal);
                                break;
                            case "5":
                                animal = new Camel(name, birthDate);
                                animals.add(animal);
                                break;
                            case "6":
                                animal = new Donkey(name, birthDate);
                                animals.add(animal);
                                break;
                            default:
                                break;
                        }
                        break;

                    case "2":
                        System.out.print("Введите имя животного: ");
                        String animalName = scanner.next();
                        Animal identifiedAnimal = null;

                        for (Animal animal1 : animals) {
                            if (animal1.getName().equalsIgnoreCase(animalName)) {
                                identifiedAnimal = animal1;
                                break;
                            }
                        }

                        if (identifiedAnimal != null) {
                            if (identifiedAnimal instanceof DomesticAnimal) {
                                System.out.println("Животное принадлежит к классу домашнее животное");
                            } else if (identifiedAnimal instanceof BeastOfBurden) {
                                System.out.println("Животное принадлежит к классу вьючное животное");
                            } else {
                                System.out.println("Животное не принаджлежит ни к какому классу");
                            }
                        } else {
                            System.out.println("Такого животного нет");
                            break;
                        }
                        break;

                    case "3":
                        System.out.print("Введите имя животного: ");
                        String animalName2 = scanner.next();
                        Animal selectedAnimal = null;

                        for (Animal animal2 : animals) {
                            if (animal2.getName().equalsIgnoreCase(animalName2)) {
                                selectedAnimal = animal2;
                                break;
                            }
                        }

                        if (selectedAnimal != null) {
                            System.out.println("Команды, которые выполняет животное " + selectedAnimal.getCommands());
                        } else {
                            System.out.println("Такого животного нет");
                        }
                        break;
                    case "4":
                        System.out.print("Введите имя животного: ");
                        String animalName3 = scanner.next();
                        Animal animalToTeach = null;

                        for (Animal animal3 : animals) {
                            if (animal3.getName().equalsIgnoreCase(animalName3)) {
                                animalToTeach = animal3;
                                break;
                            }
                        }

                        if (animalToTeach != null) {
                            System.out.print("Введите новую команду ");
                            String newCommand = scanner.next();
                            animalToTeach.addCommand(newCommand);
                            System.out.println("Новая команда успешно добавлена");
                        } else {
                            System.out.println("Такого животного нету");
                        }
                        break;
                    case "5":
                        System.out.println("Программа закрыта");
                        exit = true;
                        break;
                    default:
                        System.out.println("Неверный выбор");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Возникла ошибка: " + e.getMessage());
            }
        }
    }
}
