package com.hackathon.speechtotext;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.hackathon.speechtotext.interpretor.SpeechToText;

public class CustomerSignup {

	private static Properties custDb = null;

	static {
		InputStream inStream = CustomerSignup.class.getResourceAsStream("hackathon.db");
		custDb = new Properties();

		if (inStream != null) {
			if(inStream != null) {
				try {
					custDb.load(inStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			inStream = Thread.currentThread()
				    .getContextClassLoader().getResourceAsStream("hackathon.db");

			if(inStream != null) {
				try {
					custDb.load(inStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Customer processSignup(String custId) {
		String cin = custId;
		String name = "";
		if (custId == null || custId.trim().equals("")) {
			if (!StringUtils.isNumeric(custId)) {
				SpeechToText speechToText = SpeechToText.getInstance();
				cin = speechToText.getRawAppointmentRequest();
			}
		}

		System.out.println("cin is :" + cin);
		name = custDb.getProperty(cin.substring(0,1));
		System.out.println("name is : "+ name);

		Customer customer = new Customer(cin, name);
		
		return customer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomerSignup cs = new CustomerSignup();
		Customer c = cs.processSignup("");
		System.out.println("customer name: " + c.getName());
	}
}
