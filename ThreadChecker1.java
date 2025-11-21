public class ThreadChecker1
{
	public static void main(String []args)
	{
		Thread[] threads = new Thread[1000];

		Runnable counter = () -> {
		    long sum = 0;
		    for (int i = 1; i <= 1_000_000; i++) {
		        sum += i;
		    }
		};


	}
}