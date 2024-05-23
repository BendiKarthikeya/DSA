// #include<stdio.h>
// int main(){
//     int n;
//     scanf("%d",&n);
//     for(int i=1;i<=n/2;i++){
//         if(n<i*i){
//             printf("%d",i-1);
//             break;
//         }
//     }
// }
#include<stdio.h>
int main(){
    int n,mid,ans=-1;
     scanf("%d",&n);
     int low=1;
     int high=n;
     while(low<=high){
        mid=(low+high)/2;
if(mid*mid<=n){
    ans=mid;
    low=mid+1;
}
else{
    high=mid-1;
}
     }
     printf("%d",ans);
}