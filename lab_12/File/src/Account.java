public class Account {
    private int number;
    private String name;
    private String address;

    public Account(int number, String name, String address) {
        this.number = number;
        this.name = name;
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printAccount(){
        System.out.println(number + " " + name + " " + address);
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
