import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FileWork fileWork = new FileWork(System.getProperty("user.dir") + "\\file.txt");
        fileWork.printAccounts();
        fileWork.add(1234567, "Кузин Данил Олегович", "Проспект Вернадского 86с1");
        fileWork.add(2345678, "Пономарев Денис Николаевич", "Проспект Вернадского 86с1");
        fileWork.printAccounts();
        System.out.println("Введите номер счета, который надо удалить:");
        fileWork.deleteAccount(in.nextInt());
        fileWork.printAccounts();
        System.out.println("Введите номер счета, у которого нужно сменить адрес, и адрес (через пробел):");
        int number = in.nextInt();
        fileWork.changeAddress(number, in.nextLine());
        fileWork.printAccounts();
        System.out.println("Введите номер счета:");
        fileWork.printAccount(in.nextInt());
    }
}
