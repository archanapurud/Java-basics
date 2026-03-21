package javainternship;
import java.util.ArrayList;
import java.util.Scanner;

//Class to store contact details
class Contact{
	String name;
	String phone;
	String email;
	
	//Constructor to initialize contact
	Contact(String name,String phone,String email){
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
}


public class ContactManager {
	public static void main(String []args) {
		
		//Scanner for user input
		Scanner sc= new Scanner(System.in);
		
		//List to store contacts
		ArrayList<Contact>contacts=new ArrayList<>();
		
		int choice;
		
		do {
			//Menu Options
			System.out.println("\n------Contact Management------");
			System.out.println("1.Add Contact");
			System.out.println("2.View Contact");
			System.out.println("3.Update Contact");
			System.out.println("4.Delet Contact");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice:");
			
			choice=sc.nextInt();
			sc.nextLine();//clear buffer
			
			switch(choice) {
			
			//Add new contact
			case 1:
				System.out.println("Enter Name:");
				String name=sc.nextLine();
				
				System.out.println("Enter phone:");
				String phone=sc.nextLine();
				
				System.out.println("Enter Email:");
				String email=sc.nextLine();
				
				if(email.isEmpty()) {
					email="No Email";
				}
				
				contacts.add(new Contact(name,phone,email));
				System.out.println("Contact added successfully!");
				break;
				
				
			case 2:
				if(contacts.isEmpty()) {
					System.out.println("No contacts found.");
				}
				else {
					for(int i=0;i<contacts.size();i++) {
						Contact c =contacts.get(i);
						System.out.println((i+1)+"."+c.name+"|"+c.phone+"|"+c.email);
						
					}
				}
				break;
				
			case 3:
				System.out.println("Enter contact number to update:");
				int updateindex=sc.nextInt()-1;
				sc.nextLine();
				
				if(updateindex>=0 && updateindex<contacts.size()) {
				  System.out.println("Enter new Name:");
				  contacts.get(updateindex).name=sc.nextLine();
				  
				  System.out.println("Enter new Phone:");
				  contacts.get(updateindex).phone=sc.nextLine();
				  
				  System.out.println("Enter new Email:");
				  contacts.get(updateindex).email=sc.nextLine();
				  
				  System.out.println("Contact Updated!");
				  

				}
				else {
					System.out.println("Invalid contact Number.");
				}
				break;
				
			case 4:
				System.out.println("Enter contact number to delet:");
				int deletindex=sc.nextInt()-1;
				
				if(deletindex>=0 && deletindex<contacts.size()) {
					contacts.remove(deletindex);
					System.out.println("Contact deleted!");
				}
				else {
					System.out.println("Invalid contact number.");
				}
				break;
				
			case 5:
				System.out.println("Exiting...");
				break;
				
			default:
				System.out.println("Invalid choice.");
			}
		}while(choice !=5);
		sc.close();
		



			
		}
	}


