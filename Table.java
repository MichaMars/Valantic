import java.time.LocalDateTime;
import java.util.*;

public class Table {
    private int tableNo;
    private int maxGuests;

    Map<LocalDateTime, Reservation> reservations;

    Table(int tableNo, int maxGuests) {
        this.tableNo = tableNo;
        this.maxGuests = maxGuests;
        this.reservations = new HashMap<>();
    }

    boolean isTableFree(LocalDateTime dateAndTime) {
        return !reservations.containsKey(dateAndTime);
    }

    void reserveTable(LocalDateTime arrDateHour, int numOfGuests, String custName) {
        reservations.put(arrDateHour, new Reservation(numOfGuests, custName));
    }

    int getMaxGuests() {
        return maxGuests;
    }

    int getTableNo() {
        return tableNo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d - MAX: %d\n", tableNo, maxGuests));
        reservations.forEach((k, v) -> sb.append(String.format("\tDate: %s/%s/ %s: %s\n",
                k.getDayOfMonth(), k.getMonth(),
                k.getHour(), v)));
        return sb.toString();
    }
}
