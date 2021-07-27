#include <iostream>
using namespace std;

int main()
{
	string str = "";
	getline(cin, str);

	int ans =0;
	for (int i = 1; i < str.length() - 1; i++)
	{
		if (str[i] == ' ')
			ans++;
	}

	if (str == " ")
		cout << 0 << endl;
	else
		cout << ans + 1 << endl;

	return 0;
}
