package entity;

public class Cloth extends Product {

    public Cloth(Long id, String name, Float price, Float weight, String color,
                 Integer productCount, String size, String material) {
        super(id, name, price, weight, color, productCount, size, material);
    }



    public String toString() {
        return super.toString();
    }
}
