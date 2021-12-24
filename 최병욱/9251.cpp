#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	string s1, s2;
	cin >> s1 >> s2;
	
	vector<vector<int>> lcs(s1.length() + 1, vector<int>(s2.length() + 1, 0));
	int answer = 0;
	for (int i = 0; i < s1.length(); i++)
	{
		for (int j = 0; j < s2.length(); j++)
		{
			if (s1[i] == s2[j])
				lcs[i + 1][j + 1] = lcs[i][j] + 1;
			else
				lcs[i + 1][j + 1] = max(lcs[i][j + 1], lcs[i + 1][j]);
			
			answer = max(answer, lcs[i + 1][j + 1]);
		}
	}
	
	cout << answer << '\n';
}
