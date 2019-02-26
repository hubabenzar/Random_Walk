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
public class DonCockroach extends Cockroach{//extends Cockroach.java
	//sets minimum positions
	public DonCockroach(){
		setPos(1);
		setMaxPos(1);
	}
	public void takeStep(){//extends the abstract class from Cockroach.java
		int currPos = getPos();
		//Random Number Generator of 1-1000 which is the 0.01% chance of Don falling
		int fallDie = 1 + (int)(1000 * Math.random());
		//if it's 1 Don goes back to floor 1
		if (fallDie == 1){
			currPos = 1;
		}
		else{
			//Random Number Generator of 1-6 which is how many sides a normal dice has
			int dice = 1 + (int)(6 * Math.random());
			//If the RNG lands on 1 or 2 it goes down a position
			if (dice <= 2){
				currPos = currPos - 1;
				//If the current position is lower or equal to 1 the position gets set to 1
				if (currPos <= 1){
					currPos = 1;
				}
			}
			//If the RNG lands on 6 it Re-Rolls the dice and moves up the number it rolls.
			else if (dice == 6){
				int reRoll = 1 + (int)(6 * Math.random());
				currPos = currPos + reRoll;
				//If the current position is higher or equal to 102 the position gets set to 102
				if (currPos >= 102){
					currPos = 102;
				}
			}
			//Otherwise if RNG lands on 3, 4, 5 it moves up 1 floor
			else {
				currPos = currPos + 1;
				//If the current position is higher or equal to 102 the position gets set to 102
				if (currPos >= 102){
					currPos = 102;
				}
			}
		}
		//we swap setPos from 1 to the current floor the Cockroach is on.
		setPos(currPos);
		//We then calculate what the highest position was.
		int currMaxPos = getMaxPos();
		if (currPos > currMaxPos){
			currMaxPos = currPos;
			setMaxPos(currMaxPos);
		}
	}
}