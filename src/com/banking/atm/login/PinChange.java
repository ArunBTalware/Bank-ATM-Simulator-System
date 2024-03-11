package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{

	JButton change,back ;
	JPasswordField pin,rpin;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		//add ATM image on frame
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image ii = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(ii);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		

		//make label for change pin
		JLabel text = new JLabel("Change Your Pin");
		text.setBounds(240,240,600,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(text);
		
		//label for Religion
		JLabel pinc = new JLabel("New Pin:");
		pinc.setBounds(170,290,600,35);
		pinc.setForeground(Color.WHITE);
		pinc.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(pinc);
		//text field
	    pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(300,290,180,35);
		image.add(pin);
		//reenter pin
		JLabel repin = new JLabel("Re Enter Pin:");
		repin.setBounds(170,330,600,35);
		repin.setForeground(Color.WHITE);
		repin.setFont(new Font("Raleway",Font.BOLD, 20));
		image.add(repin);
		//text filed
		 rpin = new JPasswordField();
		rpin.setFont(new Font("Raleway",Font.BOLD,25));
		rpin.setBounds(300,330,180,35);
		image.add(rpin);
		
		//create change button
		change = new JButton("Change Pin");
		change.setBounds(370,400,120,30);
		change.setBackground(Color.GREEN);
		change.setForeground(Color.blue);
		change.setFont(new Font("Raleway",Font.BOLD,16));
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(370,440,120,30);
		back.setBackground(Color.WHITE);
		back.setForeground(Color.red);
		back.setFont(new Font("Raleway",Font.BOLD,16));
		back.addActionListener(this);
		image.add(back);
		//make frame for change pin bv
		setSize(900,800);
		setLocation(300,0);
		//setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent al) {
	
		if(al.getSource() == change) {
			
			try {
				String npin = pin.getText();
				String repin = rpin.getText();
				
				if(!npin.equals(repin)) {
					
					JOptionPane.showMessageDialog(null, "Enter pin does not match");
					return;
				}
				 if(npin.equals("") && repin.equals("")) {
					
					JOptionPane.showMessageDialog(null, "please Enter pin ");
					return;
				}
				 
			  JdbcConnection con = new JdbcConnection();
			  String query1 = "update login set pin_number = '"+npin+"' where pin_number = '"+pinnumber+"' ";
			  String query2 = "update signup_three set pin_number = '"+npin+"' where pin_number = '"+pinnumber+"' ";
			  String query3 = "update bank set pin = '"+npin+"' where pin = '"+pinnumber+"' ";
			  
			  con.stm.executeUpdate(query1);
			  con.stm.executeUpdate(query2);
			  con.stm.executeUpdate(query3);
			  
			  JOptionPane.showMessageDialog(null, "Pin change successfully");
			  setVisible(false);
			  new Transaction(repin).setVisible(true);
				
				
				
			}catch(Exception e) {
				
				System.out.println(e);
			}	
		}else {
			
			  setVisible(false);
			  new Transaction(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		
        new  PinChange("");
	}
	

}
