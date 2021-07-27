#include <iostream>
#include <stack>
using namespace std;

bool check(string str)
{
	bool ret = true;

	stack<char> s;
	for (int i = 0; i < str.length(); i++)
	{
		auto c = str[i];
		if (c == '(' || c == '[')
		{
			s.push(c);
		}
		else if (c == ')' || c == ']')
		{
			if (s.empty())
			{
				ret = false;
				break;
			}

			if ((c == ')' && s.top() == '(') || (c == ']' && s.top() == '['))
			{
				s.pop();
			}
			else
			{
				ret = false;
				break;
			}
		}
	}

	return ret && s.empty();
}

int main()
{
	while(true)
	{
		string str = "";
		getline(cin, str);

		if (str == ".") break;

		if (check(str))
			cout << "yes" << endl;
		else
			cout << "no" << endl;
	}

	return 0;
}
