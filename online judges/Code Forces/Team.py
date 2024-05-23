n=int(input())
count=0
for i in range(n):
        x,y,z=map(int,input().split())
        if x+y+z>=2 :
            count=count+1
print(count)