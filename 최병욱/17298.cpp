// [오큰수](https://www.acmicpc.net/problem/17298)
// 스택 자료구조 문제
// 첫 접근에선 가장 왼쪽에서 큰 수를 찾는것이니 수열에 들어갈 수 있는 수의 범위를 미리 answers 배열의 index로 두고 현재 입력받은 숫자의 이전에 입력받은 숫자들을 비교하고 탐색범위를 매 루프마다 갱신시키는 로직을 짰지만 수열 내에 중복 숫자가 나오는 경우 떄문에 WA를 받음.
// 타 블로그를 참조해보니 접근법 자체는 맞았으나 비교할 숫자들을 스택에 넣어놓는 방법은 생각을 못했었음.
// queue로도 풀 수 있지않을까? 다른 자료구조로도 정답 로직을 짜봐도 좋을듯. -> queue로는 못푼다. 내림차순 수열이 입력으로 들어오는 경우, 가장 큰 수가 먼저 들어가버려서 이후의 숫자들은 비교를 못하기 때문.

#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> seq(n, 0);
	for (int i = 0; i < n; i++)
		cin >> seq[i];

	stack<int> st;
	vector<int> answers(n, -1);
	for (int i = 0; i < n; i++)
	{
		while (!st.empty() && seq[st.top()] < seq[i])
		{
			answers[st.top()] = seq[i];
			st.pop();
		}

		st.push(i);
	}

	for (int i = 0; i < n; i++)
		cout << answers[i] << ' ';

	return 0;
}
