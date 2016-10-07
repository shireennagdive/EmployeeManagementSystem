import com.simulationdemo.Animal;
import com.simulationdemo.Cat;

public class Entry {
	public static void main(String[] args) {
		
		Cat c = new Cat("Feline","");
		c.roam();
		
		System.out.println(c.getSize());
		
		Animal a;
		
//		IMPLICIT UP-CASTING
		a = (Animal)c;
		
		a.roam();
//		System.out.println(a.getSize());
	}
}
