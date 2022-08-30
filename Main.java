public class Main {

public static void main(String[] args) {
    
    Restaurant r = new Restaurant();
        r.addTable(1, 2);
        r.addTable(2, 4);
        r.addTable(3, 6);
        r.addTable(4, 8); 

    
    
    String inputString1 = "Hallo, bitte für zwei Personen einen Tisch am 19.3. um 20:00 Uhr, Vielen Dank Klaus Müller";
    String inputString2 = "Sehr geehrte Damen und Herren, wir würden gern am 9. April 09:45 Uhr mit sechs Leuten zum Brunch kommen, Mit freundlichen Grüßen Maria Meier";
    String inputString3 = "Guten Tag, einen Tisch für 8 Mann am 1.5. 9 Uhr abends, Gruß Franz Schulze";

    reservation(r, inputString1);
    reservation(r, inputString2);
    reservation(r, inputString3);
    

   
     
    System.out.println(r);
    }

    private static void takeReservation(Restaurant r,String name, String dateTimeString, int numPeople) {
        int tId = r.tableReservation(name, dateTimeString, numPeople);
        if (tId != -1)
            System.out.println("Reservierter Tisch: " + tId);
        else
            System.out.println("Keine Tische mehr frei für: " + name);
    }

    private static void reservation(Restaurant r, String inpuString){
        Input input = new Input();
        takeReservation(r, input.getCustName(inpuString),input.getDateAndTime(inpuString) ,input.getNumPeople(inpuString));
    }
}
