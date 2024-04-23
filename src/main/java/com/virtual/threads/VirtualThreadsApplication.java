package com.virtual.threads;

import java.util.concurrent.*;

public class VirtualThreadsApplication {

    public static void main(String[] args) {
        int numberOfTasks = 2000;

        System.out.println("Running with FixedThreadPool...");
        long timeFixedThreadPool = runTasksWithExecutor(Executors.newFixedThreadPool(2000), numberOfTasks);

        System.out.println("Running with VirtualThreadPerTaskExecutor...");
        long timeVirtualThreadExecutor = runTasksWithExecutor(Executors.newVirtualThreadPerTaskExecutor(), numberOfTasks);

        System.out.println("FixedThreadPool time: " + timeFixedThreadPool + " ms");
        System.out.println("VirtualThreadPerTaskExecutor time: " + timeVirtualThreadExecutor + " ms");

        if (timeFixedThreadPool > 0 && timeVirtualThreadExecutor > 0) {
            double percentageDifference = ((double) (timeVirtualThreadExecutor - timeFixedThreadPool) / timeFixedThreadPool) * 100;
            System.out.printf("Virtual threads were %.2f%% %s than fixed threads.\n",
                    Math.abs(percentageDifference),
                    percentageDifference > 0 ? "slower" : "faster");
        }
    }

    private static long runTasksWithExecutor(ExecutorService executor, int numberOfTasks) {
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < numberOfTasks; i++) {
                executor.execute(new RunTask());
            }
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}