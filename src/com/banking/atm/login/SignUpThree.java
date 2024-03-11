package com.banking.atm.login;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.*;
public class SignUpThree extends JFrame implements ActionListener{

	JRadioButton saving,currunt,joint,fix;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	SignUpThree(String formno){
		
		this.formno = formno;
		setLayout(null);
		
		//make label for account details
		JLabel ll = new JLabel("PAGE 3: ACCOUNT DETAILS");
	    ll.setFont(new Font("Raleway", Font.BOLD,22));
		ll.setBounds(280,40,400,40);
		add(ll);
		
		//label for account
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		//make radio buttons for account type
		saving = new JRadioButton("Saving Account");
		saving.setFont(new Font("Raleway", Font.BOLD,20));
		saving.setBackground(Color.WHITE);
		saving.setBounds(100,180,200,30);
		add(saving);
		
		currunt = new JRadioButton("Currunt Account");
		currunt.setFont(new Font("Raleway", Font.BOLD,20));
		currunt.setBackground(Color.WHITE);
		currunt.setBounds(350,180,200,30);
		add(currunt);
		
		joint = new JRadioButton("Joint Account");
		joint.setFont(new Font("Raleway", Font.BOLD,20));
		joint.setBackground(Color.WHITE);
		joint.setBounds(100,220,200,30);
		add(joint);
		
		fix = new JRadioButton("Fixed Diposit Account");
		fix.setFont(new Font("Raleway", Font.BOLD,20));
		fix.setBackground(Color.WHITE);
		fix.setBounds(350,220,250,30);
		add(fix);
		
		//make select only one button
		ButtonGroup accType = new ButtonGroup();
		accType.add(currunt);
		accType.add(joint);
		accType.add(fix);
		accType.add(saving);
		
		//label for card number
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway", Font.BOLD,22));
		card.setBounds(100,300,200,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4512");
		number.setFont(new Font("Raleway", Font.BOLD,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		JLabel cardNum = new JLabel("Your 16 Digit Card Number");
		cardNum.setFont(new Font("Raleway", Font.BOLD,15));
		cardNum.setBounds(100,330,300,20);
		add(cardNum);
		
		//label for pin number
				JLabel pin = new JLabel("PIN :");
				pin.setFont(new Font("Raleway", Font.BOLD,22));
				pin.setBounds(100,370,200,30);
				add(pin);
				
				JLabel pinnumber = new JLabel("XXXX");
				pinnumber.setFont(new Font("Raleway", Font.BOLD,22));
				pinnumber.setBounds(330,370,300,30);
				add(pinnumber);
				
				JLabel pinDetails = new JLabel("Your 4 Digit Pin");
				pinDetails.setFont(new Font("Raleway", Font.BOLD,15));
				pinDetails.setBounds(100,400,300,20);
				add(pinDetails);
				
		//sevices required
				JLabel service = new JLabel("Services Required:");
				service.setFont(new Font("Raleway", Font.BOLD,22));
				service.setBounds(100,450,300,30);
				add(service);	
				
		//check boxes for service
			c1 = new JCheckBox("ATM CARD");
			c1.setBackground(Color.lightGray);
			c1.setFont(new Font("Raleway", Font.BOLD,15));
			c1.setBounds(100,500,200,30);
			add(c1);	
			
			c2 = new JCheckBox("Internet Banking");
			c2.setBackground(Color.lightGray);
			c2.setFont(new Font("Raleway", Font.BOLD,15));
			c2.setBounds(350,500,200,30);
			add(c2);
			
			c3 = new JCheckBox("Mobile Banking");
			c3.setBackground(Color.lightGray);
			c3.setFont(new Font("Raleway", Font.BOLD,15));
			c3.setBounds(100,550,200,30);
			add(c3);
			
			c4 = new JCheckBox("Email and SMS Alert");
			c4.setBackground(Color.lightGray);
			c4.setFont(new Font("Raleway", Font.BOLD,15));
			c4.setBounds(350,550,200,30);
			add(c4);
			
			c5 = new JCheckBox("Cheque Book");
			c5.setBackground(Color.lightGray);
			c5.setFont(new Font("Raleway", Font.BOLD,15));
			c5.setBounds(100,600,200,30);
			add(c5);
			
			c6 = new JCheckBox("E-Statment");
			c6.setBackground(Color.lightGray);
			c6.setFont(new Font("Raleway", Font.BOLD,15));
			c6.setBounds(350,600,200,30);
			add(c6);
			
			c7 = new JCheckBox(" hereby declare that all the information submitted by me is true");
			c7.setBackground(Color.lightGray);
			c7.setFont(new Font("Raleway", Font.BOLD,15));
			c7.setBounds(100,660,600,30);
			add(c7);
			
			//button
			submit = new JButton("Submit");
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.WHITE);
			submit.setFont(new Font("Raleway", Font.BOLD,14));
			submit.setBounds(250,720,100,30);
			submit.addActionListener(this);
			add(submit);
			
			cancel = new JButton("Cancel");
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.WHITE);
			cancel.setFont(new Font("Raleway", Font.BOLD,14));
			cancel.setBounds(420,720,100,30);
			cancel.addActionListener(this);
			add(cancel);
			
		//make frame
		getContentPane().setBackground(Color.WHITE);//set background 
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//sibmit user data using submit
		if(e.getSource() == submit) {
			
			String accountType = null;
			if(saving.isSelected()) {
				accountType="Saving Account";
			}else if(currunt.isSelected()) {
				accountType = "Currunt Account";
			}else if(joint.isSelected()) {
				accountType = "Joint Account";
			}else if(fix.isSelected()) {
				accountType = "Fixed Diposit Account";
			}
			
			Random random = new Random();
			long card_umber1 = Math.abs((random.nextLong() % 90000000L) + 1234567800000000L);
			long pin_number1 = Math.abs(random.nextInt() % 9000L + 1000L);
			
			String card_number = Long.toString(card_umber1);
			String pin_number = Long.toString(pin_number1);
			
			String services = "";
			if(c1.isSelected()) {
				services = services + " ATM CARD";
			} else if(c2.isSelected()){
				services = services + " Internet Banking";
			}else if(c3.isSelected()){
				services = services + " Mobile Banking";
			}else if(c4.isSelected()){
				services = services + " Email and SMS Alert";
			}else if(c5.isSelected()){
				services = services + " Cheque Book";
			}else if(c6.isSelected()){
				services = services + " E-Statment";
			}


             //conect with the data base
			try {
				if(accountType.equals("")) {
					
	                 JOptionPane.showMessageDialog(null, "Account Type is Required");
				}else {
				 JdbcConnection con = new JdbcConnection();
				 String query1 = "insert into signup_three values('"+formno+"','"+accountType+"','"+card_number+"','"+pin_number+"','"+ services+"')";
				 String query2 = "insert into login values('"+formno+"','"+card_number+"','"+pin_number+"')";
				 con.stm.executeUpdate(query1);
				 con.stm.executeUpdate(query2);
				 
				 JOptionPane.showInternalMessageDialog(null, "Card Number:"+ card_number + "\n" + "Pin Number:"+pin_number);
				 setVisible(false);
				 new Deposit(pin_number).setVisible(true);
				}
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}

		}else if(e.getSource() == cancel) {
			
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		
		new SignUpThree("");

	}
	

}
