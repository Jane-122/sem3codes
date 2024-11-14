class PushException extends Exception{
	public PushException(String message){
		super(message);
	}
}

class PopException extends Exception {
	public PopException(String message){
		super(message);
	}
}

class Stack{

	int top;
	int[] arr=new int[5];
	public Stack(){

		top=-1;

	}

	void push(int x) throws PushException{
		if(top==4){
			throw new PushException("Stack Overflow");
		}
		else {
			arr[++top]=x;
			System.out.println(x+" is pushed");
		}
	}

    void pop() throws PopException{
    	if(top==-1){
    		throw new PopException("Stack Underflow");
    	}
    	else{
    		System.out.println("Popped element is "+arr[top--]);

    	}
    }

}

public class Demo1{
	public static void main(String[] args) {

		Stack s=new Stack();

		try{
			s.push(4);
			s.push(4);
			s.push(5);
			s.push(5);
			s.push(7);
			s.push(11);
			s.pop();
		}
		catch (PushException e){
			System.out.println(e.getMessage());
		}
		catch (PopException e){
			System.out.println(e.getMessage());
		}
		
	}
}