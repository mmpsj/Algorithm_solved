def func():
    count = int(input())
    arr = list(map(int, input().split()))
    max = 0
    min = 1000000
    for i in arr:
        if (i > max):
            max = i
        if (i < min):
            min = i
    return min*max

if __name__ == "__main__":
    print(f"{func()}")