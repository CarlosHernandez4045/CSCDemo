package CSC110Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DocProjDraft {
// criteria for the given file: must contain 8 data elements seperated by a comma.
    public static void main(String[] args) throws IOException {
        aggregateData();
    }
    public static void aggregateData() throws IOException{
        //standard reading/getting the file + establishing different data structures we'll use later
        String fileName = "D:\\Documents\\NewVSWorkspace\\CSC110Project\\W7DataFile.csv";
        var filePath = Paths.get(fileName);
        var userList = new ArrayList<>();
        var badDataList = new ArrayList<>();
        var goodDataList = new ArrayList<>();
        //defensive programming
        if(!Files.exists(filePath)){
            System.out.println("The selected file could not be found, please check filePath and try again.");
        }
        var reader = Files.newBufferedReader(filePath);
        var lineData = reader.readLine();
        //storing all Lines of data into the ArrayList
        while (lineData != null) {
            lineData = reader.readLine();
            if (lineData != null) {
                userList.add(lineData);
            }
        }
        var currentLineNumber = 2; //header has been skipped, so we use 1+1 in order to get a line number counter
        for (var userData : userList){
            var dataElement = ((String) userData).split(",");
            userData = capitalizeWord((String) userData); //method call capitalizeWord method and pass the argument userData casted in order to capitalize every word
            if (dataElement.length == 8){ //if else statement makes a choice based on if our line has 8 data elements or not
                goodDataList.add(userData);
            } else {
                badDataList.add("Line number " +currentLineNumber +". "+ userData);
            }
            currentLineNumber++;
        }
        //GoodData output section
        var outFileName = "D:\\Documents\\NewVSWorkspace\\CSC110Project\\GoodData.txt";        
        var outFilePath = Paths.get(outFileName);   
        var writeStream = Files.newBufferedWriter(outFilePath);
        for (var goodUserData : goodDataList) {  
            var splitDataLine = ((String) goodUserData).split(",");
            writeStream.write(splitDataLine[0]+"|"+splitDataLine[1]+"|"+splitDataLine[2]+splitDataLine[3]+"|"+ splitDataLine[4]+splitDataLine[5]+"|"+splitDataLine[6]+"|"+splitDataLine[7]);  
            writeStream.newLine();       
         }  
         System.out.println("The GoodData file was created successfully."); 
         writeStream.close();
        badDataReporter(badDataList); //methodcall badDataReporter to do the bad data part
    }

    public static void badDataReporter(ArrayList<Object> badDataList) throws IOException{
        var outFileName = "D:\\Documents\\NewVSWorkspace\\CSC110Project\\BadData.txt";        
        var outFilePath = Paths.get(outFileName);   
        var writeStream = Files.newBufferedWriter(outFilePath);
        for (var badUserData : badDataList) {  
            writeStream.write("Line that did not meet the 8 data element requirement: "+badUserData);  
            writeStream.newLine();  
         }   
         System.out.println("The BadData file was created successfully.");
         writeStream.close();
    }
    //create a small program to capitalize every word in the string/userdata
    public static String capitalizeWord(String userData) {
        String[] words = userData.split("\\s"); //splits the data by whitespace characters
        String capitalizeWord = "";
        for(String Word: words){
            String firstChar = Word.substring(0,1);
            String afterFirstChar = Word.substring(1);
            capitalizeWord+=firstChar.toUpperCase()+afterFirstChar+" "; //capitalizes the chars needed before reassembling them into words in string again

        }
        return capitalizeWord.trim(); //retun string
        
    }
        
}
