import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Track> tracks;

    public Node(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public String getName() {
        return name;
    }

    public void add_track(Node to_node, int weight){
        tracks.add(new Track(to_node, weight));
        to_node.add_back_track(this, weight);
    }

    public void add_back_track(Node to_node, int weight){
        tracks.add(new Track(to_node, weight));
    }
}
