/*
Course:			COMP 124
Lecturer:		DR Russel Martin
Title:			Assignment 3 - Cockroach
Name: 			Huba Ferenc Benzar
Student ID:		201262833
Email:			H.Benzar@student.Liverpool.ac.uk
Deadline: 		27/04/2018 - 1700
*/
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