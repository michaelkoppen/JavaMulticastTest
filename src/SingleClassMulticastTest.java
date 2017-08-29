//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;

public class SingleClassMulticastTest {
    public static void main(String[] args) throws Exception{
        //Sending message
        String message = "hello world";
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49152);

        socket.joinGroup(address);
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),address, 49152);

        socket.send(packet);

        //Receiving message
        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(messageBuffer, 1024);

        socket.receive(receivePacket);

        String resultStr = new String(messageBuffer);
        System.out.println(resultStr);
    }
}
