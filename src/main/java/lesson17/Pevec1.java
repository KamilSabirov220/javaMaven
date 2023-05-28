package lesson17;

import org.apache.log4j.Logger;

public class Pevec1 extends Thread{
    public static final Logger LOGGER = Logger.getLogger(Pevec1.class);
    private int count = 5;
    public Pevec1() {

    }
    public Pevec1(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int j = 0;
        while (true) {
            //log4j певец 1 начал петь
            LOGGER.info("Певец 1 начал петь");
            for (int i = 0; i < 3; i++) {
                System.out.println("ла-ла-ла");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (Monitors.MICROFON) {
                //певец1 передал микрофон
                Monitors.MICROFON.notify();
                LOGGER.info("Певец 1 передал микрофон");
                //певец1 начал ждать
                LOGGER.info("Певец 1 начал ждать");
            }

            synchronized (Monitors.MICROFON) {
                try {

                    Monitors.MICROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}
