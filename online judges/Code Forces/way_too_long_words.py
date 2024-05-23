n=int(input())
for i in range(n):
    x=str(input())
    z=len(x)
    if(z>10):
        y=z-2
        print(x[0]+str(y)+x[z-1])
    else:
        print(x)
