package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	Deposit(String pinnuber){
		
		this.pinnumber = pinnuber;
		setLayout(null);//border layout null
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image ii = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(ii);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		
		//make label for transaction
		JLabel text = new JLabel("Enter the amount you want to diposit");
		text.setBounds(150,280,600,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(text);
		
		//make text filed for amount
		amount = new JTextField();
		amount.setBounds(150,330,350,30);
		amount.setFont(new Font("Arial",Font.BOLD,24));
		image.add(amount);
		
		//create button for diposit
		deposit = new JButton("Deposit");
		deposit.setBackground(Color.GREEN);
		deposit.setFont(new Font("Raleway",Font.BOLD,14));
		deposit.setBounds(355,430,150,30);
		deposit.addActionListener(this);
		image.add(deposit);	
		
		//create back button
		back = new JButton("Back");
		back.setBackground(Color.RED);
		back.setFont(new Font("Raleway",Font.BOLD,14));
		back.setBounds(355,465,150,30);
		back.addActionListener(this);
		image.add(back);	
		//create deposit frame 
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent al) {
		
		if(al.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		} else if(al.getSource() == deposit) {
			
			String amountDiposit = amount.getText();
			Date date = new Date();
			if(amountDiposit.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Please enter amount");
			}else {
			
			try {
				
				 JdbcConnection con = new JdbcConnection();
				 String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+amountDiposit+"') ";
				 con.stm.executeUpdate(query);
				 JOptionPane.showMessageDialog(null,"Rs "+amountDiposit+" Deposited Successfully");
		         setVisible(false);
				 new Transaction(pinnumber).setVisible(true);
				 
			   }catch(Exception ex) {
			
			        System.out.println(ex);
		       }
			}
		} 
			
	}
	
	
	public static void main(String[] args) {
		
		new Deposit("");
	}
	

}
