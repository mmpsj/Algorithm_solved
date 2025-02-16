def func():
    n = int(input())
    count = 0
    arr = set()
    for i in range(n):
        str = input()
        if (str == "ENTER"):
            count += len(arr)
            arr.clear()
            continue
        arr.add(str)
    count += len(arr)
    return count

if __name__ == "__main__":
    print(f"{func()}")