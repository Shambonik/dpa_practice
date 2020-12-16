import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

    public static Object[] greedyAlg(Subset[] subsets){
        ArrayList <Subset> result = new ArrayList<>();
        result.add(subsets[0]);
        int k = 0;
        for(int i = 1; i < subsets.length; i++){
            if (subsets[i].getFirst() >= subsets[k].getLast()){
                result.add(subsets[i]);
                k=i;
            }
        }
        return result.toArray();
    }

    public static void main(String[] args) {
        Subset[] subsets = {
                new Subset(0, 10),
                new Subset(1,5),
                new Subset(2,5),
                new Subset(5,10),
                new Subset(0,8),
                new Subset(3,8),
                new Subset(6,11),
                new Subset(6,10),
                new Subset(8,12),
                new Subset(12,14)
        };
        System.out.println("Изначальное: " + Arrays.toString(subsets));
        Arrays.sort(subsets, new Comparator<Subset>(){
            @Override
            public int compare(Subset o1, Subset o2) {
                return o1.getLast() - o2.getLast();
            }
        });
        System.out.println("Результат: " +
                Arrays.toString(greedyAlg(subsets)));
    }
}

class Subset{
    private int first;
    private int last;
    public Subset(int first, int last) {
        this.first = first;
        this.last = last;
    }
    public int getFirst() {
        return first;
    }
    public int getLast() {
        return last;
    }
    @Override
    public String toString() {
        return "{" + first + ";" + last + "}";
    }
}
