# find the lower bound of x in A
def lbnd(A,x):
    low=0
    high=len(A)-1
    ans=len(A)
    while(low<=high):
        mid=(low+high)//2
        if(A[mid]<x):
            low=mid+1
        elif(A[mid]>=x):
            high=mid-1
            ans=mid
        else:
            ans=mid
            high=mid-1
    return ans
A=[1,2,3,4,4,4,5,6,7]
x=4
print(lbnd(A,x))
