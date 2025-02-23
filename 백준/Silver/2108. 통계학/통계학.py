import sys

def func():
    n = int(sys.stdin.readline())
    sum = 0
    arr = []
    diction = {}
    minNum = 4000
    maxNum = -4000
    for _ in range(n):
        num = int(sys.stdin.readline())
        arr.append(num)
        if (num in diction.keys()):
            diction[num] += 1
        else:
            diction[num] = 1
        sum += num
        if (num < minNum):
            minNum = num
        if (num > maxNum):
            maxNum = num
    sortedArr = sorted(arr)
    sortedDict = dict(sorted(diction.items(), key = lambda x: (-x[1], x[0])))
    # 산술평균
    if (sum < 0):
        print(f"{int(sum / n - 0.5)}")
    else:
        print(f"{int(sum / n + 0.5)}")
    # 중앙값
    print(f"{sortedArr[n // 2]}")
    # 최빈값
    max_value = max(sortedDict.values())
    max_keys = [key for key, value in sortedDict.items() if value == max_value]
    if (len(max_keys) == 1):
        print(f"{max_keys[0]}")
    else:
        print(f"{max_keys[1]}")
    # 범위
    print(f"{maxNum - minNum}")

if __name__ == "__main__":
    func()