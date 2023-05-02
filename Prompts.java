import java.util.*;
 
// FOR POLYMORPHISM AND INHERITANCE

    class message1 {
        public void Notif() {
            System.out.println("\u001B[31mThere is no current vaccine schedule set by the admin.");
        }
    }
    class message2 extends message1 {
        public void Notif() {
            System.out.println("\u001B[32mAll of the vaccine types had been set by the admin.");
        }
    }
    
public class Prompts{
      // Encapsulation
      private static String passWord  = "1234";
    

      public void setPassword(String p){ 
        this.passWord = p;
      }
  
      public static String getPassWord(){
        return passWord;//Returning the password afterwards.
     }
    
    public static void Prompt( 
        int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
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
        int choice, boolean setReserve)

        {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //POLYMORPHISM
      

        if (patientLimit1 == 0 || patientLimit2 == 0 || patientLimit3 == 0 || patientLimit4 == 0 || patientLimit5 == 0 || doctor1 == null || doctor2 == null || doctor3 == null 
        || doctor4 == null || doctor5 == null || vaccinationSite1 == null || vaccinationSite2 == null || vaccinationSite3 == null  || vaccinationSite4 == null 
         || vaccinationSite5 == null  || vaccinator1 == null || vaccinator2 == null || vaccinator3 == null || vaccinator4 == null || vaccinator5 == null || date1 == null 
        || date2 == null || date3  == null || date4== null || date5== null || start1 == null || start2 == null || start3 == null || start4 == null || start5 == null 
        || end1 == null || end2 == null || end3 == null || end4== null || end5 == null) {
        message1 msg1 = new message1();
        msg1.Notif();
        }

        else  {
        message2 msg2 = new message2();
        msg2.Notif();
        }
        System.out.println( "\u001B[35m█████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ COVID VACCINATION SYSTEM ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out.println("\u001B[36m\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ █");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t    ▀▀▀▀▀▀▀▀▄─█─█─█─█─█─█──█▀█");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t     ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀ ▀\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t     DEVELOPED BY:");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Jeon Drew C. Jaime");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tCharles Daniel M. Nolasco");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tMarc Michael D. Malgapo");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   Gian Dale A. Lim\n");
        System.out.println( "\u001B[35m██████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ OPTIONS ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out.println("\u001B[36m1 - LOGIN AS ADMIN\n2 - LOGIN AS USER");
        while  (true){
          try {
            System.out.print("\u001B[36mEnter the number of your chosen option: \u001B[37m" );
            choice = input.nextInt();
        
            if (choice == 1){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Admin(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
      
            }
        
            else if (choice == 2) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                User(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
            }

            else {
                System.out.println("\u001B[31mInvalid input! Please try agein and  enter a number either 1 or 2.");   
            }
        }

        catch (InputMismatchException ex) {  
            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
            input.nextLine();
           }  
    }
}

    public static void Admin(
        int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
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

        
        while (true) {
            System.out.print("\u001B[36mEnter your Password: \u001B[37m");
            String Password = input.next();
            if (Password.equals(getPassWord())){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       \u001B[33m█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█");
                System.out.println("\u001B[35m███████████████████████████████████████████████████████████████████████████████████████████████████████████████\u001B[33m█░░║║║╠─║─║─║║║║║╠─░░█\u001B[35m█████████████████████████████████████████████████████████████████████████████████████████████████████████████\u001B[33m");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █▄▄▄▄▄▄ ADMIN ▄▄▄▄▄▄▄█");
        System.out.println("\u001B[36m1 - Set Reservation \n2 - Check Reservation\n3 - Edit Reservation details\n4 - Cancel Reservation\n5 - Change Password\n6 - Export Reservation lists");
        while (true){ 
            try{
                System.out.print("\u001B[36mEnter the number of your chosen option(Enter number 7 and press enter to go back.): \u001B[37m" );
                choice = input.nextInt();
            if (choice == 1){
               System.out.print("\033[H\033[2J");
               System.out.flush();
               imp.SetReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
               break;
            }
            
            else if (choice == 2 ) {
              System.out.print("\033[H\033[2J");
              System.out.flush();
              imp.CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
            }
    
            else if (choice == 3 ) {
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                imp.EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
            }
    
            else if (choice == 4) {
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                imp.RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
                break;
            }
    
            else if (choice == 5) {
                System.out.print("\033[H\033[2J");
                System.out.flush();       
                while (true){
                    try{
                        Prompts pr = new Prompts();
                        System.out.print("Enter your current password: ");
                        String pashpash = input.next();
                        if(pashpash.equals(getPassWord())){
                            System.out.print("Type your new password: ");   
                            String newPassword = input.next();
                            pr.setPassword(newPassword);
                            System.out.println("Your Admin password is now change into: " + getPassWord());
                            while (true){
                                try {
                                System.out.print("\u001B[36mEnter 1 and press enter to exit: \u001B[0m");
                                choice = input.nextInt();
                                 if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();;   
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
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
                        else{
                            System.out.println("\u001B[31mWrong input password, try again!\u001B[0m");
                        }
                    }
                    catch(InputMismatchException ex){
                        System.out.println("\u001B[31mInvalid input! Please enter a number and try again213123123.");    
                        input.nextLine();
                        break;

                    }
                  
    }
    }
    
            else if (choice == 6) {
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                imp.ExportList(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
                break;
            }
            else if(choice == 7){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
         
            else {
                System.out.println("\u001B[31mInvalid input! Please try agein and  enter a number from 1 to 7.");   
            }
        }
            catch (InputMismatchException ex) {  
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
                input.nextLine();
               }  
          }
          System.out.println("\u001B[31mInvalid input! Please try agein and  enter a number from 1 to 6.");   
       }

                  else {
                System.out.println("\u001B[31mInvalid password! Please try again.");    
            }
        }
    }

    public static void User(int patientLimit1, int patientLimit2, int patientLimit3, int  patientLimit4, int patientLimit5,
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
       
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       \u001B[33m█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█");
        System.out.println("\u001B[35m███████████████████████████████████████████████████████████████████████████████████████████████████████████████\u001B[33m█░░║║║╠─║─║─║║║║║╠─░░█\u001B[35m█████████████████████████████████████████████████████████████████████████████████████████████████████████████\u001B[33m");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t       █▄▄▄▄▄▄▄ USER ▄▄▄▄▄▄▄█");
        System.out.println("\u001B[36m1 - Reserve \n2 - Check Reservation\n3 - Edit Reservation details\n4 - Cancel Reservation\n5 - Account Recovery");
        while (true){ 
        try{
            System.out.print("\u001B[36mEnter the number of your chosen option (Enter number 6 and press enter to go back): \u001B[37m" );
            choice = input.nextInt();
        if (choice == 1 ){
           System.out.print("\033[H\033[2J");
           System.out.flush();
           imp.Register(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
           break;
        }

        else if (choice == 2 ) {
          System.out.print("\033[H\033[2J");
          System.out.flush();
          imp.CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
        }

        else if (choice == 3 ) {
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
            imp.EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);    break;
        }

        else if (choice == 4) {
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
            imp.RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);
        }

        else if (choice == 5) {
            imp.forgotPassword(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice, setReserve);       }

            else if(choice == 6){
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, false);
                }    
         
        else {
            System.out.println("\u001B[31mInvalid input! Please try agein and  enter a number from 1 to 6.");   
        }
    }
        catch (InputMismatchException ex) {  
            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");    
            input.nextLine();
           }  
      }
      System.out.println("\u001B[31mInvalid input! Please try agein and  enter a number from 1 to 6.");   
   }
}

