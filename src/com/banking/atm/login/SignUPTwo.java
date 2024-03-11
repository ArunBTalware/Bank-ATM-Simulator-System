package com.banking.atm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.lang.*;
import java.util.Random;
import com.toedter.calendar.*;

public class SignUPTwo extends JFrame implements ActionListener{

	
	//private static final long serialVersionUID = 1L;
	JTextField pincodeTextField,aadharNumber,panNunber;
	JButton next;
	
	JRadioButton seniorcy, seniorcn,neaccount,eaccount;
	
	JComboBox religion1,category,income,education ,occupation;
	
	String formno;
	
	SignUPTwo(String formno){
	   
		this.formno = formno;
		setLayout(null);
		//set title
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		
		//label for personal details
		JLabel additionalDetails = new JLabel("Page 2:Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		//label for Religion
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD, 20));
		religion.setBounds(100,140,100,30);
		add(religion);
		//make drop box for religion
		
		String valuForReligion[] = {"Select","Hindu","Christian","Boddh","Sikh","Muslim","Other"};
	    religion1 = new JComboBox(valuForReligion);
		religion1.setBounds(300,140,400,30);
		religion1.setBackground(Color.WHITE);
		add(religion1);
		
		//label for father Name
		JLabel category1 = new JLabel("Category:");
		category1.setFont(new Font("Raleway",Font.BOLD, 20));
		category1.setBounds(100,190,200,30);
		add(category1);
		//text field
		String valueForCategory[] = {"Select","General","OBC","SC","ST"};
	    category = new JComboBox(valueForCategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.WHITE);
		add(category);
		
		//label for Income
		JLabel incom = new JLabel("Income:");
		incom.setFont(new Font("Raleway",Font.BOLD, 20));
		incom.setBounds(100,240,200,30);
		add(incom);
		
		//create drop down for income
		String valueForIncome[] = {"Select","Null","< 150000","< 250000","< 500000","< 1000000"};
	    income = new JComboBox(valueForIncome);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		
		//label for Education 
		JLabel eduacation1 = new JLabel("Education");
		eduacation1.setFont(new Font("Raleway",Font.BOLD, 20));
		eduacation1.setBounds(100,290,300,30);
		add(eduacation1);
		
		//label for email
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD, 20));
		qualification.setBounds(100,310,200,30);
		add(qualification);
		//create drop down for education qualification
		String valueForQualification[] = {"Select","HSC","Graduate","PG","Doctorate","Other"};
	    education = new JComboBox(valueForQualification);
		education.setBounds(300,300,400,30);
		add(education);
		
		
		//label for Occupation status
		JLabel occup = new JLabel("Occupation:");
		occup.setFont(new Font("Raleway",Font.BOLD, 20));
		occup.setBounds(100,390,200,30);
		add(occup);
		
		//create drop down for education occupation
		String valueForOccupation[] = {"Select","Student","Self Employee","Salaride","Bussiness","Retired","Other"};
		occupation = new JComboBox(valueForOccupation);
		occupation.setBackground(Color.WHITE);
		occupation.setBounds(300,390,400,30);
		add(occupation);
		
		//Address
		JLabel pan = new JLabel("PAN Number:");
		pan.setFont(new Font("Raleway",Font.BOLD, 20));
		pan.setBounds(100,440,200,30);
		add(pan);
		
		//text pan number filed
		 panNunber = new JTextField();
		 panNunber.setFont(new Font("Raleway",Font.BOLD,14));
		 panNunber.setBounds(300,440,400,30);
		add(panNunber);
		
		
		//label for aadhar num
		JLabel aadhar = new JLabel("Addhar Number:");
		aadhar.setFont(new Font("Raleway",Font.BOLD, 20));
		aadhar.setBounds(100,490,200,30);
		add(aadhar);
		
		aadharNumber = new JTextField();
		aadharNumber.setFont(new Font("Raleway",Font.BOLD,14));
		aadharNumber.setBounds(300,490,400,30);
		add(aadharNumber);
		
		//state
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540,200,30);
		add(state);
		
		
		    seniorcy = new JRadioButton("Yes");
			seniorcy.setFont(new Font("Raleway",Font.BOLD, 16));
			seniorcy.setBackground(Color.WHITE);
			seniorcy.setBounds(300,540,120,30);
			add(seniorcy);
			
			 seniorcn = new JRadioButton("No");
			seniorcn.setFont(new Font("Raleway",Font.BOLD, 16));
			seniorcn.setBackground(Color.WHITE);
			seniorcn.setBounds(450,540,100,30);
			add(seniorcn);
			
			//make select only one button
			ButtonGroup seniorcyn = new ButtonGroup();
			seniorcyn.add(seniorcy);
			seniorcyn.add(seniorcn);
			
		
		//Existing Account:
		JLabel existingAccount = new JLabel("Existing Account:");
		existingAccount.setFont(new Font("Raleway",Font.BOLD, 20));
		existingAccount.setBounds(100,590,200,30);
		add(existingAccount);
		

		eaccount = new JRadioButton("Yes");
		eaccount.setFont(new Font("Raleway",Font.BOLD, 16));
		eaccount.setBackground(Color.WHITE);
		eaccount.setBounds(300,590,120,30);
		add(eaccount);
		
		neaccount = new JRadioButton("No");
		neaccount.setFont(new Font("Raleway",Font.BOLD, 16));
		neaccount.setBackground(Color.WHITE);
		neaccount.setBounds(450,590,100,30);
		add(neaccount);
		
		//make select only one button
		ButtonGroup account = new ButtonGroup();
		account.add(eaccount);
		account.add(neaccount);
		
		
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

		String religion = (String) religion1.getSelectedItem();
		String category1 = (String) category.getSelectedItem();
		String income1 =   (String) income.getSelectedItem();
		String eduQualification =   (String) education.getSelectedItem();
		String occupation1 =   (String) occupation.getSelectedItem();
		String seniorcitizen =   null;
		
		if(seniorcy.isSelected()) {
			seniorcitizen = "Yes";
		}else if(seniorcn.isSelected()){
			seniorcitizen = "No";
		}
		
		String existingAcc =   null;
		
		if(eaccount.isSelected()) {
			existingAcc = "Yes";
		}else if(neaccount.isSelected()){
			existingAcc = "No";
		}
		
		String pan = panNunber.getText();	
		String aadhar = aadharNumber.getText();

		
		try {
						
				JdbcConnection con = new JdbcConnection();
				String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category1+"','"+income1+"','"+eduQualification+"','"+occupation1+"','"+seniorcitizen+"','"+pan+"','"+aadhar+"','"+existingAcc+"')";
				
				con.stm.executeUpdate(query);
				
				//create signupthree obj
				setVisible(false);
				new SignUpThree(formno).setVisible(true);
			
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
		
	}
	public static void main(String[] args) {
		
		new SignUPTwo("");
	}
	

	
}
