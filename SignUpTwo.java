package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    long random;
    JTextField pan, adhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE - 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String[] incomeCategory = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "UPTO 10,00,000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        add(income);

        JLabel gender = new JLabel("Educational : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualifications : ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String[] educationValues = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 315, 400, 30);
        add(education);

        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String[] occupationValues = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);

        JLabel add = new JLabel("PAN Number : ");
        add.setFont(new Font("Raleway", Font.BOLD, 22));
        add.setBounds(100, 440, 200, 30);
        add(add);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel adharno = new JLabel("Aadhar Number : ");
        adharno.setFont(new Font("Raleway", Font.BOLD, 22));
        adharno.setBounds(100, 490, 200, 30);
        add(adharno);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);

        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String sadhar = adhar.getText();

        try {
            Con c = new Con();
            String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + sadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
            c.s.executeUpdate(query);

            
            // new NextFrame(); // Open the next frame
            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
