package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
 
	 JButton withdraw1,withdraw5,withdraw10,withdraw20,withdraw50,withdraw100,back;
	 String pinnumber;
	public FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		//add ATM image on frame
		 
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image ii = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(ii);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		
		//make label for transaction
		JLabel text = new JLabel("Please Select Amount");
		text.setBounds(230,280,600,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(text);
		
		
		//make buttons
	    withdraw1 = new JButton("Rs 100");
	    withdraw1.setBounds(165,368,150,30);
	    withdraw1.setFont(new Font("Raleway",Font.BOLD, 20));
	    withdraw1.addActionListener(this);
		image.add(withdraw1);
		
		withdraw5 = new JButton("Rs 500");
		withdraw5.setBounds(330,368,180,30);
		withdraw5.setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw5.addActionListener(this);
		image.add(withdraw5);
		
		withdraw10 = new JButton("Rs 1000");
		withdraw10.setBounds(165,405,150,30);
		withdraw10.setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw10.addActionListener(this);
		image.add(withdraw10);
		
		withdraw20 = new JButton("Rs 2000");
		withdraw20.setBounds(330,405,180,30);
		withdraw20.setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw20.addActionListener(this);
		image.add(withdraw20);
		
		withdraw50 = new JButton("Rs 5000");
		withdraw50 .setBounds(165,441,150,30);
		withdraw50 .setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw50 .addActionListener(this);
		image.add(withdraw50 );
		
		withdraw100 = new JButton("Rs 10000");
		withdraw100.setBounds(330,441,180,30);
		withdraw100.setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw100.addActionListener(this);
		image.add(withdraw100);
		
		back = new JButton("Back");
		back.setBounds(245,473,150,30);
		back.setFont(new Font("Raleway",Font.BOLD, 20));
		back.addActionListener(this);
		image.add(back);
//		
//		
		//make frame for transaction
		setSize(900,800);
		setLocation(300,0);
		//setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent al) {
		
		if(al.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}else  {
			int amount = Integer.parseInt(((JButton) al.getSource()).getText().substring(3));
			try {
				
				 JdbcConnection con = new JdbcConnection();
				 String query = "select * from bank where pin='"+pinnumber+"' ";
				 ResultSet rs = con.stm.executeQuery(query);
				 int balance=0;
				 while(rs.next()) {
					 
					 if(rs.getString("type").equals("Deposit")) {
						 
						 balance = balance + amount;
					 }else {
						 balance = balance - amount;
					 }
				 }
				 
				 if(al.getSource() != back && balance < amount) {
					
					 JOptionPane.showMessageDialog(null, "Incefficent Balance");
				 }
				 
				 Date date = new Date();
				 String query1 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
				 con.stm.executeUpdate(query1);
				 JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited successfully");
				 
				   setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				 
			   }catch(Exception ex) {
			
			        System.out.println(ex);
		       }
		}
	}
	
	public static void main(String[] args) {
		
          new FastCash("");
		
	}
	

}

