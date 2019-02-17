package main.java.typechange;

/**
 * int类型和byte类型元素互相转换
 *
 * Create by zhuqiuping
 * on 2017/5/6
 */
public class IntAndByteChangeTest {

    //将byte[]数组转换成int类型
    private static int byte4ToInt(byte[] bytes) {
        int b0 = bytes[0] & 0xff;
        int b1 = bytes[1] & 0xff;
        int b2 = bytes[2] & 0xff;
        int b3 = bytes[3] & 0xff;

        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }

    private static byte[] intToByte4(int num) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) (num & 0xff);
        bytes[2] = (byte) (num >> 8 & 0xff);
        bytes[1] = (byte) (num >> 16 & 0xff);
        bytes[0] = (byte) (num >> 24 & 0xff);
        return bytes;
    }


    public static void main(String[] args) {

//        byte[] bytes = intToByte4(287);
//        for (byte aByte : bytes) {
//            System.out.println(aByte);
//        }
//        System.out.println();
//
//        System.out.println(byte4ToInt(bytes));

        //进制转换代码
        int ss = 14;
        //10进制转化成二进制
        System.out.println(Integer.toBinaryString(ss));

        //10进制转化成16进制
        System.out.println(Integer.toHexString(ss));

        //10进制转化成8进制
        System.out.println(Integer.toOctalString(ss));

    }

}
