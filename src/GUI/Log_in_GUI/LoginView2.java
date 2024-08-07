package GUI.Log_in_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView2 extends JFrame{
    private LoginController logincontroller;

    private JPanel LoginView2;
    private JTextField userText;
    private JButton btnLogin;

    private JPanel pnTop;
    private JLabel ID;
    private JLabel Password;
    private JPasswordField passText;
    private JButton btnImage;

    public static String id;
    public String getID(){ return id; }
    public void setId(String id) { this.id = id; }
    public static void main(String[] args) {
        new LoginView2();
    }

    public LoginView2(){
        //setting
        JFrame frame = new JFrame("로그인");
        frame.setContentPane(LoginView2);
        frame.pack();
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
        add(panel);

    }


    public void placeLoginPanel(JPanel panel){
        btnImage.setBorderPainted(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logincontroller = new LoginController();
                int result = logincontroller.login(userText.getText(), passText.getText());
                if (result == 1){
                    JOptionPane.showMessageDialog(null,"로그인 성공");
                    setVisible(false);
                    setId(userText.getText());
                    new ClientConnect();
                }
                else if (result == 2){
                    JOptionPane.showMessageDialog(null,"이미 접속한 상태입니다.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Failed");
                    userText.setText("");
                    passText.setText("");
                }
            }
        });
    }


}
