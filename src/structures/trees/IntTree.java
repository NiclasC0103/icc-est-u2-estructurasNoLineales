package structures.trees;

import structures.nodes.Node;

public class IntTree {
    
    private Node<Integer> root;
    private int size;

    public IntTree(){
        this.root = null;
    }

    public void insert(int value){
        this.root = insertRecursive(this.root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        size++;
        return current;
    }
    
    public int size(){
        return size;
    }

    public void preOrder(){
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<Integer> node){
        if (node != null) {
            System.out.print(node.getValue() + " "); 
            preOrderRecursive(node.getLeft());          
            preOrderRecursive(node.getRight());     
        }
    }

    public void posOrder(){
        posOrderRecursive(root);
    }

    private void posOrderRecursive(Node<Integer> node){
        if (node != null) {
            posOrderRecursive(node.getLeft());     
            posOrderRecursive(node.getRight());   
            System.out.print(node.getValue() + " "); 
        }
    }

    public void inOrder(){
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<Integer> node){
        if (node != null) {
            inOrderRecursive(node.getLeft());     
            System.out.print(node.getValue() + " "); 
            inOrderRecursive(node.getRight());
        }
    }

    


}
