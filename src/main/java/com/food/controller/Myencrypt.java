package com.food.controller;

public class Myencrypt {

	public static String encrypt(String s) 
	{
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length();i++){
			sb.append((char)(s.charAt(i)+2));
		}
		return sb.toString();
	}
	public static String decrypt(String s) 
	{
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length();i++){
			sb.append((char)(s.charAt(i)-2));
		}
		return sb.toString();
	}
}
