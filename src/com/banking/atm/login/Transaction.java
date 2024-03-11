package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
 
	 JButton diposit,withdraw,fcash,minis,changepin,check_balance,exit;
	 String pinnumber;
	public Transaction(String pinnumber) {
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
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(190,280,600,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(text);
		
		
		//make buttons
	    diposit = new JButton("Diposit");
		diposit.setBounds(165,368,150,30);
		diposit.setFont(new Font("Raleway",Font.BOLD, 20));
		diposit.addActionListener(this);
		image.add(diposit);
		
		withdraw = new JButton("Cash Withdraw");
		withdraw.setBounds(330,368,180,30);
		withdraw.setFont(new Font("Raleway",Font.BOLD, 20));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		fcash = new JButton("Fast Cash");
		fcash.setBounds(165,405,150,30);
		fcash.setFont(new Font("Raleway",Font.BOLD, 20));
		fcash.addActionListener(this);
		image.add(fcash);
		
		minis = new JButton("Mini Statement");
		minis.setBounds(330,405,180,30);
		minis.setFont(new Font("Raleway",Font.BOLD, 20));
		minis.addActionListener(this);
		image.add(minis);
		
		changepin = new JButton("Change Pin");
		changepin.setBounds(165,441,150,30);
		changepin.setFont(new Font("Raleway",Font.BOLD, 20));
		changepin.addActionListener(this);
		image.add(changepin);
		
		check_balance = new JButton("Check Balance");
		check_balance.setBounds(330,441,180,30);
		check_balance.setFont(new Font("Raleway",Font.BOLD, 20));
		check_balance.addActionListener(this);
		image.add(check_balance);
		
		exit = new JButton("Exit");
		exit.setBounds(245,473,150,30);
		exit.setFont(new Font("Raleway",Font.BOLD, 20));
		exit.addActionListener(this);
		image.add(exit);
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
		
		if(al.getSource() == exit) {
			System.exit(0);
		}else if(al.getSource() ==  diposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(al.getSource() == withdraw) {
			setVisible(false);
			new WithdrawAmount(pinnumber).setVisible(true);
		}else if(al.getSource() == fcash) {
		    setVisible(false);
		    new FastCash(pinnumber).setVisible(true);
		}else if(al.getSource() == changepin) {
			setVisible(false);
		    new PinChange(pinnumber).setVisible(true);
		}else if(al.getSource() == check_balance) {
			setVisible(false);
		    new BalanceEnquiry(pinnumber).setVisible(true);
		}else if(al.getSource() == minis) {
			setVisible(false);
		    new MiniStatment(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		
          new Transaction("");
		
	}
	

}
