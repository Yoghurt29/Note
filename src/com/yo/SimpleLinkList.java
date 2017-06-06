package com.yo;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class SimpleLinkList {
	Node head;
	Node current;
	int size=0;
	class Node{
		Object data;
		Node next;
		public Node(Object data){
			this.data=data;
		}
	}
	public SimpleLinkList() {

	}
	public void add(Object data){
		if(head==null){
			head=new Node(data);
			current=head;
		}else{
			current.next=new Node(data);
			current=current.next;
		}
		size++;
	}
	public Object get(int index) throws Exception{
		if(index>size)throw new Exception("索引越界");
		int i=0;
		current=head;
		while(i<index){
			current=current.next;
			i++;
		}
		return current.data;
		
	}
	public boolean remove(int index) throws Exception{
		if(index>size)throw new Exception("索引越界");
		if(index==0){
			head=head.next;
			size-=1;
			return true;
		}
		int i=0;
		current=head;
		while(i!=index-1){
			current=current.next;
			i++;
		}
		current.next=current.next.next;
		size-=1;
		return true;
	}
	
	@Override
	public String toString() {
		String toString="SimpleLinkList [";
		int i=0;
		current=head;
		while(i<size){
			if(current.data instanceof String){
				String data=(String) current.data;
				toString+=data.toString();
			}else{
				toString+=current.data.toString();
			}
			toString+=",";
			current=current.next;
			i++;
		}
		toString+="]";
		return toString;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SimpleLinkList list=new SimpleLinkList();
		list.add("hello");
		list.add("word");
		list.add("java");
		list.add("!");
		System.out.println(list.toString());
		list.remove(1);
		System.out.println(list.toString());
	}

}
