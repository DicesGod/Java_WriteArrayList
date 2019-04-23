import java.util.Iterator;


public class MyListIterator <T> implements Iterator<T>{
	private MyList<T> cur;
	private MyList<T> itnext;
	private MyList<T> list;
	
	public MyListIterator(MyList<T> a) {
		cur = null;
		itnext=a;
		list=a;
	}
	
	public boolean hasNext() {
		return(!itnext.isEmpty());
	}
	
	public T next() throws MLInvalidAccessException{
		if(itnext.isEmpty()) {throw new MLInvalidAccessException(11);}
			cur = itnext;
			itnext = itnext.tail;
			return cur.data;
		}
	

	public boolean hasPrevious(){
		return(cur!=null);
	}
	
	public T previous() throws MLInvalidAccessException{
		if(cur==null) {throw new MLInvalidAccessException(12);}
			if(cur==this.list) {
			itnext = cur;
			cur=list;
		}
			else {
				MyList<T> list = this.list;
				while(list.tail != cur) {
					list=list.tail;
				}
				itnext=cur;
				cur=list;
			}
			return itnext.data;
	}
	
	public void goToBegin() {
		//if(cur==null) {throw new MLInvalidAccessException(1);}
		cur=null;
		itnext=list;
	}
	
	public void goToEnd() {
		while(!itnext.isEmpty()) {
			cur = itnext;
			itnext =itnext.tail;
		}
	}
	
	public void set(T v) throws MLInvalidAccessException{
		if (cur == null) {throw new MLInvalidAccessException (13);}
		cur.data=v;
		
	}
		
	public void add(T v) {
		MyList<T> w  = list;
		MyList<T> c = list;
		if (cur != null) {
			while (c !=  cur) {
				c = c.tail;
			}
			c = c.tail;
		}
		w = c.copy();
		c.data = v;
		c.tail = w;
		cur = c;
		itnext = w;
	}
	
	public void remove() throws MLInvalidAccessException{
		if (cur == null) {
			throw new MLInvalidAccessException(14);
		}
		
		if(cur == this.list) {
			list.data = list.tail.data;
			list.tail = list.tail.tail;
			itnext = list;
			cur = null;		}
		else
		{
			MyList<T> c = this.list;
			while(c.tail != cur) {
				c = c.tail;
			}
			c.tail = cur.tail;
			itnext = cur;
			cur = c;
		}
	}
}