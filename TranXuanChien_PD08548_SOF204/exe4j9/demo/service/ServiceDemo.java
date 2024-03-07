import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class ServiceDemo {

    public static void main(String[] args) {
        log("started at " + new Date());

        Thread workerThread = Thread.currentThread();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runtime.getRuntime().addShutdownHook(new ShutdownThread(workerThread, countDownLatch));

        // work until the thread is interrupted
        try {
            while (!workerThread.isInterrupted()) {
                Thread.sleep(2000);
                log("working at " + new Date());
            }
        } catch (InterruptedException e) {
        }

        // perform clean up on shut down
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                log("cleaning up at " + new Date());
            } catch (InterruptedException e) {

            }
        }

        // notify shutdown thread that cleanup is finished
        countDownLatch.countDown();
    }


    private static class ShutdownThread extends Thread {
        private final Thread workerThread;
        private CountDownLatch countDownLatch;

        public ShutdownThread(Thread workerThread, CountDownLatch countDownLatch) {
            this.workerThread = workerThread;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            log("shutdown requested at " + new Date());

            // request worker thread to finish
            workerThread.interrupt();
            // wait for the worker thread to finish
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
            }
            log("shutdown at " + new Date());
        }
    }

    private static void log(String val) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("service_demo.log", true));
            pw.println(val);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
