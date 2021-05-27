package ua.lviv.lgs;

public class Magazine {
    private int id;
    private String name;
    private int year;
    private String month;
    private double price;

    public Magazine() {
    }
    public Magazine(String name, int year, String month, double price) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.price = price;
    }

    public Magazine(int id, String name, int year, String month, double price) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.month = month;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", price=" + price +
                '}';
    }
}
