def func():
    n = int(input())
    count = 0
    arr = set()
    for i in range(n):
        str = input()
        if (str == "ENTER"):
            arr = set()
            continue
        if (str not in arr):
            arr.add(str)
            count += 1
    return count

if __name__ == "__main__":
    print(f"{func()}")