import java.util.HashMap;

public class AccountList extends HashMap<Integer, Account> {

    public Account put(Integer key, String name, String address) {
        return put(key, new Account(key, name, address));
    }

    public void setAddress(Integer key, String address){
        get(key).setAddress(address);
    }

    public void printList(){
        System.out.println("Список банковских счетов:");
        for(Entry<Integer, Account> entry :  super.entrySet()) {
            entry.getValue().printAccount();
        }
    }

    @Override
    public String toString() {
        String result = "AccountList{\n";
        for(Entry<Integer, Account> entry :  super.entrySet()) {
            result += entry.getValue().toString() + "\n";
        }
        return result + "}";
    }
}
