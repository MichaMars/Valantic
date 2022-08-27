public class Input {
    
String[] extractInformationFromInput(String input){
    String[] output = {null,null,null,null};
    StringBuilder sb = new StringBuilder();
    String[] stringArr = input.split(" ");
    output[0] = stringArr[stringArr.length-2] +" "+ stringArr[stringArr.length-1];
    

    return output;
}

String getCustName(String input){
    String name = extractInformationFromInput(input)[0];
    return name;
}

String getDateAndTime(String input){
    String dateAndTime = extractInformationFromInput(input)[1];
    return dateAndTime;
}

int getNumPeople(String input){
    int numPeople = Integer.parseInt(extractInformationFromInput(input)[2]);
    return numPeople;
}

}
