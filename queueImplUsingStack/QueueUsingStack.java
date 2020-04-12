//$Id$
package com.alex.queueUsingStack;

import com.alex.queue.QueueInterface;
import com.alex.stack.Stack;

public class QueueUsingStack implements QueueInterface {
	private Stack st1 = new Stack();
	private Stack st2 = new Stack();
	
	public void enQueue(int data){
		while (!st1.isEmpty())
			st2.push(st1.pop());
		st1.push(data);
		while (!st2.isEmpty())
			st1.push(st2.pop());
	}
	
	public int deQueue(){
		 return st1.pop();
	}
	
	public boolean isEmpty(){
		return st1.isEmpty();
	}
	
	public void disply(){
		st1.disply();
	}
}
