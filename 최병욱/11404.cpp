// [플로이드](https://www.acmicpc.net/problem/11404)
// 플로이드-와샬 알고리즘 구현 문제
// https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842&proxyReferer=https:%2F%2Fwww.google.com%2F 블로그를 참조해서 알고리즘에 대해 이해하고 구현함.
// 처음 구현을 완료하고 TC를 돌려봤을때 출력값이 다르게 나와서 확인해보니 중복 간선이 존재했다. 그래서 중복된 것들은 최소값으로만 저장해두도록함.
// 위 경우를 처리하고 제출했는데 틀렸었다. 이유는 INF값을 1000000으로 잡은것 때문이였음
// 도시가 100개, 버스는 100,000개가 있어서 최대 cost가 10000000이 나올수있다는것을 간과한 탓
// 문제를 언제나 꼼꼼히 읽는 습관을 들일것!

#include <bits/stdc++.h>
#define INF 10000000
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> dp(n, vector<int>(n, INF));
	for (int i = 0; i < n; i++)
		dp[i][i] = 0;

	for (int it = 0; it < m; it++)
	{
		int i, j, c;
		cin >> i >> j >> c;
		dp[i - 1][j - 1] = min(dp[i - 1][j - 1], c);
	}

	// 플로이드-와샬 구현부
	// 시간복잡도는 O(V^3)
	for (int k = 0; k < n; k++)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << (dp[i][j] == INF ? 0 : dp[i][j]) << " ";
		}
		cout << '\n';
	}

	return 0;
}