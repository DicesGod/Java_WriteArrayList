import java.util.Arrays;

public class MyList<T> {
	T data;
	MyList<T> tail;
	
	public MyList() {
		data = null;
		tail = null;
	}
	
	public MyList(T data) {
		this.data = data;
		tail = new MyList<T>();
	}
	
	public MyList(T[] v) {
		if (v == null) {
				data = null;
				tail = null;
	}
		else {
			MyList<T> w = this;
			for (int i = 0;i<v.length;i++) {
				w.data = v[i];
				w.tail = new MyList<T>();
				w=w.tail;
			}
			
		}
	}
	
	public boolean isEmpty() {
		if(this.data == null && this.tail == null) {
		return true;}
		else return false;
	}
	
	public Object[] toArray(){
		Array<T> listofT =  new Array<T>();
		return listofT;
	}
}	
