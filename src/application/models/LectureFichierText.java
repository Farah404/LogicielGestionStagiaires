package application.models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectureFichierText {

    public static void main(String[] args) throws Exception {
	InputStream is = new FileInputStream("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_CDA17_Projet1\\STAGIAIRES.DON");
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader buffer = new BufferedReader(isr);
	        
	    String line = buffer.readLine();
	    StringBuilder builder = new StringBuilder();
	        
	    while(line != null){
	       builder.append(line).append("\n");
	       line = buffer.readLine();
	    }
	        
	    String str = builder.toString();
	    System.out.println(str);


    }

}
