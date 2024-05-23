#rotated sorted array  A
#num x
# check if x exist in A or not

A=[10,12,14,2,4,6,8]
'''x=3 --false
   x=4 --true '''
minindex=findmin(A) #do the function by rotated_sorted question
binary_serch(0,minindex-1)
binary_serch(minindex,len(A)-1)
