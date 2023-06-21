package lesson22;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CopyBufferIO bufferIO = new CopyBufferIO();
        FileCopyChanel fileCopyChanel = new FileCopyChanel();
        FileCopyNio copyNio = new FileCopyNio();
        try {
            long start = System.currentTimeMillis();
            bufferIO.copy("C:\\Users\\Камиль\\Downloads\\HotA_1.6.1_full_setup.exe", "hota2.exe");
            long end = System.currentTimeMillis();
            System.out.println("CopyBufferIO " + (end - start));

            long start1 = System.currentTimeMillis();
            fileCopyChanel.copy("C:\\Users\\Камиль\\Downloads\\HotA_1.6.1_full_setup.exe", "hota2.exe");
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            copyNio.copy("C:\\Users\\Камиль\\Downloads\\HotA_1.6.1_full_setup.exe", "hota2.exe");
            long end2 = System.currentTimeMillis();
            System.out.println("CopyBufferIO " + (end2 - start2));

            System.out.println("CopyChanelNIO " + (end1 - start1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
