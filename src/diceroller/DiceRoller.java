
package diceroller;

import java.util.Scanner;

public class DiceRoller {

    /* use case to determine dice type followed by number of dice, loop until "no more" is entered
    then roll all the dice using math.random to determine numbers.
    
    NEXT STEP: allow multiple dice.
    
    This progam made by this weirdo named Kaitlynn~ <3
    */
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int num=0,type=0,total=0, bonus=0, e=0;
        Boolean Val= false;
        String Dice;
        String NumOfRoll[];
        String TypeOfRoll[];
        String Nums[];
        System.out.println("Dice roller!");
        do{
            System.out.println("Please enter the dice you would like to roll! ex 2d6 or 1d20. You can enter 'no more' to end : ");
            Dice = input.nextLine();
            while(Val==false){
                if (Dice.matches("[\\d]{1,3}d[\\d]{1,3}")){
                    Val=true;
                }
                
                else{
                    System.out.println("Please enter a valid choice! ex: 4d4 or 2d100 or 'no more' to end: ");
                    Val=false;
                    Dice = input.nextLine();
                }
            }
            
            
            Val=false;                
            Nums= Dice.split("d");
            num=Integer.parseInt(Nums[0]);
            type=Integer.parseInt(Nums[1]);
            
            switch(type){
                case 4:
                case 6:
                case 8:
                case 10:
                case 12:
                case 20:
                case 100:
                    Val=true;
                    break;
                default:
                    Val=false;
                    break;
            } 
        }while (Val==false);
        
        System.out.println("would you like to add any modifiers for your roll? Enter 0 for none:");
        bonus= input.nextInt();
        
        
    int temp = 0;
    while(num>0){
    temp = (int)Math.ceil(Math.random()*type);
    total += temp;
    System.out.print(temp + " ");
    num--;   
    }
    int totalb= total+bonus;
    System.out.println(": " + totalb);
    }
}
