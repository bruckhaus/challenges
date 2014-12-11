public class Infinity {

    //    Application Development
    //
    //    Java
    //    What is the result when one tries to compile and run the following code?
    //
    //    public final static void main(String[] args){
    //        double d = 10.0 / -0;
    //        if(d == Double.POSITIVE_INFINITY)
    //            System.out.println("Positive infinity");
    //        else
    //            System.out.println("Negative infinity");
    //    }
    //    Positive infinity
    //    Negative infinity
    //    Will fail to compile
    //    Runtime exception

    public final static String double_infinity() {
        double d = 10.0 / -0;
        if (d == Double.POSITIVE_INFINITY)
            return "Positive infinity";
        else
            return "Negative infinity";
    }

    public static void main(String[] args) {
        String result = Infinity.double_infinity();
        System.out.println("The result of calculating '10.0 / -0' is: " + result);
    }

}
