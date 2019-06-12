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
    	
        JFrame jf = new JFrame("��¼");
        jf.setSize(450, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // ����ѡ����
        final JTabbedPane tabbedPane = new JTabbedPane();

        // ������ 1 ��ѡ���ѡ�ֻ���� ���⣩
        tabbedPane.addTab("�˺ŵ�¼", createLoginPanel());

        // ������ 2 ��ѡ���ѡ����� ���� �� ͼ�꣩
        tabbedPane.addTab("�˺�ע��", createRegPanel());

        // ������ 3 ��ѡ���ѡ����� ���⡢ͼ�� �� tip��ʾ��
        tabbedPane.addTab("�����ֵ", createChargePanel());
        
        // ������ 4 ��ѡ���ѡ����� ���⡢ͼ�� �� tip��ʾ��
        tabbedPane.addTab("�޸�����", createChgPwdPanel());


        // ���ѡ�ѡ��״̬�ı�ļ�����
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("��ǰѡ�е�ѡ�: " + tabbedPane.getSelectedIndex());
            }
        });

        // ����Ĭ��ѡ�е�ѡ�
        tabbedPane.setSelectedIndex(0);

        jf.setContentPane(tabbedPane);
        jf.setVisible(true);
    }
    
    /**
     * ��¼�˺����
     */
    private static JComponent createLoginPanel() {

        JPanel panel = new JPanel(new GridLayout(3, 1));

        // �û���
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("�û���");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // ����
        JPanel panelPwd = new JPanel(new FlowLayout());
        
        JLabel labelPwd = new JLabel("��  ��");
        labelPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(labelPwd);
        
        JTextField textPwd = new JTextField(20);
        textPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(textPwd); 
        
        // ��¼
        JPanel panelLogin = new JPanel(new FlowLayout());
        
        JButton btnLogin = new JButton("��  ¼");
        btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strPwd = textPwd.getText();
				if (strUser.isEmpty() || strPwd.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "��������Ϣ", "����",JOptionPane.WARNING_MESSAGE);  
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
     * �˺�ע�����
     */
    private static JComponent createRegPanel() {

        JPanel panel = new JPanel(new GridLayout(6, 1));

        // �û���
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("��  ��  ��");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // ����
        JPanel panelPwd = new JPanel(new FlowLayout());
        
        JLabel labelPwd = new JLabel("��        ��");
        labelPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(labelPwd);
        
        JTextField textPwd = new JTextField(20);
        textPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelPwd.add(textPwd); 
        
        // ȷ������
        JPanel panelConfirmPwd = new JPanel(new FlowLayout());
        
        JLabel labelConfirmPwd = new JLabel("ȷ������");
        labelConfirmPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmPwd.add(labelConfirmPwd);
        
        JTextField textConfirmPwd = new JTextField(20);
        textConfirmPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmPwd.add(textConfirmPwd); 
        
        // ����
        JPanel panelMail = new JPanel(new FlowLayout());
        
        JLabel labelMail = new JLabel("��        ��");
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
        
        // ����ע��
        JPanel panelReg = new JPanel(new FlowLayout());
        
        JButton btnReg = new JButton("����ע��");
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
					JOptionPane.showMessageDialog(panel, "��������Ϣ", "����",JOptionPane.WARNING_MESSAGE);  
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
     * �����ֵ���
     */
    private static JComponent createChargePanel() {

        JPanel panel = new JPanel(new GridLayout(4, 1));

        // �û���
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("�û���");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // ��ֵ����
        JPanel panelCardNum = new JPanel(new FlowLayout());
        
        JLabel labelCardNum = new JLabel("��ֵ����");
        labelCardNum.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardNum.add(labelCardNum);
        
        JTextField textCardNum = new JTextField(20);
        textCardNum.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardNum.add(textCardNum); 
        
        // ��ֵ����
        JPanel panelCardPwd = new JPanel(new FlowLayout());
        
        JLabel labelCardPwd = new JLabel("��ֵ����");
        labelCardPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardPwd.add(labelCardPwd);
        
        JTextField textCardPwd = new JTextField(20);
        textCardPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelCardPwd.add(textCardPwd); 
        
        // ��ֵ
        JPanel panelCharge = new JPanel(new FlowLayout());
        
        JButton btnCharge = new JButton("��        ֵ");
        btnCharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String strUser = textUser.getText();
				String strCardNum = textCardNum.getText();
				String strCardPwd = textCardPwd.getText();
				if (strUser.isEmpty() || strCardNum.isEmpty() || strCardPwd.isEmpty())
				{
					JOptionPane.showMessageDialog(panel, "��������Ϣ", "����",JOptionPane.WARNING_MESSAGE);  
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
     * �޸��������
     */
    private static JComponent createChgPwdPanel() {

        JPanel panel = new JPanel(new GridLayout(5, 1));

        // �û���
        JPanel panelUser = new JPanel(new FlowLayout());
        
        JLabel labelUser = new JLabel("��     ��     ��");
        labelUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(labelUser);
        
        JTextField textUser = new JTextField(20);
        textUser.setHorizontalAlignment(SwingConstants.LEFT);
        panelUser.add(textUser);  
        
        // ������
        JPanel panelOldPwd = new JPanel(new FlowLayout());
        
        JLabel labelOldPwd = new JLabel("��     ��     ��");
        labelOldPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelOldPwd.add(labelOldPwd);
        
        JTextField textOldPwd = new JTextField(20);
        textOldPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelOldPwd.add(textOldPwd); 
        
        // ������
        JPanel panelNewPwd = new JPanel(new FlowLayout());
        
        JLabel labelNewPwd = new JLabel("��     ��     ��");
        labelNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelNewPwd.add(labelNewPwd);
        
        JTextField textNewPwd = new JTextField(20);
        textNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelNewPwd.add(textNewPwd); 
        
        // ȷ��������
        JPanel panelConfirmNewPwd = new JPanel(new FlowLayout());
        
        JLabel labelConfirmNewPwd = new JLabel("ȷ��������");
        labelConfirmNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmNewPwd.add(labelConfirmNewPwd);
        
        JTextField textConfirmNewPwd = new JTextField(20);
        textConfirmNewPwd.setHorizontalAlignment(SwingConstants.LEFT);
        panelConfirmNewPwd.add(textConfirmNewPwd); 
        
        // �����޸�
        JPanel panelChgPwd = new JPanel(new FlowLayout());
        
        JButton btnChgPwd = new JButton("�����޸�");
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
					JOptionPane.showMessageDialog(panel, "��������Ϣ", "����",JOptionPane.WARNING_MESSAGE);  
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
