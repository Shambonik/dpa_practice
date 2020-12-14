import java.util.HashMap;
import java.util.Map;

public class Node{
    private Node left;
    private Node right;
    private String k;
    private int weight;

    public Node(String k, int weight) {
        this.k = k;
        this.weight = weight;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        weight = left.getWeight() + right.getWeight();
    }

    public int getWeight() {
        return weight;
    }

    public HashMap<Character, String> getEncodingTable(){
        HashMap<Character, String> table = new HashMap<>();
        if(k!=null){
            table.put(k.charAt(0), "");
            return table;
        }

        HashMap<Character, String> table1 = new HashMap<>();
        table = left.getEncodingTable();
        table1 = right.getEncodingTable();
        for(Map.Entry<Character, String> entry : table.entrySet()){
            entry.setValue(entry.getValue()+"0");
        }
        for(Map.Entry<Character, String> entry : table1.entrySet()){
            entry.setValue(entry.getValue()+"1");
        }
        table.putAll(table1);
        return table;
    }

//    public Node getLeft() {
//        return left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
    public String getK() {
        return k;
    }
}




