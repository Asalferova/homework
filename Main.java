public class Main {
    public static void main(String[] args) {
        ClassToy prank = new ClassToy();
        // добавление разных игрушек
        prank.addToy(123, "teddy bear", 9, 20);
        prank.addToy(124, "doll", 15, 30);
        prank.addToy(125, "ball", 20, 40);
        // изменение веса игрушки
        prank.changeDropRate(125, 0.5);
        // вызов метода выбора приза
        prank.prizeToySelection();
        // получение приза
        Toy prizeToy = prank.getPrizeToy();
        // запись в файл
        if (prizeToy == null) {
            System.out.println("вы ничего не выиграли");
        }
        else {
            prank.writePrizeToyToFile(prizeToy);
            prank.printPrizeToyArray();
            //изменение количества игрушек
            prizeToy.setQuantity(prizeToy.getQuantity()-1);
            System.out.println("Количество игрушек " + prizeToy.getTitle() + " уменьшилось на одну, теперь их:  " + prizeToy.getQuantity());
            
        }
    }
}
