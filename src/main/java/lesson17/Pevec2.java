package lesson17;

public class Pevec2 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MICROFON) {
                try {
                    Monitors.MICROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("ну-ну-ну");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (Monitors.MICROFON) {
                Monitors.MICROFON.notify();
            }
        }
    }
}
