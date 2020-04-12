//$Id$
package com.alex.linkedList;

public class LinkedList {
	private Node tailNode;
    private Node headNode;
    private  int listSize = 0;
    public void pushDataAtBack(int data){
        Node node = new Node(data);
        if(tailNode == null){
            tailNode = node;
            headNode = node;
        }else{
            tailNode.next = node;
            tailNode = tailNode.next;
        }
        listSize++;
    }

    public void pushDataAtFront(int data){
        Node node = new Node(data);	
        if(tailNode == null){
            tailNode = node;
            headNode = node;
        }else{
            node.next = headNode;
            headNode = node;
        }
        listSize++;
    }

    public int popDataAtBack(){
        //If Array is Empty, If Condition Execute;
        if(headNode == null){
            return '*';
        }
        Node[] nodeArray = intarateLinkedList();
        Node previousNode = nodeArray[0];
        Node currentNode = nodeArray[1];
        int removeData = currentNode.data;
        //If Array is Contain Only One Data, If Condition Execute otherwise  else Condition Execute :
        if(previousNode == null){
            headNode = null;
            tailNode = null;
        }else{
            tailNode = previousNode;
            previousNode.next = null;
        }
        listSize--;
        return removeData;
    }

    public int popDataAtFront(){
        //If Array is Empty, If Condition Execute :
        if(headNode == null){
            return  '*';
        }
        int data = headNode.data;
        headNode = headNode.next;
        //If Array is Contain Only One Data, If Condition Execute otherwise  else Condition Execute :
        if(headNode == null){
            tailNode = null;
        }
        return data;
    }

    private Node[] intarateLinkedList(){
        Node[] nodeArray = new Node[2];
        int currentNodeIndex = 0;
        Node currentNode = headNode;
        Node previousNode = null;
        while(currentNode.next != null && currentNodeIndex < listSize - 1){
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentNodeIndex++;
        }
        nodeArray[0] = previousNode;
        nodeArray[1] = currentNode;
        return nodeArray;
    }
    
    public boolean isEmpty(){
    	if(headNode == null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public int peek(){
    	 if(headNode != null)
    		 	return headNode.data;
    	 else return '*';
    }
    
    public void displyData(){
    	Node currentNode = headNode;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
	
	/** insert node nth position */
	public void insertNthPosition(Node currentNode, int data, int position) {
	    Node newNode = new Node(data);
            newNode.data = data;
//  	    Node current = head;  

	    if( position == 0 ){
		newNode.next = currentNode;
// 		return newNode;
	    }

	    int counter = 0;
	    while( ++counter < position ){
		current = currentNode.next;
	    }

	    newNode.next = currentNode.next;   
	    currentNode.next = newNode;   
// 	    return head;
	}
	
	/** delete node nth position */
	Node Delete(Node head, int position) {
	    Node temp=head;
	    int pos=1;
	    if(position==0)
		return head.next;
	    while(pos<position)
	    {
		head=head.next;
		pos++;    
	    }
	    head.next=head.next.next;
	    return temp;
	}
}
