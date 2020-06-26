import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * a class to handle server operations
 * @author Alireza Ghafari
 */
public class Server {

    public static void main(String [ ]args){
        try(ServerSocket serverSocket=new ServerSocket(100);
            Socket connectionSocket=serverSocket.accept();
            InputStream reader=connectionSocket.getInputStream();
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
