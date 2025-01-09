package cz.cuni.mff.milotovl.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a binary search tree, a hierarchical data structure,
 * that allows insertion of nodes and iteration though them. Each node has
 * a left and right child. For any node, all nodes in its left subtree have
 * a smaller value than the node and all nodes in its right subtree have
 * a greater value than the node.
 */
public class BinarySearchTree implements Iterable{

    /**
     * This clas represents one node in the tree. It has a value, left and right
     * child and a parent node.
     */
    private static class Node{
        int value;
        Node left;
        Node right;
        Node parent;
    }

    private Node root;

    /**
     * This method provides insertion into the tree.
     * @param value a value of a node to be inserted into the tree
     */
    public void insert(int value){
        root = insertRec(value, root);
    }

    /**
     * This private method called by the public one <code>insert(int value)</code>
     * provides a recursive insertion of a given value into the tree.
     * @param value a value of a node to be inserted into the tree
     * @param node a root node
     * @return
     */
    private Node insertRec(int value, Node node){ // rekurzivne vlozenie noveho uzlu
        if(node == null){
            node = new Node();
            node.value = value;
        } else if(value < node.value){
            node.left = insertRec(value, node.left);
            node.left.parent = node;
        } else if(value > node.value){
            node.right = insertRec(value, node.right);
            node.right.parent = node;
        }
        return node;
    }

    /**
     * This method provides an iterator to iterate through the tree from
     * the smallest element to the greatest one.
     * @return iterator for iterating through the tree
     */
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() { // implementujem interface Iterator
            Node current = findLeftmost(root); //najmensi prvok v strome
 
            private Node findLeftmost(Node node){
                while(node != null && node.left != null){
                    node = node.left;
                }
                return node;
            }

            public boolean hasNext() {
                return current != null;
            }

            public Integer next() {
                new ArrayList<>().iterator();
                if(current == null){
                    throw new NoSuchElementException();
                }
                int value = current.value;
                if(current.right != null){ // da sa ist doprava
                    current = findLeftmost(current.right); // ideme doprava a potom dolava kym sa da
                } else { // ked sa neda ist doprava, vraciam sa do rodica, kym narazim na hodnotu vacsiu ako moju
                    while(current.parent != null && current.value > current.parent.value){
                        current = current.parent; // vraciame sa do rodica sprava
                    }
                    current = current.parent; // vratim sa do rodica zlava
                }
                return value;
            }
        };
    }
}