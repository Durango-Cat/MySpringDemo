package main.atziji.java.test;

import java.io.PrintStream;

/**
 * ip测试
 *
 * @author Zhuqiuping on 2020/9/1
 */
public class IpTest {

    public static void main(String[] args) {
        Long ip = getIp2long("10.0.0.250");
        System.out.println("ip --> " +ip);

        Long ip2 = getIp2long2("10.0.1.12");
        System.out.println("ip2 --> " +ip2);

        fun1();
    }

    public static long getIp2long(String ip) {

        ip = ip.trim();
        String[] ips = ip.split("\\.");
        long ip2long = 0L;
        for (int i = 0; i < 4; ++i) {
            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);
        }
        return ip2long;
    }

    public static long splitIp2(String ip) {
        return 0L;
    }
    public static long getIp2long2(String ip) {
        ip = ip.trim();
        String[] ips = ip.split("\\.");
        long ip1 = Integer.parseInt(ips[0]);
        long ip2 = Integer.parseInt(ips[1]);
        long ip3 = Integer.parseInt(ips[2]);
        long ip4 = Integer.parseInt(ips[3]);
        return 1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;

    }

    public static void  fun1(){

        PrintStream ps = null;
        //try {
        //    //ps = new PrintStream(new File("C:\\IP.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        int ipstart,ipend;

        //String ipstr="10.46.40.1--10.46.88.127";
        String ipstr="1.1.1.249-1.1.2.6";


        String sa[]=ipstr.split("-");
        ipstart=ip2int(sa[0]);
        ipend=ip2int(sa[1]);
        //System.out.println("ipstart --" + ipstart);
        //System.out.println(ipend);
        System.out.println(ipend-ipstart+1);
        String []result=new String[ipend-ipstart+1];
        for(int i=0;i<result.length;i++){
            String ip = int2ip(ipstart+i);
            System.out.println("i --> " +  ip);
            String[] ipArr = ip.split("\\.");
            if("0".equals(ipArr[3]) || "255".equals(ipArr[3])){
                continue;
            }
            System.out.println(ip);
            //ps.println(ip);
        }

    }

    public static String int2ip(int l){
        //System.out.println("l--> " +l);
        int a = l/(256*256*256);
        int b = (l-a*256*256*256)/(256*256);
        int c = (l-a*256*256*256-b*256*256)/256;
        int d = (l-a*256*256*256-b*256*256-c*256);
        //return l/(256*256*256)+"."+l/(256*256)+"."+l/256+"."+l%256;
        return a+"."+b+"."+c+"."+d;
    }

    public static int ip2int(String ip){
        String[] sa=ip.split("\\.");
        return Integer.parseInt(sa[0])*(256*256*256)+Integer.parseInt(sa[1])*(256*256)+Integer.parseInt(sa[2])*256+Integer.parseInt(sa[3]);
    }

}
