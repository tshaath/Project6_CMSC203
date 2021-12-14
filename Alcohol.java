package sample;

public class Alcohol extends Beverage {
    private boolean weekendOffer;
    private final double weekendOfferCost=0.6;

    public Alcohol(String name, SIZE size, boolean weekendOffer) {
        super(name, TYPE.ALCOHOL, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public String toString() {
        String str = getBevName() +", " +getSize();
        if (isWeekendOffer())
        {
            str+=", weekend cost applied";
        }
        str+=", $"+calcPrice()+" is the price.";

        return str;
    }

    public boolean equals(Alcohol alcohol)
    {
        if (super.equals(alcohol) && weekendOffer == alcohol.isWeekendOffer())
            return true;
        else
            return false;
    }

    @Override
    public double calcPrice() {
        double price=super.getBasePrice();
        if (isWeekendOffer())
        price+=weekendOfferCost;
        if (super.getSize()==SIZE.LARGE)
        {
            price+=2*super.getSizePrice();
        }
        else if (super.getSize()==SIZE.MEDIUM)
            price+=super.getSizePrice();

        return price;
    }
//Getters
    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public double getWeekendOfferCost() {
        return weekendOfferCost;
    }
//Setter
    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }
}

