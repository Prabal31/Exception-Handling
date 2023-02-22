package manchapr;
/**
 *
 * @author manch
 */
import java.util.*;
public class Main_Inve {  //creating class name "Main_inve

    public static void main(String [] args) throws Exception{    //main 
        
        Scanner in=new Scanner(System.in);      //scanner object
        
        //creating string, integer and double variable
        String id;    
        String name;
        int qoh;
        int rop;
        double SellPrice;
        int c;
        
        //Asiking the user to input the right id in the form of abc-1234
        while(true) {
            c=0;
            char ch='-';
            try {    //try block
                System.out.println("Enter Inventory Item ID:");
                id=in.nextLine();
                if(id.length()==8) {
                    
                    //checking if the first 3 character of the id string is a alphabetic
                    for(int i=0;i<3;i++) {    
                        if(Character.isAlphabetic(id.charAt(i))) {
                            c=c+1;
                        }
                    }
                    
                    //checking if the 3 index of the id string is a '-'
                    if(id.charAt(3)==ch) {
                        c=c+1;
                        }
                    
                    //checking if the last 4 character of the id string is a digit
                    for(int j=4;j<id.length();j++) {
                        if(Character.isDigit(id.charAt(j))) {
                            c=c+1; 
                        }  
                    }
                    
                    //checking if the length is equal or not equal to 8
                    if(c!=8) {  
                        throw new Exception();   //throw an exception if the enter data is not correct
                    }
                    else {
                        //if the input string is correct break for the loop
                        break;
                    }
                }
                else {
                    throw new Exception();
                } 
            }      //end of try block
            
            catch(Exception e) {        //catch block
                System.out.println("Error: Inventory ID must be in the form ABC-1234");
            }   //end of catch block
        }   //end of while loop
        
        //asking user to input a valin name of the item
        while(true) {
            c=0;
            try {     //try block 
                System.out.println("Enter Item Name:");
                name=in.nextLine();
                
                //checking if the value is an alphabetic
                for(int i=0;i<name.length();i++) {
                    if(Character.isAlphabetic(name.charAt(i))) {
                        c=c+1;   
                    }
                }
                //checking if the user input the right value
                if(c!=name.length()||name.length()==0) {  
                    throw new Exception(); //throw an exception the the input is invaluid 
                }
                else {
                    break;  
                }
            }     //end of try block
            
            catch (Exception e) {  //catch block
                System.out.println("Error: you must enter an item name.");
                }   //end of catch block
            }  //end of while loop
        
        //asking user to input the Quantity on hand 
        while (true) {
            try {       //try block
                
                //Checking if the user input the right data'Integer'
                System.out.println("Qty On Hand: ");
                qoh = Integer.parseInt(in.nextLine());
                
                //checking if the data entered is greater then or equyal to zero
                if(qoh>=0) {
                    break;
                }
                else {
                    //throw an exception if the input is invalid
                    throw new Exception();
                }
            }   //end of try block
            
            catch (Exception e) {   //catch block
                System.out.println("Error: QOH must be 0 or more");
            }   //end of catch block
        }  //end of while loop
        
        //Asking user to input valid re order points
        while(true) {
            try {   //try block
                
                //Checking if the user entered a valid data 
                System.out.println("Re-Order Point:");
                rop = Integer.parseInt(in.nextLine());
                
                //checking if the data entered is greater then or equal to zero
                if(rop>=0) {
                    break;
                }
                else {
                    //throw an exception the data entered is invalid
                    throw new Exception();
                }
            }    //end of try block
            catch (Exception e) {   //catch block
                System.out.println("Error: rop must be 0 or more.");
            }   //end of catch block
        }   //end of while loop
        
        //Asking user to input the selling price of the product in double
        while(true) {
            try {    //try block
                
                //checking if the data entered is in double
                System.out.println("Selling Price:");
                SellPrice = Double.parseDouble(in.nextLine());
                
                //checking id the data entered is greater then zero
                if(SellPrice>0) {
                    break;
                }
                else {
                    throw new Exception();
                }
            }    //end of try block
            
            catch (Exception e) {     //catch block
                System.out.println("Error: Selling price must be greater than 0");
            }   //end of catch block
        }       //end of while loop
        
        
        //Creating a Inventory object 'In' and sent the value of all the above varible to a Inverntory constructory
        Inventory In=new Inventory(id, name, qoh, rop,SellPrice);
        
        //printing and calling the to string function in the Inverntory class
        System.out.println(In.toString());
        
        //checking if the quantity on hand is less than re order points
        if(In.getQoh()<In.getRop()) {
            System.out.println("You need to order more "+In.getName()+", "+In.getRop()+"kg");
        }
        
        int unit;///creating a integer variable classed 'unit'
        while(true) {          
            try {     //try block
                
                //checking if the user entered right data 
                System.out.println("Enter # of units to buy: ");
                unit=Integer.parseInt(in.nextLine());
                
                //checking if the unit varibale is slmaller then zero
                if(unit<0) {
                    System.out.println("Total Cost: $0.00");
                    break;
                }
                
                //if the unit variable is greater then zero than calculating the total price after tax
                else {     
                    double amt=unit*In.getSellPrice();
                    double totalamt=Math.round(((amt*13)/100)+amt*100)/100.0;
                    
                    //printing the total cost in two decimal places
                    System.out.println("Total Cost: $"+totalamt);
                    break;
                }
            }  //end of try block
            catch (NumberFormatException e) {     //catch block
                System.out.println("Sorry, the value is not a valid number");
            }     //end of catch block
        }         //end of while loop
    }             //mains end
}          //end of class
