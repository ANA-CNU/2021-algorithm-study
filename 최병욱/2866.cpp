#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	std::cout.tie(0);

	int r, c = 0;
	cin >> r >> c;

	vector<string> data;
	for (int i = 0; i < r; i++)
	{
		string str = "";
		cin >> str;
		data.push_back(str);
	}

	int start = 0, end =  r - 1;
	int mid = 0;

	map<string, int> m;
	bool isRepeat = false;
	while(start <= end)
	{
		mid = (start + end) / 2;
		bool check = true;
		for (int y = 0; y < c; y++)
		{
			string str = "";
			for (int x = mid; x < r; x++)
			{
				str += data[x][y];
			}

			if (m[str])
			{
				check = false;
				break;
			}

			m[str]++;
		}

		if (!check)
			end = mid - 1;
		else
			start = mid + 1;

		m.clear();
		isRepeat = check;
	}

	std::cout << isRepeat ? mid : mid - 1 << '\n';

	return 0;
}