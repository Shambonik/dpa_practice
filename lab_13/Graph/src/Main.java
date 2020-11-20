import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Пример ввода
A B G S M D N L R
A B 27
A M 15
B L 7
B G 9
G N 8
G S 11
S D 17
S M 15
M D 21
D R 32
N R 31
N L 10
0
A N
*/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, NodeShortestWay> node_map = new HashMap<>();
        System.out.println("Введите названия точек через пробел:");
        String names = in.nextLine();
        for(String name: names.split(" ")){
            node_map.put(name, new NodeShortestWay(name));
        }
        System.out.println("Введите пути в формате \"имя1 имя2 длина\" (окончание ввода - 0):");
        names = in.nextLine();
        String[] parts;
        while(!names.equals("0")){
            parts = names.split(" ");
            node_map.get(parts[0]).getNode().add_track(node_map.get(parts[1]).getNode(), Integer.parseInt(parts[2]));
            names = in.nextLine();
        }
        System.out.println("Введите имя начальной и конечной точек в формате \"имя1 имя2\":");
        names = in.nextLine();
        parts = names.split(" ");
        System.out.println(searchShortestWay(node_map, parts[0], parts[1]));
    }

    private static void setShortestWays(HashMap<String, NodeShortestWay> node_map, String start_name){
        NodeShortestWay node = node_map.get(start_name);
        node.setInfinity(false);
        while(!node.isChecked()) {
            for (Track track : node.getNode().getTracks()) {
                NodeShortestWay to_node = node_map.get(track.getTo_node().getName());
                if (to_node.isInfinity() || to_node.getWeight() > node.getWeight() + track.getWeight()) {
                    to_node.setInfinity(false);
                    to_node.setWeight(node.getWeight() + track.getWeight());
                    to_node.setFrom_node(node);
                }
            }
            node.setChecked(true);
            for (Map.Entry<String, NodeShortestWay> entry : node_map.entrySet()) {
                NodeShortestWay _node = entry.getValue();
                if (!_node.isChecked() && !_node.isInfinity() && (node.isChecked() || node.getWeight() > _node.getWeight())) node = _node;
            }
        }
    }

    private static String searchShortestWay(HashMap<String, NodeShortestWay> node_map, String start_name, String end_name){
        setShortestWays(node_map, start_name);
        NodeShortestWay end_node = node_map.get(end_name);
        String result = "";
        result += "Длина пути: " + end_node.getWeight() + "\n";
        while(!end_node.getNode().getName().equals(start_name)){
            result += end_node.getNode().getName() + " <- ";
            end_node = end_node.getFrom_node();
        }
        result += start_name;
        return result;
    }
}
