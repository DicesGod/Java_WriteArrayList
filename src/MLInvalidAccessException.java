
@SuppressWarnings("serial")
public class MLInvalidAccessException extends RuntimeException{
	private int code;
	
	MLInvalidAccessException(int i){
		code = i;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getMessage() {
		String massage;
		switch (code) {
		case 1 : massage = "Invalid head() call: empty List";
				break;	
				
		case 2 : massage = "Invalid end() call: empty List";
		break;
		
		case 11 : massage = "Invalid next() call: hasNext() false";
		break;
		
		case 12 : massage = "Invalid previous() call: hasPrevious() false";
		break;
		
		case 13 : massage = "Invalid set(T v) call: hasNext() unidentified current position";
		break;
		
		case 14 : massage = "Invalid remove(T v) call: hasNext() unidentified current position";
		break;
		
		default: massage = "Unknow eception code";
		break;
		
		}
		return massage;
	}
}
