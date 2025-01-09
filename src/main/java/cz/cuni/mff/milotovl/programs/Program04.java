package cz.cuni.mff.milotovl.programs;

import java.util.Iterator;
import cz.cuni.mff.milotovl.util.MyString;

public class Program04 {
    public static void main(String args[]){

        //test();

        MyString s = new MyString("hello");
        s.append(" world");
        s.delete(0, 1);
        s.insert(0, "H");
        s.append("!");
        System.out.println(s);
    }   
    
    public static void test(){

        // vypisanie postupne

        MyString s = new MyString("hello");
        System.out.println(s);

        s.append(" world");
        System.out.println(s);

        s.delete(0, 1);
        System.out.println(s);


        s.insert(0, "H");
        System.out.println(s);

        s.append("!");
        System.out.println(s);
    
        System.out.println("");
        

        // vypisanie iteratorom 

        
        Iterator<Character> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }

        System.out.println("");
        System.out.println("");

        MyString s1 = new MyString(null); // parameter null
        s1.append("hello");
        System.out.println(s1);
    }
}