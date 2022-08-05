import exception.ParametrIsNotInteger;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    private StringList stringList;

    @BeforeEach
    void initTest(){
        stringList = new StringListImpl();
        stringList.add("7");
        stringList.add("55");
    }


    @org.junit.jupiter.api.Test
    void addTest() {
        stringList.add("90");
        String[] expected = new String[]{"7","55","90"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

@org.junit.jupiter.api.Test
    void addToIndexTest() {
        stringList.add(1,"50");
        String[] expected = new String[]{"7","50","55"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @org.junit.jupiter.api.Test
    void ifAddNoInteger() {
        StringList stringList = new StringListImpl();
        assertThrows(ParametrIsNotInteger.class, () -> stringList.add("abc"));
    }

    @org.junit.jupiter.api.Test
    void setTest() {
        stringList.add("90");
        stringList.set(1,"33");
        String[] expected = new String[]{"7","33","90"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @org.junit.jupiter.api.Test
    void removeByIndexTest() {
        stringList.add("90");
        stringList.remove(1);
        String[] expected = new String[]{"7","90"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @org.junit.jupiter.api.Test
    void removeByItemTest() {
        stringList.add("90");
        stringList.remove("7");
        String[] expected = new String[]{"55","90"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @org.junit.jupiter.api.Test
    void containsTest() {
        assertTrue(stringList.contains("55"));
        assertFalse(stringList.contains("111"));
    }

    @org.junit.jupiter.api.Test
    void indexOfTest() {
        int expected = 1;
        int actual = stringList.indexOf("55");
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOfTest() {
        stringList.add("7");
        int expected = 2;
        int actual = stringList.lastIndexOf("7");
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void get() {
        String expected = "7";
        String actual = stringList.get(0);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void equalsTest() {
        StringList stringListNew = new StringListImpl();
        stringListNew.add("7");
        stringListNew.add("55");
        assertTrue(stringList.equals(stringListNew));
        stringListNew.add("88");
        assertFalse(stringList.equals(stringListNew));
    }

    @org.junit.jupiter.api.Test
    void size() {
        stringList.add("88");
        stringList.add("99");
        int expected = 4;
        int actual = stringList.size();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertFalse(stringList.isEmpty());
        stringList.remove("7");
        stringList.remove("55");
        assertTrue(stringList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        stringList.clear();
        System.out.println(stringList.get(0));
        assertEquals(0, stringList.size());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        String[] expected = new String[]{"7","55"};
        String[] actual = stringList.toArray();
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }
}