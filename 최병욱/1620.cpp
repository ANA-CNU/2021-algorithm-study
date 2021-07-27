#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> pokemons;
	map<string, int> map;
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		string name;
		cin >> name;
		pokemons.push_back(name);
		map.insert(make_pair(name, i + 1));
	}

	for (int i = 0; i < m; i++)
	{
		string input;
		cin >> input;
		if (input[0] >= 'A' && input[0] <= 'Z')
		{
			cout << map[input] << '\n';
		}
		else
		{
			cout << pokemons[stoi(input) - 1] << '\n';
		}
	}

	return 0;
}
