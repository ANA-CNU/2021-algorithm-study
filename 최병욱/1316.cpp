#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int answer = n;
	for (int it = 0; it < n; it++)
	{
		string str;
		cin >> str;

		bool checker[26] = { false };
		int cursor = 0;
		while (cursor < str.length())
		{
			char prev = str[cursor++];
			while (cursor < str.length())
			{
				if (prev != str[cursor]) break;

				cursor++;
			}

			if (checker[prev - 'a'])
			{
				answer--;
				break;
			}

			checker[prev - 'a'] = true;
		}
	}

	cout << answer << '\n';

	return 0;
}