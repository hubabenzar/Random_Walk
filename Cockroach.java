//Huba Ferenc Benzar

import java.util.*;
abstract class Cockroach {
	//Creating protected variables. String and Int
	protected String cockroachName;
	protected int cockroachPos;
	protected int maxPos;
	
	//Methods to show what a cockroach does in a single step.
	public abstract void takeStep();
		//Gets current cockroach position
	public int getPos(){
		return cockroachPos;
	}
	public void setPos(int pos){
		cockroachPos = pos;
	}
		//Gets maximum cockroach position
	public int getMaxPos(){
		return maxPos;
	}
	public void setMaxPos(int pos){
		maxPos = pos;
	}
}
