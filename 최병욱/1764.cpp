#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	map<string, bool> map;
	for (int i = 0; i < n; i++)
	{
		string name;
		cin >> name;
		map.insert(make_pair(name, true));
	}

	vector<string> answers;
	for (int i = 0; i < n; i++)
	{
		string name;
		cin >> name;
		if (map[name])
			answers.push_back(name);
	}

	cout << answers.size() << '\n';

	sort(answers.begin(), answers.end());
	for (int i = 0; i < answers.size(); i++)
		cout << answers[i] << '\n';


	return 0;
}
