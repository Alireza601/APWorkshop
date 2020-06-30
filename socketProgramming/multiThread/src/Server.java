import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * a class to handle server operations
 * @author Alireza Ghafari
 */
public class Server {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        try (ServerSocket welcomingSocket = new ServerSocket(100)){
            while (true){
                Socket serverConnectionSocket = welcomingSocket.accept();
                executor.execute(new Handler(serverConnectionSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler implements Runnable {
    Socket connectionSocket;
    public Handler(Socket serverConnectionSocket){
        connectionSocket = serverConnectionSocket;
    }

    @Override
    public void run() {
        try(InputStream reader=connectionSocket.getInputStream();
            OutputStream writer=connectionSocket.getOutputStream())
        {

            String content="";
            while (true) {
                byte[] bytes = new byte[10000];
                int read = reader.read(bytes);
                String input="";
                for(int i =0;i<read;i++)
                    input+=(char)bytes[i];
                if (input.equals("over"))
                    break;
                content+=input+" ";
                writer.write(content.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}