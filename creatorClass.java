import java.util.*;
//its helper class.
public class creatorClass {
	//function creates random integer between min and max value
	public int random_int_generator(int min, int max){

		Random random=new Random();

		int random_number=(random.nextInt(max + 1 - min) + min);

		return random_number;
	}
	//creates array with random integers
	public int[] random_array_generator(int size, int min, int max){

		int random_array[] = new int[size];

		for(int i = 0; i < random_array.length; i++)
			random_array[i] = random_int_generator(min, max);
		
		return random_array;
	}
}
