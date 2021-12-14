package sample;

public abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    private final double basePrice=2.0;
    private final double sizePrice=1.0;


    public Beverage(String name, TYPE type,SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    public String toString() {
        String str= "Name: "+name+"\nSize: "+size;
        return str;
    }

    public boolean equals(Beverage beverage)
    {
        if (name.compareTo(beverage.name)==0&&size.compareTo(beverage.size)==0
                &&type.compareTo(beverage.type)==0)
        {
          return true;
        }
        else
            return false;
    }

    //Getters

    public double getBasePrice() {
        return basePrice;

    }

    public double getSizePrice() {
        return sizePrice;
    }

    public String getBevName() {
        return name;
    }

    public SIZE getSize() {
        return size;
    }

    public TYPE getType() {
        return type;
    }

  //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}