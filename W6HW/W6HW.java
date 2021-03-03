package W6HW;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class W6HW {

    private static final String fileUsed = "D:\\Documents\\SAMPLE_WORKSPACE\\W6HW\\Sample100.csv"; //INPUT CSV FILE HERE


    public static void main(String[] args) throws IOException {
        var getselection = getUserInput();
        var result = processInput((String) getselection);
    }

    private static Long processInput(String method) throws IOException {
        if (!isValid.isValid(method)) {
            System.out.println(isValid.RED + "Error, please check input and try again" + isValid.RESET);
        }

        switch (method) {
            case "SUM":
                return sumData();
            case "AVERAGE":
                return avgData();
            case "COUNT":
                return countData();
            default:
                throw new IllegalArgumentException("Invalid method inputted: " + method);
        }

    }

    private static String getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println(isValid.GREEN + "change Split[?] to change what csv value is evaluated in this program."
                + isValid.RESET);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Choose type: SUM, AVERAGE, COUNT"); // display user interface
        String method = scan.nextLine();
        return method;
    }

    public static Long countData() throws IOException {
        var fileName = W6HW.fileUsed;
        var filePath = Paths.get(fileName);

        var userArrayList = new ArrayList<String>();

        // Defensive Programming Section
        if (!Files.exists(filePath)) {
            System.out.println("Error 4076: Could not find the file in the path " + fileName);
            return null;
        }
        System.out.println("Success: File found, executing program");
        var bufferReader = Files.newBufferedReader(filePath);
        var SLineData = bufferReader.readLine();

        while (SLineData != null) {
            SLineData = bufferReader.readLine();
            if (SLineData != null) {
                bufferReader.readLine();
                userArrayList.add(SLineData);
            }
        }
        long count = Files.lines(filePath).count();
        System.out.println("Total Count of Lines in Data: " + isValid.YELLOW + count + isValid.RESET);

        bufferReader.close();
        return count;
    }

    public static Long sumData() throws IOException {
        var fileName = W6HW.fileUsed;
        var filePath = Paths.get(fileName);

        var userArrayList = new ArrayList<String>();

        //Defensive Programming Section
        if(!Files.exists(filePath)){		
			System.out.println("Error 4076: Could not find the file in the path "+ fileName); 
			return null;
		}	
        System.out.println("Success: File found, executing program");
        var bufferReader = Files.newBufferedReader(filePath);
        var SLineData = bufferReader.readLine();

        while(SLineData !=null){
            SLineData = bufferReader.readLine();
            if(SLineData !=null){
                bufferReader.readLine();
                userArrayList.add(SLineData);
            }
        }
        var sumValue = 0.00; 
        var Value = 0.00;

        for (var userData : userArrayList) {
            try {
            var split = userData.split(",");
             Value = Long.parseLong(split[0]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            sumValue = sumValue + Value;
            System.out.println(sumValue);
        }
        var finalSum = sumValue/1;

        System.out.println("The sum for this data set is: " + isValid.YELLOW + finalSum + isValid.RESET);

        bufferReader.close();
        return null;
    }

    public static Long avgData() throws IOException{
        var fileName = W6HW.fileUsed; //
        var filePath = Paths.get(fileName);

        var userArrayList = new ArrayList<String>();

        //Defensive Programming Section
        if(!Files.exists(filePath)){		
			System.out.println("Error 4076: Could not find the file in the path "+ fileName); 
			return null;
		}	
        System.out.println("Success: File found, executing program");
        var bufferReader = Files.newBufferedReader(filePath);
        var SLineData = bufferReader.readLine();

        while(SLineData !=null){
            SLineData = bufferReader.readLine();
            if(SLineData !=null){
                bufferReader.readLine();
                userArrayList.add(SLineData);
            }
        }
        var sumValue = 0.00; 
        var Value = 0.00;
        var average = 0.00;
        var totalValue =0;

        for (var userData : userArrayList) {
            try {
            var split = userData.split(",");
             Value = Long.parseLong(split[0]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            sumValue = sumValue + Value;
            System.out.println(sumValue);
            totalValue++;
        }   
        
        average = sumValue/totalValue;

        System.out.println("The average for the data set is: "+ isValid.YELLOW+ average+ isValid.RESET);

        bufferReader.close();
        return null;
    }
}
