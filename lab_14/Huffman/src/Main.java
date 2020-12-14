import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(getEncodedString("Кузин Данил Олегович"));
    }

    private static String getEncodedString(String str){
        HashMap encodingTable = getEncodingTable(str);
        StringBuilder result = new StringBuilder();
        for(Character ch : str.toCharArray()){
            result.append(encodingTable.get(ch));
            result.append(" ");
        }
        return result.toString();
    }

    private static HashMap getEncodingTable(String str){
        HashMap<Character, Integer> characters = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(characters.containsKey(ch)){
                characters.replace(ch, characters.get(ch)+1);
            }
            else{
                characters.put(ch, 1);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : characters.entrySet()){
            nodes.add(new Node(entry.getKey().toString(), entry.getValue()));
        }
        Comparator comparator = new NodeComparator();
        nodes.sort(comparator);
        while(nodes.size()>1){
            nodes.add(0, new Node(nodes.get(0), nodes.get(1)));
            nodes.remove(1);
            nodes.remove(1);
            nodes.sort(comparator);
        }
        return nodes.get(0).getEncodingTable();
    }

}


