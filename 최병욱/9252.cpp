#include<bits/stdc++.h>
using namespace std;

int main()
{
	string str1, str2;
	cin >> str1 >> str2;

	int answer = 0;
	pair<int, int> target;
	vector<vector<string>> lcs(str1.length() + 1, vector<string>(str2.length() + 1, ""));
	for (int i = 0; i < str1.length(); i++)
	{
		for (int j = 0; j < str2.length(); j++)
		{
			if (str1[i] == str2[j])
				lcs[i + 1][j + 1] = lcs[i][j] + str1[i];
			else
				lcs[i + 1][j + 1] = lcs[i][j + 1].length() > lcs[i + 1][j].length() ? lcs[i][j + 1] : lcs[i + 1][j];

			if (answer < lcs[i + 1][j + 1].length())
			{
				answer = lcs[i + 1][j + 1].length();
				target = make_pair(i + 1, j + 1);
			}
		}
	}

	cout << answer << '\n';
	if (answer > 0) cout << lcs[target.first][target.second] << '\n';

	return 0;
}
