package ProdactManager.ru.netology;

public class Smartphone extends Product {

    private String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }
}
