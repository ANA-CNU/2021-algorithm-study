#include <iostream>
using namespace std;


int main()
{
	int t = 0;
	cin >> t;

	while (t--)
	{
		int loop;
		string str;
		cin >> loop >> str;
		for (int i = 0; i < str.length(); i++)
		{
			for (int it = 0; it < loop; it++)
			{
				cout << str[i];
			}
		}

		cout << endl;
	}

	return 0;
}