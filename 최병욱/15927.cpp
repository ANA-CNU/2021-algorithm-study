//[회문은 회문아니야!!](https://www.acmicpc.net/problem/15927)
// 문자열 + 애드혹 문제
// 브루트 포스로는 절대 풀수없는 입력값이어서 문제 설명을 읽어보니 애드혹인것을 눈치챔
// 규칙을 찾고나선 굉장히 쉽게 풀었음

#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string str;
	cin >> str;

	int l = 0;
	int r = str.length() - 1;
	int result = 2; // 0 = not palindrome, 1 = normal palindrome, 2 = one combination palindrome
	while(l <= r)
	{
		if (str[l] != str[r])
		{
			result = 0;
			break;
		}

		if (str[0] != str[l] || str[0] != str[r])
			result = 1;

		l++;
		r--;
	}

	if (result == 0)
		cout << str.length() << '\n';
	else if(result == 1)
		cout << str.length() - 1 << '\n';
	else
		cout << -1 << '\n';
}
