public class Track {
    private Node to_node;
    private int weight;

    public Track(Node to_node, int weight) {
        this.to_node = to_node;
        this.weight = weight;
    }

    public Node getTo_node() {
        return to_node;
    }

    public int getWeight() {
        return weight;
    }
}
