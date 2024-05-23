'''find pair of indices in a sorted array such that sum of values at those indeices should
 be equal to k.
'''
k=int(input())
a=list(map(int,input().split()))
i=0
j=len(a)-1
while(i<j):
    if(a[i]+a[j]==k):
      print(i,j)
      break
    elif(a[i]+a[j]>k):
       j=j-1
    else:
       i=i+1


