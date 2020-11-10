import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWork{
    private String path;
    private AccountList accountList;

    public FileWork(String path) {
        this.path = path;
        accountList = new AccountList();
        setAccountListFromFile();
    }

    private void setAccountListFromFile(){
        try {
            List<String> lines = Files.lines(Paths.get(path)).collect(Collectors.toList());
            for(String line : lines){
                String[] values = line.split(" ");
                String name = values[1] + " " + values[2] + " " + values[3];
                String address = "";
                for(int i = 4; i<values.length; i++){
                    address += values[i] + " ";
                }
                accountList.put(Integer.parseInt(values[0]), name, address);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void add(Integer number, String name, String address){
        accountList.put(number, name, address);
        rewrite();
    }

    public void deleteAccount(int number){
        accountList.remove(number);
        rewrite();
    }

    public void changeAddress(int number, String address){
        accountList.setAddress(number, address);
        rewrite();
    }

    public void printAccounts(){
        accountList.printList();
    }

    public void printAccount(int number){
        accountList.get(number).printAccount();
    }

    private void rewrite(){
        try {
            FileWriter writer = new FileWriter(path, false);
            for (Map.Entry<Integer, Account> entry : accountList.entrySet()) {
                Account account = entry.getValue();
                writer.write(account.getNumber() + " " + account.getName() + " "  + account.getAddress() + '\n');
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Filework{"+
                "path= " + path +
                ", accountList= " + accountList.toString();
    }
}
