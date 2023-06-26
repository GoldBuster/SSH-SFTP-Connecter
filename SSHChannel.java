import com.jcraft.jsch.*;

public class SSHChannel {
    Session session = null;
    Channel channel = null;
    public SSHChannel(User user){
        try{
            JSch jsch=new JSch();
            session = jsch.getSession(user.getName(),user.getHost(),22);
            session.setPassword(user.getPassword());
            UserInfo userInfo = new UserInfo() {
                @Override
                public String getPassphrase() {
                    System.out.println("getPassphrase");
                    return null;
                }
                @Override
                public String getPassword() {
                    System.out.println("getPassword");
                    return null;
                }
                @Override
                public boolean promptPassword(String s) {
                    System.out.println("promptPassword:"+s);
                    return false;
                }
                @Override
                public boolean promptPassphrase(String s) {
                    System.out.println("promptPassphrase:"+s);
                    return false;
                }
                @Override
                public boolean promptYesNo(String s) {
                    System.out.println("promptYesNo:"+s);
                    return true;//notice here!
                }
                @Override
                public void showMessage(String s) {
                    System.out.println("showMessage:"+s);
                }
            };

            session.setUserInfo(userInfo);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(30000);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void closeChannel() throws Exception {
        if (channel != null) channel.disconnect();
        if (session != null) session.disconnect();}

    public Channel getChannel() {
        return channel;
    }

    public void sftp(int mode,String src,String dst){
        try {
            channel=session.openChannel("sftp");
            channel.connect(60*1000);
            if (mode==0) ((ChannelSftp)channel).put(src,dst);
            else if (mode==1) ((ChannelSftp)channel).get(src, dst);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void shell(){
        try{
        Channel channel=session.openChannel("shell");
        System.out.println("If you encounter display problem, try Chcp 65001");
        channel.setInputStream(System.in);
        channel.setOutputStream(System.out);
        channel.connect(3*1000);
    }
        catch(Exception e){
        System.out.println(e);
    }
    }
}
