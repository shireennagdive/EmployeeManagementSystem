import com.simulationdemo.Animal;
import com.simulationdemo.Cat;
import com.simulationdemo.Feline;

public class Entry4 {
	public static void main(String[] args) {
		Animal a = null;
		
//		STATIC TYPE OF a : Animal
//		DYNAMIC TYPE OF a: Cat
		
		a = new Cat("Feline", "Corner");
		
		a.roam();
		a.eat();
		a.sleep();
		
		boolean flag = (a instanceof Cat);
		
		if(flag){
			Cat c = (Cat) a;
			c.getSize();
		}
		
		flag = (a instanceof Feline);
		
		if(flag)
			System.out.println(((Cat)a).getSize());
		
		((Cat)a).getType().concat("XYZ").length();
		
		
		
	}
}
