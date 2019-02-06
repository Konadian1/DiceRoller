
package diceroller;

import java.util.Scanner;

public class DiceRollerv2 {

    /* use case to determine dice type followed by number of dice, 
    then roll all the dice using math.random to determine numbers.
    
    NEXT STEP: allow multiple dice.
    
    This progam made by this weirdo named Kaitlynn~ <3
    */
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int num=0,type=0,total=0;
        String Dice;
        String Roll[];
        System.out.println("Dice roller!");
            System.out.println("Please enter the dice you would like to roll! ex 2d6 or 1d20. You can include multiple dice and modifiers : ");
            try{
                Dice = input.nextLine();
                Dice = Dice.replaceAll("\\s","");
                System.out.println("you roll: "+ Parse(Dice));
            } catch(ArithmeticException ex) {
                System.out.println("invalid dice type. Please enter the dice you would like to roll: ");
                Dice= input.nextLine();
                Dice = Dice.replaceAll("\\s","");
                Parse(Dice);
            }
    }
    
    
    
    
    
    public static int Parse(String toParse)throws ArithmeticException{
        if (toParse.length()<1){
            return 0;
        }
        else if(toParse.length()<6){
        try {
            int parsed = Integer.parseInt(toParse);
            return parsed;
        } catch (NumberFormatException e) {
            if(toParse.matches("[\\d]{1,3}d[\\d]{1,3}")){
                return Roller(toParse);
            }
        }
    }
        String sp[] = toParse.split("\\+", 2);
        String l = sp[0]; 
        String r = sp[1];
        return Parse(l)+Parse(r);
    }
    public static int Roller(String toParse)throws ArithmeticException{
        String nums[]= toParse.split("d");
        int typeDice= Integer.parseInt(nums[1]), numDice= Integer.parseInt(nums[0]);
        switch(typeDice){
                case 4:
                case 6:
                case 8:
                case 10:
                case 12:
                case 20:
                case 100:
                    break;
                default:
                    throw new ArithmeticException("invalid type");
            }
        int total=0;
        int num= numDice;
        while(num>0){
                    
            int temp = (int)Math.ceil(Math.random()*typeDice);
            total += temp;
            num--;   
    }
        System.out.println("your " + numDice+ " d"+typeDice+"'s rolled " +total);
        return total;
    }
}

/*function parse(expr) {
  var parsed = parseInt(expr);
  if(!isNaN(parsed)) { //Check if is a number
    return parsed;
  } else if(expr.match(X"d"Y)) { //Check if dice
    return roll(expr);
  }

  //Else is a '+' operation
  var sp = expr.split("+");
  var l = sp[0]; 
  var r = sp[1];
  return parse(l) + parse(r);
}

function roll(diceString) {
  return 1; //TODO: fix me!
}*/

