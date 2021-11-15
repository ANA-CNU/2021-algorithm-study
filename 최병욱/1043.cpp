#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> people(51, vector<int>());
vector<vector<int>> party(50, vector<int>());
vector<int> known;
vector<bool> except(50, false);

void solve(int num)
{
	// 자신이 속한 모든 파티 순회
	for (int i = 0; i < people[num].size(); i++)
	{
		int partyIdx = people[num][i];
		if (except[partyIdx]) continue;

		except[partyIdx] = true;

		// 이 파티에 속한 모든 멤버 순회
		auto p = party[partyIdx];
		for (int j = 0; j < p.size(); j++)
		{
			solve(p[j]);
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int m;
	cin >> m;

	int knownCount;
	cin >> knownCount;
	while(knownCount--)
	{
		int num;
		cin >> num;
		known.push_back(num);
	}

	for (int i = 0; i < m; i++)
	{
		int cnt;
		cin >> cnt;
		while (cnt--)
		{
			int num;
			cin >> num;
			people[num].push_back(i);
			party[i].push_back(num);
		}
	}

	for (int i = 0; i < known.size(); i++)
		solve(known[i]);

	int answer = m;
	for (int i = 0; i < m; i++)
	{
		if (except[i]) answer--;
	}

	cout << answer << '\n';

	return 0;
}