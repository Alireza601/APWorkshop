import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * a class to handle client Operations
 * @author Alireza Ghafari
 * @version 1.0
 */
public class Client {

    public static void main(String [ ]args){
        try (Socket socket = new Socket("", 100);
             OutputStream writer = socket.getOutputStream();
             InputStream reader = socket.getInputStream())
        {
            Scanner scan = new Scanner(System.in);
            while (!socket.isClosed()) {
                String input = scan.next();
                writer.write(input.getBytes());

                String content = "";
                byte[] bytes=new byte[10000];
                int read = reader.read(bytes);
                if(read == -1)
                    break;
                for(int i =0;i<read;i++)
                    content+=(char)bytes[i];
                System.out.println(content);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
