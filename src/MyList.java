import java.util.Arrays;

public class MyList<T> {
	
	//The objects of the type MyList<T> are aggregation of an object of type T (data) and an object of type MyList<T> (tail).
	T data;
	MyList<T> tail;
	
	//CONSTRUCTORS:
	// empty list
	public MyList() {
		data = null;
		tail = null;
	}
	
	// list of a single node, whose member "data" is v
	public MyList(T data) {
		this.data = data;
		tail = new MyList<T>();
	}
	
	
	// list whose nodes correspond to the elements of the array v
	public MyList(T[] v) {
		if (v == null) {
				data = null;
				tail = null;
	}
		else {
			MyList<T> temp = this;  // Initial
			for (int i = 0;i<v.length;i++) {
				temp.data = v[i];
				temp.tail = new MyList<T>();
				temp=temp.tail;
			}
			
		}
	}
	
	@Override
	public String toString() {
		return "[data=" + data + ", tail=" + tail + "]";
	}
	
	//DYNAMIC METHOS:
	// returns true if the MyList is empty.
	public boolean isEmpty() {
		if(this.data == null && this.tail == null) {
		return true;}
		else return false;
	}
	
	// return the array of objects of type T corresponding to MyList
	public Object[] toArray(){
		Object[]w = new Object[0];
		MyList<T> list = this;
		while(!list.isEmpty()) {
			w= Arrays.copyOf(w, w.length+1);
			w[w.length-1]=list.data;
			list = list.tail;

		}
		return w;
	}
	
	// returns a copy (deep clone) of the MyList.
	public MyList<T> copy(){
		MyList<T> r = new MyList<T>();
		MyList<T> wt = this;
		MyList<T> wr = r;
		while(!wt.isEmpty()) {
			wr.data=wt.data;
			wr.tail= new MyList<T>();
			wr=wr.tail;
			wt=wt.tail;
		}
		return r;
	}
	
	// return the value of "data" of the first node.
	public T head() {
		MyList<T> list = this;
		if(list.isEmpty()) {
			return data = null;
		}
		else {
			return list.data = data;
		}
	}
	
	// return the MyList without its first node.
	public MyList<T> tail(){
		MyList<T> list = new MyList<T>();
		if(this.tail.isEmpty()) {
			return this;
		}
		else {			
			list=this.tail;
			return list.tail();
		}
		
		//[data=A, tail=[data=B, tail=[data=C, tail=[data=D, tail=[data=null, tail=null]]]]]
	}
	
	// return the value of "data" of the last node.
	public T end() {
		return this.tail().data;
	}
	
	// creates a node with "data"=e at the end of the MyList.
	public void append(T data) {
		if(this.isEmpty()) {
			this.data = data;
			this.tail = new MyList<T>();
		}
		else {
			MyList <T> tailtemp = this.tail();
			tailtemp.tail.data = data;
			tailtemp.tail.tail = new MyList<T>();
		}
		
	}
	
	// concatenates lc at the end of MyList.
	public void concat (MyList<T> lc) {
		if(this.isEmpty()) {
			this.data = lc.data;
			this.tail = lc.tail;
		}
		else {
			MyList <T> tailtemp = this.tail();
			tailtemp.tail = lc;
		}
	}
	
	public MyListIterator<T> iterator(){
		MyList<T> list = this;
		MyListIterator<T> itr = new MyListIterator<T>(list);
		return itr;
	}
}	
