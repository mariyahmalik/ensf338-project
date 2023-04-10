package src.main.java.mylib.datastructures.trees;
import src.main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    public AVL() {this.root = null;}

    public AVL(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public AVL(TNode obj) {
        if (obj == null) {
            root = null;
        } else {
            root = obj;
            if (root.getLeft() != null || root.getRight() != null) {
                root = balance(root);
            }
        }
    }

    public TNode getRoot() {return this.root;}

    public void setRoot(TNode node) {
        root = node;
        if (root.getLeft() != null || root.getRight() != null) {
            root = balance(root);
        }
    }

    private TNode balance(TNode node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) >= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return leftHeight - rightHeight;
    }

    private int getHeight(TNode node) {
        if (node == null) { return 0; }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private TNode rotateRight(TNode node) {
        TNode temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }

    private TNode rotateLeft(TNode node) {
        TNode temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }

    public void insert(int val) {
        super.insert(val);
        this.balance(super.search(val));
    }

    public void insert(TNode node) {
        super.insert(node);
        this.balance(node.getParent());
    }

    public void delete(int val) {
        TNode node = super.search(val);
        if (node == null) {
            System.out.println("Value not found in the tree");
            return;
        }
        super.delete(val);
        this.balance(node.getParent());
    }
    
}
