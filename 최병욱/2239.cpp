// [스도쿠](https://www.acmicpc.net/problem/2239)
// 백트래킹을 사용하는 간단한 문제
// 조건 검사식 짜는게 좀 귀찮았음

#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>> board(9, vector<int>(9, 0));
vector<pair<int, int>> zeros;

bool checkRow(int y, int num)
{
	for (int i = 0; i < 9; i++)
	{
		if (board[y][i] == num) return false;
	}
	
	return true;
}

bool checkColumn(int x, int num)
{
	for (int i = 0; i < 9; i++)
	{
		if (board[i][x] == num) return false;
	}
	
	return true;
}

bool check3x3(int y, int x, int num)
{
	int sy = (y / 3) * 3;
	int sx = (x / 3) * 3;
	for (int i = sy; i < sy + 3; i++)
	{
		for (int j = sx; j < sx + 3; j++)
		{
			if (board[i][j] == num) return false;
		}
	}
	
	return true;
}

bool solve(int idx)
{
	if (idx == zeros.size())
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cout << board[i][j];
			}
			cout << '\n';
		}
		
		return true;
	}
	
	int x = zeros[idx].second;
	int y = zeros[idx].first;
	for (int num = 1; num <= 9; num++)
	{
		if (!checkRow(y, num) || !checkColumn(x, num) || !check3x3(y, x, num)) continue;
		
		board[y][x] = num;
		bool found = solve(idx + 1);
		if (found) return true;
		board[y][x] = 0;
	}
	
	return false;
}


int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	for (int i = 0; i < 9; i++)
	{
		int n;
		cin >> n;

		int div = 100000000;
		for (int j = 0; j < 9; j++)
		{
			board[i][j] = n / div;
			n %= div;
			div /= 10;
			
			if (board[i][j] <= 0) zeros.push_back(make_pair(i, j));
		}
	}

	solve(0);
}
