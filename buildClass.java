import java.util.Scanner;

public class buildClass {

	private prioHeap queue = new prioHeap();
	private Scanner keyboard = new Scanner(System.in);
	private creatorClass random = new creatorClass();
	// a and b is alice's coordinates
	private int a;
	private int b;

	public buildClass(){
		//creates alice's location randomly
		a = random.random_int_generator(-1000, 1000);
		b = random.random_int_generator(-1000, 1000);
		
	}
	public void start(){
		// keyboard input
		int N = user_input();
		//fills queue
		fill_queue(a, b);
		// prints output
		output(N);
		
		
	}
	private int user_input(){
		System.out.println("Please enter an integer for N:");
		int N = keyboard.nextInt();
		//it checks whether N is between 0 and 100.
		if(N > 100 || N <= 0){
			System.out.println("Error! Enter an integer between 0 and 100.\n");
			user_input();
		}
		return N;
	}
	//calculates booster distance and returns it
	private int booster_dist(int x, int y,int a, int b){

		
		return (int) Math.sqrt(Math.pow(x-a, 2) + Math.pow(b-y, 2));
	}
	//creates place
	private placeClass create_place(int a, int b){
		placeClass place = new placeClass();
		//sets place's x,y coordinates, fee and booster distance and returns place obj
		place.setX_coord(random.random_int_generator(-1000, 1000));
		place.setY_coord(random.random_int_generator(-1000, 1000));
		place.setFee(random.random_int_generator(0, 60));
		place.setBooster_dist(booster_dist(place.getX_coord(), place.getY_coord(), a, b));

		return place;
	}
	
	//prints output
	private void output(int N){
		placeClass removed = new placeClass();
		for (int i = 1; i <= N; i++) {
			//removes min place from queue and prints it with informations
			removed = queue.remove();
			System.out.println("The booster distances are found!");
			System.out.println(i + "th" + " nearest distance calculated with the " + removed.getGeneration() + "th generated coordinate is " + removed.getBooster_dist());
			System.out.println("Coordinates of touristic place is " + "(" + removed.getX_coord() +","+ removed.getY_coord()+"), location fee is " + removed.getFee() + "\n");
		}
		
	}
	//queue filler
	private void fill_queue(int a, int b){
		//sets place's generation. if it's distance less than 200, it sets place's value to -(200-fee) then it insert place.
		for (int i = 1; i <= 100; i++) {
			placeClass place = create_place(a, b);
			place.setGeneration(i);
			
			if (place.getBooster_dist() <= 200) {
				place.setValue(-(200-place.getFee()));
				queue.insert(place);
			}
			else {
				place.setValue(place.getBooster_dist());
				queue.insert(place);
			}
		}
		
	}
}
