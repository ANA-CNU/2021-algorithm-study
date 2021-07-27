#include <iostream>
using namespace std;

int main()
{
	while (true)
	{
		string str;
		cin >> str;

		if (str == "0") break;

		string comp = "";
		for (int i = str.length() - 1; i >= 0; i--)
		{
			comp += str[i];
		}

		cout << (str == comp ? "yes" : "no") << endl;
	}

	return 0;
}