public class NodeShortestWay {
    private Node node;
    private NodeShortestWay from_node;
    private int weight;
    private boolean infinity;
    private boolean checked;

    public NodeShortestWay(String name) {
        node = new Node(name);
        from_node = this;
        weight = 0;
        infinity = true;
        checked = false;
    }

    public NodeShortestWay getFrom_node() {
        return from_node;
    }

    public void setFrom_node(NodeShortestWay from_node) {
        this.from_node = from_node;
    }

    public Node getNode() {
        return node;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isInfinity() {
        return infinity;
    }

    public void setInfinity(boolean infinity) {
        this.infinity = infinity;
    }
}
