import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;   


public class Implement implements Optionals{
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    //USER CAPABILITIES
    public void Register (int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve){
        System.out.println( "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'Date:\u001B[33m 'yyyy-MM-dd " + "\n\t'\u001B[36mTime:\u001B[33m 'hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("'Date: 'yyyy-MM-dd 'Time: 7:00AM - 5:00PM'");
        String timeR1 = dtf.format(now);
        Random random = new Random();
        String userMpin = String.format("%04d", random.nextInt(10000));
        int age;
        while (true){
            try {
                System.out.print("\u001B[36mEnter the number of which dose phase would like to reserve:(Enter number 6 and press enter to go back) \u001B[37m");
                choice = input.nextInt();
                /* 
                if (patientLimit1 == 0 || patientLimit2 == 0 || patientLimit3 == 0 || patientLimit4 == 0 || patientLimit5 == 0  || doctor1 == null ||  doctor2 == null &&doctor3 == null || doctor4 == null  || doctor5 == null || vaccinationSite1 == null ||  vaccinationSite2 == null||  vaccinationSite3 == null || vaccinationSite4 == null ||  vaccinationSite5 == null || vaccinator1 == null || vaccinator2 == null ||  vaccinator3 == null ||  vaccinator4 == null || vaccinator5 == null || date1 == null || date2 == null || date3  == null || date4== null || date5== null || start1 == null || start2 == null || start3 == null || start4 == null || start5 == null || end1 == null || end2 == null || end3 == null || end4== null || end5 == null){
            
                    //Balik prompt
                    while (true){
                        System.out.println("\u001B[31mThere is no current vaccine schedule set by the admin.");
                        try {
                        System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                        choice = input.nextInt();
                         if (choice == 1) {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                         }
                         else {
                            System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                         }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }
                    }
                }
                               */                     
                if (choice ==  1 ){
                    while (attempts1 <= patientLimit1){
                        IDs1.put(userMpin, userMpin);
                        timeList1.put(userMpin, timeR1);
                        attempts1++;
                        //While loop for Wholle name.
                        while (true) {
                        System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                        String fName = input.next();
                        String secondName= input.nextLine();
                        if (isNumeric(fName) == true || isNumeric(secondName) == true){
                            System.out.print("Invalid input! Please enter some letters. \n\n");
                        }
                            else if  (fName != null || secondName != null){
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName= input.next();
                                    String secondName2= input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
  
                                     }
                                    else if (mName != null || secondName != null) {
                                        middleName1.put( userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName= input.next();
                                            String secondName3= input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                System.out.print("Invalid input! Please enter some letters. \n\n");
                                                
                                             }
                                            else if (mName != null || secondName != null) {
                                                
                                                nameList1.put(userMpin, fName + " " +secondName+ " " + middleName1.get(userMpin).charAt(0) + ". " + lName + secondName3);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                         }
                        // FOr age
                        while (true){
                            try{
                                System.out.print("\u001B[36mEnter your Age (Greater than  or equal to 1 only): \u001B[37m");      
                                age = input.nextInt();
                                if (age >= 1) {
                                ageList1.put(userMpin, age);
                                break;
                                }
                                else {
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                }
                            }
                        
                            catch (InputMismatchException ex) {  
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }  

                        //For Mobile num
                        while(true){                   
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                            String mobileNumber= input.next();
                            if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                
                             }
                            if (mobileNumber.length() == 11){
                                mobileNum1.put(userMpin, mobileNumber);
                                break;
                            }
             
                            else{
                                System.out.print("\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                            }
                        }  
                        
                        // For address
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String  address= input.next();
                        String address1 = input.nextLine();
                        addresses1.put(userMpin, address + " " + address1);
                            
                        //Forr password
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList1.put(userMpin, pass);
                         if ( age <= 17){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true){
                                    try{
                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                        if (choice == 1){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");                    
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                } 
                            }
                         if(age >= 18){
                                String[] AdultDose ={"1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac"};
                                System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                for (String dose : AdultDose) {
                                    System.out.println(dose);
                                }
                                while (true){
                                    try{
                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                        if (choice == 1){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[0]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[1]);
                                            System.out.println("\u001B[36mChosen dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 3){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[2]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 4){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[3]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 5){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[4]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 6){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                            doseName1.put(userMpin, AdultDose[5]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }

                                } 
                            }
                         while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                     Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                    }
                    //Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");    
              }
                else if(choice == 2){
                    while (attempts2 <= patientLimit2){
                        IDs2.put(userMpin, userMpin);
                        timeList2.put(userMpin, timeR1);
                        attempts2++;

                        // For name
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName= input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                System.out.print("Invalid input! Please enter some letters. \n\n");
                            }
                                else if  (fName != null || secondName != null){
                                    while (true) {
                                        System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                        String mName= input.next();
                                        String secondName2= input.nextLine();
                                        if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                            System.out.print("Invalid input! Please enter some letters. \n\n");
      
                                         }
                                        else if (mName != null || secondName != null) {
                                            middleName2.put( userMpin, mName + secondName2);
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                String lName= input.next();
                                                String secondName3= input.nextLine();
                                                if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n");
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    
                                                    nameList2.put(userMpin, fName + " " +secondName+ " " + middleName2.get(userMpin).charAt(0) + ". " + lName + secondName3);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            //For age
                            while (true){
                                try{
                                    System.out.print("\u001B[36mEnter your Age (Greater than  or equal to 1 only): \u001B[37m");      
                                    age = input.nextInt();
                                    if (age >= 1) {
                                    ageList2.put(userMpin, age);
                                    break;
                                    }
                                    else {
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    }
                                }
                            
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }  
                            }  
                            //For MobileNum
                            while(true){                   
                                System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                String mobileNumber= input.next();
                                if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                    System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                    
                                 }
                                if (mobileNumber.length() == 11){
                                    mobileNum2.put(userMpin, mobileNumber);
                                    break;
                                }
                 
                                else{
                                    System.out.print("\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                }
                            }  
                        // For address, tanggalin yung parang exception
                        
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String  address= input.next();
                        String address2 = input.nextLine();
                        addresses2.put(userMpin, address + " " + address2);
                        
                        
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList2.put(userMpin, pass);

                        // For 6 months to 17 years old
                            if ( age <= 17){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                            if (choice == 1){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                doseName2.put(userMpin, doses[0]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                            else if(choice == 2){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                doseName2.put(userMpin, doses[1]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                        }
                                        catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
                                    }
                                }
                            if(age >= 18){
                                    String[] AdultDose = {"1 - Astrazeneca", "2 - Moderna ",  "3 - Pfizer", "4 - Sputnik V", "5 - Sinovac"};
                                    System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                    for (String dose : AdultDose) {
                                        System.out.println(dose);
                                    }
                                    while (true){
                                        try{
                                            System.out.println("\nEnter the number of the vaccine name that you have taken: \u001B[37m");
                                            choice = input.nextInt();
                                            //Aztra
                                            if (choice == 1){
                                                String[] compDose= {"1 - Astrazeneca", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }

                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }
                                                    
                                                }
                                                break;
                                            }
                                            //Moderna
                                            else if(choice == 2){
                                                String[] compDose= {"1 - Moderna", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }
                                            }
                                            break;
                                        }
                                            // Pfizer
                                            else if(choice == 3){
                                                String[] compDose= {"1 - Pfizer", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                            
                                                    }
                                                }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sputnik V
                                            else if(choice == 4){
                                                String[] compDose= {"1 - Suptnik V", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sinovac
                                            else if(choice == 5){
                                                String[] compDose= {"1 - Sinovac", "2 - Pfizer"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                            doseName2.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date2);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            else {
                                                System.out.println("\u001B[31mInvalid input!."); 
                                            }
                                        }
                                     
                                          catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
    
                                    } 
                                                                       
                                }
                                while (true){
                                    try {
                                    System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the reservation mode: \u001B[37m");
                                    choice = input.nextInt();
                                     if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                           
                                     else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                        Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                                     else {
                                        System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                                     }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                           }        
                        System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");                                   
                    }       
                else if(choice == 3){
                    while (attempts3 <= patientLimit3){
                        IDs3.put(userMpin, userMpin);
                        timeList3.put(userMpin, timeR1);
                        attempts3++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName= input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                System.out.print("\t\t\t\t\t\tInvalid input! Please enter some letters. \n\n");
                            }
                                else if  (fName != null || secondName != null){
                                    while (true) {
                                        System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                        String mName= input.next();
                                        String secondName3= input.nextLine();
                                        if (isNumeric(mName) == true || isNumeric(secondName) == true){
                                            System.out.print("\t\t\t\t\t\tInvalid input! Please enter some letters. \n\n");
      
                                         }
                                        else if (mName != null || secondName != null) {
                                            middleName3.put( userMpin, mName + secondName);
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                String lName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                    System.out.print("\t\t\t\t\t\tInvalid input! Please enter some letters. \n\n");
                                                    
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    
                                                    nameList3.put(userMpin, fName + " " +secondName+ " " + middleName3.get(userMpin).charAt(0) + ". " + lName + secondName3);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            //For age
                            while (true){
                                try{
                                    System.out.print("\u001B[36mEnter your Age (Greater than  or equal to 1 only): \u001B[37m");      
                                    age = input.nextInt();
                                    if (age >= 1) {
                                    ageList3.put(userMpin, age);
                                    break;
                                    }
                                    else {
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    }
                                }
                            
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }  
                            }  
                            //For MobileNum
                            while(true){                   
                                System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                String mobileNumber= input.next();
                                if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                    System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                    
                                 }
                                if (mobileNumber.length() == 11){
                                    mobileNum3.put(userMpin, mobileNumber);
                                    break;
                                }
                 
                                else{
                                    System.out.print("\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                }
                            }  
                        // For address, tanggalin yung parang exception
                        
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String  address= input.next();
                        String address3 = input.nextLine();
                        addresses3.put(userMpin, address + " " + address3);
                        
                        
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList3.put(userMpin, pass);
                                if ( age <= 17){
                                    String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                    System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                    for (String dose : doses) {
                                        System.out.println(dose);
                                    }
                                    while (true){
                                        try{
                                            System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                            choice = input.nextInt();
                                            if (choice == 1){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                doseName3.put(userMpin, doses[0]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                            else if(choice == 2){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                doseName3.put(userMpin, doses[1]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                        }
                                        catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
                                    }
                                }
                                else if(age >=18){
                                    String[] AdultDose ={"1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac"};
                                    System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                    for (String dose : AdultDose) {
                                        System.out.println(dose);
                                    }
                                    while (true){
                                        try{
                                            System.out.println("\nEnter the number of the vaccine name that you have taken: \u001B[37m");
                                            choice = input.nextInt();
                                            //Aztra
                                            if (choice == 1){
                                                System.out.println( "List of Compatible Dose for Astrazenenca\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                    
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Moderna
                                            if (choice == 2){
                                                System.out.println( "List of Compatible Dose for Moderna\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Janssen
                                            if (choice == 3){
                                                System.out.println( "List of Compatible Dose for Janssen\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }

                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //pfizer
                                            if (choice == 4){
                                                System.out.println( "List of Compatible Dose for Pfizer\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }

                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sputnik V
                                            if (choice == 5){
                                                System.out.println( "List of Compatible Dose for Sputnik V\n");
                                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }

                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sinovac
                                            if (choice == 6){
                                                System.out.println( "List of Compatible Dose for Sinovac\n");
                                                String[] compDose= {"1 - Sinovac", "2 - Pfizer"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }

                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                                            doseName3.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date3);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                        }
                                        catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
                                    }
                                 }
                                 while (true){
                                    try {
                                    System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the reservation mode: \u001B[37m");
                                    choice = input.nextInt();
                                     if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                                                                     
                                     else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                         Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                                     else {
                                        System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                                     }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
         
                    }
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. "); 
                }
                else if(choice == 4){
                    while (attempts4 <= patientLimit4){
                        IDs4.put(userMpin, userMpin);
                        timeList4.put(userMpin, timeR1);
                        attempts4++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName= input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                System.out.print("Invalid input! Please enter some letters. \n\n");
                            }
                                else if  (fName != null || secondName != null){
                                    while (true) {
                                        System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                        String mName= input.next();
                                        String secondName2= input.nextLine();
                                        if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                            System.out.print("Invalid input! Please enter some letters. \n\n");
      
                                         }
                                        else if (mName != null || secondName != null) {
                                            middleName4.put( userMpin, mName + secondName2);
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                String lName= input.next();
                                                String secondName3= input.nextLine();
                                                if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
                                                    
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    
                                                    nameList4.put(userMpin, fName + " " +secondName+ " " + middleName4.get(userMpin).charAt(0) + ". " + lName + secondName);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            //For age
                            while (true){
                                try{
                                    System.out.print("\u001B[36mEnter your Age (Greater than  or equal to 1 only): \u001B[37m");      
                                    age = input.nextInt();
                                    if (age >= 1) {
                                    ageList4.put(userMpin, age);
                                    break;
                                    }
                                    else {
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    }
                                }
                            
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }  
                            }  
                            //For MobileNum
                            while(true){                   
                                System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                String mobileNumber= input.next();
                                if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                    System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                    
                                 }
                                if (mobileNumber.length() == 11){
                                    mobileNum4.put(userMpin, mobileNumber);
                                    break;
                                }
                 
                                else{
                                    System.out.print("\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                }
                            }  
                        // For address, tanggalin yung parang exception
                        
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String  address= input.next();
                        String address4 = input.nextLine();
                        addresses4.put(userMpin, address + " " + address4);
                        
                        
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList4.put(userMpin, pass);

                            // for 5yrs old to 12 (dipa naayos)
                            if ( age <= 17){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true){
                                    try{
                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                            doseName4.put(userMpin, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                            doseName4.put(userMpin, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                            else if(age >=18){
                                    String[] AdultDose ={"1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac"};
                                    System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                    for (String dose : AdultDose) {
                                        System.out.println(dose);
                                    }
                                    while (true){
                                        try{
                                            System.out.println("\nEnter the number of the vaccine name that you have taken: \u001B[37m");
                                            choice = input.nextInt();
                                            //Aztra
                                            if (choice == 1){
                                                System.out.println( "List of Compatible Dose for Astrazenenca\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                         break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Moderna
                                            if (choice == 2){
                                                System.out.println( "List of Compatible Dose for Moderna\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Janssen
                                            if (choice == 3){
                                                System.out.println( "List of Compatible Dose for Janssen\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //pfizer
                                            if (choice == 4){
                                                System.out.println( "List of Compatible Dose for Pfizer\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sputnik V
                                            if (choice == 5){
                                                System.out.println( "List of Compatible Dose for Sputnik V\n");
                                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sinovac
                                            if (choice == 6){
                                                System.out.println( "List of Compatible Dose for Sinovac\n");
                                                String[] compDose= {"1 - Sinovac", "2 - Pfizer"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                                            doseName4.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date4);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }
                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
                                } 
                            
                        }
                                   //Balik prompt
                                   while (true){
                                    try {
                                    System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the reservation mode: \u001B[37m");
                                    choice = input.nextInt();
                                     if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                                                                     
                                     else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();;   
                                         Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                     }
                                     else {
                                        System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                                     }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
              
                    }
                    //Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");  
                    break;  
                        }
                else if(choice == 5){
                    while (attempts5 <= patientLimit5){
                        IDs5.put(userMpin, userMpin);
                        timeList5.put(userMpin, timeR1);
                        attempts5++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName= input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                System.out.print("Invalid input! Please enter some letters. \n\n");
                            }
                                else if  (fName != null || secondName != null){
                                    while (true) {
                                        System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                        String mName= input.next();
                                        String secondName2= input.nextLine();
                                        if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                            System.out.print("Invalid input! Please enter some letters. \n\n");
      
                                         }
                                        else if (mName != null || secondName != null) {
                                            middleName5.put( userMpin, mName + secondName2);
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                String lName= input.next();
                                                String secondName3= input.nextLine();
                                                if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
                                                    
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    
                                                    nameList5.put(userMpin, fName + " " +secondName+ " " + middleName5.get(userMpin).charAt(0) + ". " + lName + secondName);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            //For age
                             while (true){
                                try{
                                    System.out.print("\u001B[36mEnter your Age (Greater than  or equal to 1 only): \u001B[37m");      
                                    age = input.nextInt();
                                    if (age >= 1) {
                                    ageList5.put(userMpin, age);
                                    break;
                                    }
                                    else {
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    }
                                }
                            
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }  
                            }  
                            //For MobileNum
                            while(true){                   
                                System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                String mobileNumber= input.next();
                                if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                    System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                    
                                 }
                                if (mobileNumber.length() == 11){
                                    mobileNum5.put(userMpin, mobileNumber);
                                    break;
                                }
                 
                                else{
                                    System.out.print("\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                }
                            }  
                        // For address, tanggalin yung parang exception
                        
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String  address= input.next();
                        String address5 = input.nextLine();
                        addresses5.put(userMpin, address);
                        
                        
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList5.put(userMpin, pass);

  
                        if ( age <= 17){
                            String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                            System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSE░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                            for (String dose : doses) {
                                System.out.println(dose);
                            }
                            while (true){
                                        try{
                                            System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                            choice = input.nextInt();
    
                                            if (choice == 1){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                doseName5.put(userMpin, doses[0]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                            else if(choice == 2){
                                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                doseName5.put(userMpin, doses[1]);
                                                System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                break;
                                            }
                                        }
                                        catch (InputMismatchException ex) {  
                                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                            input.nextLine();
                                        }
                                    }
                                }
                         else if(age >= 18){
                                    String[] AdultDose ={"1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac"};
                                    System.out.print("\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");    
                                    for (String dose : AdultDose) {
                                        System.out.println(dose);
                                    }
                                    System.out.println("\nEnter the number of the vaccine name that you have taken: \u001B[37m");
                                    choice = input.nextInt();
                                    while (true){
                                        try{
                                            //Aztra
                                            if (choice == 1){
                                                System.out.println( "List of Compatible Dose for Astrazenenca\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                                
                                            }
                                            //Moderna
                                            if (choice == 2){
                                                System.out.println( "List of Compatible Dose for Moderna\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Janssen
                                            if (choice == 3){
                                                System.out.println( "List of Compatible Dose for Janssen\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //pfizer
                                            if (choice == 4){
                                                System.out.println( "List of Compatible Dose for Pfizer\n");
                                                String[] compDose= {"1 - Astrazeneca", "2 - Pfizer", "3 - Moderna"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        if (choice == 3) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[2]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sputnik V
                                            if (choice == 5){
                                                System.out.println( "List of Compatible Dose for Sputnik V\n");
                                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                while (true) {
                                                    try{
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }

                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }

                                                }
                                                break;
                                            }
                                            //Sinovac
                                            if (choice == 6){
                                                System.out.println( "List of Compatible Dose for Sinovac\n");
                                                String[] compDose= {"1 - Sinovac", "2 - Pfizer"};
                                                for (String dose : compDose) {
                                                    System.out.println(dose);
                                                }
                                                while (true) {
                                                    try{
                                                        System.out.println("\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m"); 
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[0]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                        else if (choice == 2) {
                                                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(userMpin) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                                            doseName5.put(userMpin,  compDose[1]);
                                                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                                            System.out.println("\u001B[36mRecommended date of taking second dose:  \u001B[33m" + date5);
                                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                            System.out.println("\u001B[32mVacinee's information has already been saved.");
                                                            break;
                                                        }
                                                       
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!."); 
                                                        }
                                                    }
                                                    catch (InputMismatchException ex) {  
                                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                                        input.nextLine();
                                                    }
                                                }
                                                break;
                                            }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                } 
                            }
                        
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                     Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("\u001B[31mInvalid input! Please enter number 1 only and press enter.");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }

                    }
                    //Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");    
                }    
                else if(choice == 6){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
                            
                 
            }
            catch (InputMismatchException ex) {  
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                input.nextLine();
            }     
        }

    }
    public void CheckReservation(int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve) {

        System.out.println( "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true){
            System.out.print("\u001B[36mEnter the number of which dose phase would like to check the reservation list(Enter number 6 and pressenter to go back): \u001B[37m");
            choice = input.nextInt();
            try {
                   if (choice == 1) {
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    for (Map.Entry e : nameList1.entrySet()) {
                        System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                     }
                    if (nameList1.entrySet().isEmpty()){
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush(); 
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                            for (Map.Entry e : nameList1.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                             }
                        }
                   }  
                   
                   while(true){
                    try {
                    System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                    String id = input.next();
        
                     if(IDs1.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord= input.next();
                            if(passList1.containsValue(passWord)){
                                System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs1.get(id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(id));
                                System.out.println("\u001B[36mChosen dose: \u001B[33m" + doseName1.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList1.get(id));
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1 + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date2);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1); 
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1); 
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(id));
                            System.out.print("Enter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode:  \u001B[37m");
                            choice = input.nextInt();
            
                            if(choice == 1 ){
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                break;
                            }
            
                            else if (choice == 0){
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }
            
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                     }
                     else if(id.equalsIgnoreCase("B")){
                        System.out.print("\033[H\033[2J");
                        System.out.flush(); 
                        Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                    }
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                   }
                   catch (InputMismatchException ex) {  
                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                    input.nextLine();
                }  
                }

               
            }
            else if (choice == 2) {
                System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                if (nameList2.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: \u001B[37m ");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                        for (Map.Entry e : nameList2.entrySet()) {
                            System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                         }
                    }
               }  
               for (Map.Entry e : nameList2.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
             }
               while(true){
                System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                String id = input.next();
    
                 if(IDs2.containsValue(id)) {
                        System.out.print("Enter your password: ");
                        String passWord= input.next();
                        if(passList2.containsValue(passWord)){
                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs2.get(id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(id));
                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(id));
                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(id));
                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(id));
                            System.out.println("\u001B[36mChosen Dose: \u001B[33m" + doseName2.get(id) );
                            System.out.println("\u001B[36mReservation details: \n\t" + timeList2.get(id));
                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2 + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                            System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date2);
                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2); 
                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2); 
                            System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(id));
                        System.out.print("Enter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
                     }
        
                    else {
                        System.out.println("Invalid password! Please try again ");
                    }
                 }
        
                 else if(id.equalsIgnoreCase("B")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }
                
                else{
                    System.out.println("This user doesn't exists ");
                }
                
               }
            }
            else if (choice == 3) {
                System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                if (nameList3.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m ");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                        for (Map.Entry e : nameList3.entrySet()) {
                            System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                         }
                    }
               }  
               for (Map.Entry e : nameList3.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
             }
                  while(true){
                System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                String id = input.next();
    
                 if(IDs3.containsValue(id)) {
                        System.out.print("Enter your password: ");
                        String passWord= input.next();
                        if(passList3.containsValue(passWord)){
                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs3.get(id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(id));
                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(id));
                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(id));
                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(id));
                            System.out.println("\u001B[36m1st Dose Booster: \u001B[33mP" + doseName3.get(id) );
                            System.out.println("\u001B[36mReservation details: \n\t" + timeList3.get(id));
                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                            System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date3);
                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3); 
                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3); 
                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(id));
                        System.out.print("Enter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
        
                    else {
                        System.out.println("Invalid password! Please try again ");
                    }
                 }
        
                
                else{
                    System.out.println("This user doesn't exists ");
                }
                
               }
              
               else if(id.equalsIgnoreCase("B")){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
            }
               else{
                System.out.println("This user doesn't exists ");
            }
            }
        }
            else if (choice == 4) {
                System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                if (nameList4.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m ");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4,     date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,     doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,     ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,     IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3,     timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                       
                    }
               }  
               for (Map.Entry e : nameList4.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
             }
 
               while(true){
                System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                String id = input.next();
    
                 if(IDs4.containsValue(id)) {
                        System.out.print("Enter your password: ");
                        String passWord= input.next();
                        if(passList4.containsValue(passWord)){
                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs4.get(id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(id));
                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(id));
                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(id));
                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(id));
                            System.out.println("\u001B[36m2nd Dose Booster: \u001B[33m" + doseName4.get(id) );
                            System.out.println("\u001B[36mReservation details: \n\t" + timeList4.get(id));
                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                            System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date4);
                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4); 
                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4); 
                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(id));
                        System.out.print("Enter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
                     }
        
                    else {
                        System.out.println("Invalid password! Please try again ");
                    }
                 }
        
                 else if(id.equalsIgnoreCase("B")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }
                else{
                    System.out.println("This user doesn't exists ");
                }
                
               }
            }
            else if (choice == 5) {

     
                System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                if (nameList5.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m ");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1,patientLimit2,patientLimit3,patientLimit4,patientLimit5,attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2,        date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3, doctor4,vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,nameList2,  nameList3 , nameList4, nameList5, ageList1, ageList2,  ageList3 , ageList4, ageList5, mobileNum1,mobileNum2, mobileNum3, mobileNum4,mobileNum5,    addresses1,addresses2,addresses3, addresses4,addresses5, IDs1,IDs2,IDs3,IDs4,IDs5, passList1, passList2, passList3,passList4, passList5,middleName1,middleName2, middleName3,middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,dateList2,dateList3,dateList4,dateList5, doseName1, doseName2,doseName3, doseName4,doseName5,0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush(); 
                                CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                        for (Map.Entry e : nameList5.entrySet()) {
                            System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                         }
                    }
               }  
               for (Map.Entry e : nameList5.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
             }
               while(true){
                System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                String id = input.next();
    
                 if(IDs5.containsValue(id)) {
                        System.out.print("Enter your password: ");
                        String passWord= input.next();
                        if(passList5.containsValue(passWord)){
                            System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  IDs5.get(id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                            System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(id));
                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(id));
                            System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(id));
                            System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(id));
                            System.out.println("\u001B[36m3rd Dose Booster: \u001B[33m" + doseName5.get(id) );
                            System.out.println("\u001B[36mReservation details: \n\t" + timeList5.get(id));
                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                            System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                            System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date5);
                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5); 
                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5); 
                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(id));
                        System.out.print("Enter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
                     }
        
                    else {
                        System.out.println("Invalid password! Please try again ");
                    }
                 }
        
                
                 else if(id.equalsIgnoreCase("B")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }
                else{
                    System.out.println("This user doesn't exists ");
                }
                
               }
            }
            else if(choice == 6){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
            else {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
            }
        }

            catch (InputMismatchException ex) {  
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                input.nextLine();
            }  
        }
    }                      
    public void EditReservation(int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve) {  
        
        
        System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");

        while (true){
            System.out.print("\u001B[36mEnter the number of which dose phase would like to check and edit the reservation list (Enter number 6 and press enter to go back): \u001B[37m");
            choice = input.nextInt();
            try {
                //Dose 1
                if (choice == 1) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();;   
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    if (nameList1.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }
                   }  
                   for (Map.Entry e : nameList1.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                 }
                   //Main function
                   while(true){
                    System.out.print("\n\u001B[36mEnter the ID that you want to edit the details (Enter B and press enter to go back):  \u001B[37m");
                    String id = input.next();
        
                     if(IDs1.containsValue(id)) {
                            System.out.print("\u001B[36mEnter your password: \u001B[37m");
                            String passWord= input.next();
                            if(passList1.containsValue(passWord)){
                            
                                System.out.println("1 - Name\n2 - Age & Chosen dose \n3 - Mobile No.\n4 - Address \n5 - Password");
                                System.out.print("\u001B[36mEnter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: \u001B[37m ");
                                choice = input.nextInt();
                                if (choice == 1){
                                //While loop for Whole name.
                                while (true) {
                                    System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                    String fName = input.next();
                                    String secondName= input.nextLine();
                                    if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
                                    }
                                        else if  (fName != null || secondName != null){
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
              
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    middleName1.put( id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName= input.next();
                                                        String secondName3= input.nextLine();
                                                        if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                            System.out.print("Invalid input! Please enter some letters. \n\n");
                                                        }
                                                        
                                                        else if (mName != null || secondName != null) {
                                                            nameList1.replace(id, fName + " " +secondName+ " " + middleName1.get(id).charAt(0) + ". " + lName + secondName3);
                                                            System.out.println("\u001B[36mPatient's current name is: \u001B[33m" + nameList1.get(id));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                //For age and dose
                                else if (choice == 2 ){
                                    while(true){
                                    try{
                                    System.out.print("\u001B[36mEnter your new Age: \u001B[37m");      
                                    int age = input.nextInt();
                                    
                                    if(age <= 4) {
                                        System.out.println("Invalid input! Please enter a number and try again.");
                                    }
                                    
                                    else {
                                        ageList1.replace(id, age);
                                        break;
                                    }
                                }  
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                                                               
                            if ( ageList1.get(id) <= 17 && ( doseName1.get(id).equals("1 - Pfizer (Most Compatible)") || doseName1.get(id).equals("2 - Moderna (Optional)"))){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                 for (String dose : doses) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                            doseName1.replace(id, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                            doseName1.replace(id, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                            break;
                                        } 

                                        else {
                                            System.out.println("Invalid input! PLease enter a number and try again ."); 
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                              }
                         }
                            if(ageList1.get(id)>= 18 && (doseName1.get(id).equals("1 - Astrazeneca)") ||  doseName1.get(id).equals("2 - Moderna ") || doseName1.get(id).equals( "3 - Janssen")|| doseName1.get(id).equals( "4 - Pfizer"))||  doseName1.get(id).equals( "5 - Sputnik V") || doseName1.get(id).equals( "6 - Sinovac") ||  doseName1.get(id).equals("1 - Pfizer (Most Compatible)")|| doseName1.get(id).equals("2 - Moderna (Optional)")){
                                String[] compDose= {"1 - Astrazeneca", "2 - Sinovac", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V"};
                                while (true) {
                                 try{
                                    for (String dose : compDose) {
                                        System.out.println("\u001B[36m" + dose);
                                    }
                                     System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                     choice = input.nextInt();
                                    try{
                                        if (choice == 1) {
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                            doseName1.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                            doseName1.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                            break;
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                         System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                         doseName1.replace(id, compDose[2]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                        break;
                                     }
                                                                                                                
                                     else if (choice == 4) {
                                         System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                         doseName1.replace(id, compDose[3]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                        break;
                                     }
                                                                                                                
                                     else if (choice == 5) {
                                         System.out.println("\u001B[36m vacinee's age has been edited into: \u001B[33m" + ageList1.get(id));
                                         doseName1.replace(id, compDose[4]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName1.get(id));
                                        break;
                                     }
                                       
                                        else {
                                            System.out.println("Invalid input! Please enter an output from 1 to 5"); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                                catch (InputMismatchException ex) {  
                                 input.nextLine();
                             }
                            }
                            }
                                }
                                //For Mobile num
                                else if (choice == 3){
                                    while(true){
                                        System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                        String mobileNumber= input.next();
                                        
                                        if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                            System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                         }
                                        if (mobileNumber.length() == 11){
                                            mobileNum1.replace(id, mobileNumber);
                                            System.out.println("The patient's current mobile number is: " + mobileNum1.get(id));
                                            break;
                                        }
                         
                                        else{
                                            System.out.print("You've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                        }
                                    }  
                                }
                                //Enter address
                                else if (choice == 4){
                                    System.out.print("Enter your Address: ");
                                    String address= input.next();
                                    addresses1.replace(id, address);
                                    System.out.println("The patient's current address is: " + addresses1.get(id));
                                    break; 
                                }
                                //Password
                                else if (choice == 5){
                                    System.out.print("Enter your Password: ");
                                    String pass = input.next();    
                                    passList1.replace(id, pass);
                                    System.out.println("Your password has been changed. Please remember it well.");
                                    break;
                                } 
                                //Exit
                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                               }
                            else {
                                System.out.println("Invalid password. Please try again.");
                            }
                            
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("Invalid input! Please enter number 1 only and press enter.\u001B[36m");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.\u001B[36m");    
                                    input.nextLine();
                                }
                            }
                         }
                     else if(id.equalsIgnoreCase("B")){
                         Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
                        else {
                            System.out.println("This user doesn't exists!");
                        }
                    }
                }
                //Dose 2
                else if (choice == 2) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();;   
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    if (nameList2.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }
                   }  
                   for (Map.Entry e : nameList2.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                 }
                   //Main function
                   while(true){
                    System.out.print("\n\u001B[36mEnter the ID that you want to edit the details (Enter B and press enter to go back):  \u001B[37m");
                    String id = input.next();
        
                     if(IDs2.containsValue(id)) {
                            System.out.print("\u001B[36mEnter your password: \u001B[37m");
                            String passWord= input.next();
                            if(passList2.containsValue(passWord)){
                                System.out.println("1 - Name\n2 - Age & Chosen dose \n3 - Mobile No.\n4 - Address \n5 - Password");
                                System.out.print("\u001B[36mEnter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: \u001B[37m ");
                                choice = input.nextInt();
                                if (choice == 1){
                                //While loop for Whole name.
                                while (true) {
                                    System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                    String fName = input.next();
                                    String secondName= input.nextLine();
                                    if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
                                    }
                                        else if  (fName != null || secondName != null){
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
              
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    middleName2.put( id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName= input.next();
                                                        String secondName3= input.nextLine();
                                                        if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                            System.out.print("Invalid input! Please enter some letters. \n\n");
                                                        }
                                                        
                                                        else if (mName != null || secondName != null) {
                                                            nameList2.replace(id, fName + " " +secondName+ " " + middleName1.get(id).charAt(0) + ". " + lName + secondName3);
                                                            System.out.println("\u001B[36mPatient's current name is: \u001B[33m" + nameList1.get(id));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                //For age and dose
                                else if (choice == 2 ){
                                    while(true){
                                    try{
                                    System.out.print("\u001B[36mEnter your new Age: \u001B[37m");      
                                    int age = input.nextInt();
                                    
                                    if(age <= 4) {
                                        System.out.println("Invalid input! Please enter a number that is greater than 1.");  
                                    }
                                    
                                    else {
                                        ageList1.replace(id, age);
                                        break;
                                    }
                                }  
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                                                               
                            if ( ageList2.get(id) <= 17 && ( doseName2.get(id).equals("1 - Pfizer (Most Compatible)") || doseName2.get(id).equals("2 - Moderna (Optional)"))){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                 for (String dose : doses) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                            doseName2.replace(id, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                            doseName2.replace(id, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                            break;
                                        } 

                                        else {
                                            System.out.println("Invalid input! PLease enter a number and try again ."); 
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                              }
                         }
                            if(ageList2.get(id)>= 18 && (doseName2.get(id).equals("1 - Astrazeneca)") ||  doseName2.get(id).equals("2 - Moderna ") || doseName2.get(id).equals( "3 - Janssen")|| doseName2.get(id).equals( "4 - Pfizer"))||  doseName2.get(id).equals( "5 - Sputnik V") || doseName2.get(id).equals( "6 - Sinovac") ||  doseName2.get(id).equals("1 - Pfizer (Most Compatible)")|| doseName1.get(id).equals("2 - Moderna (Optional)")){
                                String[] compDose= {"1 - Astrazeneca", "2 - Sinovac", "3 - Janssen", "4 - Pfizer", "5 - Sputnik V"};
                                while (true) {
                                 try{
                                    for (String dose : compDose) {
                                        System.out.println("\u001B[36m" + dose);
                                    }
                                     System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                     choice = input.nextInt();
                                    try{
                                        if (choice == 1) {
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                            doseName2.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                            doseName2.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                            break;
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                         System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                         doseName2.replace(id, compDose[2]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                        break;
                                     }
                                                                                                                
                                     else if (choice == 4) {
                                         System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                         doseName2.replace(id, compDose[3]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                        break;
                                     }
                                                                                                                
                                     else if (choice == 5) {
                                         System.out.println("\u001B[36m vacinee's age has been edited into: \u001B[33m" + ageList2.get(id));
                                         doseName2.replace(id, compDose[4]);
                                         System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName2.get(id));
                                        break;
                                     }
                                       
                                        else {
                                            System.out.println("Invalid input! Please enter an output from 1 to 5"); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                                catch (InputMismatchException ex) {  
                                 input.nextLine();
                             }
                            }
                            }
                                }
                                //For Mobile num
                                else if (choice == 3){
                                    while(true){
                                        System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                        String mobileNumber= input.next();
                                        
                                        if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                            System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                         }
                                        if (mobileNumber.length() == 11){
                                            mobileNum2.replace(id, mobileNumber);
                                            System.out.println("The patient's current mobile number is: " + mobileNum2.get(id));
                                            break;
                                        }
                         
                                        else{
                                            System.out.print("You've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                        }
                                    }  
                                }
                                //Enter address
                                else if (choice == 4){
                                    System.out.print("Enter your Address: ");
                                    String address= input.next();
                                    addresses1.replace(id, address);
                                    System.out.println("The patient's current address is: " + addresses1.get(id));
                                    break; 
                                }
                                //Password
                                else if (choice == 5){
                                    System.out.print("Enter your Password: ");
                                    String pass = input.next();    
                                    passList2.replace(id, pass);
                                    System.out.println("Your password has been changed. Please remember it well.");
                                    break;
                                } 
                                //Exit
                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                               }
                               else {
                                System.out.println("Invalid password. Please try again.");
                            }
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("Invalid input! Please enter number 1 only and press enter.\u001B[36m");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.\u001B[36m");    
                                    input.nextLine();
                                }
                            }
                         }

                     else if(id.equalsIgnoreCase("B")){
                         Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
                }
                // First booseter
                else if (choice == 3) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();;   
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    if (nameList3.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }
                   }  
                   for (Map.Entry e : nameList3.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                 }
                   //Main function
                   while(true){
                    System.out.print("\n\u001B[36mEnter the ID that you want to edit the details (Enter B and press enter to go back):  \u001B[37m");
                    String id = input.next();
        
                     if(IDs3.containsValue(id)) {
                            System.out.print("\u001B[36mEnter your password: \u001B[37m");
                            String passWord= input.next();
                            if(passList3.containsValue(passWord)){
                                System.out.println("1 - Name\n2 - Age & Chosen dose \n3 - Mobile No.\n4 - Address \n5 - Password");
                                System.out.print("\u001B[36mEnter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: \u001B[37m ");
                                choice = input.nextInt();
                                if (choice == 1){
                                //While loop for Whole name.
                                while (true) {
                                    System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                    String fName = input.next();
                                    String secondName= input.nextLine();
                                    if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
                                    }
                                        else if  (fName != null || secondName != null){
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
              
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    middleName3.put( id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName= input.next();
                                                        String secondName3= input.nextLine();
                                                        if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                            System.out.print("Invalid input! Please enter some letters. \n\n");
                                                        }
                                                        
                                                        else if (mName != null || secondName != null) {
                                                            nameList3.replace(id, fName + " " +secondName+ " " + middleName3.get(id).charAt(0) + ". " + lName + secondName3);
                                                            System.out.println("\u001B[36mPatient's current name is: \u001B[33m" + nameList3.get(id));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                //For age and dose
                                else if (choice == 2 ){
                                    while(true){
                                    try{
                                    System.out.print("\u001B[36mEnter your new Age: \u001B[37m");      
                                    int age = input.nextInt();
                                    
                                    if(age <= 4) {
                                        System.out.println("Invalid input! Please enter a number that is greater than 1.");  
                                    }
                                    
                                    else {
                                        ageList3.replace(id, age);
                                        break;
                                    }
                                }  
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                                                               
                            if ( ageList3.get(id) <= 17 && ( doseName3.get(id).equals("1 - Pfizer (Most Compatible)") || doseName3.get(id).equals("2 - Moderna (Optional)"))){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                 for (String dose : doses) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList3.get(id));
                                            doseName3.replace(id, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList3.get(id));
                                            doseName3.replace(id, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        } 

                                        else {
                                            System.out.println("Invalid input! PLease enter a number and try again ."); 
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                              }
                         }
              
                             if(ageList3.get(id) >= 18 && doseName3.get(id).equals("1 - Astrazeneca")){
                       
                               String[] compDose= {"1 - Astrazeneca", "2 - Sinovac"};
                               for (String dose : compDose) {
                                System.out.println("\u001B[36m" + dose);
                            }
                               while (true) {
                                   try{
                                    System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();
                                       if (choice == 1) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                           doseName3.replace(id, compDose[0]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                      break;
                                       }
                                       else if (choice == 2) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                           doseName3.replace(id, compDose[1]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                           break;
}
                                      
                                       else {
                                           System.out.println("\u001B[31mInvalid input!."); 
                                       }
                                   }

                                   catch (InputMismatchException ex) {  
                                       System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                       input.nextLine();
                                   }
                               }
                           
                        }
                        if(ageList3.get(id) >= 18 && doseName3.get(id).equals("2 - Moderna ")){
                                String[] compDose= {"1 - Moderna", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            
                         }
                        if(ageList3.get(id) >= 18 && doseName3.get(id).equals("3 - Pfizer")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList3.get(id)>= 18 && doseName3.get(id).equals("4 - Sputnik V")){
                            if (choice == 1){
                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList3.get(id) >= 18 && doseName3.get(id).equals("5 - Sinovac")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
            }
                                //For Mobile num
                                else if (choice == 3){
                                    while(true){
                                        System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                        String mobileNumber= input.next();
                                        
                                        if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                            System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                         }
                                        if (mobileNumber.length() == 11){
                                            mobileNum3.replace(id, mobileNumber);
                                            System.out.println("The patient's current mobile number is: " + mobileNum3.get(id));
                                            break;
                                        }
                         
                                        else{
                                            System.out.print("You've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                        }
                                    }  
                                }
                                //Enter address
                                else if (choice == 4){
                                    System.out.print("Enter your Address: ");
                                    String address= input.next();
                                    System.out.println("The patient's current mobile number " + addresses3.get(id) + " has been edited into");
                                    addresses3.replace(id, address);
                                    System.out.println(addresses2.get(id) + ".");
                                    break; 
                                }
                                //Password
                                else if (choice == 5){
                                    System.out.print("Enter your Password: ");
                                    String pass = input.next();    
                                    passList3.replace(id, pass);
                                    System.out.println("Your password has been changed. Please remember it well.");
                                    break;
                                } 
                                //Exit
                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                               }
                               else {
                                System.out.println("Invalid password. Please try again.");
                            }
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("Invalid input! Please enter number 1 only and press enter.\u001B[36m");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.\u001B[36m");    
                                    input.nextLine();
                                }
                            }
                         }

                     else if(id.equalsIgnoreCase("B")){
                         Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
                }
                //Second booster
                else if (choice == 4) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();;   
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    if (nameList4.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }
                   }  
                   for (Map.Entry e : nameList4.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                 }
                   //Main function
                   while(true){
                    System.out.print("\n\u001B[36mEnter the ID that you want to edit the details (Enter B and press enter to go back):  \u001B[37m");
                    String id = input.next();
        
                     if(IDs4.containsValue(id)) {
                            System.out.print("\u001B[36mEnter your password: \u001B[37m");
                            String passWord= input.next();
                            if(passList4.containsValue(passWord)){
                                System.out.println("1 - Name\n2 - Age & Chosen dose \n3 - Mobile No.\n4 - Address \n5 - Password");
                                System.out.print("\u001B[36mEnter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: \u001B[37m ");
                                choice = input.nextInt();
                                if (choice == 1){
                                //While loop for Whole name.
                                while (true) {
                                    System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                    String fName = input.next();
                                    String secondName= input.nextLine();
                                    if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
                                    }
                                        else if  (fName != null || secondName != null){
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
              
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    middleName4.put( id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName= input.next();
                                                        String secondName3= input.nextLine();
                                                        if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                            System.out.print("Invalid input! Please enter some letters. \n\n");
                                                        }
                                                        
                                                        else if (mName != null || secondName != null) {
                                                            nameList4.replace(id, fName + " " +secondName+ " " + middleName4.get(id).charAt(0) + ". " + lName + secondName3);
                                                            System.out.println("\u001B[36mPatient's current name is: \u001B[33m" + nameList4.get(id));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                //For age and dose
                                else if (choice == 2 ){
                                    while(true){
                                    try{
                                    System.out.print("\u001B[36mEnter your new Age: \u001B[37m");      
                                    int age = input.nextInt();
                                    
                                    if(age <= 4) {
                                        System.out.println("Invalid input! Please enter a number that is greater than 1.");  
                                    }
                                    
                                    else {
                                        ageList4.replace(id, age);
                                        break;
                                    }
                                }  
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                                                               
                            if ( ageList4.get(id) <= 17 && ( doseName4.get(id).equals("1 - Pfizer (Most Compatible)") || doseName4.get(id).equals("2 - Moderna (Optional)"))){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                 for (String dose : doses) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList4.get(id));
                                            doseName4.replace(id, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList4.get(id));
                                            doseName4.replace(id, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        } 

                                        else {
                                            System.out.println("Invalid input! PLease enter a number and try again ."); 
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                              }
                            break;
                         }
              
                             if(ageList4.get(id) >= 18 && doseName4.get(id).equals("1 - Astrazeneca")){
                               String[] compDose= {"1 - Astrazeneca", "2 - Sinovac", "3 - Pfizer"};
                               for (String dose : compDose) {
                                System.out.println("\u001B[36m" + dose);
                            }
                               while (true) {
                                   try{
                                    System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();
                                       if (choice == 1) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                           doseName4.replace(id, compDose[0]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                       }
                                       else if (choice == 2) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                           doseName4.replace(id, compDose[1]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                       }
                                                                                                                  
                                       else if (choice == 3) {
                                        System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                        doseName4.replace(id, compDose[2]);
                                        System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                        break;
                                    }
                                      
                                       else {
                                           System.out.println("\u001B[31mInvalid input!."); 
                                       }
                                   }

                                   catch (InputMismatchException ex) {  
                                       System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                       input.nextLine();
                                   }
                               }
    
                        }
                          if(ageList4.get(id) >= 18 && doseName4.get(id).equals("2 - Moderna ")){
                            if (choice == 1){
                                String[] compDose= {"1 - Moderna", "2 - Sinovac", "3 - Astrazenica"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[2]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList4.get(id) >= 18 && doseName4.get(id).equals("3 - Pfizer")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac", "3 - Astrazeneca"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[2]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList4.get(id)>= 18 && doseName4.get(id).equals("4 - Sputnik V")){
                            
                            if (choice == 1){
                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList3.get(id));
                                            doseName3.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName3.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList4.get(id) >= 18 && doseName4.get(id).equals("5 - Sinovac")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList4.get(id));
                                            doseName4.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
            }
                                //For Mobile num
                                else if (choice == 3){
                                    while(true){
                                        System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");  
                                        String mobileNumber= input.next();
                                        
                                        if (isNumeric(mobileNumber) == false || isNumeric(mobileNumber) == false){
                                            System.out.print("\u001B[31mInvalid input! Please enter some numbers. \n");
                                         }
                                        if (mobileNumber.length() == 11){
                                            mobileNum4.replace(id, mobileNumber);
                                            System.out.println("The patient's current mobile number is: " + mobileNum4.get(id));
                                            break;
                                        }
                         
                                        else{
                                            System.out.print("You've entered a wrong length of digits, Please try again.\n\u001B[37m");  
                                        }
                                    }  
                                }
                                //Enter address
                                else if (choice == 4){
                                    System.out.print("Enter your Address: ");
                                    String address= input.next();
                                    System.out.println("The patient's current mobile number " + addresses3.get(id) + " has been edited into");
                                    addresses3.replace(id, address);
                                    System.out.println(addresses2.get(id) + ".");
                                    break; 
                                }
                                //Password
                                else if (choice == 5){
                                    System.out.print("Enter your Password: ");
                                    String pass = input.next();    
                                    passList3.replace(id, pass);
                                    System.out.println("Your password has been changed. Please remember it well.");
                                    break;
                                } 
                                //Exit
                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                               }
                            else {
                                System.out.println("invalid password! Please try again");
                            }
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("Invalid input! Please enter number 1 only and press enter.\u001B[36m");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.\u001B[36m");    
                                    input.nextLine();
                                }
                            }
                         }

                     else if(id.equalsIgnoreCase("B")){
                         Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
                        else {
                            System.out.println("This user doesn't exists. Please try again ");
                        }
                    }
                }
                // Third booster
                else if (choice == 5) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();;   
                    System.out.println( "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
                    if (nameList5.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m ");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                        }
                   }  
                   for (Map.Entry e : nameList5.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                 }
                   //Main function
                   while(true){
                    System.out.print("\n\u001B[36mEnter the ID that you want to edit the details (Enter B and press enter to go back):  \u001B[37m");
                    String id = input.next();
        
                     if(IDs5.containsValue(id)) {
                            System.out.print("\u001B[36mEnter your password: \u001B[37m");
                            String passWord= input.next();
                            if(passList5.containsValue(passWord)){
                                System.out.println("1 - Name\n2 - Age & Chosen dose \n3 - Mobile No.\n4 - Address \n5 - Password");
                                System.out.print("\u001B[36mEnter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: \u001B[37m ");
                                choice = input.nextInt();
                                if (choice == 1){
                                //While loop for Whole name.
                                while (true) {
                                    System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                    String fName = input.next();
                                    String secondName= input.nextLine();
                                    if (isNumeric(fName) == true || isNumeric(secondName) == true){
                                        System.out.print("Invalid input! Please enter some letters. \n\n");
                                    }
                                        else if  (fName != null || secondName != null){
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName= input.next();
                                                String secondName2= input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true){
                                                    System.out.print("Invalid input! Please enter some letters. \n\n");
              
                                                 }
                                                else if (mName != null || secondName != null) {
                                                    middleName5.put( id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName= input.next();
                                                        String secondName3= input.nextLine();
                                                        if (isNumeric(lName) == true || isNumeric(secondName3) == true){
                                                            System.out.print("Invalid input! Please enter some letters. \n\n");
                                                        }
                                                        
                                                        else if (mName != null || secondName != null) {
                                                            nameList5.replace(id, fName + " " +secondName+ " " + middleName5.get(id).charAt(0) + ". " + lName + secondName3);
                                                            System.out.println("\u001B[36mPatient's current name is: \u001B[33m" + nameList5.get(id));
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                //For age and dose
                                else if (choice == 2 ){
                                    while(true){
                                    try{
                                    System.out.print("\u001B[36mEnter your new Age: \u001B[37m");      
                                    int age = input.nextInt();
                                    
                                    if(age <= 4) {
                                        System.out.println("Invalid input! Please enter a number that is greater than 1.");  
                                    }
                                    
                                    else {
                                        ageList5.replace(id, age);
                                        break;
                                    }
                                }  
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.");    
                                    input.nextLine();
                                }
                            }
                                                               
                            if ( ageList5.get(id) <= 17 && ( doseName5.get(id).equals("1 - Pfizer (Most Compatible)") || doseName5.get(id).equals("2 - Moderna (Optional)"))){
                                String[] doses ={"1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)"};
                                 for (String dose : doses) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true){
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList4.get(id));
                                            doseName4.replace(id, doses[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        }
                                        else if(choice == 2){
                                            System.out.println("\u001B[36mThe vacinee's age has been edited into: \u001B[33m" + ageList4.get(id));
                                            doseName4.replace(id, doses[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName4.get(id));
                                            break;
                                        } 

                                        else {
                                            System.out.println("Invalid input! PLease enter a number and try again ."); 
                                        }
                                    }
                                    catch (InputMismatchException ex) {  
                                        System.out.println("Invalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                              }
                         }
              
                             if(ageList5.get(id) >= 18 && doseName5.get(id).equals("1 - Astrazeneca")){
                               String[] compDose= {"1 - Astrazeneca", "2 - Sinovac", "3 - Pfizer"};
                               for (String dose : compDose) {
                                System.out.println("\u001B[36m" + dose);
                            }
                               while (true) {
                                   try{
                                    System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();
                                       if (choice == 1) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                           doseName5.replace(id, compDose[0]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                           break;
                                       }
                                       else if (choice == 2) {
                                           System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                           doseName5.replace(id, compDose[1]);
                                           System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                           break;
                                       }
                                                                                                                  
                                       else if (choice == 3) {
                                        System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                        doseName5.replace(id, compDose[2]);
                                        System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                        break;
                                    }
                                      
                                       else {
                                           System.out.println("\u001B[31mInvalid input!."); 
                                       }
                                   }

                                   catch (InputMismatchException ex) {  
                                       System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                       input.nextLine();
                                   }
                               }
                        }
                          if(ageList5.get(id) >= 18 && doseName5.get(id).equals("2 - Moderna ")){
                            if (choice == 1){
                                String[] compDose= {"1 - Moderna", "2 - Sinovac", "3 - Astrazenica"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[2]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList5.get(id) >= 18 && doseName5.get(id).equals("3 - Pfizer")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac", "3 - Astrazeneca"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                                                                                                   
                                        else if (choice == 3) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[2]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList5.get(id)>= 18 && doseName5.get(id).equals("4 - Sputnik V")){
                            
                            if (choice == 1){
                                String[] compDose= {"1 - Sputnik V", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
                        if(ageList5.get(id) >= 18 && doseName5.get(id).equals("5 - Sinovac")){
                            if (choice == 1){
                                String[] compDose= {"1 - Pfizer", "2 - Sinovac"};
                                for (String dose : compDose) {
                                    System.out.println("\u001B[36m" + dose);
                                }
                                while (true) {
                                    try{
                                        System.out.print("\n\u001B[36mEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[0]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                        else if (choice == 2) {
                                            System.out.println("The vacinee's age has been edited into: " + ageList5.get(id));
                                            doseName5.replace(id, compDose[1]);
                                            System.out.println("\u001B[36mChosen Dose has been edited into: \u001B[33m" + doseName5.get(id));
                                            break;
                                        }
                                       
                                        else {
                                            System.out.println("\u001B[31mInvalid input!."); 
                                        }
                                    }

                                    catch (InputMismatchException ex) {  
                                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                                        input.nextLine();
                                    }
                                }
                            }
                         }
            }
               
                                //Exit
                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                               }
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the edit reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                                                 
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else {
                                    System.out.println("Invalid input! Please enter number 1 only and press enter.\u001B[36m");    
                                 }
                                }
                                catch (InputMismatchException ex) {  
                                    System.out.println("Invalid input! Please enter a number and try again.\u001B[36m");    
                                    input.nextLine();
                                }
                            }
                         }

                     else if(id.equalsIgnoreCase("B")){
                         Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                     }
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
                }
                else if(choice == 6){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                    }    
     
                else {
                    System.out.println("Invalid input! Please enter a number and try again.");    
                }
            }

            catch (InputMismatchException ex) {  
                System.out.println("Invalid input! Please enter a number and try again.");    
                input.nextLine();
            }  
        }
    }      
    public void RemoveReservation(int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve) {
        System.out.println( "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ REMOVE RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true){
        try{
            System.out.print("\u001B[36mEnter the number of which dose phase would like to check and cancel the reservation list(Enter number 6 and press enter to go back): \u001B[37m");
            choice = input.nextInt();
          if (choice == 1 ) {
                if (nameList1.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty!\u001B[36m");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m \u001B[37m");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("\u001B[31mInvalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                 }
                                                           
               }
                // Main
                for (Map.Entry e : nameList1.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
            }
                while(true){
                    System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                    String id = input.next();
        
                    for (Map.Entry e : nameList1.entrySet()) {
                       System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                    }
                    
                    if(IDs1.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord= input.next();
                            if(passList1.containsValue(passWord)){
                            System.out.print("Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                            choice = input.nextInt();
                            
                            if (choice ==1){
                                nameList1.remove(id);
                                ageList1.remove(id);
                                mobileNum1.remove(id);
                                addresses1.remove(id);
                                timeList1.remove(id);
                                dateList1.remove(id);
                                passList1.remove(id);
                                IDs1.remove(id);
                                middleName1.remove(id);
                                doseName1.remove(id);
                                System.out.println("\u001B[35mVaccinee is already been removed on the reservation list.");
                                System.out.print("Enter 0 and press enter to go back, .   Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                                }
                                             }
                                            }
                                        else {
                                            System.out.println("Invalid password! Please try again ");
                                        }
                                    }
                    
                    else if(id.equalsIgnoreCase("B")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }           
              }
            }
          else if (choice == 2 ) {
                if (nameList2.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty!\u001B[36m");          
                while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                       
                             }
         
            }
               for (Map.Entry e : nameList2.entrySet()) {
               System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
            }
                 // Main
                while(true){
                        System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();
            
                        if(IDs2.containsValue(id)) {
                                System.out.print("Enter your password: ");
                                String passWord= input.next();
                                if(passList2.containsValue(passWord)){
                                System.out.print("Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                choice = input.nextInt();
                                
                                if (choice ==1){
                                    nameList2.remove(id);
                                    ageList2.remove(id);
                                    mobileNum2.remove(id);
                                    addresses2.remove(id);
                                    timeList2.remove(id);
                                    dateList2.remove(id);
                                    passList2.remove(id);
                                    IDs2.remove(id);
                                    middleName2.remove(id);
                                    doseName2.remove(id);
                                    System.out.println("\u001B[35mVaccinee is already been removed on the reservation list.");
                                    System.out.print("Enter 0 and press enter to go back, .   Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();
                    
                                    if(choice == 1 ){
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                    }
                    
                                    else if (choice == 0){
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                                 }
                                                }
                                            else {
                                                System.out.println("Invalid password! Please try again ");
                                            }
                                        }
                                    }
                   else if(id.equalsIgnoreCase("B")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                } 
                                                 else {}
                    }      
        }
          else if (choice == 3 ) {
                if (nameList3.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty!\u001B[36m");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                    }
               }
               for (Map.Entry e : nameList3.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
        }
              // Main
               while(true){
            System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
            String id = input.next();

            if(IDs3.containsValue(id)) {
                    System.out.print("Enter your password: ");
                    String passWord= input.next();
                    if(passList3.containsValue(passWord)){
                    System.out.print("Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                    choice = input.nextInt();
                    
                    if (choice ==1){
                        nameList3.remove(id);
                        ageList3.remove(id);
                        mobileNum3.remove(id);
                        addresses3.remove(id);
                        timeList3.remove(id);
                        dateList3.remove(id);
                        passList3.remove(id);
                        IDs3.remove(id);
                        middleName3.remove(id);
                        doseName3.remove(id);
                        System.out.println("\u001B[35mVaccinee is already been removed on the reservation list.");
                        System.out.print("Enter 0 and press enter to go back, .   Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                        }
                                     }
                                    }
                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }
                        }
                }    
          else if (choice == 4 ) {
                if (nameList4.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty!\u001B[36m");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                                       }
               }
               for (Map.Entry e : nameList4.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
        }
        // Main
        while(true){
            System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
            String id = input.next();

            
            if(IDs4.containsValue(id)) {
                    System.out.print("Enter your password: ");
                    String passWord= input.next();
                    if(passList4.containsValue(passWord)){
                    System.out.print("Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                    choice = input.nextInt();
                    
                    if (choice ==1){
                        nameList4.remove(id);
                        ageList4.remove(id);
                        mobileNum4.remove(id);
                        addresses4.remove(id);
                        timeList4.remove(id);
                        dateList4.remove(id);
                        passList4.remove(id);
                        IDs4.remove(id);
                        middleName4.remove(id);
                        doseName4.remove(id);
                        System.out.println("\u001B[35mVaccinee is already been removed on the reservation list.");
                        System.out.print("Enter 0 and press enter to go back, .   Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4,     date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,     doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,     ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,     IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3,     timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4,     date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,     doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,     ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,     IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3,     timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, false);
                                        }
                                     }
                                    }
                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }
                        }
  
            }
          else if (choice == 5 ) {
                if (nameList5.entrySet().isEmpty()){
                    System.out.println("\u001B[31mReservation list is empty!\u001B[36m");
                    while (true){
                            try {
                            System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                            choice = input.nextInt();
                             if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
                              
                             else if (choice == 0) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();;   
                                RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                             }
    
                             else {
                                System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                             }
                        }    
         
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                        }  
                    }
               }
               for (Map.Entry e : nameList5.entrySet()) {
                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
        }
        // Main
        while(true){
            System.out.print("\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
            String id = input.next();
            
            if(IDs5.containsValue(id)) {
                    System.out.print("Enter your password: ");
                    String passWord= input.next();
                    if(passList5.containsValue(passWord)){
                    System.out.print("Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                    choice = input.nextInt();
                    
                    if (choice ==1){
                        nameList5.remove(id);
                        ageList5.remove(id);
                        mobileNum5.remove(id);
                        addresses5.remove(id);
                        timeList5.remove(id);
                        dateList5.remove(id);
                        passList5.remove(id);
                        IDs5.remove(id);
                        middleName5.remove(id);
                        doseName5.remove(id);
                        System.out.println("\u001B[35mVaccinee is already been removed on the reservation list.");
                        System.out.print("Enter 0 and press enter to go back, .   Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                        choice = input.nextInt();
        
                        if(choice == 1 ){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                        }
        
                        else if (choice == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                        }
                                     }
                                    }
                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }
                        }

            }
        
            else if(choice == 6){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
 
        }
        catch (InputMismatchException ex) {  
            System.out.println("Invalid input! Please enter a number and try again.");    
            input.nextLine();
        }  
    }
}
    public void forgotPassword (int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve){

        System.out.println( "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true){
            try {
                System.out.print("\u001B[36mEnter the number of which dose phase would like to retrieve your password (Enter number 6 and press enter to go back): \u001B[37m");
                choice = input.nextInt();
                if (choice == 1 ) {
                    if (nameList1.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                          
                    }
                }   
                    //Main
                    for (Map.Entry e : nameList1.entrySet()) {
                        System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                }
                    while(true){
                        try {
                            System.out.print("\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if(IDs1.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord= input.next();
                                if(middleName1.containsValue(passWord)){
                                    System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  passList1.get     (id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList1.get(id));
                                
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                System.out.flush();
                                forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }
            
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
            
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                            
                    }  
                }
                }
                else if (choice == 2 ) {
                    if (nameList2.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  

                    }
                }   
                for (Map.Entry e : nameList2.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
            }
                    //Main
                    while(true){
                        try {
                            System.out.print("\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if(IDs2.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord= input.next();
                                if(middleName2.containsValue(passWord)){
                                    System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  passList1.get     (id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList2.get(id));
                                
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                System.out.flush();
                                forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }
            
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
            
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                            
                    }  
                }
                
            }
                else if (choice == 3 ) {
                    if (nameList3.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1,patientLimit2,patientLimit3,patientLimit4,patientLimit5,attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2,        date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3, doctor4,vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,nameList2,  nameList3 , nameList4, nameList5, ageList1, ageList2,  ageList3 , ageList4, ageList5, mobileNum1,mobileNum2, mobileNum3, mobileNum4,mobileNum5,    addresses1,addresses2,addresses3, addresses4,addresses5, IDs1,IDs2,IDs3,IDs4,IDs5, passList1, passList2, passList3,passList4, passList5,middleName1,middleName2, middleName3,middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,dateList2,dateList3,dateList4,dateList5, doseName1, doseName2,doseName3, doseName4,doseName5,0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                         
                    }
                }   
                    //Main
                    for (Map.Entry e : nameList3.entrySet()) {
                        System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                }
                    while(true){
                        try {
                            System.out.print("\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if(IDs3.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord= input.next();
                                if(middleName3.containsValue(passWord)){
                                    System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  passList1.get     (id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList3.get(id));
                                
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                System.out.flush();
                                forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }
            
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
            
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                            
                    }  
                }
                }
                else if (choice == 4 ) {
                    if (nameList4.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                   forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                    }
                }   
                    //Main
                    for (Map.Entry e : nameList4.entrySet()) {
                        System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                }
                    while(true){
                        try {
                            System.out.print("\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if(IDs4.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord= input.next();
                                if(middleName4.containsValue(passWord)){
                                    System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  passList1.get     (id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList4.get(id));
                                
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                System.out.flush();
                                forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }
            
                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
            
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                            
                    }  
                }
                }
                else if (choice == 5 ) {
                    if (nameList5.entrySet().isEmpty()){
                        System.out.println("Reservation list is empty");
                        while (true){
                                try {
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0 , false);
                                 }
                                  
                                 else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                 }
        
                                 else {
                                    System.out.println("Invalid input! Please enter 0 or 1 and and press enter."); 
                                 }
                            }    
             
                            catch (InputMismatchException ex) {  
                                System.out.println("Invalid input! Please enter a number and try again.");    
                                input.nextLine();
                            }  
                         
                    }
                }   
                for (Map.Entry e : nameList5.entrySet()) {
                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
            }
                    //Main
                    while(true){
                        try {
                            System.out.print("\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if(IDs5.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord= input.next();
                                if(middleName5.containsValue(passWord)){
                                    System.out.print("\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#" +  passList1.get     (id) + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");  
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList5.get(id));
                                
                                System.out.print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();
                
                                if(choice == 1 ){
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                                }
                
                                else if (choice == 0){
                                    System.out.print("\033[H\033[2J");
                                System.out.flush();
                                forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                            }
                         }

                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }
            
                    else{
                        System.out.println("This user doesn't exists ");
                    }
                        }
                        catch (InputMismatchException ex) {  
                            System.out.println("Invalid input! Please enter a number and try again.");    
                            input.nextLine();
                            
                    }  
                }
                }
                else if(choice == 6){
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                    }    
     
            }

            catch (InputMismatchException ex) {  
                System.out.println("Invalid input! Please enter a number and try again.");    
                input.nextLine();
            }  
        }
    }
    public void SetReservation (int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve){
 
     
  
             System.out.println( "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ SET RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n"); 
             System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
            
             SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Date format
             dateFormat.setLenient(false);
 
             SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa"); // 12 hour time format
             timeFormat.setLenient(true); 
 
             while (true){
            try {
            
               System.out.print("\u001B[36mEnter the number of which dose phase would like to check and set the reservation list(Enter number 6 and press enter to go back): \u001B[37m");
               choice = input.nextInt();
               input.nextLine();
 
                if (choice ==  1  ){
                 System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                 vaccinationSite1 = input.nextLine();
 
               while (true) {
                 System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                  vaccinator1 = input.nextLine();
                  if (isNumeric(vaccinator1) == true){
                     System.out.println("\u001B[36mPlease input letters only.\u001B[37m\n");  
                  }
 
                  else if (vaccinator1 != null) {
                     break;
                  }
               }
 
               while (true) {
                 System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                 String fname1 = input.next();
                 String sname1 = input.nextLine();
                 doctor1 = fname1 + sname1;
 
                  if (isNumeric(doctor1) == true){
                     System.out.println("\u001B[36mPlease input letters only. \u001B[37m");  
                  }
 
                  else if (doctor1 != null) {
                     break;
                  }
               }
               while (true){
                 try{
                     System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");    
                     patientLimit1 = input.nextInt();
                break;
                }
                catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
                }  
             }
                  
             while (true) {
             System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
             date1 = input.next();
             try {
                 Date dateParsed = dateFormat.parse(date1);
                 System.out.println("1st Dose vaccination scheduled date: " + date1);
                 break;
             }
             catch (ParseException e) {
                 System.out.println("Invalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
             }
             }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
            
                 try {
                     start1 = inputs + " " + inputs2;
                     Date timeParsedStart = timeFormat.parse(start1);
                     System.out.println("Starting time: " + start1);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
                 
                 try {
                 end1 = inputs + " " + inputs2;
                 Date timeParsedEnd = timeFormat.parse(end1);
                     
                     System.out.println("End time: " + end1);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
      
                 Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
                 break;
                }
                                                                                                             
                if (choice ==  2  ){
                 System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                 vaccinationSite2 = input.nextLine();
 
               while (true) {
                 System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                  vaccinator2 = input.nextLine();
                  if (isNumeric(vaccinator2) == true){
                     System.out.println("\u001B[36mPlease input letters only.  \u001B[37m\n");  
                  }
 
                  else if (vaccinator2 != null) {
                     break;
                  }
               }
 
               while (true) {
                 System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                 String fname1 = input.next();
                 String sname1 = input.nextLine();
                 doctor2 = fname1 + sname1;
 
                  if (isNumeric(doctor2) == true){
                     System.out.println("\u001B[36mPlease input letters only. \u001B[37m");  
                  }
 
                  else if (doctor2 != null) {
                     break;
                  }
               }
               while (true){
                 try{
                     System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");    
                     patientLimit2 = input.nextInt();
                break;
                }
                catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
                }  
             }
                  
             while (true) {
             System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
             date2 = input.next();
             try {
                 Date dateParsed = dateFormat.parse(date2);
                 System.out.println("2nd Dose vaccination scheduled date: " + date2);
                 break;
             }
             catch (ParseException e) {
                 System.out.println("Invalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
             }
             }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
            
                 try {
                     start2 = inputs + " " + inputs2;
                     Date timeParsedStart = timeFormat.parse(start2);
                     System.out.println("Starting time: " + start2);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
                 
                 try {
                 end2 = inputs + " " + inputs2;
                 Date timeParsedEnd = timeFormat.parse(end2);
                     
                     System.out.println("End time: " + end2);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
      
                 Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
                 break; 
             }
             
 
             if (choice ==  3){
                 System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                 vaccinationSite3 = input.nextLine();
 
               while (true) {
                 System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                  vaccinator3 = input.nextLine();
                  if (isNumeric(vaccinator3) == true){
                     System.out.println("\u001B[36mPlease input letters only.  \u001B[37m\n");  
                  }
 
                  else if (vaccinator3 != null) {
                     break;
                  }
               }
 
               while (true) {
                 System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                 String fname1 = input.next();
                 String sname1 = input.nextLine();
                 doctor3 = fname1 + sname1;
 
                  if (isNumeric(doctor3) == true){
                     System.out.println("\u001B[36mPlease input letters only. \u001B[37m");  
                  }
 
                  else if (doctor3 != null) {
                     break;
                  }
               }
               while (true){
                 try{
                     System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");    
                     patientLimit3 = input.nextInt();
                break;
                }
                catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
                }  
             }
                  
             while (true) {
             System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
             date3 = input.next();
             try {
                 Date dateParsed = dateFormat.parse(date3);
                 System.out.println("1st Booster vaccinanation scheduled date: " + date3);
                 break;
             }
             catch (ParseException e) {
                 System.out.println("Invalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
             }
             }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
            
                 try {
                     start3 = inputs + " " + inputs2;
                     Date timeParsedStart = timeFormat.parse(start3);
                     System.out.println("Starting time: " + start3);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
                 
                 try {
                 end3 = inputs + " " + inputs2;
                 Date timeParsedEnd = timeFormat.parse(end3);
                     
                     System.out.println("End time: " + end3);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
      
                 Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
                 break;
               
             }
             
             if (choice ==  4){
                 System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                 vaccinationSite4 = input.nextLine();
 
               while (true) {
                 System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                  vaccinator4 = input.nextLine();
                  if (isNumeric(vaccinator4) == true){
                     System.out.println("\u001B[36mPlease input letters only. \u001B[37m\n");  
                  }
 
                  else if (vaccinator4 != null) {
                     break;
                  }
               }
 
               while (true) {
                 System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                 String fname1 = input.next();
                 String sname1 = input.nextLine();
                 doctor4 = fname1 + sname1;
 
                  if (isNumeric(doctor4) == true){
                     System.out.println("\u001B[36mPlease input letters only. \u001B[37m");  
                  }
 
                  else if (doctor4 != null) {
                     break;
                  }
               }
               while (true){
                 try{
                     System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");    
                     patientLimit4 = input.nextInt();
                break;
                }
                catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
                }  
             }
                  
             while (true) {
             System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
             date4 = input.next();
             try {
                 Date dateParsed = dateFormat.parse(date4);
                 System.out.println("2nd Booster vaccinanation scheduled date: " + date4);
                 break;
             }
             catch (ParseException e) {
                 System.out.println("Invalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
             }
             }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
            
                 try {
                     start4 = inputs + " " + inputs2;
                     Date timeParsedStart = timeFormat.parse(start4);
                     System.out.println("Starting time: " + start4);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
                 
                 try {
                 end4 = inputs + " " + inputs2;
                 Date timeParsedEnd = timeFormat.parse(end4);
                     
                     System.out.println("End time: " + end4);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
      
                 Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
                 break;
             }
 
 
             if (choice ==  5){
                 System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                 vaccinationSite5 = input.nextLine();
 
               while (true) {
                 System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                  vaccinator5 = input.nextLine();
                  if (isNumeric(vaccinator5) == true){
                     System.out.print("\u001B[36mPlease input letters only.  \u001B[37m\n");  
                  }
 
                  else if (vaccinator5 != null) {
                     break;
                  }
               }
 
               while (true) {
                 System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                 String fname1 = input.next();
                 String sname1 = input.nextLine();
                 doctor5 = fname1 + sname1;
 
                  if (isNumeric(doctor5) == true){
                     System.out.print("\u001B[36mPlease input letters only. \u001B[37m");  
                  }
 
                  else if (doctor5 != null) {
                     break;
                  }
               }
               while (true){
                 try{
                     System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");    
                     patientLimit5 = input.nextInt();
                break;
                }
                catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
                }  
             }
                  
             while (true) {
             System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
             date5 = input.next();
             try {
                 Date dateParsed = dateFormat.parse(date5);
                 System.out.println("3rd Booster vaccinanation scheduled date: " + date5);
                 break;
             }
             catch (ParseException e) {
                 System.out.println("Invalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
             }
             }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
            
                 try {
                     start5 = inputs + " " + inputs2;
                     Date timeParsedStart = timeFormat.parse(start5);
                     System.out.println("Starting time: " + start5);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
 
             while (true) {
                 System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                 String inputs = input.next();
                 String inputs2 = input.next();
                 
                 try {
                 end5 = inputs + " " + inputs2;
                 Date timeParsedEnd = timeFormat.parse(end5);
                     
                     System.out.println("End time: " + end5);
                     break;
                 }
                 catch (ParseException e) {
                     System.out.println("Invalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                 }
                 }
      
                 Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
                 break;
             }
             else if(choice == 6){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
 
             else {
                System.out.println("\u001B[31mInvalid input! Please enter a number from 1 to 6.\u001B[36m");    
             }
            }

             catch (InputMismatchException ex) {  
                 System.out.println("Invalid input! Please enter a number and try again.");    
                 input.nextLine();
             }  
        }
    }
    public void ExportList(int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
    int attempts1, int attempts2, int attempts3, int attempts4, int attempts5, 
    String date1, String date2, String date3, String date4, String date5, 
    String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4, String vaccinationSite5,
    String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
    String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
    String start1, String start2, String start3, String start4, String start5,
    String end1, String end2,  String end3,  String end4,  String end5,
    Scanner input, Implement imp,
    LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2, LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4, LinkedHashMap<String, String> nameList5, 
    LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2, LinkedHashMap<String, Integer> ageList3,LinkedHashMap<String, Integer> ageList4, LinkedHashMap<String, Integer> ageList5,
    LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,LinkedHashMap<String, String> mobileNum3,
    LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
    LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,LinkedHashMap<String, String> addresses3,LinkedHashMap<String, String> addresses4,LinkedHashMap<String, String> addresses5,
    LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3, LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
    LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2, LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4, LinkedHashMap<String, String> passList5,
    LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2, LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4, LinkedHashMap<String, String> middleName5,
    LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2, LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4, LinkedHashMap<String, String> timeList5,
    LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2, LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4, LinkedHashMap<String, String> dateList5,
    LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2, LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4, LinkedHashMap<String, String> doseName5,
    int choice, boolean setReserve){
     System.out.println("Please wait while data is exporting...");
     DateTimeFormatter dtfExport = DateTimeFormatter.ofPattern("'Date: 'yyyy-MM-dd " + "'Time: 'hh:mm:ss");
     LocalDateTime nowExport = LocalDateTime.now();
     String timeExport = dtfExport.format(nowExport);
     //dose 1 excel
     try{
         XSSFWorkbook workbook = new XSSFWorkbook();
         XSSFSheet spreadsheet1 = workbook.createSheet("Dose 1");
         XSSFSheet spreadsheet2 = workbook.createSheet("Dose 2");
         XSSFSheet spreadsheet3 = workbook.createSheet("1st Booster");
         XSSFSheet spreadsheet4 = workbook.createSheet("2nd Booster");
         XSSFSheet spreadsheet5 = workbook.createSheet("3rd Booster");
         XSSFRow row;
 
         //styling
         XSSFCellStyle fontstyle0 = workbook.createCellStyle();
        Font fonta0 = workbook.createFont();
        fonta0.setFontHeightInPoints((short)12);
        fonta0.setFontName("Arial");
        fonta0.setBold(true);
        fontstyle0.setFont(fonta0);
        fontstyle0.setAlignment(HorizontalAlignment.CENTER);

         XSSFCellStyle fontstyle1 = workbook.createCellStyle();
         Font fonta1 = workbook.createFont();
         fonta1.setFontHeightInPoints((short)12);
         fonta1.setFontName("Arial");
         fonta1.setBold(true);
         fontstyle1.setFont(fonta1);
         fontstyle1.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
         fontstyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
 
         XSSFCellStyle fontstyle2 = workbook.createCellStyle();
         Font fonta2 = workbook.createFont();
         fonta2.setFontHeightInPoints((short)12);
        fonta2.setFontName("Arial");
        fontstyle2.setFont(fonta2);
        fontstyle2.setAlignment(HorizontalAlignment.CENTER);
        fontstyle2.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        fontstyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        fontstyle2.setBorderRight(BorderStyle.MEDIUM);
        fontstyle2.setBorderLeft(BorderStyle.MEDIUM);
 
        //start of dose 1 to array
         Object[] id1 = nameList1.keySet().toArray(new Object[0]);
         Object[] name1 = nameList1.values().toArray(new Object[0]);
         Object[] age1 = ageList1.values().toArray(new Object[0]);
         Object[] number1 = mobileNum1.values().toArray(new Object[0]);
         Object[] address1 = addresses1.values().toArray(new Object[0]);
         Object[] pword1 = passList1.values().toArray(new Object[0]);
         Object[] dose1 = doseName1.values().toArray(new Object[0]);
         Object[] vacc1 = {};
         ArrayList<Object> addera1 = new ArrayList<Object>(Arrays.asList(vacc1));
         Object[] vaccSite1 = {};
         ArrayList<Object> addera2 = new ArrayList<Object>(Arrays.asList(vaccSite1));
         Object[] doc1 = {};
         ArrayList<Object> addera3 = new ArrayList<Object>(Arrays.asList(doctor1));
         Object[] startDate1 = {};
         ArrayList<Object> addera4 = new ArrayList<Object>(Arrays.asList(date1));
         Object[] endDate1 = {};
         ArrayList<Object> addera5 = new ArrayList<Object>(Arrays.asList(date2));
         
         for (int r = 0; r < id1.length; r++){
         addera1.add(vaccinator1);
         vacc1 = addera1.toArray(vacc1);
         addera2.add(vaccinationSite1);
         vaccSite1 = addera2.toArray(vaccSite1);
         addera3.add(doctor1);
         doc1 = addera3.toArray(doc1);
         addera4.add(date1);
         startDate1 = addera4.toArray(startDate1);
         addera5.add(date2);
         endDate1 = addera5.toArray(endDate1);
        }
        //end of dose 1 to array

        //start of dose 2 to array
        Object[] id2 = nameList2.keySet().toArray(new Object[0]);
         Object[] name2 = nameList2.values().toArray(new Object[0]);
         Object[] age2 = ageList2.values().toArray(new Object[0]);
         Object[] number2 = mobileNum2.values().toArray(new Object[0]);
         Object[] address2 = addresses2.values().toArray(new Object[0]);
         Object[] pword2 = passList2.values().toArray(new Object[0]);
         Object[] dose2 = doseName2.values().toArray(new Object[0]);
         Object[] vacc2 = {};
         ArrayList<Object> adderb1 = new ArrayList<Object>(Arrays.asList(vacc2));
         Object[] vaccSite2 = {};
         ArrayList<Object> adderb2 = new ArrayList<Object>(Arrays.asList(vaccSite2));
         Object[] doc2 = {};
         ArrayList<Object> adderb3 = new ArrayList<Object>(Arrays.asList(doctor2));
         Object[] startDate2 = {};
        ArrayList<Object> adderb4 = new ArrayList<Object>(Arrays.asList(date2));
        Object[] endDate2 = {};
        ArrayList<Object> adderb5 = new ArrayList<Object>(Arrays.asList(date3));

         for (int r = 0; r < id2.length; r++){
         adderb1.add(vaccinator2);
         vacc2 = adderb1.toArray(vacc2);
         adderb2.add(vaccinationSite2);
         vaccSite2 = adderb2.toArray(vaccSite2);
         adderb3.add(doctor2);
         doc2 = adderb3.toArray(doc2);
         adderb4.add(date2);
         startDate2 = adderb4.toArray(startDate2);
         adderb5.add(date3);
         endDate2 = adderb5.toArray(endDate2);
        }
        //end of dose 2 to array

        //start of 1st booster to array
        Object[] id3 = nameList3.keySet().toArray(new Object[0]);
        Object[] name3 = nameList3.values().toArray(new Object[0]);
        Object[] age3 = ageList3.values().toArray(new Object[0]);
        Object[] number3 = mobileNum3.values().toArray(new Object[0]);
        Object[] address3 = addresses3.values().toArray(new Object[0]);
        Object[] pword3 = passList3.values().toArray(new Object[0]);
        Object[] dose3 = doseName3.values().toArray(new Object[0]);
        Object[] vacc3 = {};
        ArrayList<Object> adderc1 = new ArrayList<Object>(Arrays.asList(vacc3));
        Object[] vaccSite3 = {};
        ArrayList<Object> adderc2 = new ArrayList<Object>(Arrays.asList(vaccSite3));
        Object[] doc3 = {};
        ArrayList<Object> adderc3 = new ArrayList<Object>(Arrays.asList(doctor3));
        Object[] startDate3 = {};
        ArrayList<Object> adderc4 = new ArrayList<Object>(Arrays.asList(date3));
        Object[] endDate3 = {};
        ArrayList<Object> adderc5 = new ArrayList<Object>(Arrays.asList(date4));
    
        for (int r = 0; r < id3.length; r++){
         adderc1.add(vaccinator3);
         vacc3 = adderc1.toArray(vacc3);
         adderc2.add(vaccinationSite3);
         vaccSite3 = adderc2.toArray(vaccSite3);
         adderc3.add(doctor3);
         doc3 = adderc3.toArray(doc3);
         adderc4.add(date3);
         startDate3 = adderc4.toArray(startDate3);
         adderc5.add(date4);
         endDate3 = adderc5.toArray(endDate3);
        }
        //end of 1st booster to array

        //start ng 2nd booster to array
        Object[] id4 = nameList4.keySet().toArray(new Object[0]);
        Object[] name4 = nameList4.values().toArray(new Object[0]);
        Object[] age4 = ageList4.values().toArray(new Object[0]);
        Object[] number4 = mobileNum4.values().toArray(new Object[0]);
        Object[] address4 = addresses4.values().toArray(new Object[0]);
        Object[] pword4 = passList4.values().toArray(new Object[0]);
        Object[] dose4 = doseName4.values().toArray(new Object[0]);
        Object[] vacc4 = {};
        ArrayList<Object> adderd1 = new ArrayList<Object>(Arrays.asList(vacc4));
        Object[] vaccSite4 = {};
        ArrayList<Object> adderd2 = new ArrayList<Object>(Arrays.asList(vaccSite4));
        Object[] doc4 = {};
        ArrayList<Object> adderd3 = new ArrayList<Object>(Arrays.asList(doctor4));
        Object[] startDate4 = {};
        ArrayList<Object> adderd4 = new ArrayList<Object>(Arrays.asList(date4));
        Object[] endDate4 = {};
        ArrayList<Object> adderd5 = new ArrayList<Object>(Arrays.asList(date5));

        for (int r = 0; r < id4.length; r++){
         adderd1.add(vaccinator4);
         vacc4 = adderd1.toArray(vacc4);
         adderd2.add(vaccinationSite4);
         vaccSite4 = adderd2.toArray(vaccSite4);
         adderd3.add(doctor4);
         doc4 = adderd3.toArray(doc4);
         adderd4.add(date4);
         startDate4 = adderd4.toArray(startDate4);
         adderd5.add(date5);
         endDate4 = adderd5.toArray(endDate4);
        }
        //end ng 2nd booster to array

        //start of 3rd booster to array
        Object[] id5 = nameList5.keySet().toArray(new Object[0]);
        Object[] name5 = nameList5.values().toArray(new Object[0]);
        Object[] age5 = ageList5.values().toArray(new Object[0]);
        Object[] number5 = mobileNum5.values().toArray(new Object[0]);
        Object[] address5 = addresses5.values().toArray(new Object[0]);
        Object[] pword5 = passList5.values().toArray(new Object[0]);
        Object[] dose5 = doseName5.values().toArray(new Object[0]);
        Object[] vacc5 = {};
        ArrayList<Object> addere1 = new ArrayList<Object>(Arrays.asList(vacc5));
        Object[] vaccSite5 = {};
        ArrayList<Object> addere2 = new ArrayList<Object>(Arrays.asList(vaccSite5));
        Object[] doc5 = {};
        ArrayList<Object> addere3 = new ArrayList<Object>(Arrays.asList(doctor5));
        Object[] startDate5 = {};
        ArrayList<Object> addere4 = new ArrayList<Object>(Arrays.asList(date5));
  
        for (int r = 0; r < id5.length; r++){
        addere1.add(vaccinator5);
        vacc5 = addere1.toArray(vacc5);
        addere2.add(vaccinationSite5);
        vaccSite5 = addere2.toArray(vaccSite5);
        addere3.add(doctor5);
        doc5 = addere3.toArray(doc5);
        addere4.add(date5);
        startDate4 = adderd4.toArray(startDate5);
        }
        //end ng 3rd booster to array

        //start of dose 1
         for (int r = 0; r <= 0; r++){

			row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("RESERVATION - As of " + timeExport);
            categorycell.setCellStyle(fontstyle0);
            spreadsheet1.addMergedRegion(new CellRangeAddress(0,0,0,5));
		}
         for (int r = 1; r <= 1; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("ID");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : id1) {
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 2; r <= 2; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Name");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : name1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 3; r <= 3; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Age");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : age1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((Integer)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 4; r <= 4; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Contact Number");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : number1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 5; r <= 5; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Address");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : address1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 6; r <= 6; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Password");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : pword1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 7; r <= 7; r++){
 
             row = spreadsheet1.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Dose Requested");
             categorycell.setCellStyle(fontstyle1);
 
             for (Object excel : dose1){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 8; r <= 8; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccinator");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : vacc1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 9; r <= 9; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccination Site");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : vaccSite1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 10; r <= 10; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Doctor");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : doc1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 11; r <= 11; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Start of Vaccination");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : startDate1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 12; r <= 12; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Recommended Date of Return");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : endDate1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 13; r <= 13; r++){

            row = spreadsheet1.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Status");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : dose1){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
         //end of dose 1
         
        //start of dose 2
        for (int r = 0; r <= 0; r++){

            row = spreadsheet2.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("RESERVATION");
            categorycell.setCellStyle(fontstyle0);
            spreadsheet2.addMergedRegion(new CellRangeAddress(0,0,0,5));
        }
         for (int r = 1; r <= 1; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("ID");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : id2) {
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 2; r <= 2; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Name");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : name2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 3; r <= 3; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Age");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : age2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((Integer)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 4; r <= 4; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Contact Number");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : number2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 5; r <= 5; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Address");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : address2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 6; r <= 6; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Password");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : pword2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 7; r <= 7; r++){
        
             row = spreadsheet2.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Dose Requested");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : dose2){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 8; r <= 8; r++){
        
            row = spreadsheet2.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccinator");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vacc2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 9; r <= 9; r++){
        
            row = spreadsheet2.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccination Site");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vaccSite2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 10; r <= 10; r++){
        
            row = spreadsheet2.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Doctor");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : doc2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 11; r <= 11; r++){

            row = spreadsheet2.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Date of Reservation");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : startDate2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 12; r <= 12; r++){

            row = spreadsheet2.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Recommended DoR");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : endDate2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 13; r <= 13; r++){
        
            row = spreadsheet2.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Status");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : dose2){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
        //end of dose 2

        //start of 1st booster
        for (int r = 0; r <= 0; r++){

            row = spreadsheet3.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("RESERVATION");
            categorycell.setCellStyle(fontstyle0);
            spreadsheet3.addMergedRegion(new CellRangeAddress(0,0,0,5));
        }
         for (int r = 1; r <= 1; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("ID");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : id3) {
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 2; r <= 2; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Name");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : name3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 3; r <= 3; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Age");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : age3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((Integer)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 4; r <= 4; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Contact Number");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : number3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 5; r <= 5; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Address");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : address3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 6; r <= 6; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Password");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : pword3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 7; r <= 7; r++){
        
             row = spreadsheet3.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Dose Requested");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : dose3){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 8; r <= 8; r++){
        
            row = spreadsheet3.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccinator");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vacc3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 9; r <= 9; r++){
        
            row = spreadsheet3.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccination Site");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vaccSite3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 10; r <= 10; r++){
        
            row = spreadsheet3.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Doctor");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : doc3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 11; r <= 11; r++){

            row = spreadsheet3.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Date of Reservation");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : startDate3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 12; r <= 12; r++){

            row = spreadsheet3.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Recommended DoR");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : endDate3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 13; r <= 13; r++){
        
            row = spreadsheet3.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Status");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : dose3){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
        //end of 1st booster

        //start ng 2nd booster
        for (int r = 0; r <= 0; r++){

            row = spreadsheet4.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("RESERVATION");
            categorycell.setCellStyle(fontstyle0);
            spreadsheet4.addMergedRegion(new CellRangeAddress(0,0,0,5));
        }
         for (int r = 1; r <= 1; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("ID");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : id4) {
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 2; r <= 2; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Name");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : name4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 3; r <= 3; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Age");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : age4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((Integer)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 4; r <= 4; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Contact Number");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : number4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 5; r <= 5; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Address");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : address4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 6; r <= 6; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Password");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : pword4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 7; r <= 7; r++){
        
             row = spreadsheet4.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Dose Requested");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : dose4){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 8; r <= 8; r++){
        
            row = spreadsheet4.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccinator");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vacc4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 9; r <= 9; r++){
        
            row = spreadsheet4.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccination Site");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vaccSite4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 10; r <= 10; r++){
        
            row = spreadsheet4.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Doctor");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : doc4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 11; r <= 11; r++){

            row = spreadsheet4.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Date of Reservation");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : startDate4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 12; r <= 12; r++){

            row = spreadsheet4.createRow(r);
			int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Recommended DoR");
            categorycell.setCellStyle(fontstyle1);

            for (Object excel : endDate4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 13; r <= 13; r++){
        
            row = spreadsheet4.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Status");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : dose4){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
        //end ng 2nd booster

        //start ng 3rd booster
        for (int r = 0; r <= 0; r++){

            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("RESERVATION");
            categorycell.setCellStyle(fontstyle0);
            spreadsheet5.addMergedRegion(new CellRangeAddress(0,0,0,5));
        }
         for (int r = 1; r <= 1; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("ID");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : id5) {
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 2; r <= 2; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Name");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : name5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 3; r <= 3; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Age");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : age5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((Integer)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 4; r <= 4; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Contact Number");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : number5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 5; r <= 5; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Address");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : address5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 6; r <= 6; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Password");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : pword5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 7; r <= 7; r++){
        
             row = spreadsheet5.createRow(r);
             int cellid = 0;
             Cell categorycell = row.createCell(cellid++);
             categorycell.setCellValue("Dose Requested");
             categorycell.setCellStyle(fontstyle1);
        
             for (Object excel : dose5){
                 Cell cell = row.createCell(cellid++);
                 cell.setCellValue((String)excel);
                 cell.setCellStyle(fontstyle2);
             }
         }
         for (int r = 8; r <= 8; r++){
        
            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccinator");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vacc5){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 9; r <= 9; r++){
        
            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Vaccination Site");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : vaccSite5){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 10; r <= 10; r++){
        
            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Doctor");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : doc5){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)excel);
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 11; r <= 11; r++){
        
            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Recommended DoR");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : dose5){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
        for (int r = 12; r <= 12; r++){
        
            row = spreadsheet5.createRow(r);
            int cellid = 0;
            Cell categorycell = row.createCell(cellid++);
            categorycell.setCellValue("Status");
            categorycell.setCellStyle(fontstyle1);
        
            for (Object excel : dose5){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue("PENDING");
                cell.setCellStyle(fontstyle2);
            }
        }
        //end ng 3rd booster

        for (int i = 10; i <= 12; i++){
        Row rowDel1 = spreadsheet1.getRow(i);
        int lastColumn1 = rowDel1.getLastCellNum();
            for ( int c = id1.length + 1; c < lastColumn1; c++ ){
                Cell oldCell = rowDel1.getCell(c);
                if (oldCell != null ){
                    rowDel1.removeCell(oldCell);
                }
            }
        }
        for (int i = 10; i <= 12; i++){
            Row rowDel2 = spreadsheet2.getRow(i);
            int lastColumn2 = rowDel2.getLastCellNum();
            for ( int c = id1.length + 1; c < lastColumn2; c++ ){
                Cell oldCell = rowDel2.getCell(c);
                if (oldCell != null ){
                    rowDel2.removeCell(oldCell);
                }
            }
        }
        for (int i = 10; i <= 12; i++){
            Row rowDel3 = spreadsheet3.getRow(i);
            int lastColumn3 = rowDel3.getLastCellNum();
            for ( int c = id1.length + 1; c < lastColumn3; c++ ){
                Cell oldCell = rowDel3.getCell(c);
                if ( oldCell != null ){
                    rowDel3.removeCell(oldCell);
                }
            }
        }
        for (int i = 10; i <= 12; i++){
            Row rowDel4 = spreadsheet4.getRow(i);
            int lastColumn4 = rowDel4.getLastCellNum();
            for ( int c = id1.length + 1; c < lastColumn4; c++ ){
                Cell oldCell = rowDel4.getCell(c);
                if (oldCell != null ){
                    rowDel4.removeCell(oldCell);
                }
            }
        }
        for (int i = 10; i <= 12; i++){
            Row rowDel5 = spreadsheet5.getRow(i);
            int lastColumn5 = rowDel5.getLastCellNum();
            for ( int c = id1.length + 1; c < lastColumn5; c++ ){
                Cell oldCell = rowDel5.getCell(c);
                if (oldCell != null ){
                    rowDel5.removeCell(oldCell);
                }
            }
        }

        for (int sizer = 0; sizer <= patientLimit1; sizer++){
            spreadsheet1.autoSizeColumn(sizer);
        }
        for (int sizer = 0; sizer <= patientLimit2; sizer++){
           spreadsheet2.autoSizeColumn(sizer);
       }
       for (int sizer = 0; sizer <= patientLimit3; sizer++){
           spreadsheet3.autoSizeColumn(sizer);
       }
       for (int sizer = 0; sizer <= patientLimit4; sizer++){
           spreadsheet4.autoSizeColumn(sizer);
       }
       for (int sizer = 0; sizer <= patientLimit5; sizer++){
           spreadsheet5.autoSizeColumn(sizer);
       }

         FileOutputStream out = new FileOutputStream(new File("C:/Users/ink/Downloads/ExcelTests/ReserVacVaccinationList.xlsx"));
         workbook.write(out);
         out.close();
         workbook.close();
         System.out.print("\033[H\033[2J");
         System.out.flush();

         //deleter
         System.out.println("Exporting done.\nPress 1 to continue reservation and keep vaccinee information.\nPress 2 to delete all information and start a new vaccination area.\nPress 3 to delete all information and close the terminal.");
         int exportChoice = input.nextInt();
         while (exportChoice == 1 || exportChoice == 2 || exportChoice == 3){
            if (exportChoice == 1){
                Prompts.Prompt(patientLimit1,patientLimit2,patientLimit3,patientLimit4,patientLimit5,attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2,date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,  nameList3 , nameList4, nameList5, ageList1, ageList2,  ageList3 , ageList4, ageList5, mobileNum1,mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,addresses2,addresses3,addresses4,addresses5, IDs1,IDs2,IDs3,IDs4,IDs5, passList1, passList2, passList3,passList4, passList5, middleName1, middleName2, middleName3,middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,dateList2,dateList3,dateList4, dateList5, doseName1, doseName2,doseName3, doseName4, doseName5,0, true);
            }
            else if (exportChoice ==2){
                nameList1.clear();nameList2.clear();nameList3.clear();nameList4.clear();nameList5.clear();
                ageList1.clear();ageList2.clear();ageList3.clear();ageList4.clear();ageList5.clear();
                mobileNum1.clear();mobileNum2.clear();mobileNum3.clear();mobileNum4.clear();mobileNum5.clear();
                addresses1.clear();addresses2.clear();addresses3.clear();addresses4.clear();addresses5.clear();
                IDs1.clear();IDs2.clear();IDs3.clear();IDs4.clear();IDs5.clear();
                passList1.clear();passList2.clear();passList3.clear();passList4.clear();passList5.clear();
                middleName1.clear();middleName2.clear();middleName3.clear();middleName4.clear();middleName5.clear();
                timeList1.clear();timeList2.clear();timeList3.clear();timeList4.clear();timeList5.clear();
                dateList1.clear();dateList2.clear();dateList3.clear();dateList4.clear();dateList5.clear();
                doseName1.clear();doseName2.clear();doseName3.clear();doseName4.clear();doseName5.clear();
                Prompts.Prompt(patientLimit1,patientLimit2,patientLimit3,patientLimit4,patientLimit5,attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2,date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,  nameList3 , nameList4, nameList5, ageList1, ageList2,  ageList3 , ageList4, ageList5, mobileNum1,mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,addresses2,addresses3,addresses4,addresses5, IDs1,IDs2,IDs3,IDs4,IDs5, passList1, passList2, passList3,passList4, passList5, middleName1, middleName2, middleName3,middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,dateList2,dateList3,dateList4, dateList5, doseName1, doseName2,doseName3, doseName4, doseName5,0, true);
            }
            else if (exportChoice ==3){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("System shutting down. Thank you for using Reservac.");
                System.out.close();
                
            }
            else {
                System.out.println("Wrong input. Please try again with a numbers 1, 2, and 3 only.");
            }
        }
     }
     catch(IOException fnf){} 
    }
}
