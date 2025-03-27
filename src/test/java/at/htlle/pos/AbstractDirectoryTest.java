package at.htlle.pos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractDirectoryTest {
    protected Node root;

    /*
     *  /
     *  +- home/
     *       +- toni/
     *            +- .bashrc 	[1024 bytes]
     *            +- todo.txt 	[2048 bytes]
     *       +- tomcat/
     *            +- .bashrc     [512 bytes]
     */
    @Test
    public void testNavigation() {
        assertEquals("/", root.getName());
        assertEquals("home", root.getNodes().get(0).getName());
        assertEquals("toni", root.getNodes().get(0).getNodes().get(0).getName());
        assertEquals(".bashrc", root.getNodes().get(0).getNodes().get(0).getNodes().get(0).getName());
        assertEquals(1024, root.getNodes().get(0).getNodes().get(0).getNodes().get(0).getSize());
        assertEquals("todo.txt", root.getNodes().get(0).getNodes().get(0).getNodes().get(1).getName());
        assertEquals(2048, root.getNodes().get(0).getNodes().get(0).getNodes().get(1).getSize());

        assertEquals("tomcat", root.getNodes().get(0).getNodes().get(1).getName());
        assertEquals(".bashrc", root.getNodes().get(0).getNodes().get(1).getNodes().get(0).getName());
        assertEquals(512, root.getNodes().get(0).getNodes().get(1).getNodes().get(0).getSize());
    }

    @Test
    public void testGetSize() {
        assertEquals(1024 + 2048 + 512, root.getSize());
    }

    @Test
    public void testNumberOfFiles() {
        assertEquals(3, root.numberOfFiles());
    }

    @Test
    public void testSetNameNull() {
        assertThrows(NullPointerException.class, () -> {
            new Directory(null);
        });
    }

    @Test
    public void testSetNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Directory("");
        });
    }

    @Test
    public void testSetNameBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Directory("\t ");
        });
    }

    @Test
    public void testAddNodeNull() {
        assertThrows(NullPointerException.class, () -> {
            root.addNode(null);
        });
    }

    @Test
    public void testReadOnlyList() {
        assertThrows(UnsupportedOperationException.class, () -> {
            root.getNodes().add(new File("virus", 666));
        });
    }
}
