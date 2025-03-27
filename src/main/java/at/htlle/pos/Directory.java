package at.htlle.pos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory extends Node{

    /**
     * Properties
     */
    private String name;
    private List<Node> nodes;

    /*
     * Constructor
     */
    public Directory(String name) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        if (name.trim().isEmpty()) {  // `.trim()` entfernt Leerzeichen!
            throw new IllegalArgumentException("name is empty or blank");
        }
        this.name = name;
        this.nodes = new ArrayList<>();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void addNode(Node node) {
        if (node == null) {
            throw new NullPointerException("Node cannot be null");
        }
        nodes.add(node);
    }

    @Override
    public String getName() {
        return name;
    }


    /*
     * Navigation
     */
    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }




    /*
     *  Operations
     */

    @Override
    public long getSize() {
        long size = 0;
        for (Node n : getNodes()) {
            size += n.getSize();
        }
        return size;
    }

    @Override
    public int numberOfFiles() {
        int number = 0;
        for (Node n : getNodes()) {
            number += n.numberOfFiles();
        }
        return number;
    }
}
