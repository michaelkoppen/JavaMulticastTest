//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        String message = "hello world";
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49152);

        socket.joinGroup(address);
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),address, 49152);

        socket.send(packet);
        socket.leaveGroup(address);
        socket.close();


    }
}
