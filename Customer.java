package sample;

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age=age;
    }

    public Customer(Customer customer)
    {
        this.name = customer.name;
        this.age=customer.age;
    }

    public String toString()
    {

        String str= "Customer name is "+getName()+", the customer age is "+getAge()+".";
        return str;
    }
//Getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
//Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
