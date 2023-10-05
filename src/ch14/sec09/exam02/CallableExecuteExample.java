package ch14.sec09.exam02;

import java.util.concurrent.*;

public class CallableExecuteExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 1000; i++) {
            final int idx = i;
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i < idx; i++) {
                        sum += i;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
                    return sum;
                }
            });

            try {
                Integer result = future.get();
                System.out.println("리턴 " + result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
        executorService.shutdown();

    }
}
