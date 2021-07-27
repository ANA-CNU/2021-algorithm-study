#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main()
{
	int t;
	cin >> t;
	cin.ignore();

	vector<int> st;
	while(t--)
	{
		string cmd = "";
		getline(std::cin, cmd);

		if (cmd.find("push") != string::npos)
		{
			st.push_back(stoi(cmd.substr(5)));
		}
		else if(cmd == "top")
		{
			cout << (st.size() != 0 ? st.back() : -1) << '\n';
		}
		else if(cmd == "size")
		{
			cout << st.size() << '\n';
		}
		else if(cmd == "empty")
		{
			cout << (st.size() == 0) << '\n';
		}
		else if(cmd == "pop")
		{
			cout << (st.size() == 0 ? -1 : st.back()) << '\n';
			if (st.size() != 0)
				st.pop_back();
		}
	}


	return 0;
}
