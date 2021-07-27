#include <iostream>
using namespace std;

int main()
{
	string str = "";
	cin >> str;

	int counts[26] = {0,};
	int biggest = 0;
	char alphabet = '\0';
	for (int i = 0; i < str.length(); i++)
	{
		int idx = -1;
		if (islower(str[i]))
			idx = str[i] - 'a';
		else
			idx = str[i] - 'A';

		counts[idx]++;
		if (biggest < counts[idx])
		{
			biggest = counts[idx];
			alphabet = idx + 'A';
		}
	}

	int equalCnt = 0;
	for (int i = 0; i < 26; i++)
	{
		if (biggest == counts[i])
			equalCnt++;
	}

	cout << (equalCnt >= 2 ? "?" : string(1, alphabet)) << endl;

	return 0;
}
