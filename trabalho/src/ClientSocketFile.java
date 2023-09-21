import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketFile {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 2001);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            Message msg = new Message("0200", "000000013560", "09221", "2409", "902121", "123456789012", "1");
            String msgPayload = msg.buildMessage();
            output.writeUTF(msgPayload);
            String response = input.readUTF();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
