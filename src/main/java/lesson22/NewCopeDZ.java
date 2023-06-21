package lesson22;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewCopeDZ {

    // Main driver method
    public static void main(String[] args) {

        String text = "geeksforgeeks";
        Path path = (Path) Paths.get("C:\\Users\\Камиль\\IdeaProjects\\javaMaven\\lesson22Data.txt");

        System.out.println("Path of target file: "
                + path.toString());

        InputStream in = new ByteArrayInputStream(text.getBytes());

        try {
            System.out.println(
                    "Number of bytes copied: "
                            + Files.copy(
                            in, path,
                            StandardCopyOption.REPLACE_EXISTING));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
