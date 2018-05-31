package spandroid.dev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/25/18.
 */

public class MyTest {
    public static void main(String...args){

        List<MySCheme> listAMt = new ArrayList<>();
        listAMt.add(new MySCheme(5000,1));
        listAMt.add(new MySCheme(500,500));
        listAMt.add(new MySCheme(500,500));


    }

    private void distributeAmount(long totalAMount,List<MySCheme> listAMt){

        for(MySCheme mySCheme : listAMt){

        }

    }



}

class MySCheme{
    public MySCheme(int amount, int amountMin) {
        this.amount = amount;
        this.amountMin = amountMin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(int amountMin) {
        this.amountMin = amountMin;
    }

    int amount;
    int amountMin;

}
