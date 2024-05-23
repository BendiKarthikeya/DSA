/*'''Given there A=110010101 is a binary array
k=1 it is the number of changes we can do in binary array like 1 to 0 or 0 to 1
'''
#find max possible length of a subarray with only 1's*/
for(int i=0;i<n;i++){
    opr=0;
    for(j=i;j<n;j++){
        if(a[j]==0){
            opr++;                      //time complexity is n square
        }
        if(opr<=k){
            ans=max(ans,j-i+1);
        }
        if(a[i]==0) opr--;
        else{
            if(a[i]==0) opr--;
            break;
        }
        
    }
}

//....................................
j=0;
for(int i=0;i<n;i++){
    opr=0;
    for(;j<n;j++){
        if(a[j]==0){
            opr++;                      //time complexity is n 
        }
        if(opr<=k){
            ans=max(ans,j-i+1);
        }
        else{
            if(a[i]==0) opr--;
            break;
        }
        
    }
}