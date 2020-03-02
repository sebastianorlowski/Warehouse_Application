package enums;


public enum Color {
    WHITE("#FFFFFF"), BLACK("#000000"), GREEN("#008000"), RED("#FF0000"), BLUE("#0000FF"), YELLOW("#FFFF00"), ORANGE("#FFA500"), PURPLE("#800080"),
    GRAY("#808080");

    private String color;

    Color (String color){
        this.color = color;
    }

    public String getHex() {
        return color;
    }
}
