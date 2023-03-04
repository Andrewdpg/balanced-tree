package seguimientos.laboratorio_5;

import java.util.ArrayList;

public class BST {

    private Node root;
    private int max;

    public void addInOrder(ArrayList<String> names) {
        root = new Node(null);
        root.addInOrder(names);
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(Node current, Node node) {
        if (node.getKey().compareTo(current.getKey()) < 0) {
            // Meter a la izquierda
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }
        } else if (node.getKey().compareTo(current.getKey()) > 0) {
            // Meter a la derecha
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                add(current.getRight(), node);
            }

        } else {
            // No hacer nada
        }
    }

    public Node getMin() {
        return getMin(root);
    }

    private Node getMin(Node current) {
        if (current.getLeft() == null) {
            return current;
        }
        return getMin(current.getLeft());
    }

    public Node getMax() {
        return getMax(root);
    }

    private Node getMax(Node current) {
        if (current.getRight() == null) {
            return current;
        }
        return getMax(current.getRight());
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeft());
        System.out.println(current.getKey());
        inOrder(current.getRight());
    }

    public void reverseOrder() {
        System.out.println("Lista en reversa: ");
        reverseOrder(root, 0);
        System.out.println("\nMaxima profundidad: " + max);
    }

    private void reverseOrder(Node current, int count) {
        if (current == null) {
            return;
        }
        count++;
        if (count > max)
            max = count;
        reverseOrder(current.getRight(), count);
        System.out.print(current.getKey() + ",");
        reverseOrder(current.getLeft(), count);
    }

    public Node search(String goal) {
        return search(root, goal);
    }
    
    public int height() {
        return getMax(root, 0);
    }
    
    public int getHeight(Node current, int count){
        if(current == null){
            return count;
        }
        int left = getMax(current.left, count+1);
        int right = getMax(current.right, count+1);
        return left <right?right:left;
    }

    private Node search(Node current, String goal) {
        if (current == null) {
            System.out.println("Not found");
            return null;
        }
        if (current.getKey().equals(goal)) {
            return current;
        }

        if (goal.compareTo(current.getKey()) < 0) {
            return search(current.getLeft(), goal);
        } else {
            return search(current.getRight(), goal);
        }
    }

    public void delete(String goal) {
        delete(root, null, goal);
    }

    private void delete(Node current, Node parent, String goal) {
        if (current == null) {
            return;
        }

        if (current.getKey().equals(goal)) {
            if (parent == null) {
                root = deleteNode(current);
            } else {
                if (parent.getLeft() == current) {
                    parent.setLeft(deleteNode(current));
                } else {
                    parent.setRight(deleteNode(current));
                }
            }
            return;
        }

        if (goal.compareTo(current.getKey()) < 0) {
            delete(current.getLeft(), current, goal);
        } else {
            delete(current.getRight(), current, goal);
        }
    }

    private Node deleteNode(Node current) {
        if (current.getLeft() != null && current.getRight() == null) {
            return current.getLeft();
        } else if (current.getLeft() == null && current.getRight() != null) {
            return current.getRight();
        } else if (current.getRight() != null && current.getLeft() != null) {
            current.setKey(getMin(current.getRight()).getKey());
            delete(current.getRight(), current, current.getKey());
            return current;
        } else {
            return null;
        }
    }
}
