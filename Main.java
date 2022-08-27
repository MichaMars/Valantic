public class Main {

public static void main(String[] args) {
    
    Restaurant r = new Restaurant();
        r.addTable(1, 2);
        r.addTable(2, 4);
        r.addTable(3, 6);
        r.addTable(4, 8);

    Input input = new Input();
    
    String inputString = "Hallo, bitte für zwei Personen einen Tisch am 19.3. um 20:00 Uhr, Vielen Dank Klaus Müller";
    
        takeReservation(r, input.getCustName(inputString), input.getDateAndTime(inputString), input.getNumPeople(inputString));
     
        System.out.println(r);
    }

    private static void takeReservation(Restaurant r,String name, String dateTimeString, int numPeople) {
        int tId = r.tableReservation(name, dateTimeString, numPeople);
        if (tId != -1)
            System.out.println("Reserved table: " + tId);
        else
            System.out.println("No available table");
    }
}
