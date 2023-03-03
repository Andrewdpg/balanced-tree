package seguimientos.laboratorio_5;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String key;
    // Datos

    // Enlaces
    private Node right;
    private Node left;

    public Node(String key) {
        this.key = key;
    }

    public void addInOrder(List<String> names) {
        if (names.size() == 1) {
            this.key = names.get(0);
            return;
        }

        int middle = (names.size()-1)/2;
        this.key = names.get(middle);
        names.remove(middle);

        if (names.size() > 1) {
            setLeft(new Node(null));
            left.addInOrder(getItems(names, 0, middle));
            setRight(new Node(null));
            right.addInOrder(getItems(names, middle, names.size()));
        } else {
            if (this.key.compareTo(names.get(0)) > 0) {
                setLeft(new Node(names.get(0)));
            } else {
                setRight(new Node(names.get(0)));
            }
        }
    }

    public List<String> getItems(List<String> list, int init, int end) {
        List<String> nList = new ArrayList<String>();
        for (int i = init; i < end; i++) {
            nList.add(list.get(i));
        }
        return nList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
