//$Id$
package com.alex.mainStack;
import com.alex.stack.Stack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainStack {

	private static Scanner scan = new Scanner(System.in);
	private static Stack st = new Stack();
	public static void main(String[] args) {
		mainMethod();
	}
	
	private static void mainMethod(){
		System.out.println();
		System.out.println("1) Push Data");
		System.out.println("2) Pop Data");
		System.out.println("3) Disply Array");
		System.out.println();
		System.out.print("Enter your Option - ");
		int option = scan.nextInt();
		
		switch(option)
		{
			case 1:
			{
				int data = isValidInput();
				st.push(data);
				mainMethod();
				break;
			}
			case 2:
			{
				int data = st.pop();
				if(data == '*') System.out.println("Stack is Empty");
				else System.out.println("Removed data is -" + data);
				mainMethod();
				break;
			}
			case 3:
			{
				st.disply();
				mainMethod();
				break;
			}
			case 4:
			{
				System.out.println("Program is Exit");
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
