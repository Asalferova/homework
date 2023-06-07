import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    private String name;
    private LocalDate birthDate;
    private List<String> commands;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}

// Конкретный класс, представляющий домашнее животноеa
class DomesticAnimal extends Animal {
    public DomesticAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий собаку
class Dog extends DomesticAnimal {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий кошку
class Cat extends DomesticAnimal {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий хомяка
class Hamster extends DomesticAnimal {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий вьючное животное
class BeastOfBurden extends Animal {
    public BeastOfBurden(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий лошадь
class Horse extends BeastOfBurden {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий верблюда
class Camel extends BeastOfBurden {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретный класс, представляющий осла
class Donkey extends BeastOfBurden {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Класс счетчика для отслеживания использования ресурсов
class Counter implements AutoCloseable {
    private int count = 0;

    public void add() {
        count++;
    }

    public void sub() {
        count--;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count == 0) {
            throw new Exception("Заполнены не все поля");
        }
        System.out.println("Ресурс успешно закрыт.");
    }
}