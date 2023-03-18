package org.example.Data;

public class IntermediateQuery extends Query{

    public IntermediateQuery(int year, int number) {
        super(year);
        this.number = number;
    }
    private int number;

    @Override
    public int getNumber(){
        return number;
    }
}
