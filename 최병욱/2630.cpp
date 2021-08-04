// [색종이만들기](https://www.acmicpc.net/problem/2630)
// 4등분씩 분할해서 재귀시키는 함수를 만드는 문제(분할정복)
// 4등분 분할을 for문으로 구현하려다가 계속 오류를 못잡아 다른사람의 코드와 비교했었음.
// 2차원 배열을 NxN bound로 자르는 방식은 이번에 확실히 짚고 넘어갈것.

#include <bits/stdc++.h>
using namespace std;
int colors[] = {0, 0};
vector<vector<int>> v;

void solve(pair<int, int> start, int len)
{
	bool match = true;
	int check = v[start.first][start.second];
	for (int y = start.first; y < start.first + len; y++)
	{
		for (int x = start.second; x < start.second + len; x++)
		{
			if (check != v[y][x])
			{
				match = false;
				break;
			}
		}
	}

	if (match)
	{
		colors[check]++;
		return;
	}

	int half = len / 2;
	int nx = start.second;
	int ny = start.first;
	for (int i = 0; i < 4; i++)
	{
		solve(make_pair(ny, nx), half);

		if (nx + half >= start.second + len)
		{
			ny += half;
			nx = start.second;
		}
		else
		{
			nx += half;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	v.assign(n, vector<int>(n, 0)) ;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> v[i][j];
		}
	}

	solve(make_pair(0, 0), n);

	for (int i = 0; i < 2; i++)
		cout << colors[i] << '\n';

	return 0;
}