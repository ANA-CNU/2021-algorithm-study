#include <iostream>
#include <set>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	cin >> t;

	while(t--)
	{
		int k;
		cin >> k;
		cin.ignore();

		cout << "IN" << endl;

		set<int> s;
		while (k--)
		{
			string cmd = "";
			getline(std::cin, cmd);

			if (cmd.find("I") != string::npos)
			{
				int num = stoi(cmd.substr(2));
				auto it = s.find(num);
				if (it != s.end())
					*it++;
				else
					s.insert(num);
			}
			else if (cmd.find("D") != string::npos)
			{
				if (s.empty()) continue;

				if (stoi(cmd.substr(2)) > 0)
				{
					if (*s.end() > 1)
					{
						*s.end()--;
						continue;
					}

					s.erase(s.end());
				}
				else
				{
					if (*s.begin() > 1)
					{
						*s.begin()--;
						continue;
					}

					s.erase(s.begin());
				}
			}
		}

		if (s.empty())
			cout << "EMPTY" << '\n';
		else
			cout << *s.end() << ' ' << *s.begin() << '\n';
	}

	return 0;
}