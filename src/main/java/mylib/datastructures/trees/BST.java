package src.main.java.mylib.datastructures.trees;

import java.util.*;
import src.main.java.mylib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    public BST() {root = null;}

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {this.root = obj;}

    public void setRoot(TNode node) {this.root = node;}

    public TNode getRoot() {return root;}

    public void insert(int val) {
        TNode node = new TNode(val, 0, null, null, null);
        if (root == null) {
            this.root = node;
        } else {
            TNode curr = root;
            while (true) {
                if (val < curr.getData()) {
                    if (curr.getLeft() == null) {
                        curr.setLeft(node);
                        node.setParent(curr);
                        break;
                    } else {
                        curr = curr.getLeft();
                    }
                } else {
                    if (curr.getRight() == null) {
                        curr.setRight(node);
                        node.setParent(curr);
                        break;
                    } else {
                        curr = curr.getRight();
                    }
                }
            }
        }
    }

    public void insert(TNode node) {
        if (root == null) {
            this.root = node;
        } else {
            TNode curr = root;
            while (true) {
                if (node.getData() < curr.getData()) {
                    if (curr.getLeft() == null) {
                        curr.setLeft(node);
                        node.setParent(curr);
                        break;
                    } else {
                        curr = curr.getLeft();
                    }
                } else {
                    if (curr.getRight() == null) {
                        curr.setRight(node);
                        node.setParent(curr);
                        break;
                    } else {
                        curr = curr.getRight();
                    }
                }
            }
        }
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }
    
    private TNode deleteNode(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree.");
            return null;
        }
        if (val < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(deleteNode(node.getRight(), val));
        } else {
            // node found, delete it
            if (node.getLeft() == null && node.getRight() == null) {
                // node has no children
                node = null;
            } else if (node.getLeft() == null) {
                // node has one child (right)
                node = node.getRight();
            } else if (node.getRight() == null) {
                // node has one child (left)
                node = node.getLeft();
            } else {
                // node has two children, find the minimum value in the right subtree
                TNode minNode = node.getRight();
                while (minNode.getLeft() != null) {
                    minNode = minNode.getLeft();
                }
                node.setData(minNode.getData());
                node.setRight(deleteNode(node.getRight(), minNode.getData()));
            }
        }
        return node;
    }
    
    public TNode search(int val) {
        TNode curr = root;
        while (curr != null) {
            if (val == curr.getData()) {
                return curr;
            } else if (val < curr.getData()) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return null;
    }
    
    public void printInOrder() {
        inOrderTraversal(root);
        System.out.println();
    }
    
    private void inOrderTraversal(TNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }
    
    public void printBF() {
        if (root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            System.out.println();
        }
    }
}    