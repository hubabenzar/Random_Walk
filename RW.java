/*
Course:			COMP 124
Lecturer:		DR Russel Martin
Title:			Assignment 3 - Cockroach
Name: 			Huba Ferenc Benzar
Student ID:		201262833
Email:			H.Benzar@student.Liverpool.ac.uk
Deadline: 		27/04/2018 - 1700
*/
public class RW{
	//Main method that prints out the outcomes
	public static void main(String[] args){
		MaxPosAvrg();
		AvrgStep();
		Co_Occurences();
	}

	//3A
	public static void MaxPosAvrg() {
		//Sets flexible values for the number of experiments and steps.
		int experiment = 2000;
		int steps = 100;
		
		//Don variables
		double donTotal = 0.00;
		int donMaxPos = 0;
		
		//Bella variables
		double bellaTotal = 0.00;
		int bellaMaxPos = 0;
		
		//Loops the number of times we want to do the experiment
		for (int i = 0; i < experiment; i++){
			//defining the cockroaches
			DonCockroach don = new DonCockroach();
			BellaCockroach bella = new BellaCockroach();
			//Loops the number of times we want to step through the experiment
			//and execute the java files for each cockroach
			for (int j = 0; j < steps; j++) {
				don.takeStep();
				bella.takeStep();
			}
			//Don - Max position gets set then added to a total each experiment
			donMaxPos = don.getMaxPos();
			donTotal += donMaxPos;
			//Bella - Max position gets set then added to a total each experiment
			bellaMaxPos = bella.getMaxPos();
			bellaTotal += bellaMaxPos;
		}
		//Don - Message printed out with calculation done inside it for the average
		System.out.println("\n---------------\nDon\n---------------");
		System.out.println("The max average height achieved is: " + (donTotal/experiment) + " - In "+experiment+" experiments and walking "+steps+" steps.");
		//Bella - Message printed out with calculation done inside it for the average
		System.out.println("---------------\nBella\n---------------");
		System.out.println("The max average height achieved is: " + (bellaTotal/experiment) + " - In "+experiment+" experiments and walking "+steps+" steps.\n");
	}
	
	//3B
	public static void AvrgStep() {
		//Sets flexible values for the number of experiments
		int experiment = 2000;
		
		//Don variables
		double donStep = 0.00;
		double donTotalStep = 0.00;
		
		//Bella variables
		double bellaStep = 0.00;
		double bellaTotalStep = 0.00;
		//Maximum number of floors in the Empire State Building
		int maxFloor = 102;
		
		//Loops the number of times we want to do the experiment
		for (int i = 0; i < experiment; i++) {
			//defining the cockroaches
			DonCockroach don = new DonCockroach();
			BellaCockroach bella = new BellaCockroach();
			//Don and Bella step gets set to 0 each experiment
			donStep = 0.00;
			bellaStep = 0.00;
				//Don - gets a step added and it executes the java files for each cockroach
				//While position of Don is not 102
				do{ don.takeStep();
					donStep++;
				} while(don.getPos() != maxFloor);
				//Bella - gets a step added and it executes the java files for each cockroach
				//While position of Bella is not 102
				do{ bella.takeStep();
					bellaStep++;
				} while(bella.getPos() != maxFloor);
			//Don and Bella gets the number of steps added to a total
			donTotalStep += donStep;
			bellaTotalStep += bellaStep;
		}
		//Don - Message printed out with calculation done inside it for the average
		System.out.println("---------------\nDon\n---------------");
		System.out.println("The average number of steps is: " + (donTotalStep/experiment) + " - In "+experiment+" experiments, walking a total of " + donTotalStep + "steps.");		
		//Bella - Message printed out with calculation done inside it for the average
		System.out.println("---------------\nBella\n---------------");
		System.out.println("The average number of steps is: " + (bellaTotalStep/experiment) + " - In "+experiment+" experiments, walking a total of " + bellaTotalStep + "steps.\n");		
	}
	
	//3C
	public static void Co_Occurences(){
		//Sets flexible values for the number of experiments
		int experiment = 2000;
		
		//Sets the total count of encounters to 0
		double totalEncounter = 0.00;
		
		//Loops the number of times we want to do the experiment
		for(int i = 0; i < experiment; i++){
			//Encounter gets set to 1 as they start on the same floor
			double encounter = 1.00;
			//defining the cockroaches
			DonCockroach don = new DonCockroach();
			BellaCockroach bella = new BellaCockroach();
			//Loops the number of times we want to step through the experiment
			//and execute the java files for each cockroach
			for(int j = 0; j < experiment; j++){
				don.takeStep();
				bella.takeStep();
				//if don and bella meet encounter increments
				if(don.getPos() == bella.getPos()){
					encounter++;
				}
			}
			//encounter gets added to a total
			totalEncounter = totalEncounter + encounter;			
		}
		//Don and Bella - Message printed out with calculation done inside it for the average
		System.out.println("---------------\nCo-Occurences\n---------------");
		System.out.println("The average number of Co-Occurences is: " + (totalEncounter/experiment) + ". They met of "+ totalEncounter +", in "+experiment+" experiments.\n");
	}
}