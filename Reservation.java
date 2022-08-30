public class Reservation {
    
        private String custName;
        private int numPeople;
    
        Reservation(int numOfGuests, String custName) {
            this.custName = custName;
            this.numPeople = numOfGuests;
        }
    
        public String toString() {
            return String.format("%d Personen auf den Namen: %s", numPeople, custName);
        }
}
