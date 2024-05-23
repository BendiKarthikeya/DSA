#include<stdio.h>
int main(){
    int n;
    printf("Enter number of elements in array");
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
}
//7,9,12,15,13,12,5,3,1,-2