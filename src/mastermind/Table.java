package mastermind;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Table {
    private Row secretRow;
    final private int numOfRows;

    private int numGuess = 0;
    protected boolean gameOver = false;

    public Table() {
        numOfRows = 6;
        this.secretRow = new Row();
        addSecretRow();
    }

    private void addSecretRow() {
        Random random = new Random();
        for (int i =0; i < secretRow.getNumSymbols(); i++){
            int index = random.nextInt(6);
            secretRow.addSymbol((Symbol.values())[index]);

        }
    }

    public String isMatch(Row row) throws RowException {

        numGuess++;

        int numPositionMatch = 0;
        int numSymbolMatch = 0;

        if (row.size() != secretRow.size()){
            throw new RowException("Bad size of row entered.");
        }

        int len = secretRow.size();
        Set<Integer> checked = new HashSet<>();
        for (int i=0; i<len; i++){
            Symbol symbolChecking = row.getSymbol(i);
            if (secretRow.contains(symbolChecking)){
                if (symbolChecking.equals(secretRow.getSymbol(i))) {
                    numPositionMatch++;
                    checked.add(i);
                }

                else {
                    for (int j=0; j<len; j++){
                        if (i == j)
                            continue;
                        if (symbolChecking.equals(secretRow.getSymbol(j)) && !checked.contains(j) && !row.getSymbol(j).equals(secretRow.getSymbol(j))){
                            numSymbolMatch++;
                            checked.add(j);
                        }
                    }
                }

            }

        }

        if (this.numGuess >= this.numOfRows){
            gameOver = true;
            if (numPositionMatch == secretRow.size() && numSymbolMatch==0){
                return "Congratulations. You won!";
            }
            return "Position match: "+numPositionMatch+ "\nSymbols match: "+numSymbolMatch +
                    "\nThis was your last chance. You lost. Secret row is: "+this.secretRow;

        }

        if (numPositionMatch == secretRow.size() && numSymbolMatch==0){
            gameOver = true;
            return "Congratulations. You won!";
        }
        return "Position match: "+numPositionMatch+"\nSymbols match: "+numSymbolMatch;
    }

}


