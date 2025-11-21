public class ThreadChecker1
{
    public static void main(String[] args)
    {
        Thread[] threads = new Thread[1000];

        long[] results = new long[1000];

        for (int i = 0; i < threads.length; i++) {

            final int index = i;

            threads[i] = new Thread(() -> {
                long sum = 0;
                for (int n = 1; n <= 1_000_000; n++) {
                    sum += n;
                }
                results[index] = sum;
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long finalTotal = 0;
        for (long r : results) {
            finalTotal += r;
        }

        System.out.println("Final total: " + finalTotal);
    }
}
