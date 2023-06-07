
public class Toy {     
    private int toyID;
    private String title;
    private int quantity;
    private double dropRate;
    
    public Toy(int toyID, String title, int quantity, double dropRate) {
        this.toyID = toyID;
        this.title = title;
        this.quantity = quantity;
        this.dropRate = 100 / dropRate;
    }

//геттеры (для получения приватных значений.)
    public int getToyID() {
        return toyID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getDropRate() {
        return dropRate;
    }

//сеттеры (для изменения значений)
    public void setDropRate(double dropRate) {
        this.dropRate = dropRate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


//Перезапись метода toString для корректного вывода на экран
    @Override
    public String toString() {
        return "айди:  " + toyID + ", " +
        "название:  " + title + ",  " +
        "количество :  " + quantity + ",  " +
        "частота выпадения  :  " + dropRate;
    }
}
