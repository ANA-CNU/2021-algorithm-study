#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	vector<int> arr(n, 0);
	for (int i = 0; i < n; i++)
		cin >> arr[i];

	vector<int> copy;
	copy.assign(arr.begin(), arr.end());
	sort(copy.begin(), copy.end());

	map<int, int> m;
	int last = copy.front();
	int count = 0;
	for (int i = 0; i < copy.size(); i++)
	{
		if (last != copy[i]) count++;

		m.insert(make_pair(copy[i], count));
		last = copy[i];
	}

	for (int i = 0; i < arr.size(); i++)
	{
		cout << m[arr[i]] << (i != arr.size() - 1 ? " " : "");
	}

	return 0;
}