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
public class BellaCockroach extends Cockroach{//extends Cockroach.java
	//sets minimum positions
	public BellaCockroach(){
		setPos(1);
		setMaxPos(1);
	}
	public void takeStep(){//extends the abstract class from Cockroach.java
		//Setting variables. Booleans and integers as well as the Random Number Generator
		boolean pos_86 = false;
		int currPos = getPos();
		int prevPos = currPos;
		int dice = 1 + (int)(6 * Math.random());
		
		//If Bella is on floor 86 she pauses on it
		if (!(pos_86 == false)) {
			pos_86 = false;
		}
		//Otherwise
		else{
			//if RNG is 1,2,3 it goes down -1 floors from her current position
			//Also check if it is at least floor 1
			if(dice <= 3) {
				if(currPos - 1 <= 1 ) {
					currPos = 1;
				}
				else{
					currPos = currPos - 1;
				}
			}
			//if RNG lands on 4 it moves up 2 floors it checks if its on floor 102 it doesnt change
			else if(dice == 4) {
				if(currPos + 2 >= 102) {
					currPos = 102;
				}
				else{
					currPos = currPos + 2;
				}
			}
			//if RNG lands on 5 it moves up 3 floors it also checks if its on floor 102 it doesnt change
			else if(dice == 5) {
				if(currPos + 3 >= 102) {
					currPos = 102;
				}
				else{
					currPos = currPos + 3;
				}
			}
			//If she her current position or if her current position is maller 
			//than 86 and her previous position is higher than 86
			//or if current position is higher than 86 and her previous position is lower than 86
			//she stops on floor 86 and waits a round
			else if(currPos == 86 || (currPos < 86 && prevPos > 86) || (currPos > 86 && prevPos < 86)) {
				pos_86 = true;
				currPos = 86;
			}
			//Otherwise she doesn't move
			else{
				currPos = currPos;
			}
		}
		//we swap setPos from 1 to the current floor the Cockroach is on.
		setPos(currPos);
		//We then calculate what the highest position was.
		int curMaxPos = getMaxPos();
		if (currPos > curMaxPos) {
			curMaxPos = currPos;
			setMaxPos(curMaxPos);
		}
	}
}