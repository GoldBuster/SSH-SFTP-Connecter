import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;

import static java.lang.System.*;

public class SignInGUI {

    private String regName;
    private String regPassword;
    private String regHost;//名字密码host

    private ArrayList<User> userList;//user的ArrayList

    public void initRegister(){
        JFrame panel = new JFrame();//新建
        panel.setTitle("注册");//名字
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击叉子关闭窗口

        FlowLayout flow = new FlowLayout(1);//中心对齐
        panel.setLayout(flow);//布局方式

        JButton signUp = new JButton();//确认注册按钮
        JLabel name = new JLabel();
        JLabel password = new JLabel();
        JLabel host = new JLabel();//相应标签
        JTextField nameIn = new JTextField(10);
        JTextField passwordIn = new JTextField(10);
        JTextField hostIn = new JTextField(10);//相应输入框
        nameIn.setOpaque(true);
        passwordIn.setOpaque(true);
        hostIn.setOpaque(true);//文本框变透明





        JPanel enterPanel = new JPanel();
        enterPanel.setOpaque(false);//透明的输入区域面板；


        name.setText("用户：");
        password.setText("密码：");
        host.setText("主机：");
        signUp.setText("确定");//标明对应输入框需要输入内容

        ImageIcon ima = new ImageIcon(getClass().getResource("photo66.jpg"));//背景图片
        JLabel imaJla = new JLabel(ima);//标签中添加图片
        imaJla.setBounds(0,0,ima.getIconWidth(),ima.getIconHeight());//让标签位置大小和图片一样
        panel.getLayeredPane().add(imaJla,Integer.valueOf(Integer.MIN_VALUE));//标签添加到第二层面板

//        enterPanel.setSize(300,500);
//        enterPanel.setLayout(flow);
//
//        enterPanel.add(name);
//        enterPanel.add(nameIn);
//        enterPanel.add(password);
//        enterPanel.add(passwordIn);
//        enterPanel.add(host);
//        enterPanel.add(hostIn);
//        enterPanel.add(signUp);//全加到面板上

        JPanel imPanel = (JPanel)panel.getContentPane();
        imPanel.setOpaque(false);//获取顶层容器设为透明

        JPanel displayPanel = new JPanel();
        displayPanel.setOpaque(false);//建立透明的文本显示区域面板

        JTextArea display = new JTextArea(10,10);
        display.setOpaque(false);//建立新的TextArea显示输出内容
        display.setSize(enterPanel.getWidth(),enterPanel.getHeight());
        imPanel.add(displayPanel,BorderLayout.WEST);//文本显示面板加到顶层的容器内

        imPanel.add(enterPanel,BorderLayout.SOUTH);//文本输入面板加到顶层

        panel.setSize(ima.getIconWidth(),ima.getIconHeight());//大小

        panel.setResizable(true);//窗口大小可调整
        panel.setVisible(true);//显示窗口



        panel.add(name);
        panel.add(nameIn);
        panel.add(password);
        panel.add(passwordIn);
        panel.add(host);
        panel.add(hostIn);
        panel.add(signUp);//全加到面板上




        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nameIn.getText().isEmpty() || passwordIn.getText().isEmpty() || hostIn.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "您有未输入的信息！", "错误！",JOptionPane.WARNING_MESSAGE);
                    System.exit(0);//如果用户有没有输入的东西，那么自动退出
                }
                else{
                    //让用户确认输入正确，正确，继续。不正确，退出
                    int userOption = JOptionPane.showConfirmDialog(null,"您确认用以上信息注册么？", "提示", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (userOption == JOptionPane.OK_OPTION){
                        regName = nameIn.getText().trim();
                        regPassword = passwordIn.getText().trim();
                        regHost = hostIn.getText().trim();//将收集到的文本框中的上传

                        User user = new User(regName,regPassword,regHost);//直接建立一个新的用户的object
//                System.out.println(user.getName());
//                System.out.println(user.getPassword());
//                System.out.println(user.getHost());//测试

                        userList = new ArrayList<User>();
                        userList.add(user);//加入


////////////////////////////等着注意加进去！！！ SSHChannel channel1=new SSHChannel(user);

                        panel.setVisible(false);//关闭（使第一个页面消失）
                        modeGUI();//唤起mode界面（终端，上传，下载）





//                System.out.println(userList.get(0).getName());//测试

                    }
                    else{
                        System.exit(0);
                    }
                }




            }
        });

    }

    public void modeGUI(){
        JFrame modePanel = new JFrame();//新建
        modePanel.setTitle("您想要做什么？");//名字
        modePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击叉子关闭窗口

        FlowLayout flow = new FlowLayout(1);//中心对齐
        modePanel.setLayout(flow);//布局方式

        JButton terminal = new JButton();//终端按钮
        JButton upLoad = new JButton();//上传按钮
        JButton downLoad = new JButton();//下载按钮


        terminal.setText("终端");
        upLoad.setText("上传");
        downLoad.setText("下载");//标明对应输入框需要输入内容


        ImageIcon ima = new ImageIcon(getClass().getResource("photo66.jpg"));//背景图片
        JLabel imaJla = new JLabel(ima);//标签中添加图片
        imaJla.setBounds(0,0,ima.getIconWidth(),ima.getIconHeight());//让标签位置大小和图片一样
        modePanel.getLayeredPane().add(imaJla,Integer.valueOf(Integer.MIN_VALUE));//标签添加到第二层面板



        JPanel imPanel = (JPanel)modePanel.getContentPane();
        imPanel.setOpaque(false);//获取顶层容器设为透明

        JPanel displayPanel = new JPanel();
        displayPanel.setOpaque(false);//建立透明的文本显示区域面板

        JTextArea display = new JTextArea(10,10);
        display.setOpaque(false);//建立新的TextArea显示输出内容
        imPanel.add(displayPanel,BorderLayout.WEST);//文本显示面板加到顶层的容器内


        modePanel.setSize(ima.getIconWidth(),ima.getIconHeight());//大小

        modePanel.setResizable(true);//窗口大小可调整
        modePanel.setVisible(true);//显示窗口

        modePanel.add(terminal);
        modePanel.add(upLoad);
        modePanel.add(downLoad);//全加到面板上

        SSHChannel channel1=new SSHChannel(userList.get(0));
        terminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这是终端要干嘛

              channel1.shell();
            }
        });

        upLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这是上传要干嘛

                String uploadFrom = JOptionPane.showInputDialog(null,"请输入您要上传的文件的路径：","输入",JOptionPane.WARNING_MESSAGE);//要上传的文件对话框
                String uploadTo = JOptionPane.showInputDialog(null,"请输入您的文件要上传到哪的路径：","输入",JOptionPane.WARNING_MESSAGE);//要传到哪的对话框
                channel1.sftp(0,uploadFrom,uploadTo);

            }
        });

        downLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这是下载要干嘛

                String downloadFrom = JOptionPane.showInputDialog(null,"请输入您要下载的对方的文件的路径：","输入",JOptionPane.WARNING_MESSAGE);//要下载的文件对话框
                String downloadTo = JOptionPane.showInputDialog(null,"请输入您想要下载到哪的路径：","输入",JOptionPane.WARNING_MESSAGE);//要下载到哪的对话框
                channel1.sftp(1,downloadFrom,downloadTo);
            }
        });


    }

    public String getRegPassword() {
        return regPassword;
    }

    public String getRegHost() {
        return regHost;
    }

    public String getRegName() {
        return regName;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public static void main(String[] args){

        SignInGUI a = new SignInGUI();
        a.initRegister();



    }
}
