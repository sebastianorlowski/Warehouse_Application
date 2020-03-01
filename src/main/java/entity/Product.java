package entity;

public class Product {
    private Long id;
    private String name;
    private Float price;
    private Float weight;
    private String color;
    private Integer productCount;
    private String size;
    private String material;

    public Product(Long id, String name, Float price, Float weight, String color,
                   Integer productCount, String size, String material) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
        this.size = size;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", productCount=" + productCount +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
