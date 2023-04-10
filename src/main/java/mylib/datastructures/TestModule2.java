package src.main.java.mylib.datastructures;
import src.main.java.mylib.datastructures.nodes.TNode;
import src.main.java.mylib.datastructures.trees.BST;
import src.main.java.mylib.datastructures.trees.AVL;

public class TestModule2 {
    public static void main(String[] args) {
    
    /** Test TNode Class methods */
    System.out.println("");
    System.out.println("***Testing TNode Class...***");

    // create a new TNode object by using overloaded constructor
    TNode node1 = new TNode(5, 0, null, null, null);
    System.out.println("");
    System.out.println("A TNode object is successfully created via TNode overloaded constructor!");

    // test getters
    System.out.println("Expected data: 5, Actual data: " + node1.getData());
    System.out.println("Expected balance: 0, Actual balance: " + node1.getBalance());
    System.out.println("Expected parent: null, Actual parent: " + node1.getParent());
    System.out.println("Expected left: null, Actual left " + node1.getLeft());
    System.out.println("Expected right: null, Actual right: " + node1.getRight());

    // create a new TNode object by using default constructor
    TNode node2 = new TNode();

    System.out.println("");
    System.out.println("A TNode object is successfully created via TNode default constructor!");

    System.out.println("Expected data: 0, Actual data: " + node2.getData());
    System.out.println("Expected balance: 0, Actual balance: " + node2.getBalance());
    System.out.println("Expected parent: null, Actual parent: " + node2.getParent());
    System.out.println("Expected left: null, Actual left " + node2.getLeft());
    System.out.println("Expected right: null, Actual right: " + node2.getRight());
    
    // test setters
    node2.setData(3);
    node2.setBalance(1);
    node2.setLeft(new TNode(4, 0, null, null, null));
    node2.setRight(new TNode(7, 0, null, null, null));
    node2.setParent(new TNode(2, 0, null, null, null));

    System.out.println("");
    System.out.println("TNode setters successfully set member varialbes!");

    System.out.println("Expected data: 3, Actual data: " + node2.getData());
    System.out.println("Expected balance: 1, Actual balance: " + node2.getBalance());
    System.out.println("Expected left data: 4, Actual left data: " + node2.getLeft());
    System.out.println("Expected right data: 7, Actual right data: " + node2.getRight());
    System.out.println("Expected parent data: 2, Actual parent data: " + node2.getParent());

    // test print(), toString() is tested in the print()
    System.out.println("");
    System.out.println("Testing TNode print() and toString()...");

    System.out.println("Expected output: ");
    System.out.println("Node data: 3, balance: 1");
    System.out.println("Actual output: ");
    node2.print();


    /** Test BST Class methods */
    System.out.println("");
    System.out.println("");
    System.out.println("***Testing BST Class...***");

    // create a new BST object by using overloaded constructor BST(int val)
    BST bst1 = new BST(2);

    System.out.println("");
    System.out.println("A BST object is successfully created via BST overloaded constructor BST(int val)!");

    // test getter
    System.out.println("Expected data: 2, Actual data: " + bst1.getRoot());

    // create a new BST object by using overloaded constructor BST(TNode obj)
    TNode node3 = new TNode();
    BST bst2 = new BST(node3);

    System.out.println("");
    System.out.println("A BST object is successfully created via BST overloaded constructor BST(TNode obj)!");
    System.out.println("Expected data: 0, Actual data: " + bst2.getRoot());

    // create a new BST object by using default constructor
    BST bst3 = new BST();

    System.out.println("");
    System.out.println("A BST object is successfully created via BST default constructor!");    
    System.out.println("Expected data: null, Actual data: " + bst3.getRoot());

    // test setters
    TNode node4 = new TNode(2, 0, null, null, null);
    bst3.setRoot(node4);

    System.out.println("");
    System.out.println("BST setters successfully set root!");
    System.out.println("Expected data: 2, Actual data: " + bst3.getRoot());

    // test insert(int val)
    BST bst4 = new BST();
    bst4.insert(5);
    bst4.insert(2);
    bst4.insert(8);
    bst4.insert(1);
    bst4.insert(3);
    bst4.insert(7);
    bst4.insert(9);

    System.out.println("");
    System.out.println("Nodes are created by the provided values and the nodes are successfully inserted into the BST object!");

    // test insert(TNode node)
    BST bst5 = new BST();
    TNode node5 = new TNode(1, 0, null, null, null);
    TNode node6 = new TNode(3, 0, null, null, null);
    TNode node7 = new TNode(2, 0, null, null, null);
    bst5.insert(node5);
    bst5.insert(node6);
    bst5.insert(node7);

    System.out.println("");
    System.out.println("The nodes are successfully inserted into the BST object!");
    
    // test inOrderTraversal(TNode node)
    System.out.println("");
    System.out.println("Testing BST inOrderTraversal(TNode node)...");
    
    System.out.println("In-order traversal of BST:");
    bst4.printInOrder();

    // test search(int val)
    System.out.println("");
    System.out.println("Testing BST search(int val)...");

    TNode searchedNode1 = bst4.search(3);
    if (searchedNode1 != null) {
        System.out.println("Node with value 3 found in the BST object");
    } else {
        System.out.println("Node with value 3 not found in the BST object");
    }

    // test delete(int val) and deleteNode(TNode node, int val)
    System.out.println("");
    System.out.println("Testing BST delete(int val)...");
    
    bst4.delete(2);
    TNode searchedNode2 = bst4.search(2);
    if (searchedNode2 != null) {
        System.out.println("Node with value 2 was not deleted from the BST object");
    } else {
        System.out.println("Node with value 2 was successfully deleted from the BST object");
    }

    // test printBF()
    System.out.println("");
    System.out.println("Testing BST printBF()...");

    System.out.println("Breadth-first traversal of BST:");
    bst4.printBF();


    /** Test AVL Class methods */
    System.out.println("");
    System.out.println("");
    System.out.println("***Testing AVL Class...***");
    
    // create a new AVL object by using overloaded constructor AVL(int val)
    AVL avl1 = new AVL(2);

    System.out.println("");
    System.out.println("A AVL object is successfully created via AVL overloaded constructor AVL(int val)!");

    // test getter
    System.out.println("Expected data: 2, Actual data: " + avl1.getRoot());

    // create a new AVL object by using overloaded constructor AVL(TNode obj)
    TNode node8 = new TNode();
    AVL avl2 = new AVL(node8);

    System.out.println("");
    System.out.println("A AVL object is successfully created via AVL overloaded constructor AVL(TNode obj)!");
    System.out.println("Expected data: 0, Actual data: " + avl2.getRoot());

    // create a new AVL object by using default constructor
    AVL avl3 = new AVL();

    System.out.println("");
    System.out.println("A AVL object is successfully created via AVL default constructor!");    
    System.out.println("Expected data: null, Actual data: " + avl3.getRoot());

    // test setters
    TNode node9 = new TNode(2, 0, null, null, null);
    avl3.setRoot(node9);

    System.out.println("");
    System.out.println("AVL setters successfully set root!");
    System.out.println("Expected data: 2, Actual data: " + avl3.getRoot());

    // test insert(int val)
    AVL avl4 = new AVL();
    avl4.insert(5);
    avl4.insert(2);
    avl4.insert(6);
    avl4.insert(1);
    avl4.insert(3);
    avl4.insert(7);
    avl4.insert(4);

    System.out.println("");
    System.out.println("Nodes are created by the provided values and the nodes are successfully inserted into the AVL object!");

    // test insert(TNode node)
    AVL avl5 = new AVL();
    TNode node10 = new TNode(8, 0, null, null, null);
    TNode node11 = new TNode(10, 0, null, null, null);
    TNode node12 = new TNode(9, 0, null, null, null);
    avl5.insert(node10);
    avl5.insert(node11);
    avl5.insert(node12);

    System.out.println("");
    System.out.println("The nodes are successfully inserted into the AVL object!");

    // test inherited method inOrderTraversal(TNode node) from BST class
    System.out.println("");
    System.out.println("Testing inherited method inOrderTraversal(TNode node) from BST class...");
    
    System.out.println("In-order traversal of AVL object:");
    avl5.printInOrder();

    // test inherited method search(int val) from BST class
    System.out.println("");
    System.out.println("Testing inherited method search(int val) from BST class...");

    TNode searchedNode3 = avl4.search(3);
    if (searchedNode3 != null) {
        System.out.println("Node with value 3 found in the AVL object");
    } else {
        System.out.println("Node with value 3 not found in the AVL object");
    }

    // test delete(int val)
    System.out.println("");
    System.out.println("Testing AVL delete(int val)...");
    
    avl4.delete(6);
    TNode searchedNode4 = avl4.search(6);
    if (searchedNode4 != null) {
        System.out.println("Node with value 6 was not deleted from the AVL object");
    } else {
        System.out.println("Node with value 6 was successfully deleted from the AVL object");
    }

    // test inherited method printBF() from BST class
    System.out.println("");
    System.out.println("Testing inherited method printBF() from BST class...");

    System.out.println("Breadth-first traversal of AVL object:");
    avl4.printBF();
 
    }
}
