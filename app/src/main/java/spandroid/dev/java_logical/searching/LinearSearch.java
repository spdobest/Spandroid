package spandroid.dev.java_logical.searching;

/**
 * Created by root on 6/2/18.
 */

public class LinearSearch {
    public static void main(String...args){
        LinearSearch linearSearch = new LinearSearch();

        int[] arr = {4,8,3,7,2,53,65,97,12,554,87,5,6,73,679,97};
        linearSearch.linearSearch(65,arr);
    }

    private void linearSearch(int searchedItem, int[] array){
        for(int i = 0;i<array.length;i++){
            if(array[i] == searchedItem){
                System.out.print("searched Position - "+i);
            }
        }
    }
}
