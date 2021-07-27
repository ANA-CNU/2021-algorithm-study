#include <iostream>
#include <string>
using namespace std;

int main()
{
	int t = 0;
	cin >> t;

	while (t--)
	{
		string str;
		cin >> str;

		int sum = 0;
		int score = 0;
		for (int i = 0; i < str.length(); i++)
		{
			if (str[i] == 'O')
				score += 1;
			else
				score = 0;

			sum += score;
		}

		cout << sum << endl;
	}

	return 0;
}