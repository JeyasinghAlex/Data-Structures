//$Id$
package com.alex.stackUsingQueue;

import com.alex.queue.Queue;
import com.alex.stack.StackInterface;

public class StackUsingQueue implements StackInterface {
	
	private Queue qu1 = new Queue();
	private Queue qu2 = new Queue();
	
	public void push(int data){
		qu2.enQueue(data);
		while(!qu1.isEmpty())
			qu2.enQueue(qu1.deQueue());
		
		//Swap :
		Queue tempQu = qu1;
		qu1 = qu2;
		qu2 = tempQu;
	}
	
	public int pop(){
		return qu1.deQueue();
	}
	
	public int peek(){
		return qu1.peek();
	}
	
	public void disply(){
		qu1.disply();
	}
}
