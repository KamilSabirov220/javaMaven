package lesson17;

import org.apache.log4j.Logger;

public class Vedushiy {
    public static final Logger LOGGER = Logger.getLogger(Vedushiy.class);
    public static void main(String[] args) {
        System.out.println("Концерт начался");
        //лог ведущий начинает концерт
        LOGGER.info("Ведущий начал концерт");
        Pevec1 pevec1 = new Pevec1();
        pevec1.setDaemon(true);
        Pevec2 pevec2 = new Pevec2();
        pevec2.setDaemon(true);
        Pevec3 pevec3 = new Pevec3();
        pevec3.setDaemon(true);
        pevec1.start();
        pevec2.start();
        pevec3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец концерта");

    }
}
