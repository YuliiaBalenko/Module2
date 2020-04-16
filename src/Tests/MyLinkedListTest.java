package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task3_3.MyLinkedList;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList<String> elements = new MyLinkedList();
    private MyLinkedList<Integer> elementsInt = new MyLinkedList<>();

    @Before
    public void setUp() {

        elements.add("1");
        elements.add("2");
        elements.add("3");
        elements.add("4");
        elements.add("5");
    }

    @Test
    public void add() {

        assertEquals("1,2,3,4,5", elements.toString());
        int[] testIntArray = {1, 2, 3, 4, 5};

    }

    @Test
    public void remove() {
        elements.remove(2);
        assertEquals("1,2,4,5", elements.toString());
    }

    @Test
    public void get() {
        assertEquals("4", elements.get(3));

    }

}