//$Id$
package com.alex.stack;
import com.alex.linkedList.LinkedList;

public class Stack implements StackInterface{
	private LinkedList list = new LinkedList();
	
	@Override
	public void push(int data){
		list.pushDataAtFront(data);
	}
	
	@Override
	public int pop(){
		return list.popDataAtFront();
	}
	
	@Override
	public void disply(){
		list.displyData();
	}

	@Override
	public int peek() {
		return list.peek();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
}
