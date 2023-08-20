package Network.src;

public class transport extends segment{

    class TCP extends segment{
        TCP(String transport) {
            start_segment = transport.substring(0, 16);
            end_segment = transport.substring(16, 32);
            cnt_number = transport.substring(32, 64);
            next_number = transport.substring(64, 96);
            tcp_start_control = transport.substring(96, 100);
            Reserved = transport.substring(100, 106);
            Control_flags = transport.substring(106, 112);
            window_size = transport.substring(112, 128);
            checksum = transport.substring(128, 142);
            data_point = transport.substring(142, 158);
        }
        String cnt_number;
        String next_number;
        String tcp_start_control;
        String Reserved;
        String Control_flags;
        String window_size;
        String data_point;
        String option;
        String padding;
    }

    class UDP extends segment {
        String total_length;

        UDP(String transport) {
            start_segment = transport.substring(0, 16);
            end_segment = transport.substring(16, 32);
            total_length = transport.substring(32, 48);
            checksum = transport.substring(48, 64);
        }
    }
}

class segment {
    String start_segment;
    String end_segment;
    String checksum;
}



