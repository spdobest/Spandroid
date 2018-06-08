package spandroid.dev.java_logical.searching;

/**
 * Created by root on 6/2/18.
 */

public class BinarySearch {
    public static void main(String...args){
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length/ 1;
        int x = 10;
        int result = binarySearch.binarySearch(arr, 0, n-1, x);
        System.out.print("Searched Value Position = "+result);
    }

    int binarySearch(int arr[], int firstElement, int lastPosition, int searchedItem) {

        if (lastPosition >= firstElement) {
            int middleItem = firstElement + (lastPosition - firstElement)/2;
            // If the element is present at the middle
            // itself
            if (arr[middleItem] == searchedItem)
                return middleItem;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[middleItem] > searchedItem)
                return binarySearch(arr, firstElement, middleItem-1, searchedItem);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, middleItem+1, lastPosition, searchedItem);
        }
        // We reach here when element is not
        // present in array
        return -1;
    }
}
