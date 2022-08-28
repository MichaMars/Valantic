

public class Input {

String[] extractInformationFromInput(String input){
    String[] output = {null,null,null,null};
    String[] stringArr = input.split(" ");
    
    output[0] = stringArr[stringArr.length-2] +" "+ stringArr[stringArr.length-1];

    for (int i = 0; i < stringArr.length - 2; i++) {
        if(stringArr[i].contains(".") && stringArr[i].length() >= 4){
            output[1]= extractDate(stringArr[i], "null");
        }else if(stringArr[i].contains(".") && stringArr[i].length() < 4){
            output[1]= extractDate(stringArr[i], stringArr[i+1]);
        }
        
        if (stringArr[i].contains(":") && !stringArr[i+2].contains("abends,")){
            output[2] = stringArr[i];
        }else if (stringArr[i+1].contains("Uhr") && stringArr[i+2].contains("abends,")){
            output[2] = extractTime(stringArr[i]);
        }

        if(stringArr[i+1].contains("Personen") || stringArr[i+1].contains("Mann") || stringArr[i+1].contains("Leuten")){
            output[3] = extractNumOfPoeple(stringArr[i]);
        }
    }
    return output;
}

String getCustName(String input){
    String name = extractInformationFromInput(input)[0];
    return name;
}

String getDate(String input){
    String date = extractInformationFromInput(input)[1];
    return date;
}

String getTime(String input){
    String time = extractInformationFromInput(input)[2];
    return time;
}

int getNumPeople(String input){
    int numPeople = Integer.parseInt(extractInformationFromInput(input)[3]);
    return numPeople;
}

String extractDate(String dateString, String monthString){
    StringBuilder sb = new StringBuilder();
    String[] dateArr = dateString.split("[.]");
    for (int i = 0; i < dateArr.length; i++) {
        if(dateArr[i].length() < 2){
            sb.append("0"+dateArr[i]+".");
        }else{
            sb.append(dateArr[i]+".");
        }
    }
    if(monthString.contains("April")){
        sb.append("04.");
    }
    sb.append("2022");
    return sb.toString();
}

String extractTime(String timeString){
    StringBuilder sb = new StringBuilder();
    int time = Integer.parseInt(timeString)+12;
    String newTime = String.valueOf(time);
    sb.append(newTime+":00");
    return sb.toString();
}

String extractNumOfPoeple(String numString){
    if(numString.length() > 2){
        if(numString.contains("zwei")){
            return "2";
        }else if (numString.contains("sechs")){
            return "6";
        }else if (numString.contains("acht")){
            return "8";
        }
    }  
    return numString;
}

String getDateAndTime(String input){
    String dateAndTime = getDate(input) + " " + getTime(input);
    return dateAndTime;
}

}
