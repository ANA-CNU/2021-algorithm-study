#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, int> p1, pair<int, int> p2)
{
	if (p1.first == p2.first)
	{
		return p1.second < p2.second;
	}
	else
		return p1.first < p2.first;
}

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++)
	{
		int x, y;
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end(), compare);
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i].first << ' ' << v[i].second << endl;
	}

	return 0;
}