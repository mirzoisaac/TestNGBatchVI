package com.testng.class02;

public interface Example {
		
	public void methods();
	public void methods(int i);

}
 interface Example4  {
	
	public void methods(String str);
	public void methodss(int i);

}
abstract class Example2{
	
	abstract public void method2();
	
}
class Example3 implements Example, Example4{
	
	 public void method3() {
		 //a
		 //s
	}

	@Override
	public void methods() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methods(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methods(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodss(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
