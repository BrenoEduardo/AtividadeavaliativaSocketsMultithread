import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketFile {
    private static List<Cartao> cards = new ArrayList<>();
    private static int nsuCounter = 1;

    public static void main(String[] args) throws IOException {
        cards.add(new Cartao("123456789012", "Breno Eduardo", 10.0));
        cards.add(new Cartao("210987654321", "Seu Junio", 4000.0));
        cards.add(new Cartao("123877123821", "Dona Paula", 1700.0));

        ServerSocket serverSocket = new ServerSocket(2001);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());
            Thread clientThread = new Thread(() -> {
                try (
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    while (true) {
                        String message = input.readUTF();
                        System.out.println("Received message: " + message);
                        String response = processMessage(message);
                        output.writeUTF(response);
                        System.out.println("Response sent: " + response);
                    }
                } catch (IOException e) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            clientThread.start();
        }
    }

    private static synchronized String generateNSU() {
        return String.format("", nsuCounter++);
    }
    
    private static synchronized String processMessage(String message) {
        String centValueStr = message.substring(4, 12);
        double centValue = Double.parseDouble(centValueStr) / 100.0;
        String cardNumber = message.substring(29, 40);

        for (Cartao card : cards) {
            if (card.getNumero().equals(cardNumber)) {
                if (centValue > card.getSaldo()) {
                    return "5100" + "0000";
                } else {
                    card.performDebit(centValue);
                    String nsu = generateNSU();
                    return "0000" + nsu;
                }
            }
        }
        return "0500" + "0000";
    }
}
