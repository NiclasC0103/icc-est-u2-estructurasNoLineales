package structures.trees;

import structures.nodes.Node;

public class Tree<T extends Comparable<T>>{
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insertRecursive(this.root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        
        return current;
    }

    public void preOrder(){
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<T> node){
        if (node != null) {
            System.out.print(node.getValue() + " "); 
            preOrderRecursive(node.getLeft());          
            preOrderRecursive(node.getRight());     
        }
    }

    public T search(T value){
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> current, T value){
        if (current == null) {
            return null;
        }

        int comparison = value.compareTo(current.getValue());

        if (comparison == 0) {
            return current.getValue();
        }

        if (comparison < 0) {
            return searchRecursive(current.getLeft(), value);
        } 

        else {
            return searchRecursive(current.getRight(), value);
        }
    }

    public T searchByAge(int age) {
        return searchByAgeRecursive(root, age);
    }

    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) {
            return null;
        }

        if (current.getValue() instanceof models.Persona p) {
            if (p.getEdad() == age) {
                return current.getValue();
            }
        }

        T foundLeft = searchByAgeRecursive(current.getLeft(), age);
        if (foundLeft != null) {
            return foundLeft;
        }

        return searchByAgeRecursive(current.getRight(), age);
    }
}
