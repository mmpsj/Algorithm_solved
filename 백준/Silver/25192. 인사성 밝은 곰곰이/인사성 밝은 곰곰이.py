import sys

def func():
    n = int(sys.stdin.readline())
    count = 0
    arr = set()
    for _ in range(n):
        str = sys.stdin.readline().rstrip()
        if (str == "ENTER"):
            count += len(arr)
            arr.clear()
            continue
        arr.add(str)
    count += len(arr)
    return count

if __name__ == "__main__":
    print(f"{func()}")