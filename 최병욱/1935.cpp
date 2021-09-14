// [후위 표기식2](https://www.acmicpc.net/problem/1935)
// 스택을 사용해서 풀이하는 문제
// 후위 표기식 문제를 풀었던 김에 풀어봤음.
// 후위 표기식1을 풀었던지라 스택을 사용해서 쉽게 풀음.

#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	string str;
	cin >> str;

	vector<double> nums(n, 0);
	for (int i = 0; i < n; i++)
		cin >> nums[i];

	stack<double> st;
	for (int i = 0; i < str.length(); i++)
	{
		char c = str[i];
		if (c >= 'A' && c <= 'Z')
		{
			st.push(nums[c - 'A']);
		}
		else if (c == '*' || c == '/' || c == '+' || c == '-')
		{
			double n1, n2;
			for (int it = 0; it < 2; it++)
			{
				it == 0 ? (n2 = st.top()) : (n1 = st.top());
				st.pop();
			}

			switch (c)
			{
			case '*':
				st.push(n1 * n2);
				break;
			case '/':
				st.push(n1 / n2);
				break;
			case '+':
				st.push(n1 + n2);
				break;
			case '-':
				st.push(n1 - n2);
				break;
			}
		}
	}

	cout << fixed;
	cout.precision(2);
	cout << st.top() << '\n';

	return 0;
}