package communicaton;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Singleton extends Thread {

    private static  TCP_Singleton instance;
    private OnMessageListener observer;
    private ServerSocket server;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private BufferedWriter writer;
    private BufferedReader reader;
    private  TCP_Singleton(){

    }

    public void SetObserver(OnMessageListener observer){

        this.observer=observer;

    }

    public static TCP_Singleton getInstance(){

        if(instance==null){

            instance= new TCP_Singleton();
            instance.start();
        }
        return  instance;
    }

    public void run(){

        try {
        	server = new ServerSocket(5000);
            System.out.println("esperando");
        	socket=server.accept();
        	System.out.println("Conectado");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            reader = new BufferedReader(inputStreamReader);
            writer = new BufferedWriter( outputStreamWriter);
            
            while(true) {
            	
            	String message = reader.readLine();
            	observer.OnMessage(message);
            	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void SendMessage(String message){

        new Thread(
                ()->{
                    try {
                        writer.write(message);
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

    }
}

