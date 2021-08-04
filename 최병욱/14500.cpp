// https://www.acmicpc.net/problem/14500
// check를 매 NxM 반복문에서 assign해서 시간초과가 난 문제
// vector.assign()은 O(n^2)만큼 시간이 걸리니 유의
// bfs로 완전탐색을 구현해도 풀수있을거같음.
// 백트래킹의 개념에 대해서 확실히 짚고 넘어가기

#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<vector<bool>> check;

// dfs 중복값 체킹을 하거나 bfs로 풀거나
int dfs(vector<vector<int>> &v, pair<int, int> start, int level)
{
	if (level == 4)
		return v[start.first][start.second];

	check[start.first][start.second] = true;
	int biggest = 0;
	int sum = v[start.first][start.second];
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, 1, -1};
	for (int i = 0; i < 4; i++)
	{
		int nx = start.second + dx[i];
		int ny = start.first + dy[i];
		if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
		if (check[ny][nx]) continue;

		check[ny][nx] = true;
		biggest = max(biggest, sum + dfs(v, make_pair(ny, nx), level + 1));
		check[ny][nx] = false;
	}
	check[start.first][start.second] = false;

	return biggest;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;

	vector<vector<int>> v(n, vector<int>(m, 0));
	check.assign(n, vector<bool>(m, false));
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> v[i][j];
	}

	int answer = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			// cout << "start: " <<  i << ":" << j << endl;
			answer = max(answer, dfs(v, make_pair(i, j), 1));

			// ㅜ 최대값 구하기
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			int case5 = 0;
			for (int exclude = 0; exclude < 4; exclude++)
			{
				int sum = v[i][j];
				int count = 0;
				for (int it = 0; it < 4; it++)
				{
					if (it == exclude)
						continue;

					int ny = i + dy[it];
					int nx = j + dx[it];
					if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

					sum += v[ny][nx];
					count++;
				}
				sum = count == 3 ? sum : 0;
				case5 = max(case5, sum);
			}
			answer = max(answer, case5);
		}
	}

	cout << answer << '\n';

	return 0;
}