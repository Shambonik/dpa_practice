public class Main {
    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree(3);
        tree.add(5);
        tree.add(11);
        tree.add(4);
        tree.delete(5);
        tree.add(32);
        tree.add(9);
        tree.add(12);
        tree.add(33);
        tree.add(34);
        tree.add(35);
        tree.delete(11);
        tree.printTree();
    }
}
