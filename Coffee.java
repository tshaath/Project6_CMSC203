package sample;

public class Coffee extends Beverage {
    private boolean extraShot;
    private final double shotCost = 0.5;
    private boolean extraSyrup;
    private final double syrupCost = 0.5;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot=extraShot;
        this.extraSyrup=extraSyrup;
    }

    public String toString() {
        String str = getBevName() +", " +getSize();
        if (extraShot) {
            str += " Extra shot";
        }
        if (extraSyrup) {
            str += " Extra syrup";
        }

        str += ", cost is $" +calcPrice();

        return str;
    }

    @Override

    public double calcPrice()
    {
        double price= super.getBasePrice();
        if (extraSyrup)
        {
            price+=syrupCost;

        }
        if (extraShot)
        {
            price+=shotCost;
        }

        if (super.getSize()==SIZE.LARGE)
        {
            price+=2*super.getSizePrice();
        }
        else if (super.getSize()==SIZE.MEDIUM)
            price+=super.getSizePrice();

        return price;
    }
    public boolean equals(Coffee coffee)
    {
        if (super.equals(coffee)&&extraShot==coffee.getExtraShot() &&
                extraSyrup==coffee.getExtraSyrup())
        {
            return true;
        }
        else
            return false;
    }
    public boolean getExtraShot() {
        return extraShot;
    }
    public boolean getExtraSyrup() {
        return extraSyrup;
    }
    public double getShotCost() {
        return shotCost;
    }
    public double getSyrupCost() {
        return syrupCost;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }
    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraShot;
    }
}



