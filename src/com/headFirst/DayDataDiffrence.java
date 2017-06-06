package com.headFirst;

import java.util.Date;
import java.util.Observable;
//這個被觀察對象如何設計?
//方法,計算差異並change
public class DayDataDiffrence extends Observable {
	private int diffrence=100;
	public DayDataDiffrence() {
		// TODO Auto-generated constructor stub
	}
	public void checkDiffrence(){
		this.setChanged();
		this.notifyObservers(new Integer(diffrence));
	}
}
