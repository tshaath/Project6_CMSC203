package sample;

public class Smoothie extends Beverage
{
    private int numFruits;
    private boolean proteinPowder;
    private final double proteinCost=1.50;
    private final double fruitCost=0.50;

    public Smoothie(String name, SIZE size,int numFruits, boolean proteinPowder )
    {
        super(name, TYPE.SMOOTHIE, size);
        this.numFruits=numFruits;
        this.proteinPowder=proteinPowder;
    }

    public String toString()
    {
    String str= getBevName()+", "+getSize()+", "+numFruits+", is number of fruits";
    if (proteinPowder)
    {
        str+=", protein powder is added";
    }
    if (numFruits>0)
    {
        str+=", "+getNumOfFruits()+" is number of fruits added";
    }

    str+=", $"+calcPrice()+" is the price" ;

    return str;

    }
    public boolean equals(Smoothie smoothie)
    {
        if (super.equals(smoothie) && numFruits==smoothie.getNumOfFruits()
                && proteinPowder==smoothie.getAddProtien())
        return true;

        else
            return false;
    }

    @Override
    public double calcPrice() {
        double price= super.getBasePrice();
        if (getAddProtien())
        {
            price+=proteinCost;
        }
        if (getNumOfFruits()>0)
        {
            price+=getNumOfFruits()*fruitCost;
        }
        if (super.getSize()==SIZE.LARGE)
        {
            price+=2*super.getSizePrice();
        }
        else if (super.getSize()==SIZE.MEDIUM)
            price+=super.getSizePrice();

        return price;
    }

    //Getters
    public double getFruitCost() {
        return fruitCost;
    }

    public int getNumOfFruits() {
        return numFruits;
    }

    public double getProteinCost() {
        return proteinCost;
    }

    public boolean getAddProtien() {
        return proteinPowder;
    }

    //Setters
    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public void setProteinPowder(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }
}
