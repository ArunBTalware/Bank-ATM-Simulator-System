package com.banking.atm.login;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	
	JButton login , signUp,clear;
	JTextField cardTextField;
	JPasswordField pin1TextFiled;

	Login(){
		
		setTitle("AUTOMATED TRELER MACHINE");
		setLayout(null);//border layout null
		//place icon on frame
		ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i = ii.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//set icon size
		
		ImageIcon image = new ImageIcon(i);
		
		JLabel label = new JLabel(image);
	    label.setBounds(70, 10, 100, 100);
		add(label);
		
		//headline
		JLabel text = new JLabel("Welcome To ATM");
		text.setBounds(200,40,400,30);
		text.setFont(new Font("Raleway",Font.BOLD,38));
		add(text);
		
		//for card number label
		JLabel carNumber = new JLabel("Card No.:");
		carNumber .setBounds(120,150,400,30);
		carNumber .setFont(new Font("Raleway",Font.BOLD,28));
		add(carNumber);
		//for card number input
		 cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,24));
		add(cardTextField);
		
		//for pin
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(120,220,250,30);
		pin.setFont(new Font("Osward",Font.BOLD,28));
		add(pin);
		//for pin number input
		 pin1TextFiled = new JPasswordField ();
		pin1TextFiled.setBounds(300,220,230,30);
		pin1TextFiled.setFont(new Font("Arial",Font.BOLD,28));
		add(pin1TextFiled);
		//create sine in button
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.GREEN);
		login.setForeground(Color.blue);
		login.addActionListener(this);
		add(login);
		//create clear in button
		 clear = new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.GREEN);
		clear.setForeground(Color.blue);
		clear.addActionListener(this);
		add(clear);
		//create sign up in button
		 signUp = new JButton("SIGN UP");
		signUp.setBounds(300,350,230,30);
		signUp.setBackground(Color.GREEN);
		signUp.setForeground(Color.blue);
		signUp.addActionListener(this);
		add(signUp);
	
		getContentPane().setBackground(Color.WHITE);//set background color
		
		setSize(800, 480);//create frame
		setVisible(true);//visible
		setLocation(350,200);//open frame location
	}
	public static void main(String[] args) {
		
          new Login();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == clear) {
			
			cardTextField.setText("");
			pin1TextFiled.setText("");
		   } 
		 if(ae.getSource() == login) {
			
			 String cardnumber = cardTextField.getText();	
			 String pinnumber = pin1TextFiled .getText();

			
				
				try {
								
						JdbcConnection con = new JdbcConnection();
						String query = "select * from login where card_number = '"+cardnumber+"'and pin_number = '"+pinnumber+"' ";
						ResultSet rs =con.stm.executeQuery(query);
				    	if(rs.next()) {
							
							setVisible(false);
							new Transaction(pinnumber).setVisible(true);
						} else {
							
							JOptionPane.showMessageDialog(null,"Incorrect Card No or Pin");
						}	
					
			      }catch(Exception ex) {
					
					System.out.println(ex);
				}
	       }
		 if(ae.getSource() == signUp) {
			 setVisible(false);
			 new SignUPOne().setVisible(true);
		 }
	    	   
	       

   }
}
