import models.Persona;
import structures.graphs.Graph;
import structures.nodes.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        //runIntTree();
        //runTree();
        runGraph();
    }

    private static void runIntTree(){
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("Pre Order");
        tree.preOrder();
        System.out.println();
        System.out.println("Pos Order");
        tree.posOrder();
        System.out.println();
        System.out.println("In Order");
        tree.inOrder();
        System.out.println();
        System.out.println("size: " + tree.size());

        Tree<Persona> tree1 = new Tree<>();
        tree1.insert(new Persona("Pablo", 21));
        tree1.insert(new Persona("Maria", 23));
        tree1.insert(new Persona("Ana", 25));
        tree1.insert(new Persona("Pedro", 23));
        tree1.insert(new Persona("Luis", 19));

        System.out.println("PreOrder");
        tree1.preOrder();
        
    }

    private static void runTree(){
        Tree<Persona> tree = new Tree<>();
        tree.insert(new Persona("Pablo", 21));
        tree.insert(new Persona("Maria", 23));
        tree.insert(new Persona("Ana", 25));
        tree.insert(new Persona("Pedro", 23));
        tree.insert(new Persona("Luis", 19));

        System.out.println("PreOrder");
        tree.preOrder();
        System.out.println();

        System.out.println("Busqueda de Persona Edad 23");

        Persona findPerson = tree.searchByAge(23);
        if(findPerson != null){
            System.out.println(findPerson);
        }else{
            System.out.println("No se encontró");
        }
        
    }

    private static void runGraph(){
        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");
        
        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);
        graph.printGraph();

        Node<String>[] neighbors = graph.getNeighbors(nA);
        System.out.print("Neighbors de A: ");
        for(Node<String> neighbor : neighbors){
            System.out.print(neighbor + " ");
        }
    }
}
