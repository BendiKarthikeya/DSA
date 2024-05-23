'''
you are given a string a,b and permutation A.find min number of char you should delete form 
a in order given by A.such that b should not a subsequence of a .
'''
def findAns(s,t,p):
    n=len(s)
    low=0
    high=n
    ans=-1
    while(low<=high):
        mid=(high+low)//2
        if(check(s,t,p,mid)):
            ans=mid
            low=mid+1
        else:
            high=mid-1
def check(s,t,p,x):
    for i in range(x):
        s[p[i]]='#'
    i=0
    j=0
    while(i<len(s) and j<len(t)):
        if (s[i] == t[j]):
            i=i+1
            j=j+1
        else :
            i=i+1
    if(j == t.size()):
        return True
    else:
        return False 
    
