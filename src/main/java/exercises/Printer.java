package exercises;

public interface Printer{
    void print(String msg);
    default void print(int number){
        print(String.valueOf(number));
    }
}