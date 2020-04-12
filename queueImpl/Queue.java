//$Id$
package com.alex.queue;

import com.alex.linkedList.LinkedList;

public class Queue implements QueueInterface{
	private LinkedList list = new LinkedList();
	
	@Override
	public void enQueue(int data){
		list.pushDataAtBack(data);
	}
	
	@Override
	public int deQueue(){
		return list.popDataAtFront();
	}
	
	@Override
	public void disply(){
		list.displyData();
	}
	
	public int peek(){
		return list.peek();
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}
}


