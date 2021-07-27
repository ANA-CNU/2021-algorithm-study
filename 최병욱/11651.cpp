#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	cin >> n;

	vector<pair<int ,int>> v;
	for (int i = 0; i < n; i++)
	{
		int x, y;
		cin >> x;
		cin >> y;
		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end(), [](pair<int ,int> a, pair<int ,int> b) -> bool
        {
        	if(a.second == b.second)
			{
				return a.first < b.first;
			}
			else
				return a.second < b.second;
        });

	for (int i = 0; i < n; i++)
	{
		cout << v[i].first << ' ' << v[i].second << (i != n -1 ? "\n" : "");
	}


	return 0;
}