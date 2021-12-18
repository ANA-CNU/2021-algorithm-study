//[미세먼지 안녕!](https://www.acmicpc.net/problem/17144)
// 삼성 SW 역량 문제
// 문제를 잘 이해하고 구현하면 되는 문제
// 문제 자체는 그리 어렵지 않으나 공기청정기 쪽 순회 순서를 잘못 넣어서 디버깅 삽질을 하루 종일 한 문제..
// 단순 실수를 줄이도록 노력해보자

#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int r,c, t;
	cin >> r >> c >> t;
	
	vector<vector<int>> board(r, vector<int>(c, 0));
	vector<pair<int, int>> conditioner;
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			cin >> board[i][j];
			if (board[i][j] < 0) conditioner.push_back(make_pair(i, j));
		}
	}
	
	while(t--)
	{
		vector<vector<int>> copy(board);
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				int each = copy[i][j] / 5;
				if (each <= 0) continue;
				
				int count = 0;
				for (int k = 0; k < 4; k++)
				{
					int nx = j + dx[k];
					int ny = i + dy[k];
					if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
					
					if (board[ny][nx] < 0) continue;
					
					board[ny][nx] += each;
					count++;
				}
				
				board[i][j] -= each * count;
			}
		}
		
		vector<vector<int>> copy2(board);
		for (int i = 0; i < conditioner.size(); i++)
		{
			vector<int> order = {0, 3, 1, 2};
			if (i == 1) order = {0, 2, 1, 3};

			int x = conditioner[i].second + 1;
			int y = conditioner[i].first;
			board[y][x] = 0;
			for (int j = 0; j < 4; j++)
			{
				while (true)
				{
					int ny = y + dy[order[j]];
					int nx = x + dx[order[j]];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) break;

					if (board[ny][nx] < 0) break;

					board[ny][nx] = copy2[y][x];
					y = ny; x = nx;
				}
			}
		}
	}
	
	int answer = 0;
	for (int i = 0; i < r; i++)
		for (int j =0; j < c; j++)
			if (board[i][j] > 0) answer += board[i][j];
	
	cout << answer << '\n';
}
