public class TestJNI
{
	static
	{
		 System.loadLibrary("cal");
	}
	private native int add(int n1, int n2);
	private native int sub(int n1, int n2);
	public static void main(String[] args)
	{
		System.out.println("Addition is="+new TestJNI().add(15,20));
		
		System.out.println("Subtraction is =" + new TestJNI().sub(40,30)); 
	}
}

//http://deepak_srivastava.tripod.com/jni/jni.html

//http://statweb.stanford.edu/~naras/java/course/lec5/lec5.html

//https://docs.oracle.com/javase/7/docs/technotes/guides/jni/spec/functions.html
