package seguimientos.laboratorio_5;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static BST tree;
    public static void main(String[] args) {

        tree = new BST();
        ArrayList<String> array = new ArrayList<String>();
        System.out.print("Introduce el arreglo de nombres ordenado: ");
        Collections.addAll(array,Reader.readString().split(" "));
        tree.addInOrder(array);
        tree.reverseOrder();
    }
}