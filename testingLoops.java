public class testingLoops {
    public static void main(String[] args) {
        // for(int b = 0; b < 3; b++){
        //     System.out.println("Printing 3 times.");
        // }
        // boolean Condition = true;
        // if(Condition){
        //     System.out.println("Printing");
        // }
        var num1 = 12;
        var num2 = 12;

        if(num1 > num2 || num1 == 10){
            System.out.println("num1 is higher than num2! or num1 is 10.");
        } else if (num2 > num1 || num1 == 1){
            System.out.println("num2 is higher than num1! or num1 is 1.");
        } else {
            System.out.println("None of the conditions apply.");
        }

    }
}
