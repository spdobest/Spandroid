package spandroid.dev.java_logical;

/**
 * Created by root on 6/1/18.
 */

public class TimeComplexity {

    public static void main(String...args){
        TimeComplexity timeComplexity = new TimeComplexity();
        timeComplexity.findPrimeNUmber1();

        System.out.print("=============================");
        timeComplexity.findPrimeNUmber2();

    }

    private void findPrimeNUmber1(){
        int count = 0;
        for(int i = 2;i<100;i++){
            count = 0;
            for(int j = 1;j<i;j++){
                if(i%j == 0){
                    count++;
                }
            }
            if(count<=1){
                System.out.println(i);
            }
        }
    }

    private void findPrimeNUmber2(){
        int count = 0;
        for(int i = 2;i<100;i++){
            count = 0;
            for(int j = 1;j<=Math.sqrt(i);j++){
                if(i%j == 0){
                    count++;
                }
            }
            if(count<=1){
                System.out.println(i);
            }
        }
    }
}
