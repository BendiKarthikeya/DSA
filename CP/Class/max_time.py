'''
There are n tasks with i th task having A[i] difficultu . Divide there n tasks among K people
You can only give some consecutive task only to any person .minimize the maximum difficulty 
given to any individual
'''
def check(A,k,xf):
    p=1
    curr_sum=0
    for i in range(len(A)):
        if(A[i]>x):
            return False
        if(curr_sum+A[i]<=x):
            cur_sum+=A[i]
        else:
            p=p+1
            corr_sum=A[i]
    return p<=k
    
A=[12,34,54,90]
k=4
ans=-1
low=max(A)
high=sum(A)
while(low<=high):
    mid=(low+high)//2
    if(check(A,k,mid)):
        ans=mid
        high=mid-1
    else:
        low=mid+1
print(ans)
