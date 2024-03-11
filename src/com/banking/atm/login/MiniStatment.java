package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatment extends JFrame implements ActionListener{
    String pinnumber;
    JButton back,print;
	MiniStatment(String pinnumber){
		
		this.pinnumber = pinnumber;
		setTitle("Mini Statment");
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		mini.setFont(new Font("Raleway",Font.BOLD,16));
		add(mini);
		
		JLabel bank = new JLabel("SBI Bank");
		bank.setBounds(150,20,100,20);
		bank.setFont(new Font("Raleway",Font.BOLD,20));
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(40,100,400,20);
		card.setFont(new Font("Raleway",Font.BOLD,20));
		add(card);
		
		JLabel balan = new JLabel();
		balan.setBounds(40,300,400,20);
		balan.setFont(new Font("Raleway",Font.BOLD,20));
		add(balan);
		
		back = new JButton("Back");
		back.setBounds(40,460,120,30);
		back.setFont(new Font("Raleway",Font.BOLD,16));
		back.addActionListener(this);
		add(back);
		
		print = new JButton("Print");
		print.setBounds(200,460,120,30);
		print.setFont(new Font("Raleway",Font.BOLD,16));
		print.setBackground(Color.orange);
		print.addActionListener(this);
		add(print);
		
		try {
			
			 JdbcConnection con = new JdbcConnection();
			 String query = "select * from login where pin_number='"+pinnumber+"' ";
			 ResultSet rs = con.stm.executeQuery(query);
			
			 while(rs.next()) {
				 System.out.println("hello");
				card.setText("Card Number:"+rs.getString("card_number").substring(0,4) +"XXXXXXXX"+rs.getString("card_number").substring(12));
			 }
			 
		 }catch(Exception ex) {
		
		        System.out.println(ex);
	     }
		
		try {
			
			 JdbcConnection con = new JdbcConnection();
			 String query = "select * from bank where pin='"+pinnumber+"' ";
			 ResultSet rs = con.stm.executeQuery(query);
			 int bal=0;
			 while(rs.next()) {
				 
				mini.setText(mini.getText() +"<html>"+ rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					 
					bal = bal + Integer.parseInt(rs.getString("amount"));
					 System.out.println("check balance");
				 }else {
					 bal = bal - Integer.parseInt(rs.getString("amount"));
				 }
			 }
			 
			  balan.setText("Your total Balance is Rs "+bal);
			 
		 }catch(Exception ex) {
		
		        System.out.println(ex);
	     }
		//make frame for mini transaction
		getContentPane().setBackground(Color.WHITE);
		setSize(400,600);
		setLocation(20,20);		
	    setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent al) {
		
		if(al.getSource() == back) {
			setVisible(false);
			new Transaction("pinnumber").setVisible(true);
		}else if(al.getSource() ==  print) {
			
		}
		
	}

	public static void main(String[] args) {
		
		new MiniStatment("");

	}
	
}
