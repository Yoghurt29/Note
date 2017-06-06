package com.java8;

public class Test24 {

	public Test24() {
		// TODO Auto-generated constructor stub
	}
	public int cacl(int n1,int n2){
		return n2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number={1,2,3,4};
		String[] method={"+","-","*","/"};
		int n1=0;
		int n2=0;
		int n3=0;
		int n4=0;
		String res="";
		for (int i=0;i<number.length;i++) {
			n1=number[i];
			for (int j=0;j<number.length;j++) {
				if(j==i)continue;
				n2=number[j];	
				for (int k=0;k<method.length;k++) {
					if(method[k]=="+"){
						res+="n"+i+"+n"+j;
						System.out.println(res);
						res="";
						
					}
					if(method[k]=="-"){
						res+="n"+i+"-n"+j;
						System.out.println(res);
						res="";
					}
					if(method[k]=="*"){
						res+="n"+i+"*n"+j;
						System.out.println(res);
						res="";
					}
					if(method[k]=="/"){
						res+="n"+i+"/n"+j;
						System.out.println(res);
						res="";
					}
				}
			}
		}
	}

}
