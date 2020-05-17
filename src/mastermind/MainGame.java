package mastermind;

import java.util.Scanner;

public class MainGame {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        Table table;
        System.out.println("Whould you like to play a game? Y/N");

        for (;;){

            try {

                String choice = in.next();
                in.nextLine();
                switch (choice){
                    case "Y": case"y":{

                        table = new Table();

                        while (!table.gameOver){
                            System.out.println("Try your guess: ");
                            try {
                            String row = in.nextLine();
                            String[] rowSymbols = row.split(" ");
                            Row guess = new Row(rowSymbols);

                            System.out.println(table.isMatch(guess));
                            } catch (RowException e) {
                                System.out.print("Row length wrong");
                                continue;
                            }catch (Exception e) {
                                System.out.print("Your input is wrong.");
                                continue;
                            }
                        }
                        System.out.println("Play again? Y/N");
                        continue;


                    } case "N": case "n":{
                        System.out.print("See you some other time.");
                        in.close();
                        System.exit(1);
                    }
                }
            } catch (Exception exc ){
                System.out.print("Your input is wrong.");

            } finally {

                continue;
            }
        }
    }
}
