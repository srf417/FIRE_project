import java.util.Scanner;

public class FIRE {
    static double prin;
    static double year;
    static double roi;
    static double cont;
    static double target;
    static String fr;
    static double factor;

    public static double endBalance(double prin, double year, double roi, double factor, double cont) {
        return prin * Math.pow((1 + (roi / factor)), year * factor) + ((cont) * Math.pow((1 + (roi / factor)), year * factor) - (cont)) / (roi / factor);
    }

    public static int setFreq(String freq) {
        if (freq.startsWith("m") || freq.startsWith("M")) {
            return 12;
        } else {
            return 1;
        }
    }

    public static double term(double prin, double target, double roi, double factor, double cont) {
        return 0;
    }

    public static double minCont(double prin, double target, double roi, double factor, double year) {
        return 0;
    }

    public static double perc(double roi) {
        return roi / 100;
    }

    public static double roundMoney(double vald) {
        vald = vald * 100;
        int vali = (int) vald;
        double valdn = (double) vali;
        return valdn / 100;
    }

    public static void main(String[] args) {
        String play = "yes";
        String path = "";
        Scanner input = new Scanner(System.in);

        while (play.startsWith("y") || play.startsWith("Y")) {
            System.out.println("Welcome to the F.I.R.E. financial calculator. Which of the following financial figures would you like to calculate?");
            System.out.println();
            System.out.println("Enter either one of the below 3 letters on your keyboard to select an option:");
            System.out.println("(A) Ending balance of an investment.");
            System.out.println("(B) Time needed to get to your desired balance based on your current investing routine.");
            System.out.println("(C) Additional contribution needed to achieve desired balance at either a monthly or annual rate.");
            path = input.next();

            if (path.equalsIgnoreCase("a")) {

                System.out.println("To derive your ending balance, enter the below information:");
                System.out.println();
                System.out.println("Starting Balance?");
                prin = input.nextDouble();

                System.out.println("Number of years you expect to invest?");
                year = StdIn.readDouble();

                System.out.println("Expected yearly rate of return on investment as a percentage?");
                roi = perc(StdIn.readDouble());

                System.out.println("Do you contribute monthly or annually?");
                fr = StdIn.readString();
                factor = setFreq(fr);

                System.out.println("How much do you contribute at this rate?");
                cont = StdIn.readDouble();

                double end = endBalance(prin, year, roi, factor, cont);
                end = roundMoney(end);
                System.out.println("Ending balance: $" + end);


            } else if (path.equalsIgnoreCase("b")) {
                System.out.println("To derive the term of your investment, enter the below information");
                System.out.println();
                System.out.println("Starting Balance?");
                prin = input.nextDouble();

                System.out.println("Target Balance?");
                target = input.nextDouble();

                System.out.println("Expected yearly rate of return on investment as a percentage?");
                roi = perc(input.nextDouble());

                System.out.println("Do you contribute monthly or annually?");
                factor = setFreq(input.next());

                System.out.println("How much do you contribute at this rate?");
                cont = input.nextDouble();

                double time = term(prin, target, roi, factor, cont);
                System.out.println("To accrue to $" + target + ", you must maintain this regiment for " + time + " years.");
            } else if (path.equalsIgnoreCase("c")) {
                System.out.println("To derive your minimum contribution, enter the below information");
                System.out.println();

                System.out.println("Would you contribute monthly or annually?");
                factor = setFreq(input.next());
                String textRate = "";
                if (factor == 1) {
                    textRate += "year";
                } else {
                    textRate += "month";
                }

                System.out.println("Starting Balance?");
                prin = input.nextDouble();

                System.out.println("Target Balance?");
                target = input.nextDouble();

                System.out.println("In how many years would you like this target balance achieved?");
                year = StdIn.readDouble();

                System.out.println("Expected yearly rate of return on investment as a percentage?");
                roi = perc(input.nextDouble());

                cont = minCont(prin, target, roi, factor, year);
                System.out.println("To acquire $" + target + " in " + year + " years, you will need to contribute $" + cont + " per " + textRate + ".");

            } else {
                System.out.println("ERROR: Invalid Input, you genius.");
            }
            input.nextLine();
            System.out.println("Would you like to calculate anything else or test a different investing regiment? (yes/no)");
            play = input.nextLine();

        }
        System.out.println("Thank you for using this service.");
    }


}
