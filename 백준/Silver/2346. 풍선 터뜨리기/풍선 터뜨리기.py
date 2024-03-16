import sys
from collections import deque
input = sys.stdin.readline

def func():
    n = int(input())
    q = deque([i, j] for i, j in zip(range(1, n + 1), list(map(int, input().split()))))
    pop_num = q.popleft()
    print(pop_num[0], end = ' ')
    while (True):
        if (len(q) < 1):
            break
        if (pop_num[1] > 0):
            for i in range(pop_num[1] - 1):
                q.append(q.popleft())
            pop_num = q.popleft()
            print(pop_num[0], end = ' ')
        else:
            for i in range(abs(pop_num[1]) - 1):
                q.appendleft(q.pop())
            pop_num = q.pop()
            print(pop_num[0], end = ' ')
            
if __name__ == "__main__":
    func()