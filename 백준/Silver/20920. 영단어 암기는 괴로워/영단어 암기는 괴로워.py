import sys

def func():
    n, m = map(int, sys.stdin.readline().split())
    diction = {}
    for _ in range(n):
        str = sys.stdin.readline().rstrip()
        if (len(str) < m):
            continue
        if (str in diction.keys()):
            diction[str] += 1
        else:
            diction[str] = 1
    sorted_dict = dict(sorted(diction.items(), key=lambda x: (-x[1], -len(x[0]), x[0])))
    for key in sorted_dict.keys():
        print(key)

if __name__ == "__main__":
    func()