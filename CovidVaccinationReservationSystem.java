import java.util.*;

class CovidVaccinationReservationSystem{
    public static void main(String [] args) {
      Prompts prompt = new Prompts();
      Implement imp = new Implement(); 
      Scanner input = new Scanner(System.in);

      //Name list for the each doses to boosters1
      LinkedHashMap<String, String> nameList1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> nameList2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> nameList3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> nameList4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> nameList5 = new LinkedHashMap<>();

      //Age lists for each doses to boosters
      LinkedHashMap<String, Integer> ageList1 = new LinkedHashMap<>();
      LinkedHashMap<String, Integer> ageList2 = new LinkedHashMap<>();
      LinkedHashMap<String, Integer> ageList3 = new LinkedHashMap<>();
      LinkedHashMap<String, Integer> ageList4 = new LinkedHashMap<>();
      LinkedHashMap<String, Integer> ageList5 = new LinkedHashMap<>();

      //Mobilenumber lists for each doses to boosters
      LinkedHashMap<String, String> mobileNum1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> mobileNum2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> mobileNum3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> mobileNum4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> mobileNum5 = new LinkedHashMap<>();

      //Adress lists for each doses to boosters
      LinkedHashMap<String, String> addresses1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> addresses2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> addresses3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> addresses4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> addresses5 = new LinkedHashMap<>();
  
      //ID lists for each doses to boosters
      LinkedHashMap<String, String> IDs1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> IDs2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> IDs3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> IDs4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> IDs5 = new LinkedHashMap<>();

      //Password Lists for each doses to boosters
      LinkedHashMap<String, String> passList1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> passList2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> passList3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> passList4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> passList5 = new LinkedHashMap<>();

      //Middle names for authentication
      LinkedHashMap<String, String> middleName1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> middleName2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> middleName3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> middleName4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> middleName5 = new LinkedHashMap<>();

      //Time Lists of reservation
      LinkedHashMap<String, String> timeList1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> timeList2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> timeList3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> timeList4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> timeList5 = new LinkedHashMap<>();

      //Time Lists of reservation
      LinkedHashMap<String, String> dateList1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> dateList2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> dateList3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> dateList4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> dateList5 = new LinkedHashMap<>();
      //Attempts
      int attempts1, attempts2, attempts3, attempts4, attempts5, 
      choice;

      //DosesNames
      LinkedHashMap<String, String> doseName1 = new LinkedHashMap<>();
      LinkedHashMap<String, String> doseName2 = new LinkedHashMap<>();
      LinkedHashMap<String, String> doseName3 = new LinkedHashMap<>();
      LinkedHashMap<String, String> doseName4 = new LinkedHashMap<>();
      LinkedHashMap<String, String> doseName5 = new LinkedHashMap<>();

      prompt.Prompt( 
        //Patient Limit
        0,0,0,0,0,
        //Attempts 
        1, 1, 1, 1, 1,
        //Date
        null, null, null, null, null,
        //VaccinationSite
        null, null, null, null, null,
        //Vaccinator1
        null, null, null, null, null,
        //Doctor
        null, null, null, null, null,
        //Starting time
        null, null, null, null, null,
        //EndTime
        null, null, null, null, null,
        //Objects
        input, imp,
        //Name Lists
         nameList1, nameList2,  nameList3 , nameList4, nameList5,
        //Age Lists
         ageList1, ageList2,  ageList3 , ageList4, ageList5,
        //Mobile number List
        mobileNum1,mobileNum2, mobileNum3, mobileNum4, mobileNum5,
        //Addresses list
        addresses1,addresses2,addresses3,addresses4,addresses5,
        //IDs
        IDs1,IDs2,IDs3,IDs4,IDs5,
        //Password List
        passList1, passList2, passList3,passList4, passList5,
        //middleName for Authentication
        middleName1, middleName2, middleName3,middleName4, middleName5,
        //Time List
        timeList1, timeList2, timeList3, timeList4, timeList5,
        //DateList
        dateList1,dateList2,dateList3,dateList4, dateList5,
        //Dose Names
        doseName1, doseName2, doseName3, doseName4, doseName5,

        //For Decision making
        0, false
        );
    }
}