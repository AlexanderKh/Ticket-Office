package alex;


import java.util.Date;
import java.util.Random;

public class Flight implements Comparable{
    public static final String NEW_LINE = "\n";
    private int id;
    private City destination;
    private Date date;
    private Row[] rows;
    private int maxRows;
    private int maxSeatsInRow;

    Flight(City destination, Date date, int maxRows, int maxSeatsInRow){
        this.maxSeatsInRow = maxSeatsInRow;
        this.maxRows = maxRows;
        this.destination = destination;
        this.date = date;
        this.rows = new Row[maxRows];
        for (int i = 0; i < maxRows; i++) {
            rows[i] = new Row(this, i + 1);
        }
    }


    public boolean hasFreeSeatsInRow(int numberOfPassengers){
        boolean result = false;
        for (Row row : rows){
            result = row.hasFreeSeatsInRow(numberOfPassengers);
        }
        return result;
    }


    public int compareTo(Object o) {
        if (o instanceof Flight){
            return this.date.compareTo(((Flight) o).date);
        }else {
            throw new ClassCastException();
        }
    }

    public int getMaxSeatsInRow() {
        return maxSeatsInRow;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public Row[] getRows() {
        return rows;
    }

    public Row getRow(int rowNumber) {
        return rows[rowNumber - 1];
    }

    public String toString(){
        String result = "Destination: ";
        result += destination.toString() + NEW_LINE;
        result += "Date: ";
        result += date.toString() + NEW_LINE;
        result += "Rows" + NEW_LINE;
        for (Row row : rows){
            result += row.toString() + NEW_LINE;
        }
        result += NEW_LINE;
        return result;
    }
}
