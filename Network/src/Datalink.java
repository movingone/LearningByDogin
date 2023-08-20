package Network.src;

public class Datalink extends Frame {

    Datalink(int bitstream[]) {
        data = new int[bitstream.length - 24];
        int index = 0;
        int hexa = 0;
        int get_address = 0;
        int send_address = 0;
        for (int i = 0; i < bitstream.length; i++) {
            if (i >= 0 && i <= 3) Preamble[i] = bitstream[i];
            else if (i == 4) SFD = bitstream[i];
            else if (i >= 5 && i <= 52) {
                hexa += bitstream[i];
                if ((i - 5) % 4 == 3) {
                    Mac_get_address[get_address++] = Integer.toHexString(hexa);
                    hexa = 0;
                }
            } else if (i >= 53 && i <= 100) {

                hexa += bitstream[i];
                if ((i - 5) % 4 == 3) {
                    Mac_send_address[send_address++] = Integer.toHexString(hexa);
                    hexa = 0;
                }
            } else if (i >= 101 && i <= 104) type_data[i - 16] = bitstream[i];
            else if (bitstream.length > i && i >= bitstream.length - 4) FCS[index] = bitstream[i];
            else data[index++] = bitstream[i];
        }
    }
}

class Frame {
    int Preamble[] = new int[8];
    int SFD = 0;
    String Mac_get_address[] = new String[6];
    String Mac_send_address[] = new String[6];
    int type_data[] = new int[4];
    int data[];
    int FCS[] = new int[4];
}