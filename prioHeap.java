import java.util.ArrayList;

public class prioHeap
{
	private ArrayList<placeClass> Heap;
	private int size;
	placeClass place = new placeClass();

	public prioHeap(){

		size = 0;
		Heap = new ArrayList<placeClass>();
		placeClass zeroPoint = new placeClass();
		//sets arraylist's index zero
		zeroPoint.setValue(Integer.MIN_VALUE);
		Heap.add(0,zeroPoint);

	}
	//returns parent's position
	private int parent(int pos){
		return pos / 2;
	}
	//returns left child's position
	private int leftChild(int pos){
		return (2 * pos) ;
	}
	//returns right child's position
	private int rightChild(int pos){
		return (2 * pos) + 1;
	}
	//returns position is leaf or not
	private boolean isLeaf(int pos) {
		return (leftChild(pos) >= Heap.size());
	}

	//swap function
	private void swap(int fpos,int spos){
		placeClass tmp = Heap.get(fpos);
		Heap.set(fpos, Heap.get(spos));
		Heap.set(spos, tmp);
	}

	private void min_heapify(int pos){
		//if position has no child returns
		if(isLeaf(pos)){
			return;
		}
		
		if (!(pos*2 > Heap.size())){
			if (pos * 2 + 1  == Heap.size()) {
				if(Heap.get(pos).getValue() > Heap.get(leftChild(pos)).getValue()){
					swap(pos,leftChild(pos));
					
					min_heapify(leftChild(pos));
				}
			}
			else if ( Heap.get(pos).getValue() > Heap.get(leftChild(pos)).getValue() ||
					Heap.get(pos).getValue() > Heap.get(rightChild(pos)).getValue()){

				if (Heap.get(leftChild(pos)).getValue() < Heap.get(rightChild(pos)).getValue()){

					swap(pos, leftChild(pos));
					min_heapify(leftChild(pos));
				}else
				{
					swap(pos, rightChild(pos));
					min_heapify(rightChild(pos));
				}
			}
		}
	}
	//insertation function
	public void insert(placeClass element){
		Heap.add(++size, element);
		int current = size;

		while(Heap.get(current).getValue() < Heap.get(parent(current)).getValue()){
			swap(current,parent(current));
			current = parent(current);
		}	
	}

	//it removes min value from queue and calls heapify
	public placeClass remove(){
		if(Heap.size() == 1)
			return Heap.get(0);
		placeClass popped = Heap.get(1);
		Heap.set(1, Heap.get(size));
		Heap.remove(size);
		size--;
		min_heapify(1);
		return popped;
	}

}