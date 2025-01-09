package cz.cuni.mff.milotovl.util;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.lang.NegativeArraySizeException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;

/**
 * Implementation of a mutable string, allowing dynamic modifications.
 */
public class MyString implements MutableString, Iterable<Character> {

    private char[] s;

    // pouzivam getChars a arraycopy, drzim pole charov

    /**
     * Default constructor that creates an empty MyString.
     */
    public MyString() {
        this.s = new char[0];
    }

    /**
     * Constructor that creates a MyString from the given String.
     *
     * @param str The source String to create the MyString from.
     * @throws NullPointerException If the input String is null.
     */
    public MyString(String str) {
        if (str == null) {
            throw new NullPointerException(); // chcem vyhodit podmienku aby nikto nevytvaral MyString(null)
        }
        this.s = str.toCharArray();
    }

    /**
     * Appends the given string to the end of the current MyString.
     *
     * @param str The string to append.
     */
    public void append(String str) {
        char[] destination = new char[this.s.length + str.length()];
        System.arraycopy(this.s, 0, destination, 0, this.s.length);
        str.getChars(0, str.length(), destination, this.s.length);
        this.s = destination;
    }

    /**
     * Appends the given character to the end of the current MyString.
     *
     * @param ch The character to append.
     */
    public void append(char ch) {
        char[] destination = new char[this.s.length + 1];
        System.arraycopy(this.s, 0, destination, 0, this.s.length);
        destination[destination.length - 1] = ch;
        this.s = destination;
    }

    /**
     * Inserts the given string at the specified position in the MyString.
     *
     * @param pos The position at which to insert the string.
     * @param str The string to insert.
     * @throws ArrayIndexOutOfBoundsException If the position is greater than the length of the MyString.
     */
    public void insert(int pos, String str) {
        if (this.s.length < pos) {
            throw new ArrayIndexOutOfBoundsException(); // vyhodim vynimku ked niekto vklada "za" string
        }
        char[] destination = new char[this.s.length + str.length()];
        System.arraycopy(this.s, 0, destination, 0, pos); // skopirovanie prvej casti stringu
        str.getChars(0, str.length(), destination, pos); // vlozenie noveho stringu
        System.arraycopy(this.s, pos, destination, pos + str.length(), this.s.length - pos); // skopirovanie druhej casti stringu
        this.s = destination;
    }

    /**
     * Inserts the given character at the specified position in the MyString.
     *
     * @param pos The position at which to insert the character.
     * @param ch  The character to insert.
     * @throws ArrayIndexOutOfBoundsException If the position is greater than the length of the MyString.
     */
    public void insert(int pos, char ch) {
        if (this.s.length < pos) {
            throw new ArrayIndexOutOfBoundsException(); // vyhodim vynimku ked niekto vklada "za" string
        }
        char[] destination = new char[this.s.length + 1];
        System.arraycopy(this.s, 0, destination, 0, pos); // skopirovanie prvej casti stringu
        destination[pos] = ch; // vlozenie noveho charu
        System.arraycopy(this.s, pos, destination, pos + 1, this.s.length - pos); // skopirovanie druhej casti stringu
        this.s = destination;
    }

    /**
     * Deletes a substring of the MyString starting from the specified position with the given length.
     *
     * @param pos    The starting position for deletion.
     * @param length The length of the substring to delete.
     * @throws NegativeArraySizeException If the length is greater than the current length of the MyString.
     */
    public void delete(int pos, int length) {
        if (this.s.length < length) {
            throw new NegativeArraySizeException(); // vyhodim vynimku pri mazani viac znakov nez je string vobec dlhy
        }
        char[] destination = new char[this.s.length - length];
        System.arraycopy(this.s, 0, destination, 0, pos); // skopirovanie prvej casti stringu
        System.arraycopy(this.s, pos + length, destination, pos, this.s.length - pos - length); // skopirovanie druhej casti stringu
        this.s = destination;
    }

    /**
     * Returns the string representation of the MyString.
     *
     * @return The string representation of the MyString.
     */
    public String toString() {
        return new String(this.s);
    }

    /**
     * Returns the length of the MyString.
     *
     * @return The length of the MyString.
     */
    @Override
    public int length() {
        return s.length;
    }

    /**
     * Checks if the given object is equal to the MyString.
     * It checks three possible types of the instance. For
     * other types false is returned. The three types are
     * String, MyString and Character.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == getClass()) {
            MyString myString = (MyString) o;
            return Arrays.equals(this.s, myString.s);
        } else if (o.getClass() == String.class) {
            return this.toString().equals(o);
        } else if (o.getClass() == Character.class) {
            return this.s[0] == (char) o;
        }
        return false;
    }

    /**
     * Computes the hash code of the MyString.
     *
     * @return The hash code of the MyString.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(s);
    }

    /**
     * Returns an iterator over the characters of the MyString.
     *
     * @return An iterator over the characters of the MyString.
     */
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            int currIndex = 0;

            public boolean hasNext() {
                return currIndex < s.length;
            }

            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return s[currIndex++];
            }
        };
    }
}