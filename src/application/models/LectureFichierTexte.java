//package application.models;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class LectureFichierTexte {
//    public static boolean isNumeric(String strNum) {
//        if (strNum == null) {
//            return false;
//        }
//        try {
//            int d = Integer.parseInt(strNum);
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//    public static void main(String[] args) {
//        
//        List<Stagiaire> listDesStagiaires = new ArrayList<Stagiaire>();
//        int lineNumber = 1;
//        
//        try {
//            File mondoc = new File("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_CDA17_Projet1\\src\\application\\STAGIAIRES.DON");
//          Scanner myReader = new Scanner(mondoc);
//            String line;
//            Stagiaire stagiaire = new Stagiaire();
//            while (myReader.hasNextLine()) {
//                line = myReader.nextLine();
//                
//                if (lineNumber % 6 == 1) {
//                    stagiaire.setNom(line);
//                     
//                } else if (lineNumber % 6 == 2) {
//                    stagiaire.setPrenom(line);
//                }
//                if (lineNumber % 6 == 3) {
//                    if (line != null && !line.isEmpty() && isNumeric(line) == true) {
//                        stagiaire.setDepartement((line));
//                    }
//                }
//                if (lineNumber % 6 == 4) {
//                    stagiaire.setPromotion(line);
//                }
//                if (lineNumber % 6 == 5){
//                    if (line != null && !line.isEmpty() && isNumeric(line) == true) {
//                        stagiaire.setAnnee((line));
//                    }
//                }
//                if (lineNumber % 6 == 0) {
//                    listDesStagiaires.add(stagiaire);
//                    stagiaire = new Stagiaire();
//                }
//                
//                lineNumber += 1;
//                
//            }
//            myReader.close();
//            
//            for (Stagiaire s : listDesStagiaires) {
//                System.out.println(s.toString());
//        }
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println(listDesStagiaires);
//}
//    
//    }
//
//// //Reading the file using Buffer reader
//    
////    public static void main(String[] args) throws Exception
////    {	
////	//file Path
////	File file = new File(
////		"C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_CDA17_Projet1\\src\\application\\STAGIAIRES.DON");
////
////	// Creating an object of BufferedReader class
////	BufferedReader br= new BufferedReader(new FileReader(file));
////
////	// Declaring a string variable
////	String stgrDetails;
////
////	// Condition holds true till
////	// there is character in a string
////	while ((stgrDetails = br.readLine()) != null)
////	    // Print the string
////	    System.out.println(stgrDetails);
////    }
//    
//    //Reading the file into a list
////    public static List<String> lectureFichierEnListe(String fileName)
////    {
////	List<String> lines = Collections.emptyList();
////	   try
////	    {
////	      lines =
////	       Files.readAllLines(Paths.get(fileName), StandardCharsets.ISO_8859_1);
////	    }
////	 
////	    catch (IOException e)
////	    {
////
////	      e.printStackTrace();
////	    }
////	   return lines;
////    }
////    public static void main(String[] args)
////    {
////      List stgrDetails = lectureFichierEnListe("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_CDA17_Projet1\\src\\application\\STAGIAIRES.DON");
////   
////      Iterator<String> itr = stgrDetails.iterator();
////      while (itr.hasNext())
////        System.out.println(itr.next());
////		
////    }
//
//
