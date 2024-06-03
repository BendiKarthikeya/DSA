t = int(input())
for _ in range(t):
    n, f, x = map(int, input().split())  
    arr = list(map(int, input().split()))  

    favorite = arr[f - 1]  
    arr.sort(reverse=True)  

    removed_cubes = arr[:x]  
    if favorite in removed_cubes:
        if favorite not in arr:
            print("NO")
        elif favorite in arr[x:]:
            print("MAYBE")
        else:
            print("YES")
    else:
        print("NO")
