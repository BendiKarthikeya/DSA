/*'''Question :
            Number of subarrays with sum>k
'''
#A=2,3,7,21,94
#k=10
#subarray=contiunous segment of arrays*/

//time complexity is nlog(n)
int j=0;
int ans=0;

for(i=0;i<n;i++){
    curr=0;
    for(j=i;j<n;j++){
        curr+=a[j];
        if(curr>sum){
            ans+=n-j;
            break;
        }
    }
}
cout << ans ;

//time complexity is n
/*int j=0;
int curr=0;
for(i=0;i<n;i++){
    for(;j<n;j++){
        curr+=a[j];
        if(curr>sum){
            ans+=n-j;
            curr-=a[i]
            break;
        }
    }
}
cout << ans ;*/
