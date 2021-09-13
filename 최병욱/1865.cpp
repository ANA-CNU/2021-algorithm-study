// [웜홀](https://www.acmicpc.net/problem/1865)
// 최단거리 & 최장거리 계산 문제
// 처음엔 지점간의 거리와 웜홀 메모리를 각자 따로 두고 플로이드-와샬로 최단거리 & 최장거리 계산을 진행하고 답을 출력함.
// 근데 계속 틀려서 질문을 보다가 웜홀 자체도 "지점간의 경로"로써 사용이 가능하다는 사실을 간과함.
// 웜홀을 음의 가중치로 세팅하고 플로이드-와샬 알고리즘을 사용하고 제출하니 AC를 받음.
// 플로이드 - 와샬이 최단거리 계산 알고리즘이라 웜홀로 다시 돌아갈때의 거리 계산이 틀렸을거라 생각했는데 웜홀 경로는 음의 가중치로 세팅을 해줘서 사실상 최장거리 계산을 하는것과 마찬가지였음.
// 벨만포드 알고리즘이 정석 풀이인것 같으니 이 알고리즘으로도 풀어보기

#include <bits/stdc++.h>
#define INF 5000000
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	cin >> t;
	while(t--)
	{
		int n, m, w;
		cin >> n >> m >> w;

		vector<vector<int>> d(n, vector<int>(n, INF));
		for (int i = 0; i < n; i++)
			d[i][i] = 0;

		for (int i = 0; i < m; i++)
		{
			int s, e, t;
			cin >> s >> e >> t;
			d[s - 1][e - 1] = min(d[s - 1][e - 1], t);
			d[e - 1][s - 1] = min(d[e - 1][s - 1], t);
		}

		for (int i = 0; i < w; i++)
		{
			int s, e, t;
			cin >> s >> e >> t;
			d[s - 1][e - 1] = min(d[s - 1][e - 1], -t);
		}

		for (int k = 0; k < n; k++)
		{
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}

		bool flag = false;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (d[i][j] + d[j][i] < 0)
				{
					flag = true;
					break;
				}
			}

			if (flag) break;
		}

		cout << (flag ? "YES" : "NO") << '\n';
	}

	return 0;
}