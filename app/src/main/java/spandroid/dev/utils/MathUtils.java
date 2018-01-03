package spandroid.dev.utils;


public class MathUtils {


    public static int roundUp(double value) {

        return (int) Math.round(value);

    }

    public static float convertInterestRate(float rate) {

        if (rate != 0) {
            rate = rate + 500;
            float result = rate / 100;
            return result;
        }

        return 0;
    }

    public static double getInterestRate(float rate) {

        if (rate != 0) {
            float result = rate * 100;
            float convertedRate = result - 500;
            return convertedRate;
        }

        return 0;
    }


    //____________________________________ Home Affordability Calculations - Start ____________________________________________________

    public static float getMaxEMI(float salaryEmiRatio, float monthlyIncome, float existingObligations) {

        return ((salaryEmiRatio / 100) * (monthlyIncome - existingObligations));

    }

    public static double getPresentValue(double rate, double nper, double pmt) {

        return pmt / rate * (1 - Math.pow(1 + rate, -nper));

    }

    public static double getLoanPrincipal(double rateInPercent, double npr, double maxEmi) {

        double percentRate = rateInPercent / 100;

        double actualRate = percentRate / 12;

        double actualNper = npr * 12;

        return getPresentValue(actualRate, actualNper, maxEmi);

    }

    public static double getHomePrice(double ltvInPercent, double loanPrincipal) {

        double actualLTV = ltvInPercent / 100;

        return (1 / actualLTV) * loanPrincipal;
    }

    public static double getDownPayment(double ltvInPercent, double homePrice) {

        double actualLTV = ltvInPercent / 100;

        return (1 - actualLTV) * homePrice;
    }

    //____________________________________ Home Affordability Calculations - End ____________________________________________________


    //____________________________________ Child Education Calculations - Start ____________________________________________________

    public static double getGraduationCost(double costOfGraduation, double inflation, double noOfYearsTillGraduation) {

        return (costOfGraduation * Math.pow(1 + (inflation / 100), noOfYearsTillGraduation));
    }

    public static double getPostGraduationCost(double costOfPostGraduation, double inflation, double noOfYearsTillPostGraduation) {

        return (costOfPostGraduation * Math.pow(1 + (inflation / 100), noOfYearsTillPostGraduation));
    }

    //____________________________________ Child Education Calculations - End ____________________________________________________
}
