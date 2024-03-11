package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.lang.*;
import java.util.Random;
import com.toedter.calendar.*;

public class SignUPOne extends JFrame implements ActionListener{

	
	//private static final long serialVersionUID = 1L;
	long random;
	JTextField nameTextField,fatherTextField,emailTextField,addressTextField,pincodeTextField,
	              stateTextField,cityTextField;
	JButton next;
	
	JRadioButton marride,unMarride,others,male,female;
	
	JDateChooser dateChooser;
	
	SignUPOne(){
	   
		setLayout(null);
		//make random class obj to genrate random no
		Random ran = new Random();
		 random = Math.abs((ran.nextLong() % 9000L) + 1000L); 
		//label application form
		JLabel formno = new JLabel("APPLICATION FORM NO:"+random);
		formno.setFont(new Font("Raleway",Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		//label for personal details
		JLabel personal = new JLabel("Page 1:Personal Details");
		personal.setFont(new Font("Raleway",Font.BOLD, 22));
		personal.setBounds(290,80,400,30);
		add(personal);
		
		//label for Name
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD, 20));
		name.setBounds(100,140,100,30);
		add(name);
		//text field
		 nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		//label for father Name
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD, 20));
		fname.setBounds(100,190,200,30);
		add(fname);
		//text field
		 fatherTextField = new JTextField();
		fatherTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fatherTextField.setBounds(300,190,400,30);
		add(fatherTextField);
		
		//label for DOB
		JLabel dob = new JLabel("Date Of Borth:");
		dob.setFont(new Font("Raleway",Font.BOLD, 20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		//create calendar
		 dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Raleway",Font.BOLD, 14));
		dateChooser.setBounds(300, 240, 400, 30);
		add(dateChooser);
		
		
		//label for Gender 
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		//make radio button
		male = new JRadioButton("Male");
		male.setFont(new Font("Raleway",Font.BOLD, 16));
		male.setBackground(Color.WHITE);
		male.setBounds(300,290,60,30);
		add(male);
		
		 female = new JRadioButton("Female");
		female.setFont(new Font("Raleway",Font.BOLD, 16));
		female.setBackground(Color.WHITE);
		female.setBounds(450,290,120,30);
		add(female);
		
		//make select only one button
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		//label for email
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD, 20));
		email.setBounds(100,340,200,30);
		add(email);
		
		 emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		
		//label for marital status
		JLabel maritalStatus = new JLabel("Marital Status:");
		maritalStatus.setFont(new Font("Raleway",Font.BOLD, 20));
		maritalStatus.setBounds(100,390,200,30);
		add(maritalStatus);
		
		//make button for marride unmarride
		marride = new JRadioButton("Marride");
		marride.setFont(new Font("Raleway",Font.BOLD, 16));
		marride.setBackground(Color.WHITE);
		marride.setBounds(300,390,100,30);
		add(marride);
		
		 unMarride = new JRadioButton("UnMarride");
		unMarride.setFont(new Font("Raleway",Font.BOLD, 16));
		unMarride.setBackground(Color.WHITE);
		unMarride.setBounds(450,390,120,30);
		add(unMarride);
		
		 others = new JRadioButton("Others");
		others.setFont(new Font("Raleway",Font.BOLD, 16));
		others.setBackground(Color.WHITE);
		others.setBounds(600,390,100,30);
		add(others);
		
		//make select only one button
		ButtonGroup marrideStatusGroup = new ButtonGroup();
		marrideStatusGroup.add(marride);
		marrideStatusGroup.add(unMarride);
		marrideStatusGroup.add(others);
		
		//Address
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440,200,30);
		add(address);
		
		 addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		
		//city
		
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490,200,30);
		add(city);
		
		 cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		
		
		
		//state
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540,200,30);
		add(state);
		
		 stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		//pincode
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway",Font.BOLD, 20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		 pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		
		
		//make next Button
		 next = new JButton("Next");
		next.setBackground(Color.GREEN);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		

		
		
	
		getContentPane().setBackground(Color.WHITE);//set background 
		setSize(850,800);//make frame
		setLocation(350,10);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname = fatherTextField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = "null";
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()){
			gender = "Female";
		}
		
		String email = emailTextField.getText();
		String marital = "null";
		if(marride.isSelected()) {
			marital = "Marride";
		}else if(unMarride.isSelected()){
			
			marital = "Unmarride";
		}else if(others.isSelected()) {
			marital = "other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pincodeTextField.getText();
		
		try {
			 
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is Required");
			}else {
				
				JdbcConnection con = new JdbcConnection();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				
				con.stm.executeUpdate(query);
				
				setVisible(false);
				new SignUPTwo(formno).setVisible(true);
			}
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
		
	}
	public static void main(String[] args) {
		
		new SignUPOne();
	}
	

	
}
