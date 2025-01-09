package cz.cuni.mff.milotovl.util;

/**
 * This class represents a dynamic array that automatically
 * resizes itself by a variation of number of elements in it.
 * It provides methods to add and remove elements from the
 * array and a method to get an element by a specified index.
 */
public class Array implements MyCollection{ //tu musi byt implemets
    private Object[] objects = new Object[0]; //array s ktorym budem pracovat v metodach -> private

    /**
     * This method adds Object o to the end of this Array.
     *
     * @param o Object to be added to the end of this <code>Array</code>
     */
    public void add(Object o){
        Object[] newObjects = new Object[objects.length+1]; //potrebujem pole zvacsit o 1

        for(int j = 0; j < objects.length; j++){ //skopirujem vsetky objekty zo stareho pola do noveho
            newObjects[j] = objects[j];
        }

        newObjects[newObjects.length-1] = o; //novy objekt pridam na koniec noveho zoznamu    
        this.objects = newObjects; //this tu nemusi byt
    }

    /**
     * This method gets an element from the array by its index.
     *
     * @param i index of an item to get
     * @return the element at the specified index
     */
    public Object get(int i){ //iba vraciam objekt na indexe i
        checkIndex(i);
        return objects[i];
    }

    /**
     * This method removes a specified element from the array.
     *
     * @param o Object to be removed
     */
    public void remove(Object o){ // odstranim prvy vyskyt Objectu o v poli ak sa tam nachadza, inak sa nedeje nic
        int i = indexOf(o);
        if(i != -1){
            this.remove(i);
        }
    }

    /**
     * This method removes an element at the specified index from the array.
     *
     * @param i index of an element to be removed
     */
    public void remove(int i){ //odstranenie objektu z indexu i
        checkIndex(i);
        Object[] newObjects = new Object[objects.length-1]; //potrebujem pole zmensit o 1
        
        for(int j = 0; j < objects.length; j++){
            if(j < i){ //vsetky objekty pred indexom i skopirujem do noveho pola
                newObjects[j] = objects[j];
            }
            else if(j == i){ //objekt na indexe i preskocim
                continue;
            }
            else{ //ostatne objekty posuniem o jeden dopredu v novom poli
                newObjects[j-1] = objects[j];
            }
        }
        this.objects = newObjects; //this tu nemusi byt
    }


    private void checkIndex(int i){ //metoda na kontrolu indexu keby sa niekto snazil napr. mazat z prazdneho pola
        if(i >= objects.length || i < 0){
            throw new IndexOutOfBoundsException(String.format("%s, array length: %s", i, objects.length)); //asi to mozem takto thrownut :D
            // %s su placeholdery vo formate String pre argumenty
        }
    }

    private int indexOf(Object o){ // metoda na zistenie indexu Objectu o
        for(int i = 0; i < objects.length; i++){
            if (o.equals(objects[i])){
                return i;
            }
        }
        return -1; // ak Object o nie je v poli
    }

    /**
     * This method provides the size of the array.
     *
     * @return size of the array
     */
    public int size() {
        return objects.length;
    }

    /**
     * This method creates an instance of dynamic array of given elements.
     *
     * @param args elements to be stored in the array
     * @return an array with given elements
     */
    public static Array of(Object... args) { // beriem lubovolny pocet parametrov lubovolneho typu
        Array newArray = new Array();
        newArray.objects = new Object[args.length];

        for(int i = 0; i < newArray.objects.length; i++){
            newArray.objects[i] = args[i];
        }
        return newArray; // vratim nove dynamicke pole obsahujuce dane parametre
    }
}
