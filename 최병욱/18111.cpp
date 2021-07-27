#include <iostream>
#include <vector>
#include <algorithm>
#define MAX_HEIGHT 256
using namespace std;
int N, M, B;

int main()
{
	cin >> N >> M >> B;

	vector<vector<int>> area(N, vector<int>(M, 0));
	for (int y = 0; y < N; y++)
	{
		for (int x = 0; x < M; x++)
		{
			cin >> area[y][x];
		}
	}

	int answerSec = INT32_MAX;
	int answerH = -1;
	for (int h = 0; h <= MAX_HEIGHT; h++)
	{
		int inventory = B;
		int sec = 0;
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				int diff = abs(area[y][x] - h);
				if (area[y][x] > h)
				{
					sec += 2 * diff;
					inventory += diff;
				}
				else if (area[y][x] < h)
				{
					sec += diff;
					inventory -= diff;
				}
			}
		}

		// 인벤토리에 블록이 부족한 경우의 수는 제외
		if (inventory >= 0 && answerSec >= sec)
		{
			answerH = answerSec == sec ? max(answerH, h) : h;
			answerSec = sec;
		}
	}

	cout << answerSec << ' ' << answerH << endl;

	return 0;
}