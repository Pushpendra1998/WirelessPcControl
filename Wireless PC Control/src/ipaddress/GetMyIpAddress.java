package ipaddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;


public class GetMyIpAddress {
    
    //to validate ip address
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    String ipAddresses[] = new String[10], temp;
    int j = 0;
    
    public static boolean validateIP(final String ip) {
        return PATTERN.matcher(ip).matches();
    }
    
    public boolean validatePort(String portNumber) {
        if ((portNumber != null) && (portNumber.length() >= 4) && (portNumber.matches(".*\\d.*"))) {
            if( (Integer.parseInt(portNumber) > 1023))
                return true;
            else
                return false;
        }
        else 
            return false;
    }
    
    public String[] ipAddress() {
        System.out.println("Printing only IPv4 Addresses");
        Enumeration e = null;
        String s = "";
        try {
            e = NetworkInterface.getNetworkInterfaces();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                temp = i.getHostAddress();
                //this temp contains IPv4 as well as IPv6 addresses
                //System.out.println(temp);
                if((temp.charAt(1) == '7' || temp.charAt(1) == '9') && (temp.charAt(2) == '2')) {
                    ipAddresses[j] = temp;
                    j++;
                    System.out.println(temp);
                }
                else if(temp.charAt(0) == '1' && temp.charAt(1) == '0') {
                    ipAddresses[j] = temp;
                    j++;
                    System.out.println(temp);
                }
            }
        }
        if (ipAddresses[0] == null) {
            ipAddresses[0] = "127.0.0.1";
        }
        return ipAddresses;
    }
    
    public static void main(String args[]) {
        new GetMyIpAddress().ipAddress();
    }
}
