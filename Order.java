package sample;
import java.util.ArrayList;
import java.util.Random;
public class Order implements OrderInterface, Comparable<Order>{
    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public int generateRandom()
    {
        Random random= new Random();
        int num= random.nextInt(80001)+10000;
        return num;
    }
    public Order( int orderTime, DAY orderDay, Customer customer)
    {
        this.orderNumber=generateRandom();
        this.orderTime=orderTime;
        this.orderDay=orderDay;
        this.customer=new Customer(customer);
        beverages=new ArrayList<>();
    }

    public void addNewBeverage(String bevName, SIZE size,
                               boolean extraShot,
                               boolean extraSyrup)
    {
        Coffee coffee=new Coffee(bevName, size,extraShot, extraSyrup);
        beverages.add(coffee);
    }

    public void addNewBeverage(String bevName, SIZE size)
    {
        boolean weekend =isWeekend() ;
        Alcohol alcohol= new Alcohol(bevName, size, weekend);
        beverages.add(alcohol);
    }
    public void  addNewBeverage( String bevName, SIZE size, int numOfFruits,
                                 boolean addPRotien)
    {
        Smoothie smoothie= new Smoothie(bevName, size,numOfFruits, addPRotien );
        beverages.add(smoothie);
    }
    public boolean isWeekend()
    {
        DAY day=getOrderDay();
     if(day==DAY.SATURDAY||day==DAY.SUNDAY)
     {
         return true;
     }
     else
         return true;

    }
    public Beverage getBeverage(int itemNo)
    {
        return beverages.get(itemNo);
    }
    public double calcOrderTotal()
    {
        double total = 0;

        for (Beverage beverage : beverages)
        {
            total += beverage.calcPrice();
        }

        return total;
    }
    public int findNumOfBeveType(TYPE type){
        int num=0;
        for (Beverage beverage : beverages) {
            if(beverage.getType()==type)
                num++;
        }
        return num;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public DAY getOrderDay() {
        return orderDay;
    }

    public int getOrderNo() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public String toString()
    {
        String str="Order number is "+getOrderNo()+", day is "+getOrderDay()+
                ", customer name is "+customer.getName()+", customer age is "+
                customer.getAge()+".\nOrder list is :";
        for (Beverage beverage : beverages)
        {
        str +="\n"+beverage.toString();
        }
        return str;
    }
    public int compareTo(Order order)
    {
        if (this.orderNumber==order.orderNumber)
        {
            return 0;
        }
        else if (this.orderNumber<order.orderNumber)
        {
            return -1;
        }
        else
        {
           return 1;
        }
    }
    public int getTotalItems() {
        return beverages.size();
    }

}
