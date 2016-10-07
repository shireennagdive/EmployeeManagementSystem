import com.simulationdemo.Animal;
import com.simulationdemo.Cat;
import com.simulationdemo.Pet;

public class Entry5 {
	public static void main(String[] args) {
		Pet p;
		System.out.println(Pet.MAX_ALLOWED);

		
		Animal a = getAnimal();

		
		a.someUtility();
		Cat.someUtility();

		
		
		boolean flag = (a instanceof Pet);
		if(flag){
			p = (Pet) a;
			p.beFriendly();
			p.play();
		}
		
	}
	
	
	public static Animal getAnimal(){
		return new Cat("Feline", "XYZ");
	}
	
	
}
