//$Id$
package com.alex.mainStackUsingQueue;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.alex.stackUsingQueue.StackUsingQueue;

public class MainStackUsingQueue {

	public static void main(String[] args) {
		StackUsingQueue st = new StackUsingQueue();
		mainMethod(st);
	}
	
	private static void mainMethod(StackUsingQueue st){
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("1) push");
		System.out.println("2) pop");
		System.out.println("3) peek");
		System.out.println("4) Disply Array");
		System.out.println("5)Exit");
		System.out.println();
		System.out.print("Enter your Option - ");
		int option = scan.nextInt();
		
		switch(option)
		{
			case 1:
			{
				int data = isValidInput(scan);
				st.push(data);
				mainMethod(st);
				break;
			}
			case 2:
			{
				int data = st.pop();
				if(data == '*') System.out.println("Stack is Empty");
				else System.out.println("Removed data is -" + data);
				mainMethod(st);
				break;
			}
			case 3:
			{
				int result = st.peek();
				if (result != '*') System.out.println("Peek data is - " + result);
				else System.out.println("Stack is Empty");
				mainMethod(st);
				break;
			}
			case 4:
			{
				st.disply();
				mainMethod(st);
				break;
			}
			case 5:
			{
				System.out.println("Program Stop");
				System.exit(0);
			}
			default :{
				System.out.println("Enter the Correct option");
				mainMethod(st);
			}
		} 
	}
	
	public static int isValidInput(Scanner scan){
		System.out.print("Enter the Number - ");
		int data = 0;
		try{
			 data = scan.nextInt();
		}catch(InputMismatchException ex){
			System.out.print("Type of Exception -  " + ex);
			System.out.println();
			System.out.println("Plz Enter the valid Number");
			isValidInput(scan);
		}
		return data;
	}
}
