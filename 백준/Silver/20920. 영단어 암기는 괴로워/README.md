# [Silver III] 영단어 암기는 괴로워 - 20920 

[문제 링크](https://www.acmicpc.net/problem/20920) 

### 성능 요약

메모리: 39028 KB, 시간: 624 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 정렬, 문자열, 트리를 사용한 집합과 맵

### 제출 일자

2024년 4월 13일 00:12:53

### 문제 설명

<p>화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.</p>

<ol>
	<li>자주 나오는 단어일수록 앞에 배치한다.</li>
	<li>해당 단어의 길이가 길수록 앞에 배치한다.</li>
	<li>알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다</li>
</ol>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>이상인 단어들만 외운다고 한다. 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.</p>

### 입력 

 <p>첫째 줄에는 영어 지문에 나오는 단어의 개수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>과 외울 단어의 길이 기준이 되는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>이 공백으로 구분되어 주어진다. (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>100</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \leq N \leq 100\,000$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>M</mi><mo>≤</mo><mn>10</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \leq M \leq 10$</span></mjx-container>)</p>

<p>둘째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N+1$</span></mjx-container>번째 줄까지 외울 단어를 입력받는다. 이때의 입력은 알파벳 소문자로만 주어지며 단어의 길이는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>10</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$10$</span></mjx-container>을 넘지 않는다.</p>

<p>단어장에 단어가 반드시 1개 이상 존재하는 입력만 주어진다.</p>

### 출력 

 <p>화은이의 단어장에 들어 있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 순서대로 출력한다.</p>

### 풀이

우선 각 단어에 대한 횟수를 저장해야 하기 때문에, HashMap<String, Integer>로 저장했다. 저장할 때 길이 m 미만인 것들은 저장하지 않았다. 

이제 정렬을 해야 하는데, 이게 좀 막막했다. 그냥 단순히 경우 나눠서 해야 하는 건지, 그렇다면 각 경우 조건을 어떻게 걸어야 하는지, ... 고민을 오래 해보다가 답이 안 나와서 검색을 해봤다. 찾아보니 Arrays.sort에 인자로 람다 함수를 줘서 정렬하는 방법이 있다는 것을 알았다. 그렇게 정렬한 코드는 다음과 같다.

```java
String[] words = new String[dict.size()];
int idx = 0;
for (String s : dict.keySet()) {
	words[idx++] = s;
}
Arrays.sort(words, (String o1, String o2) -> {
	if (dict.get(o1) > dict.get(o2)) {
		return -1;
	} else if (dict.get(o1) < dict.get(o2)) {
                return 1;
	} else {
		if (o1.length() == o2.length()) {
			return o1.compareTo(o2);
		} else {
			return o2.length() - o1.length();
		}
	}
});
```

해당 코드는 words 배열을 Arrays.sort를 이용해 정렬하는데 정렬 조건으로 람다 함수를 준 것이다. 

해당 람다 함수는 words의 두 문자열을 비교하는데, 먼저 빈도수를 기준으로 많은 쪽이 앞으로 오도록 한다. 횟수가 같다면 길이를 비교한다. 길이가 같다면 문자열을 그대로 비교해서 알파벳 순으로 정렬하고, 길이가 다르다면 뒤 문자열에서 앞 문자열의 길이를 빼면 길이가 긴 순서대로 정렬할 수 있다.

이렇게 하고 StringBuilder로 출력했는데, 시간 초과가 나왔다. 그래서 질문 게시판을 찾아봤는데, String 배열 대신 ArrayList를 사용하니 된다는 이야기가 있어서 시도해봤다. list로 바꾸면 Arrays.sort를 Collections.sort로 바꿔야 한다. 값을 가져오는 방식도 달라진다.

```java
List<String> words = new ArrayList<>(dict.keySet());
Collections.sort(words, (String o1, String o2) -> {
	if (dict.get(o1) > dict.get(o2)) {
		return -1;
	} else if (dict.get(o1) < dict.get(o2)) {
                return 1;
	} else {
                if (o1.length() == o2.length()) {
			return o1.compareTo(o2);
		} else {
			return o2.length() - o1.length();
		}
	}
});
```

이렇게 하니 시간제한인 1초에 아슬아슬하게 걸려서 성공했다.(948ms) 하지만 너무 아슬아슬해서 더 좋은 방법이 있지 않을까 하고 찾아봤다. 찾아보니 저렇게 직접 정렬하는 것 말고 클래스를 만들어서 Comparable을 implement하는 방법도 있어서 사용해봤다. Word 클래스를 만들어서, 해당 객체가 문자열, 문자열의 길이, 빈도수를 저장하도록 했다. 그리고 compareTo 함수를 override하여 정렬 기준을 정해줬다. 정렬 기준은 위에서 사용했던 방식과 같다. 아래는 Word 클래스이다.

```java
class Word implements Comparable<Word> {
    int count;
    int len;
    String word;

    public Word(String word) {
        this.word = word;
        len = word.length();
        count = 1;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word w) {
        if (count > w.count) {
            return -1;
        } else if (count < w.count) {
            return 1;
        } else {
            if (len == w.len) {
                return word.compareTo(w.word);
            } else {
                return w.len - len;
            }
        }
    }
}
```

이렇게 클래스를 만들면 Collections.sort와 같은 자바 내부적으로 구현된 정렬을 진행할 때 Word 객체의 정렬 기준이 정해진다. 이후 map의 엔트리를 <String, Integer>에서 <String, Word>로 변경해서 저장 구조를 바꿨다.

```java
for (int i = 0; i < n; i++) {
	String str = br.readLine();
	if (str.length() < m) continue;
	if (map.containsKey(str)) {
		map.get(str).addCount();
	} else {
                map.put(str, new Word(str));
	}
}
```

이제 정렬만 하면 되는데, key와 관계없이 value만 정렬하면 된다. 그래서 value를 정렬하려는데, map.values()로 모두 가져올 수는 있지만 return type이 Collection<Word>라서 바로 Collections.sort를 할 수 없었다. 마침 자바에는 TreeSet이라는 Set을 정렬해서 저장하는 자료구조가 있고, Set을 생성할 때 인자로 Collection<E>를 줄 수 있었다. 그래서 이를 생성하면 자동으로 정렬도 되는 것이다.

```java
Set<Word> set = new TreeSet<>(map.values());
```

이렇게 정렬된 Set을 iterator를 이용해 모두 Stringbuilder를 이용해 출력해주니 시간이 좀 넉넉해졌다.(624ms)

여러 자료구조의 특성을 잘 알아야겠다는 생각을 했다.
