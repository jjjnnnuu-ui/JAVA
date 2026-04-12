public abstract class Person {
    protected String customerId;
    protected String name;

    public Person(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public abstract void showInfo();
}