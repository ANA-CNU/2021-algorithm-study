#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<vector<string>> v(11, vector<string>());
	int n, m;
	cin >> n >> m;

	while (true)
	{
		int c = 0;
		string name = "";
		cin >> c >> name;

		if (c == 0) break;

		if (v[c].size() < m)
			v[c].push_back(name);
	}

	for (int i = 1; i <= n; i++)
	{
		sort(v[i].begin(), v[i].end(), []
			(const std::string& first, const std::string& second){

				if (first.size() == second.size())
					return first < second;
				else
        			return first.size() < second.size();
		});
	}

	for (int i = 1; i <= n; i += 2)
	{
		for (int j = 0; j < v[i].size(); j++)
			cout << i << ' ' << v[i][j] << '\n';
	}

	for (int i = 2; i <= n; i += 2)
	{
		for (int j = 0; j < v[i].size(); j++)
			cout << i << ' ' << v[i][j] << '\n';
	}

	return 0;
}
