package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Controller;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main view = new Main();

		int option = 0;
		do{
		view.menu();
		option = view.validateIntegerInput();
		view. executeoption(option);
		}while(option !=0);

		view.reader.close();		

	}

	// Incomplete
	public void menu() {
		System.out.println("1.RegisterProject");
		System.out.println("2. searchProjectsAfterDate");
		System.out.println("3. searchProjectsBeforeDate");
		System.out.println("0. Exit");

	}

	public void executeoption(int option){
		switch(option){
			case 1:
			RegisterProject();
			break;

			case 2:
			searchProjectsAfterDate();
			break;

			case 3:
			searchProjectsBeforeDate();
			break;

			case 0:
			System.out.println("exit");
			break;

			case -1:
			System.out.println("invalit option!!");
        	break;


		}
	}

	public int validateIntegerInput(){
       int option = 0;
        if (reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
            System.out.println("Ingrese el valor entero:");
        }
        return option;
    }

	//Incomplete
	public void RegisterProject() {

		String name;
		String clientName;
		Calendar initialDate;
		Calendar finalDate;
		double budget;
		int month;

		System.out.println("Type the project name: ");
		name = reader.next();
		System.out.println("Type the costomer name: ");
		clientName = reader.next();

		initialDate = Calendar.getInstance();
		String timeStamp = new simpleDateFormat("dd/MM/yyyy").format(initialDate.getTime());
		System.out.println("The start Date is: "+timeStamp);

		System.out.println("type in months how long the project will last  ");
		month = reader.nextInt();
		finalDate = Calendar.getInstance();
		finalDate.add(Calendar.MONTH,month);
		String timeStamp2 = new simpleDateFormat("dd/MM/yyyy").format(finalDate.getTime());
		System.out.println("The start Date is: "+timeStamp2);

		System.out.println("type the project budget");
		budget = reader.nextDouble();

		controller.RegisterProject(name,clientName,initialDate,finalDate,budget);
		

	}

	//Incomplete
	public void searchProjectsAfterDate() {

		String nameProject;

		System.out.println("Type the project name: ");
		nameProject = reader.next();

		controller.searchProjectsAfterDate(nameProject);

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

		String nameProject;

		System.out.println("Type the project name: ");
		nameProject = reader.next();

		controller.searchProjectsBeforeDate(nameProject);
	}
}
