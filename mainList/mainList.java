//$Id$
package com.alex.mainList;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alex.linkedList.LinkedList;

public class mainList {
	
	private static Scanner scan = new Scanner(System.in);
	private static LinkedList linkedList = new LinkedList(); 
	
	public static void main(String[] args) {
		mainMethod();
	}
	
	public static void mainMethod(){
		System.out.println();
		System.out.println("1) Insert data at Back");
		System.out.println("2) Insert data at Front");
		System.out.println("3) Remove data at Back");
		System.out.println("4) Remove data at Front");
		System.out.println("5) Disply Array");
		System.out.println("6) Exit");
		System.out.println();
		System.out.print("Enter your Option - ");
		int option = scan.nextInt();
		
		switch(option)
		{
			case 1:
			{
				int data = isValidInput();
				linkedList.pushDataAtBack(data);
				mainMethod();
				break;
			}
			case 2:
			{
				int data = isValidInput();
				linkedList.pushDataAtFront(data);
				mainMethod();
				break;
			}
			case 3:
			{
				int data = linkedList.popDataAtBack();
				if(data == '*') System.out.println("Stack is Empty");
				else System.out.println("Removed data is -" + data);
				
				mainMethod();
				break;
			}
			case 4:
			{
				int data = linkedList.popDataAtFront();
				if(data == '*') System.out.println("Stack is Empty");
				else System.out.println("Removed data is -" + data);
				mainMethod();
				break;
			}
			case 5:
			{
				linkedList.displyData();
				mainMethod();
				break;
			}
			case 6:
			{
				System.out.println("Program Exit");
				System.exit(0);
			}
			default :{
				System.out.println("Enter the Correct option");
				mainMethod();
			}
		}
	}
	
	public static int isValidInput(){
		System.out.print("Enter the Number - ");
		int data = 0;
		try{
			 data = scan.nextInt();
		}catch(InputMismatchException ex){
			System.out.print("Type of Exception -  " + ex);
			System.out.println();
			System.out.println("Plz Enter the valid Number");
			isValidInput();
		}
		return data;
	}

}
