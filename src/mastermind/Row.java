package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private int numSymbols;
    protected List<Symbol> row;

    public Row() {
        this.numSymbols = 4;
        row = new ArrayList<>(numSymbols);
    }
    public Row(String[] row){
        this.numSymbols = row.length;
        this.row = new ArrayList<>(numSymbols);
        for (int i=0; i<row.length; i++){
            this.addSymbol(Symbol.valueOf(row[i]));
        }

    }
    public boolean addSymbol(Symbol symbol){
        if (row.size() < numSymbols){
            row.add(symbol);
            return true;
        }
        return false;
    }

    public int size(){
        return row.size();
    }

    public Symbol getSymbol(int i){
        return row.get(i);
    }

    public boolean contains(Symbol s){
        return row.contains(s);
    }

    public int getNumSymbols() {
        return numSymbols;
    }

    @Override
    public String toString() {
        return "" + row;
    }
}
