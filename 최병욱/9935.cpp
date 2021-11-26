#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string str;
	cin >> str;

	string search;
	cin >> search;

	string answer = "";
	for (int i = 0; i < str.length(); i++)
	{
		answer += str[i];

		if (answer[answer.length() - 1] == search[search.size() - 1])
		{
			if (answer.length() < search.length()) continue;

			bool ok = true;
			vector<char> popped;
			for (int j = 1; j <= search.size() - 1; j++)
			{
				if (answer[answer.length() - 1 - j] != search[search.size() - 1 - j])
				{
					 ok = false;
					 break;
				}
			}

			if (ok)
			{
				int cnt = search.size();
				while (cnt--)
					answer.pop_back();
			}
		}
	}

	std::cout << (answer == "" ? "FRULA" : answer);

	return 0;
}