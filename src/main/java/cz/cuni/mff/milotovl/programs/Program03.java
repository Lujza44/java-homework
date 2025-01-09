package cz.cuni.mff.milotovl.programs;

import cz.cuni.mff.milotovl.util.BinarySearchTree;
import java.lang.NumberFormatException;
import java.util.Iterator;

public class Program03 {

    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree();
        
        for(String arg : args){
            try {
                int value = Integer.parseInt(arg);
                bst.insert(value);
            } catch (NumberFormatException e) {
                System.out.println(arg + "nie je validny int");
            }
        }

        Iterator<Integer> it = bst.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}