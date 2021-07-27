#include <iostream>
#include <deque>
using namespace std;

int main()
{
	int t = 0;
	cin >> t;

	while (t--)
	{
		int n, m;
		cin >> n >> m;
		deque<pair<int, int>> dq;
		for (int i = 0; i < n; i++)
		{
			int prior;
			cin >> prior;
			dq.push_back(make_pair(prior, i));
		}

		int order = 0;
		while(!dq.empty())
		{
			bool isPrint = true;
			for (int i = 1; i < dq.size(); i++)
			{
				if (dq.front().first < dq[i].first)
				{
					isPrint = false;
					auto front = dq.front();
					dq.pop_front();
					dq.push_back(front);
					break;
				}
			}

			if (isPrint)
			{
				auto out = dq.front();
				dq.pop_front();
				order++;

				if (out.second == m) break;
			}
		}


		cout << order << endl;
	}

	return 0;
}
