#rotated sorted array A.find min element in A
A=[0,1,2,3,4,5,6,7]
#rotated by 1
A1=[7,0,1,2,3,4,5,6]

a=[3,4,5,6,7,0,1,2]
# find min=0 and index_min=5
if(a[0]<a[n-1]): #array not rotated
    return 0; #0th index is smallest

low=1
high=n-1
while(low<=high):
    mid=(low+high)//2
    if(a[mid-1]>a[mid]):
        return mid
    elif(a[0]>a[mid])
        high=mid-1
    else:
        low=mid+1
