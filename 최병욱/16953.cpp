// [A → B](https://www.acmicpc.net/problem/16953)
// 간단한 BFS 문제
// 문제를 보자마자 BFS를 떠올렸고 쉽게 구현해서 풀었다.
// 그리디 알고리즘으로도 풀수있는듯 한데 풀이를 확인해볼것.

#include <bits/stdc++.h>
#define MAX 1000000000
using namespace std;


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	long long a, b;
	cin >> a >> b;

	queue<pair<long long, int>> q;
	q.push(make_pair(a, 1));
	while(!q.empty())
	{
		long long num = q.front().first;
		int level = q.front().second;
		q.pop();

		if (num == b)
		{
			cout << level << '\n';
			return 0;
		}

		if (num * 2 <= MAX)
			q.push(make_pair(num * 2, level + 1));

		if (num * 10 + 1 <= MAX)
			q.push(make_pair(num * 10 + 1, level + 1));
	}

	cout << -1 << '\n';
	return 0;
}