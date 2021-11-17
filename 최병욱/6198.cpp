// [옥상 정원 꾸미기](https://www.acmicpc.net/problem/6198)
// 스택 문제
// 처음에는 정렬로 푸는건가 했는데 잘 살펴보니 스택으로 푸는 문제였다
// 첫 제출에는 WA를 받았는데 이유는 입력이 80000 ~ 1 까지 내림차순으로 들어올경우 정답이 32억을 초과해서 overflow가 나기 떄문
// answer를 long long형으로 바꿔줘서 AC를 받음
// 생각하는데 시간이 좀 걸린게 아쉬웠던 문제
// 문제를 더 많이 풀면서 생각하는 시간을 줄이는걸 목표로

#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	stack<int> st;
	long long answer = 0;
	for (int i = 0; i < n; i++)
	{
		int h;
		cin >> h;

		while(!st.empty() && st.top() <= h)
		{
			answer += st.size() - 1;
			st.pop();
		}

		st.push(h);
	}

	// 남은 오름차순 수열들을 pop하고 계산해줌
	while(!st.empty())
	{
		answer += st.size() - 1;
		st.pop();
	}

	cout << answer << '\n';

	return 0;
}