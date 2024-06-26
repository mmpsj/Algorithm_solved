# [Silver III] 칸토어 집합 - 4779 

[문제 링크](https://www.acmicpc.net/problem/4779) 

### 성능 요약

메모리: 23196 KB, 시간: 308 ms

### 분류

분할 정복, 재귀

### 제출 일자

2024년 4월 13일 11:16:31

### 문제 설명

<p>
	칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.</p>

<p>
	전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.</p>

<p>
	1. -가 3<sup>N</sup>개 있는 문자열에서 시작한다.</p>

<p>
	2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.</p>

<p>
	3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.</p>

<p>
	예를 들어, N=3인 경우, 길이가 27인 문자열로 시작한다.</p>

<pre>---------------------------</pre>

<p>
	여기서 가운데 문자열을 공백으로 바꾼다.</p>

<pre>---------         ---------</pre>

<p>
	남은 두 선의 가운데 문자열을 공백으로 바꾼다.</p>

<pre>---   ---         ---   ---</pre>

<p>
	한번 더</p>

<pre>- -   - -         - -   - -</pre>

<p>
	모든 선의 길이가 1이면 멈춘다. N이 주어졌을 때, 마지막 과정이 끝난 후 결과를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>
	입력을 여러 줄로 이루어져 있다. 각 줄에 N이 주어진다. 파일의 끝에서 입력을 멈춘다. N은 0보다 크거나 같고, 12보다 작거나 같은 정수이다.</p>

### 출력 

 <p>
	입력으로 주어진 N에 대해서, 해당하는 칸토어 집합의 근사를 출력한다.</p>

### 풀이

우선 입력 개수가 정해져 있지 않으므로, 반복문 안에서 입력받고 입력값이 없거나 비어있으면 반복문을 종료하도록 했다. 먼저 어떤 자료구조를 사용할지 고민했는데, 전체 문자열을 저장할 배열을 만들기에는 배열의 크기가 3^12까지 되기 때문에 너무 커질 것 같았다. 그래서 어차피 문자열 한 줄 출력하는 것이니 StringBuilder 객체를 재귀 함수의 인자로 넘겨주면 문자열을 다 이을 수 있다는 생각을 했다.

재귀 함수의 인자로는 공백을 확인하는 boolean, 현재 함수의 문자열 길이를 알려주는 int, 문자열을 기록할 StringBuilder가 들어간다.

```java
public static void cantor(boolean print, int len, StringBuilder sb)
```

재귀 함수에서는 길이인 len이 3 미만이면 sb에 문자열을 추가하는데, print가 true이면 "-"를 추가하고 false이면 " "를 추가한다.

3 이상이면 재귀 함수를 호출한다. 각 입력이 세개로 쪼개져서 진행되는 것이므로 3번의 호출이 필요하다. 왼쪽-가운데-오른쪽 순으로 호출하는데, 기본적으로 왼쪽과 오른쪽은 문자가 있으니까 print를 true로 넘겨 주고, 가운데는 false로 넘겨준다. 한번 false로 넘어왔으면 그에 해당하는 아래 재귀들은 모두 " "을 출력하도록 print가 false이면 셋 모두 false로 넘겨준다.

```java
public static void cantor(boolean print, int len, StringBuilder sb) {
	if (len < 3) {
            	sb.append((print)? "-" : " ");
        } else {
            	if (print) {
                	cantor(true, len / 3, sb);
                	cantor(false, len / 3, sb);
                	cantor(true, len / 3, sb);
            	} else {
                	cantor(false, len / 3, sb);
                	cantor(false, len / 3, sb);
                	cantor(false, len / 3, sb);
            	}
        }
}
```

다른 사람의 코드를 보니 재귀를 사용하지 않고 n값에 따른 결과들을 미리 저장해놓는 방식도 있었다. 

String형 배열을 인덱스 0~12로 만들고, 각 n에 대한 출력 결과를 저장한다. 배열(arr)[0]을 "-"로 하고, 각 n에 들어갈 공백을 space로 정의한다.

반복문을 i  = 1 ~ 12까지 돌려서, arr[i] = arr[i - 1] + space + arr[i - 1]로 하고, space는 space를 3번 붙인 것으로 업데이트한다. 이 과정을 반복하면 n = 12까지의 모든 결과를 저장하게 된다.

```java
public static String[] arr = new String[13];
~
	arr[0] = "-";
	StringBuilder sb;
	String space = " ";
	StringBuilder spsb;	
	for(int i=1; i<arr.length; i++) {
		sb = new StringBuilder();
		sb = sb.append(arr[i-1]).append(space).append(arr[i-1]);
		arr[i] = sb.toString();	
		spsb = new StringBuilder();
		for(int j=0; j<3; j++) {
			spsb.append(space);
		}
		space = spsb.toString();
	}
```

이후 n을 입력받고 arr[n]을 출력하면 되는 것이다.

이 방법은 n의 입력 범위가 작아서 사용할 수 있다고 생각한다. n이 12를 넘어 훨씬 커진다면 배열의 크기도 훨씬 커지고, 저장할 양도 많아져서 자원 관리에 문제가 생길 수 있기 때문이다. 

물론 이 문제처럼 범위가 작은 경우에는 사용해도 문제 없다. 문제를 풀 때 입력 범위에 대한 고려도 필요하다는 것을 배웠다. 내 방법이 모든 경우를 커버할 수 있는 방법이라고 생각해서 풀었더라도, 문제에 따라 단순하게 풀릴 수도 있다.
