//$Id$
package com.alex.mainQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.alex.linkedList.LinkedList;
import com.alex.queue.Queue;
import com.alex.queueUsingStack.QueueUsingStack;

public class MainQueue {
		
		private static Scanner scan = new Scanner(System.in);
		private static Queue queue = new Queue();
		public static void main(String[] args) {
			mainMethod();
		}
		
		private static void mainMethod(){
			System.out.println();
			System.out.println("1) enQueue");
			System.out.println("2) deQueue");
			System.out.println("3) Disply Array");
			System.out.println("3) Exit");
			System.out.println();
			System.out.print("Enter your Option - ");
			int option = scan.nextInt();
			
			switch(option)
			{
				case 1:
				{
					int data = isValidInput();
					queue.enQueue(data);
					mainMethod();
					break;
				}
				case 2:
				{
					int data = queue.deQueue();
					if(data == '*') System.out.println("Stack is Empty");
					else System.out.println("Removed data is -" + data);
					mainMethod();
					break;
				}
				case 3:
				{
					queue.disply();
					mainMethod();
					break;
				}
				case 4:
				{
					System.out.println("Program stop");
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
