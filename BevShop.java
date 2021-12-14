package sample;
import java.util.ArrayList;

public class BevShop implements BevShopInterfce
{
private int numAlcohol;
private int currentOrder;
private ArrayList<Order> orders;

    public BevShop() {
        orders = new ArrayList<>();
    }

    public boolean validTime(int time)
    {
        if(time<=MAX_TIME&&time>=MIN_TIME)
        {
            return true;
        }
        else
            return false;
    }

    public boolean eligibleForMore()
    {
        if (getNumOfAlcoholDrink()>=MAX_ORDER_FOR_ALCOHOL)
            return true;
        else
            return false;

    }
    public boolean validAge(int age)
    {
        if(age>=MIN_AGE_FOR_ALCOHOL)
            return true;
        else
            return false;
    }

    public void startNewOrder(int time, DAY day, String customerName,
                              int customerAge)
    {
        Customer customer= new Customer(customerName, customerAge);
        Order order= new Order(time, day, customer);
        orders.add(order);
        currentOrder= orders.size() - 1;
    }
    public void processCoffeeOrder( String bevName, SIZE size,
                                    boolean extraShot,
                                    boolean extraSyrup)
    {
        orders.get(currentOrder).addNewBeverage
                (bevName, size, extraShot, extraSyrup);

    }
    public void  processAlcoholOrder( String bevName, SIZE size )
    {
        orders.get(currentOrder).addNewBeverage(bevName,size);
    }

    public void processSmoothieOrder( String bevName, SIZE size, int numOfFruits,
                                      boolean addProtien)
    {
        orders.get(currentOrder).addNewBeverage
                (bevName, size, numOfFruits, addProtien);

    }

    public int findOrder(int orderNo)
    {
        for(int num=0; num<orders.size();num++)
        {
            if(orders.get(num).getOrderNo()==orderNo)
                return num;
        }
        return -1;
    }
    public double totalOrderPrice(int orderNo)
    {
       return orders.get(findOrder(orderNo)).calcOrderTotal();
    }
    public double totalMonthlySale()
    {
        double total=0;
        for(int n=0; n<orders.size();n++)
        {
            total+=orders.get(n).calcOrderTotal();
        }
        return total;
    }

    public Order getOrderAtIndex(int index)
    {
        return orders.get(index);
    }
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }
    public void sortOrders() {

        for (int n = 0; n < orders.size()-1; n++) {
            int min = n;
            for (int i = n+1; i < orders.size(); i++) {
                if (orders.get(i).getOrderNo() < orders.get(min).getOrderNo()) {
                    min = i;
                }
            }

            Order temp = orders.get(min);
            orders.set(min, orders.get(n));
            orders.set(n, temp);
        }
    }

    public Order getCurrentOrder() {
        return getOrderAtIndex(currentOrder);
    }

    public int getNumOfAlcoholDrink() {
        return numAlcohol;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setCurrentOrder(int currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void setNumAlcohol(int numAlcohol) {
        this.numAlcohol = numAlcohol;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    public boolean isMaxFruit(int num)
    {
        return num>5;
    }

}
