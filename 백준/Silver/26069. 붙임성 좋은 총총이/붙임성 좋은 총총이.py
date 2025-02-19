import sys

def func():
    n = int(sys.stdin.readline())
    parr = set()
    chongCheck = False
    for _ in range(n):
        p1, p2 = sys.stdin.readline().split()
        if (p1 == "ChongChong" or p2 == "ChongChong"):
            parr.add(p1)
            parr.add(p2)
            continue
        if (p1 in parr or p2 in parr):
            parr.add(p1)
            parr.add(p2)
            continue
    return len(parr)        

if __name__ == "__main__":
    print(f"{func()}")