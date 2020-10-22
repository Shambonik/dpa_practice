public class AVL_Tree {
    Node root;

    public AVL_Tree(int k){
        root = insert(null, k);
    }

    public void add(int k){
        root = insert(root, k);
    }

    public void delete(int k) {
        root = remove(root, k);
    }

    public void printTree(){
        System.out.println("digraph G{");
        printing(root);
        System.out.println("}");
    }

    private void printing(Node node){
        if(node.left!=null) {
            System.out.println("\"" + node.k + "\" -> \"" + node.left.k + "\"");
            printing(node.left);
        }
        if(node.right!=null) {
            System.out.println("\""  + node.k + "\" -> \"" + node.right.k + "\"");
            printing(node.right);
        }
    }


    private class Node{
        public int k;
        public int height;
        Node left;
        Node right;
        Node(int k){
            this.k = k;
            left = null;
            right = null;
            height = 1;
        }

    }

    private int height(Node node){
        return (node!=null)?node.height:0;
    }

    private int deltaHeight(Node node){
        return height(node.right) - height(node.left);
    }

    private void fixHeight(Node node){
        int hl = height(node.left);
        int hr = height(node.right);
        node.height = ((hl>hr)?hl:hr)+1;
    }

    private Node rotateRight(Node p){
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    private Node rotateLeft(Node q){
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    private Node balance(Node node){
        fixHeight(node);
        if(deltaHeight(node) == 2){
            if(deltaHeight(node.right)<0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if(deltaHeight(node)==-2){
            if(deltaHeight(node.left)>0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        return node;
    }

    private Node insert(Node node, int k){
        if(node == null) return new Node(k);
        if(k<node.k)
            node.left = insert(node.left, k);
        else
            node.right = insert(node.right, k);
        return balance(node);
    }

    private Node findMin(Node node){
        return (node.left==null)?node:findMin(node.left);
    }

    private Node removeMin(Node node){
        if(node.left==null){
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }

    private Node remove(Node p, int k) // удаление ключа k из дерева p
    {
        if(p==null) return null;
        if( k < p.k)
            p.left = remove(p.left,k);
        else if( k > p.k )
            p.right = remove(p.right,k);
        else
        {
            Node q = p.left;
            Node r = p.right;
            if(r==null) return q;
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }

}
