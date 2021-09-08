// [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)
// 최단경로 탐색 문제
// 처음에 BFS로 접근해서 최단경로를 처음으로 도달한 경로로 하는게 아니라 모든 경로의 depth를 다 비교해보는 로직으로 짬.
// 원래라면 시간초과가 나야했지만 큐에 정보가 너무많이 들어가서 그런지 메모리초과가 났음.
// DFS로도 접근해봤지만 채점 중 11%에서 틀려서 멘탈이 나가 풀이방법을 검색함.
// 검색해보니 내 코드의 문제점은 방문 배열을 한가지 경우의 수로만 한정시킨게 문제. 즉, 먼저 특정 노드를 방문한 경로가 있으면 다른 경로에서 그 노드는 더 이상 방문하지 못하게 짠게 문제였음.
// 벽을 부수고 특정 노드로 가는 경로와 벽을 부수지않고 특정 노드로 가는 경로, 두가지 경우의 수를 커버하도록 로직 수정하니 AC를 받음.
// 너무 최단경로 문제만 보면 "BFS아니면 DFS겠지" 생각하고 코드 먼저 때려박는 습관은 없애야할듯함.
// 다익스트라로도 풀수있을거같은느낌. 시간날때 구현해보기

#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	string str;
	vector<vector<int>> board(n, vector<int>(m, 0));
	for (int i = 0; i < n; i++)
	{
		cin >> str;

		for (int j = 0; j < m; j++)
		{
			board[i][j] = str[j] - '0';
		}
	}

	int answer = 1;
	vector<vector<vector<bool>>> check(2, vector<vector<bool>>(n, vector<bool>(m, false)));
	queue<tuple<int, int, bool>> q;
	q.push(make_tuple(0, 0, true));
	check[true][0][0] = true;
	while(!q.empty())
	{
		int size = q.size();
		for (int it = 0; it < size; it++)
		{
			int x = get<0>(q.front());
			int y = get<1>(q.front());
			bool canBreak = get<2>(q.front());
			q.pop();

			if (y == n - 1 && x == m - 1)
			{
				cout << answer << '\n';
				return 0;
			}

			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			for (int i = 0; i < 4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;

				if (check[canBreak][ny][nx])
					continue;

				if (board[ny][nx] == 1 && canBreak)
				{
					q.push(make_tuple(nx, ny, false));
					check[false][ny][nx] = true;
				}
				else if (board[ny][nx] == 0)
				{
					q.push(make_tuple(nx, ny, canBreak));
					check[canBreak][ny][nx] = true;
				}
			}
		}

		answer++;
	}

	cout << -1 << '\n';

	return 0;
}