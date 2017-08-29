//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;

public class MulticastReader {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49152);

        socket.joinGroup(address);

        byte[] messageBuffer = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(messageBuffer, 1024);

            socket.receive(receivePacket);

            String resultStr = new String(messageBuffer);
            if (resultStr.equals("Q") || resultStr.equals("q")) {
                break;
            }
            System.out.println(resultStr);
        }
        socket.leaveGroup(address);
        socket.close();
    }
}
