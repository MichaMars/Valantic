public class Main {

public static void main(String[] args) {
    
    Restaurant r = new Restaurant();
        r.addTable(1, 2);
        r.addTable(2, 4);
        r.addTable(3, 6);
        r.addTable(4, 8);

    Input input = new Input();
    
    String inputString1 = "Hallo, bitte für zwei Personen einen Tisch am 19.3. um 20:00 Uhr, Vielen Dank Klaus Müller";
    String inputString2 = "Sehr geehrte Damen und Herren, wir würden gern am 9. April 09:45 Uhr mit sechs Leuten zum Brunch kommen, Mit freundlichen Grüßen Maria Meier";
    String inputString3 = "Guten Tag, einen Tisch für 8 Mann am 1.5. 9 Uhr abends, Gruß Franz Schulze";
    //System.out.println(input.getCustName(inputString3));
    //System.out.println(input.getDate(inputString3));
    //System.out.println(input.getTime(inputString3));
    //System.out.println(input.getNumPeople(inputString3));
    //System.out.println(input.getDateAndTime(inputString3));
    


    takeReservation(r, input.getCustName(inputString1),input.getDateAndTime(inputString1) ,input.getNumPeople(inputString1));
     
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
