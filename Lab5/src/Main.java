// MyServer.java
import java.io.*;
import java.net.*;

class MyServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8030)) {
            System.out.println("Сервер запущен и ожидает подключения...");


            Socket client1 = serverSocket.accept();
            System.out.println("Клиент 1 подключился!");


            Socket client2 = serverSocket.accept();
            System.out.println("Клиент 2 подключился!");


            BufferedReader inputFromClient1 = new BufferedReader(
                    new InputStreamReader(client1.getInputStream()));
            String message = inputFromClient1.readLine();
            System.out.println("Получено сообщение от клиента 1: " + message);


            PrintStream outputToClient2 = new PrintStream(client2.getOutputStream());
            outputToClient2.println("Сообщение от клиента 1: " + message);


            client1.close();
            client2.close();
            System.out.println("Сообщения переданы, соединения закрыты.");
        } catch (IOException e) {
            System.out.println("Ошибка сервера: " + e.getMessage());
        }
    }
}
