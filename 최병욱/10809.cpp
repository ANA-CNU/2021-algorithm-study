#include <iostream>
using namespace std;

int main()
{
	string s;
	cin >> s;

	for (int i = 'a'; i <= 'z'; i++)
	{
		bool found = false;
		for (int j = 0; j < s.length(); j++)
		{
			if (s[j] == char(i))
			{
				found =  true;
				cout << j;
				break;
			}
		}

		if (!found)
			cout << -1;

		if (i != 'z')
			cout << ' ';
	}


	return 0;
}
