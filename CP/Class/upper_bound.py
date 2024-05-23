def ubnd(A,x):
    low=0
    high=len(A)-1
    ans=len(A)
    while(low<=high):
        mid=(low+high)//2
        if(A[mid]<x):
            low=mid+1
            ans=mid
        elif(A[mid]>x):
            high=mid-1
        else:
            ans=mid
            
    