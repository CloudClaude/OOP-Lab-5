import java.io.*;
import java.net.*;

class MyClientSender {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8030)) {
            System.out.println("Подключено к серверу!");


            PrintStream output = new PrintStream(socket.getOutputStream());
            output.println("Привет от клиента 1!");
            System.out.println("Сообщение отправлено серверу.");
        } catch (IOException e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
