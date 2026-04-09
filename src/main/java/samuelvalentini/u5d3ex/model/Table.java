package samuelvalentini.u5d3ex.model;

public class Table {
    private final int tableNumber;
    private final int maximumNumberOfSeats;
    private boolean isOccupied;

    public Table(int tableNumber, int maximumNumberOfSeats) {
        this.tableNumber = tableNumber;
        this.maximumNumberOfSeats = maximumNumberOfSeats;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getMaximumNumberOfSeats() {
        return maximumNumberOfSeats;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", maximumNumberOfSeats=" + maximumNumberOfSeats +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
