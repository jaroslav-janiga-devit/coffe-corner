package charlene;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceReaderUtil {

    public static String readReceipt(String filePath) {
        URI uri = null;
        try {
            uri = Thread.currentThread().getContextClassLoader().getResource(filePath).toURI();
            return new String(Files.readAllBytes(Paths.get(uri)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
