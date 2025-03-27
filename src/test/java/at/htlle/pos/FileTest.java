package at.htlle.pos;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FileTest {


    @Test
    public void testConstructorHappyPath() {
        File f = new File("File.java", 520);
        assertNotNull(f);
    }

    @Test
    public void testConstructorNameNull() {
        assertThrows(NullPointerException.class, () -> {
            new File(null, 0);
        });
    }

    @Test
    public void testConstructorNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new File("", 1024);
        });
    }

    @Test
    public void testConstructorNameBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new File("\n\t ", 1024);
        });
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testConstructorSizeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new File("Name", -1);
        });
    }


    @Test
    public void testNumberOfFiles() {
        File f = new File("Node.java", 520);
        assertEquals(1, f.numberOfFiles());
    }

    @Test
    public void testGetSize() {
        File f = new File("Node.java", 1024);
        assertEquals(1024, f.getSize());
    }

    @Test
    public void testEqualsAndHashCode() {
        File a = new File("README.txt", 666);
        File b = new File("README.txt", 666);
        File c = new File("README", 666);
        File d = new File("README.txt", 333);

        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertTrue(a.hashCode() == b.hashCode());

        assertFalse(a.equals(c));
        assertFalse(a.equals(d));
    }

    @Test
    public void testToString() {
        File f = new File("README.txt", 666);
        assertEquals("README.txt", f.toString());
    }
}
