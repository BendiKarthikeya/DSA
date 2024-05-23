#Bitonic array ,find Max Element
# a[0]<a[1]<.......<a[ind]>a[ind+1]>.....>....>...
#timr compleity log[n]
a=[1,4,10,8,6,2]
low=1
high=len(a)-2
while(low<=high):
    mid=(low+high)//2
    if(a[mid-1]<a[mid] and a[mid]>a[mid+1]):
        return mid 
    elif(a[mid-1]<a[mid] and a[mid]<a[mid+1]):
        low=mid+1
    else:
        high=mid-1
