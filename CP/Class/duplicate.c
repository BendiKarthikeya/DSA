//a[i] belong to [1,n-1] only one duplicate number 
// 1 duplicate
//sorted
//size=n

#include <stdio.h>

int main() {
    int n;
    printf("Enter number of elements in array: ");
    scanf("%d", &n);
    
    int a[n];
    printf("Enter the sorted array with one duplicate: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    int low = 0;
    int high = n - 1;
    int duplicate = -1; // Variable to store the duplicate element

    while(low <= high) {
        int mid = low + (high - low) / 2;
        if(mid == a[mid]){// When mid == a[mid], it means duplicate is in left or right
            duplicate = a[mid]; // Storing duplicate value
            break;
        }
        else if(a[mid]<mid){
        low=mid+1;
    }
    else{
        high=mid-1;
    }
    }

    if(duplicate != -1) {
        printf("The duplicate value is: %d\n", duplicate);
    } else {
        printf("No duplicate found.\n");
    }

    return 0;
}
