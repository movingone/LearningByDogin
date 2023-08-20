package Network.src;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network extends Packet {
    Network(String header_str, Datalink datalink) {
        Version = header_str.substring(0, 4);
        Header_length = header_str.substring(4, 8);
        type_service = header_str.substring(8, 16);
        total_length = header_str.substring(16, 32);
        identification = header_str.substring(32, 48);
        flag_offset = header_str.substring(48, 64);
        time_live = header_str.substring(64, 72);
        protocol = header_str.substring(72, 80);
        header_checksum = header_str.substring(80, 96);

        int ip16_change;
        String change;
        for (String mac_send_address : datalink.Mac_send_address) {
            ip16_change = Integer.parseInt(mac_send_address, 16);
            change = Integer.toBinaryString(ip16_change);
            start_IP = start_IP.concat(String.format("%4s", change).replace(' ', '0'));
        }
        for (String mac_send_address : datalink.Mac_get_address) {
            ip16_change = Integer.parseInt(mac_send_address, 16);
            change = Integer.toBinaryString(ip16_change);
            end_IP = end_IP.concat(String.format("%4s", change).replace(' ', '0'));
        }
    }
}


class Packet {
    String Version = new String();
    String Header_length = new String();
    String type_service = new String();
    String total_length = new String();
    String identification = new String();
    String flag_offset = new String();
    String time_live = new String();
    String protocol = new String();
    String header_checksum = new String();
    String start_IP = new String();
    String end_IP = new String();


    int header;
    int Version_check(){
        {
            try {
                InetAddress ipAddress = InetAddress.getByName("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
                byte[] addressBytes = ipAddress.getAddress();

                if (addressBytes.length == 4) {
                    return 4;
                } else {
                    return 6;
                }
            } catch (UnknownHostException e) {
                System.out.println("둘다 아님");
            }
        }
        return 0;
    }
}