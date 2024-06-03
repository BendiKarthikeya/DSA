t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    a=input()
    arr=[0]*7
    for i in a:
        if('A' <= i <= 'G'):
            arr[ord(i)-ord('A')]+=1
    
    total= 0
    for count in arr:
        if count < m:
            total += (m - count)

            
    print(total)
        