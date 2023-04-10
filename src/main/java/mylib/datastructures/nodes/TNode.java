package src.main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private int balance;
    private TNode left;
    private TNode right;
    private TNode parent;
    
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;
    }

    // getters
    public int getData() {return data;}
    public int getBalance() {return balance;}
    public TNode getLeft() {return left;}
    public TNode getRight() {return right;}
    public TNode getParent() {return parent;}
    
    // setters
    public void setData(int data) {this.data = data;}
    public void setBalance(int balance) {this.balance = balance;}
    public void setLeft(TNode left) {this.left = left;}
    public void setRight(TNode right) {this.right = right;}
    public void setParent(TNode parent) {this.parent = parent;}
    
    public void print() {
        String dataString = toString();
        System.out.println("Node data: " + dataString + ", balance: " + balance);
    }

    public String toString() {
        return Integer.toString(data);
    }
}
