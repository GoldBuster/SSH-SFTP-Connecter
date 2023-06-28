import java.util.Scanner;
import java.util.ArrayList;
public class Relay {
    public static void main(String[] args){
        int mode=-1;
        Scanner sc=new Scanner(System.in);
        mode=sc.nextInt();
        User user=new User(sc.next(),sc.next(),sc.next());
        ArrayList<SSHChannel> channels=new ArrayList<>();
        SSHChannel channel1=new SSHChannel(user);
        channels.add(channel1);
        if (mode==0) channels.get(0).shell();
        else{
            System.out.println("sftp");
            channels.get(0).sftp(mode-1,sc.next(),sc.next());
        }
    }
}