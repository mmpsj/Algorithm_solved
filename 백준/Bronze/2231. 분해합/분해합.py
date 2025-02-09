def func():
    n = int(input())
    for i in range(1, n+1):
        val = i
        temp = i
        while True:
            val += temp % 10
            temp //= 10
            if (temp == 0):
                break
        if (val == n):
            return i
    return 0

if __name__ == "__main__":
    print(f"{func()}")