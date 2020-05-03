package Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task3_3.MyLinkedList;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class LinkedListTest<E> {

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"1", "2", "3"}},
                {new Integer[]{1}},
                {new Boolean[]{true, true, false, true}},
                {new Boolean[]{true, true}},
        });
    }

    private E[] array;

    public LinkedListTest(E[] array) {
        this.array = array;
    }

    @Test
    public void add() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        assertEquals(array.length, list.length());
    }

    @Test(expected = AssertionError.class)
    public void addNegativeCase() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 1; i < array.length; i++) {
            list.add(array[i]);
        }

        assertEquals(array.length, list.length());
    }

    @Test
    public void remove() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        list.remove(array.length - 1);
        assertEquals(array.length - 1, list.length());
    }

    @Test
    public void getFirstElement() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        assertEquals(array[0], list.get(0));
    }

    @Test
    public void getLastElement() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        assertEquals(array[array.length - 1], list.get(list.length() - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfRangeIndexLess() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        list.get(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfRangeIndexMore() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        list.get(array.length);
    }

    @Test
    public void equalsValue() {
        MyLinkedList<E> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], list.get(i));
        }
    }
}
