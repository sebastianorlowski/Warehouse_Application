package entity;
import enums.Color;
public class Product {
    private Long id;
    private String name;
    private Float price;
    private Float weight;
    private Color color;
    private Integer productCount;
    private String size;
    private String material;

    private Product(Long id, String name, Float price, Float weight, Color color,
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

    public Product(String name, Float price, Float weight, Color color,
                   Integer productCount, String size, String material) {
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

    public Color getColor() {
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

    @Override
    public String toString() {
        return id + name + price + weight + color + productCount + size + material;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Float price;
        private Float weight;
        private Color color;
        private Integer productCount;
        private String size;
        private String material;

        public Builder() {

        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(Float price) {
            this.price = price;
            return this;
        }

        public Builder setWeight(Float weight) {
            this.weight = weight;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder setProductCount(Integer productCount) {
            this.productCount = productCount;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Product build() {
            return new Product(id, name, price, weight, color, productCount, size, material);
        }
     }
}
