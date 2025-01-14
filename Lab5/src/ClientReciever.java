
import java.io.*;
import java.net.*;

class MyClientReceiver {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8030)) {
            System.out.println("Подключено к серверу!");


            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = input.readLine();
            System.out.println("Получено сообщение: " + message);
        } catch (IOException e) {
            System.out.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
