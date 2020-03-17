//$Id$
package com.alex.mainQueueUsingStack;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.alex.queueUsingStack.QueueUsingStack;

public class MainQueueUsingStack {
	
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack(); 
		mainMethod(queue);
	}
	
	private static void mainMethod(QueueUsingStack queue){
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("1) enQueue");
		System.out.println("2) deQueue");
		System.out.println("3) Disply Array");
		System.out.println("4)Exit");
		System.out.println();
		System.out.print("Enter your Option - ");
		int option = scan.nextInt();
		
		switch(option)
		{
			case 1:
			{
				int data = isValidInput(scan);
				queue.enQueue(data);
				mainMethod(queue);
				break;
			}
			case 2:
			{
				int data = queue.deQueue();
				if(data == '*') System.out.println("Stack is Empty");
				else System.out.println("Removed data is -" + data);
				mainMethod(queue);
				break;
			}
			case 3:
			{
				queue.disply();
				mainMethod(queue);
				break;
			}
			case 4:
			{
				System.out.println("Program Stop");
				System.exit(0);
			}
			default :{
				System.out.println("Enter the Correct option");
				mainMethod(queue);
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
