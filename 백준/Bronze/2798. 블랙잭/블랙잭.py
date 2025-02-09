def func():
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    max = 0
    for i in range(0, len(arr)-2):
        for j in range(i+1, len(arr)-1):
            for k in range(j+1, len(arr)):
                val = arr[i]+arr[j]+arr[k]
                if (val == m):
                    return val
                if (val < m and val > max):
                    max = val
    return max

if __name__ == "__main__":
    print(f"{func()}")