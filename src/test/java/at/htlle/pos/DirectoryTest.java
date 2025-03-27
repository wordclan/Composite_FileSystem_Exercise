package at.htlle.pos;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest 	extends AbstractDirectoryTest {
	@BeforeEach
	void setup() {
		root = new Directory("/");

		Directory home = new Directory("home");
		Directory toni = new Directory("toni");
		Directory tomcat = new Directory("tomcat");

		File bashrcToni = new File(".bashrc", 1024);
		File todoTxt = new File("todo.txt", 2048);
		File bashrcTomcat = new File(".bashrc", 512);

		root.addNode(home);
		home.addNode(toni);
		home.addNode(tomcat);

		toni.addNode(bashrcToni);
		toni.addNode(todoTxt);

		tomcat.addNode(bashrcTomcat);
	}

	@Test
	void testConstructor(){
		Directory dir = new Directory("Test");
		assertNotNull(dir);
	}

	@Test
	void testConstructorNameNull(){
		assertThrows(NullPointerException.class, () -> new Directory(null));
	}

	@Test
	void  testConstructorNameEmpty(){
		assertThrows(IllegalArgumentException.class, ()-> new Directory(""));
	}

	@Test
	void testConstructorNameBlank(){
		assertThrows(IllegalArgumentException.class, ()-> new Directory("\t\n "));
	}

}
