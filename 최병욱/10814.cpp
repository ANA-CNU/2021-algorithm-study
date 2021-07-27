#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, string>> origin;
	for (int i = 0; i < n; i++)
	{
		string name;
		int old;
		cin >> old >> name;
		origin.push_back(make_pair(old, name));
	}

	stable_sort(origin.begin(), origin.end(), [](pair<int, string> a, pair<int, string>b) -> bool
	{
		return a.first < b.first;
	});

	for (int i = 0; i < origin.size(); i++)
	{
		cout << origin[i].first << ' ' << origin[i].second << (i != origin.size() - 1 ? "\n" : "");
	}

	return 0;
}
