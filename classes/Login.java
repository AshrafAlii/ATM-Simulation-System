package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    JButton login, clear, sign;
    JTextField cf;
    JPasswordField pf;
            
    Login(){
        
        setLayout(null);
        setTitle("ATM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pic/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
          
        //image
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        //teXT
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(230,40,400,40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);
        
        JLabel cardno = new JLabel("CARD NO : ");
        cardno.setBounds(120,150,165,40);
        cardno.setFont(new Font("RaleWay", Font.BOLD, 28));
        add(cardno);
        
        cf = new JTextField();
        cf.setBounds(300, 160, 230, 30 );
        cf.setFont(new Font("Arial", Font.BOLD, 14));
        add(cf);
        
        
        JLabel pin = new JLabel("PIN : ");
        pin.setBounds(120,220,250,40);
        pin.setFont(new Font("RaleWay", Font.BOLD, 28));
        add(pin);
        
        pf = new JPasswordField();
        pf.setBounds(300, 220, 230, 30 );
        pf.setFont(new Font("Arial", Font.BOLD, 14));
        add(pf);
        
        login = new JButton("SIGN UP");
        login.setBounds(300,300,100, 30);
        login.setBackground(Color.DARK_GRAY);
        //login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100, 30);
        clear.setBackground(Color.DARK_GRAY);
        //clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        sign = new JButton("SIGN UP");
        sign.setBounds(300,350,230, 30);
        sign.setBackground(Color.DARK_GRAY);
        //sign.setForeground(Color.WHITE);
        sign.addActionListener(this);
        add(sign);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cf.setText("");
            pf.setText("");
        }
        else if(ae.getSource() == login){
            Con conn = new Con();
            String cardnumber = cf.getText();
            String pinnumber = pf.getText();
        String query = "select * from login where cardnumber = '" +cardnumber+"' and pin = '" +pinnumber+ "'";
            
            try{
                
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid card number or pin");
                }
                
            }catch(Exception e){
                System.out.println();
            }
            
        }
        else if(ae.getSource() == sign){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        new Login();
    }
    
}
