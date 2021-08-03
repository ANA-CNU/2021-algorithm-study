// https://www.acmicpc.net/problem/16236
// 푸는 로직은 금방 생각했지만 최적화 하려고 고민을 너무 했던 문제
// 나중에 코드를 최적화해서 짜보기

#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	vector<vector<int>> m(n, vector<int>(n, 0));
	pair<int, int> shark;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> m[i][j];
			if (m[i][j] == 9)
			{
				shark = make_pair(i, j);
				m[i][j] = 0;
			}
		}
	}

	int answer = 0;
	int eat = 0;
	int sharkSize = 2;
	while(true)
	{
		// bfs
		vector<vector<bool>> check(n, vector<bool>(n, false));
		vector<vector<int>> d(n, vector<int>(n, 0));
		pair<int, int> target = make_pair(n, n);
		queue<pair<int, int>> q;
		q.push(shark);
		int minimum = INT32_MAX;
		while(!q.empty())
		{
			auto start = q.front();
			q.pop();

			check[start.first][start.second] = true;

			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			for (int i = 0; i < 4; i++)
			{
				int ny = start.first + dy[i];
				int nx = start.second + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >=n) continue;

				if (sharkSize < m[ny][nx]) continue;

				if (check[ny][nx]) continue;

				check[ny][nx] = true;
				d[ny][nx] = d[start.first][start.second] + 1;
				q.push(make_pair(ny, nx));

				if (m[ny][nx] > 0 && sharkSize > m[ny][nx] && minimum >= d[ny][nx])
				{
					if (minimum == d[ny][nx] && target.first * n + target.second < ny * n + nx)
						continue;

					minimum = d[ny][nx];
					target = make_pair(ny, nx);
				}
			}

			// 타겟 찾았으면 bfs 탈출
			// if (target.first >= 0 && target.second >= 0) break;
		}

		// 먹을 물고기가 없는 경우엔 종료
		if (target.first == n && target.second == n) break;

		answer += d[target.first][target.second];

		// 상어 크기 갱신
		if (++eat == sharkSize)
		{
			sharkSize++;
			eat = 0;
		}

		// 물고기 있던 위치 비우고 상어 위치 변경
		shark = make_pair(target.first, target.second);
		m[target.first][target.second] = 0;
	}

	std::cout << answer << '\n';

	return 0;
}
