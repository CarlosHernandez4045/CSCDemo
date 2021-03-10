package Week8ClassAssignment;

public class Logics {

    public static void main(String[] args){
        var a = true;
        var b = false;
        var c = true; 
        var name = "Y";
        
        if (a && b || c){
            name = "X";
            System.out.println("What happened");
        }else{
            name = "Y";
            System.out.println("Did not expect");
        }
        var temp = -5;
        //cold // hot // very hot // below Zero 
        boolean cold = temp < 40 && temp > 0;
        boolean hot = temp > 40; 
        boolean veryHot = temp >= 100;
        boolean belowZero = temp < 0;

        var T = "W";
        if(cold){
            T = "cold";
        } else if(hot){
            T = "hot";
        } else if(veryHot){
            T = "veryHot";
        } else if(belowZero){
            T = "belowZero";
        }

        switch(T){

            case "cold":
                System.out.println("it is cold");
                break;
            case "hot":
                System.out.println("it is hot");
                break;
            case "veryHot":
                System.out.println("It is very hot");
                break;
            case "belowZero":
                System.out.println("It is below zero");
                break;
            default:
                System.out.println("Well I do not know");
                break;

        }

        var isTrue = true;
        var val = 10; 
        do{
            System.out.println("Select a range value");
            if(val >= 100){
                isTrue = false;
            }
            val = val + 10;
        }while (isTrue);
    }
    
}
