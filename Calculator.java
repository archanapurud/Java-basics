package javainternship;
import java.util.Scanner;

public class Calculator {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		char ch;
		do {
			try {
				System.out.println("\n=======Basic Calculator=======");
				System.out.println("1.Addidtion");
				System.out.println("2.Subtraction");
				System.out.println("3.Multiplication");
				System.out.println("4.Division");
				System.out.println("5.Square Root");
				System.out.println("6.Power");
				System.out.println("7.Exit");
				System.out.println("===============================");
				System.out.println("Enter Your Choice:");
				
				choice =sc.nextInt();
				double num1,num2,result;
				
				switch(choice){
				 
				 case 1:
					System.out.println("===============================");
					System.out.println("Enter two numbers:");
				    num1=sc.nextDouble();
				    num2=sc.nextDouble();
				    result=num1+num2;
				    System.out.println("Result="+result);
				    break;
				    
				  case 2:
					 System.out.println("===============================");
				    System.out.println("Enter two numbers:");
				    num1=sc.nextDouble();
				    num2=sc.nextDouble();
				    result=num1-num2;
				    System.out.println("Result="+result);
				    break;
				   case 3:
					   System.out.println("===============================");
					   System.out.println("Enter two numbers:");
				    num1=sc.nextDouble();
				    num2=sc.nextDouble();
				    result=num1*num2;
				    System.out.println("Result="+result);
				    break;
				   case 4:
					   System.out.println("===============================");
					 System.out.println("Enter two numbers:");
				    num1=sc.nextDouble();
				    num2=sc.nextDouble();
				    if(num2!=0) {
				    	result=num1/num2;
				    	System.out.println("Result="+result);
				    }else {
				    	System.out.println("Error:Division by Zero not allowed!");
				    }
				    break;
				    
				    case 5:
				    	System.out.println("===============================");
				    	System.out.println("Enter a number:");
				    	num1=sc.nextDouble();
				    	if(num1>=0){
				    		System.out.println("Square root ="+Math.sqrt(num1));
				    	}
				    		else {
				    			System.out.println("Error:Negative number!");
				    		}
				    	break;
				    case 6:
				    	System.out.println("===============================");
				    	System.out.println("Enter base and Exponent:");
				    	num1=sc.nextDouble();
				    	num2=sc.nextDouble();
				    	System.out.println("Power="+Math.pow(num1, num2));
				    	break;
				    case 7:
				    	System.out.println("===============================");
				    	System.out.println("Exiting Calculator...");
				    	return;
				    default:
				    	System.out.println("Invalid Choice");
				}
			}catch(Exception e) {
				System.out.println("Invalid input!Please enter numbers only.");
				sc.nextLine();
			}
			
			System.out.println("\nDo You Want to Continue?(y/n):");
			ch=sc.next().charAt(0);
		}while(ch=='y'|| ch=='Y');
		
		sc.close();
				    	
				    
				    
				    
				    
				}    
				    
				
				
				
				
				
				
				
			
		}
				
	
