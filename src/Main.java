import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Check MyList
		
		Integer [] input = {1,2,3,4};
		
		MyList<Integer> emptylist = new MyList<Integer>();
		MyList<Integer> listsample = new MyList<Integer>(input);
		System.out.println("Check empty list: "+emptylist.isEmpty());
		System.out.println("Check listsample: "+emptylist.isEmpty());
		System.out.println("Test list: "+listsample);
		System.out.println("Array of objects: "+listsample.toArray());
		System.out.println("Data of first node: "+listsample.head());
		System.out.println("MyList without first node: "+listsample.tail());
		System.out.println("Data of last node: "+listsample.end());
		
		listsample.append(5);
		System.out.println("Create a node at the end of the MyList: "+listsample.toString());
		
		Integer [] input2 = {6,7,8};
		
		MyList<Integer> listsample2 = new MyList<Integer>(input2);
		listsample.concat(listsample2);
		System.out.println("Concatenated list: "+listsample.toString());
		
		//Create iterator
		Integer [] input3 = {1,2,3};
		MyList<Integer> listsample3 = new MyList<Integer>(input3);
		MyListIterator<Integer> itr = listsample3.iterator();
		
		//Check Iterator
	
		System.out.println("Check hasNext: "+itr.hasNext());
		System.out.println("Check hasPrevious: "+itr.hasPrevious());
		itr.next();
		itr.next();
		itr.next();
		System.out.println("Check hasNext: "+itr.hasNext());
		System.out.println("Check hasPrevious: "+itr.hasPrevious());
		
		itr.goToBegin();
		System.out.println("Check hasNext after goToBegin: "+itr.hasNext());
		System.out.println("Check hasPrevious after goToBegin: "+itr.hasPrevious());
		
		itr.goToEnd();
		System.out.println("Check hasNext after goToEnd: "+itr.hasNext());
		System.out.println("Check hasPrevious after goToEnd: "+itr.hasPrevious());
		
		itr.goToBegin();

		
		itr.next(); // Move to A
		
		//Add iteration (E)
		itr.add(5);
		System.out.println("Add iteration E: "+listsample3.toString());
		
		
		//Remove iteration (B)
		itr.next(); // move to B
		itr.remove();
		System.out.println("Remove iteration B: "+listsample3.toString());
		
		
		
	}

}
