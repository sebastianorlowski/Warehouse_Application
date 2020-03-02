package entity;
import enums.Color;

public class Boots extends Product{

    public Boots(Long id, String name, Float price, Float weight, Color color, Integer productCount, String size, String material) {
        super(id, name, price, weight, color, productCount, size, material);
    }

    public String toString() {
        return super.toString();
    }
}
