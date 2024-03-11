package com.banking.atm.login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class BalanceEnquiry extends JFrame implements ActionListener{

	    JButton back;
	String pinnumber;
	public BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355,460,150,30);
		back.setFont(new Font("Raleway",Font.BOLD,16));
		back.addActionListener(this);
		image.add(back);
		
		 int balance=0;
		try {
			
			 JdbcConnection con = new JdbcConnection();
			 String query = "select * from bank where pin='"+pinnumber+"' ";
			 ResultSet rs = con.stm.executeQuery(query);
			
			 while(rs.next()) {
				 
				 if(rs.getString("type").equals("Deposit")) {
					 
					 balance = balance + Integer.parseInt(rs.getString("amount"));
					 System.out.println("check balance");
				 }else {
					 balance = balance - Integer.parseInt(rs.getString("amount"));
				 }
			 }
			 
		 }catch(Exception ex) {
		
		        System.out.println(ex);
	     }
		
		JLabel text = new JLabel("Your Currunt Account Balance is RS "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170,300,400,30);
		text.setFont(new Font("Raleway",Font.BOLD,17));
		image.add(text);
		//System.out.println("hello");
		//make frame for change balance enquiry
		setSize(900,800);
		setLocation(300,0);
				
	    setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
          new BalanceEnquiry("");
	}

	@Override
	public void actionPerformed(ActionEvent al) {
		
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
		
	}

}
