package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField namef, fnamef, mailf, addf, cityf, statef, pinf;
    JButton next;
    JRadioButton male, female, other, yes, no;
    JDateChooser dateChooser;
    
    SignUpOne() {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel pd = new JLabel("Page 1 : Personal Details");
        pd.setFont(new Font("Raleway", Font.BOLD, 22));
        pd.setBounds(290, 80, 400, 30);
        add(pd);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        namef = new JTextField();
        namef.setFont(new Font("Raleway" , Font.BOLD, 14));
        namef.setBounds(300, 140, 400, 30);
        add(namef);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnamef = new JTextField();
        fnamef.setFont(new Font("Raleway" , Font.BOLD, 14));
        fnamef.setBounds(300, 190, 400, 30);
        add(fnamef);
        
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
      
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100,30);
        add(female);
        
        ButtonGroup gp = new ButtonGroup();
        gp.add(male);
        gp.add(female);
        
        JLabel email = new JLabel("E-Mail Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        mailf = new JTextField();
        mailf.setFont(new Font("Raleway" , Font.BOLD, 14));
        mailf.setBounds(300, 340, 400, 30);
        add(mailf);
        
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        yes = new JRadioButton("Married");
        yes.setBounds(300, 390, 100,30);
        add(yes);
        
        no = new JRadioButton("Unmarried");
        no.setBounds(450, 390, 100,30);
        add(no);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100,30);
        add(other);
        
        ButtonGroup gp1 = new ButtonGroup();
        gp1.add(yes);
        gp1.add(no);
        gp1.add(other);
        
        JLabel add = new JLabel("Address : ");
        add.setFont(new Font("Raleway", Font.BOLD, 22));
        add.setBounds(100, 440, 200, 30);
        add(add);
        
        addf = new JTextField();
        addf.setFont(new Font("Raleway" , Font.BOLD, 14));
        addf.setBounds(300, 440, 400, 30);
        add(addf);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityf = new JTextField();
        cityf.setFont(new Font("Raleway" , Font.BOLD, 14));
        cityf.setBounds(300, 490, 400, 30);
        add(cityf);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        statef = new JTextField();
        statef.setFont(new Font("Raleway" , Font.BOLD, 14));
        statef.setBounds(300, 540, 400, 30);
        add(statef);
        
        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinf = new JTextField();
        pinf.setFont(new Font("Raleway" , Font.BOLD, 14));
        pinf.setBounds(300, 590, 400, 30);
        add(pinf);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = namef.getText();
        String fname = fnamef.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = mailf.getText();
        String marital = null;
        if(yes.isSelected()){
            marital = "Married";
        }
        else if(no.isSelected()){
            marital = "Unmarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        String add = addf.getText();
        String city = cityf.getText();
        String state = statef.getText();
        String pincode = pinf.getText();
        
        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Name is required");
           }
           else{
               Con c = new Con();
               String querry = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+add+"', '"+city+"', '"+pincode+"', '"+state+"')";
               c.s.executeUpdate(querry);
               
               setVisible(false);
               new SignUpTwo(formno).setVisible(true);
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        
        new SignUpOne();
    }
    
}
