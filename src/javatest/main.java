package javatest;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

    public static void main(String[] args) {
    	
    	System.loadLibrary("apiServer");
    	apiServer api = new apiServer();
    	
    	String strAddress = "http://116.255.146.78";
    	String strDeviceUID = java.util.UUID.randomUUID().toString();
    	String strSoftId = "phonemgr";
    	String strVer = "1.0";
    	api.Init(strAddress, strDeviceUID, strSoftId, strVer);
    	
    	String strUid = "test01";
    	String strPwd = "12345678";
    	String[] ret = api.Login(strUid, strPwd);
    	
    	System.out.print(ret[0]);
    	System.out.print(ret[1]);
    	
        JFrame jf = new JFrame("登录");
        jf.setSize(450, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // 创建选项卡面板
        final JTabbedPane tabbedPane = new JTabbedPane();

        // 创建第 1 个选项卡（选项卡只包含 标题）
        tabbedPane.addTab("账号登录", createLoginPanel());

        // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
        tabbedPane.addTab("账号注册", createRegPanel());

        // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
        tabbedPane.addTab("软件充值", createChargePanel());
        
        // 创建第 4 个选项卡（选项卡包含 标题、图标 和 tip提示）
        tabbedPane.addTab("修改密码", createChgPwdPanel());


        // 添加选项卡选中状态改变的监听器
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
            }
        });

        // 设置默认选中的选项卡
        tabbedPane.setSelectedIndex(0);

        jf.setContentPane(tabbedPane);
        jf.setVisible(true);
    }
    
    /**
     * 登录账号面板
     */
    private static JComponent createLoginPanel() {

        JPanel panel = new JPanel(new GridLayout(3, 1));

        // 用户名
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("用户名");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // 密码
        JPanel panelPwd = new JPanel(new FlowLayout());
        
        JLabel labelPwd = new JLabel("密  码");
        labelPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(labelPwd);
        
        JTextField textPwd = new JTextField(20);
        textPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(textPwd); 
        
        // 登录
        JPanel panelLogin = new JPanel(new FlowLayout());
        
        JButton btnLogin = new JButton("登  录");
        btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strPwd = textPwd.getText();
				if (strUser.isEmpty() || strPwd.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "请输入信息", "错误",JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
        });
        panelLogin.add(btnLogin);
        
        panel.add(panelUser);
        panel.add(panelPwd);
        panel.add(panelLogin);

        return panel;
    }
    
    /**
     * 账号注册面板
     */
    private static JComponent createRegPanel() {

        JPanel panel = new JPanel(new GridLayout(6, 1));

        // 用户名
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("用  户  名");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // 密码
        JPanel panelPwd = new JPanel(new FlowLayout());
        
        JLabel labelPwd = new JLabel("密        码");
        labelPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(labelPwd);
        
        JTextField textPwd = new JTextField(20);
        textPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(textPwd); 
        
        // 确认密码
        JPanel panelConfirmPwd = new JPanel(new FlowLayout());
        
        JLabel labelConfirmPwd = new JLabel("确认密码");
        labelConfirmPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmPwd.add(labelConfirmPwd);
        
        JTextField textConfirmPwd = new JTextField(20);
        textConfirmPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmPwd.add(textConfirmPwd); 
        
        // 邮箱
        JPanel panelMail = new JPanel(new FlowLayout());
        
        JLabel labelMail = new JLabel("邮        箱");
        labelMail.setHorizontalAlignment(SwingConstants.LEFT);
        panelMail.add(labelMail);
        
        JTextField textMail = new JTextField(20);
        textMail.setHorizontalAlignment(SwingConstants.LEFT);
        panelMail.add(textMail); 
        
        // QQ
        JPanel panelQQ = new JPanel(new FlowLayout());
        
        JLabel labelQQ = new JLabel("QQ        ");
        labelQQ.setHorizontalAlignment(SwingConstants.LEFT);
        panelQQ.add(labelQQ);
        
        JTextField textQQ = new JTextField(20);
        textQQ.setHorizontalAlignment(SwingConstants.LEFT);
        panelQQ.add(textQQ); 
        
        // 立即注册
        JPanel panelReg = new JPanel(new FlowLayout());
        
        JButton btnReg = new JButton("立即注册");
        btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strPwd = textPwd.getText();
				String strConfirmPwd = textConfirmPwd.getText();
				String strMail = textMail.getText();
				String strQQ = textQQ.getText();
				if (strUser.isEmpty() || strPwd.isEmpty() || strConfirmPwd.isEmpty() ||
						strMail.isEmpty() || strQQ.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "请输入信息", "错误",JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
        });
        panelReg.add(btnReg);
        
        panel.add(panelUser);
        panel.add(panelPwd);
        panel.add(panelConfirmPwd);
        panel.add(panelMail);
        panel.add(panelQQ);
        panel.add(panelReg);

        return panel;
    }
    
    /**
     * 软件充值面板
     */
    private static JComponent createChargePanel() {

        JPanel panel = new JPanel(new GridLayout(4, 1));

        // 用户名
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("用户名");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // 充值卡号
        JPanel panelCardNum = new JPanel(new FlowLayout());
        
        JLabel labelCardNum = new JLabel("充值卡号");
        labelCardNum.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardNum.add(labelCardNum);
        
        JTextField textCardNum = new JTextField(20);
        textCardNum.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardNum.add(textCardNum); 
        
        // 充值卡密
        JPanel panelCardPwd = new JPanel(new FlowLayout());
        
        JLabel labelCardPwd = new JLabel("充值卡密");
        labelCardPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardPwd.add(labelCardPwd);
        
        JTextField textCardPwd = new JTextField(20);
        textCardPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardPwd.add(textCardPwd); 
        
        // 充值
        JPanel panelCharge = new JPanel(new FlowLayout());
        
        JButton btnCharge = new JButton("充        值");
        btnCharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strCardNum = textCardNum.getText();
				String strCardPwd = textCardPwd.getText();
				if (strUser.isEmpty() || strCardNum.isEmpty() || strCardPwd.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "请输入信息", "错误",JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
        });
        panelCharge.add(btnCharge);
        
        panel.add(panelUser);
        panel.add(panelCardNum);
        panel.add(panelCardPwd);
        panel.add(panelCharge);

        return panel;
    }
    
    /**
     * 修改密码面板
     */
    private static JComponent createChgPwdPanel() {

        JPanel panel = new JPanel(new GridLayout(5, 1));

        // 用户名
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("用     户     名");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // 旧密码
        JPanel panelOldPwd = new JPanel(new FlowLayout());
        
        JLabel labelOldPwd = new JLabel("旧     密     码");
        labelOldPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelOldPwd.add(labelOldPwd);
        
        JTextField textOldPwd = new JTextField(20);
        textOldPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelOldPwd.add(textOldPwd); 
        
        // 新密码
        JPanel panelNewPwd = new JPanel(new FlowLayout());
        
        JLabel labelNewPwd = new JLabel("新     密     码");
        labelNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelNewPwd.add(labelNewPwd);
        
        JTextField textNewPwd = new JTextField(20);
        textNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelNewPwd.add(textNewPwd); 
        
        // 确认新密码
        JPanel panelConfirmNewPwd = new JPanel(new FlowLayout());
        
        JLabel labelConfirmNewPwd = new JLabel("确认新密码");
        labelConfirmNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmNewPwd.add(labelConfirmNewPwd);
        
        JTextField textConfirmNewPwd = new JTextField(20);
        textConfirmNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmNewPwd.add(textConfirmNewPwd); 
        
        // 立即修改
        JPanel panelChgPwd = new JPanel(new FlowLayout());
        
        JButton btnChgPwd = new JButton("立即修改");
        btnChgPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strOldPwd = textOldPwd.getText();
				String strNewPwd = textNewPwd.getText();
				String strConfirmNewPwd = textConfirmNewPwd.getText();
				if (strUser.isEmpty() || strOldPwd.isEmpty() || strNewPwd.isEmpty() ||
						strConfirmNewPwd.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "请输入信息", "错误",JOptionPane.WARNING_MESSAGE);  
					return;
				}
			}
        });
        panelChgPwd.add(btnChgPwd);
        
        panel.add(panelUser);
        panel.add(panelOldPwd);
        panel.add(panelNewPwd);
        panel.add(panelConfirmNewPwd);
        panel.add(panelChgPwd);

        return panel;
    }
}
