// [Four Squares](https://www.acmicpc.net/problem/17626)
// 난이도 티어를 보고 쉬울줄 알고 접근했지만 생각보다 고민을 많이했던 문제
// dp 최적화로 풀이했지만 메모이제이션을 이용한 brute force로도 풀이 가능.

#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> dp(n + 1, 0);
	dp[0] = 1;
	for (int i = 1; i <= n; i++)
	{
		int minimum = INT32_MAX;
		for (int it = 1; it * it <= i; it++)
		{
			minimum = min(minimum, dp[it * it] + dp[i - it * it]);
		}
		dp[i] = minimum;
	}

	cout << dp[n] << '\n';

	return 0;
}