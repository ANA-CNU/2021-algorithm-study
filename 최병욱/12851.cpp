#include <bits/stdc++.h>
using namespace std;

bool check[100001];

bool valid(int n)
{
	return n >= 0 && n <= 100000 && !check[n];
}

int main()
{
	int n, k;
	cin >> n >> k;

	int answer = 0;
	queue<int> q;
	q.push(n);
	check[n] = true;
	while(!q.empty())
	{
		bool found = false;
		int cnt = 0;
		int size = q.size();
		for (int i = 0; i < size; i++)
		{
			int num = q.front();
			check[num] = true;
			q.pop();

			if (num == k)
			{
				found = true;
				cnt++;
			}

			if (found) continue;

			if (valid(num + 1))
			{
				q.push(num + 1);
			}
			if (valid(num - 1))
			{
				q.push(num - 1);
			}
			if (valid(num * 2))
			{
				q.push(num * 2);
			}
		}

		if (found){
			cout << answer << '\n' << cnt;
			return 0;
		}

		answer++;
	}

	return 0;
}