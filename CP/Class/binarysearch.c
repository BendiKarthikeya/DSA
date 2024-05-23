#include<stdio.h>
int main(){
    int n;
    printf("Enter number of elements in array");
    scanf("%d",&n);
    int target;
    printf("Enter the target number");
    scanf("%d",&target);
    int a[n];
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    int low=0;
    int mid;
    int high=n-1;
    while(low<=high){
         mid=(low+high)/2;
    if(target==a[mid]){
        break;
    }
    else if(a[mid]<=target){
        low=mid+1;
    }
    else{
        high=mid-1;
    }
    }
printf("the target index is %d",mid);
}
