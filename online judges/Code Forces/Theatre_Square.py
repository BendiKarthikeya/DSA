import math
x,y,z=map(int,input().split())
c=math.ceil(x/z)*math.ceil(y/z)
print(c)