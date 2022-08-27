import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant {
    private List<Table> tables = new ArrayList<>();;

   
    public int tableReservation(String name, String dateTimeString, int numPeople) {
        LocalDateTime parsedDateTime = toDateTime(dateTimeString);

        for (Table table : tables) {
            if (table.getMaxGuests() >= numPeople && table.isTableFree(parsedDateTime)) {
                table.reserveTable(parsedDateTime, numPeople, name);
                return table.getTableNo();
            }
        }
        return -1;
    }
    
    public void addTable(int tableNo, int maxGuests) {
        tables.add(new Table(tableNo, maxGuests));
    }

    private LocalDateTime toDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRESTAURANT TABLE RESERVATIONS\n");
        for (Table t : tables) {
            sb.append(t);
        }
        return sb.toString();
    }
}
