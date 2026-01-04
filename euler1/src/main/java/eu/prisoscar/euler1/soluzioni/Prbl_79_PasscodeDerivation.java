package eu.prisoscar.euler1.soluzioni;

import java.util.*;
import java.util.stream.Collectors;

public class Prbl_79_PasscodeDerivation {

    private final String SUCCESSFUL_ATTEMPTS = "319,680,180,690,129,620,762,689,762,318,368,710,720,710,629,168,160,689,716,731,736,729,316,729,729,710,769,290,719,680,318,389,162,289,162,718,729,319,790,680,890,362,319,760,316,729,380,319,728,716";
    private final Set<String> ATTEMPTS_LIST = Arrays.stream(SUCCESSFUL_ATTEMPTS.split(",")).collect(Collectors.toSet());
    private final Graph GRAPH = new Graph();
    private String solution = "";

    public String getSolution() {
        populateGraph();
        insertPassChar();
        return solution;
    }

    private void populateGraph(){
        ATTEMPTS_LIST.forEach(attempt -> {
            GRAPH.addPredecessor(attempt.substring(2), attempt.substring(1, 2));
            GRAPH.addPredecessor(attempt.substring(2), attempt.substring(0,1));
            GRAPH.addPredecessor(attempt.substring(1, 2), attempt.substring(0,1));
        });
    }

    private void insertPassChar() {
        Node lonlinest = GRAPH.getLonlinest();
        solution += lonlinest.element;
        GRAPH.NODES.remove(lonlinest);
        GRAPH.NODES.forEach(node -> node.predecessors.removeIf(p -> p.element.equals(lonlinest.element)));
        if(!GRAPH.NODES.isEmpty()) insertPassChar();
    }




    private static class Graph {
        List<Node> NODES = new LinkedList<>();

        void addPredecessor(String element, String previous) {
            Optional<Node> maybeNode = getNode(element);
            Node rootNode = maybeNode.orElse(new Node(element));
            if(maybeNode.isEmpty()) NODES.add(rootNode);
            Optional<Node> maybePrevious = getNode(previous);
            Node previousNode = maybePrevious.orElse(new Node(previous));
            if(maybePrevious.isEmpty()) NODES.add(previousNode);
            rootNode.predecessors.add(previousNode);
        }

        Optional<Node> getNode(String element){
            return NODES.stream().filter(node -> Objects.equals(node.element, element)).findFirst();
        }

        Node getLonlinest(){
            return NODES.stream().filter(node -> node.predecessors.isEmpty()).findFirst().orElse(null);
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder("Graph -> \n");
            for(Node node: NODES){
                string.append(node.toString()).append("\n");
            }
            return string.substring(0, string.length() -1);
        }
    }

    private static class Node {
        String element;
        List<Node> predecessors = new LinkedList<>();

        Node (String element){
            this.element = element;
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder("Node: " + element + "\nPredecessors:\n");
            for (Node node:predecessors){
                string.append(node.element).append(",");
            }
            return string.substring(0, string.length() -1);
        }

    }

}
