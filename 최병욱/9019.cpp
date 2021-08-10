// [DSLR](https://www.acmicpc.net/problem/9019)
// BFS의 대표적 문제
// 처음에 DFS로 생각해서 DFS를 사용해 최소값을 찾는것으로 풀이를 했는데 깊이 자체가 너무 깊어져서 시간 초과가 났음.
// 그 후에도 연달아 실패해서 타 블로그를 참조했는데 BFS로 접근하는것을 보고 BFS로 로직을 수정해서 풀어봄.
// 하지만 방문 할 "예정"인 노드들을 큐에 그냥 넣어버리는 식으로 로직을 짰더니 시간초과가 남.
// 그래서 방문 할 예정인 노드들은 큐에 넣지않는 식으로 푸니 성공했음. 추후에 다른 문제를 풀때도 이 점을 주의하도록 하자.

#include <bits/stdc++.h>
using namespace std;
vector<bool> visited;

void solve(int start, int target)
{
	queue<pair<int, string>> q;
	q.push(make_pair(start, ""));
	visited[start] = true;
	while(!q.empty())
	{
		int n = q.front().first;
		string str = q.front().second;
		q.pop();

		if (n == target)
		{
			cout << str << '\n';
			return;
		}

		int nums[] = {
			(n * 2) % 10000,
			n - 1 < 0 ? 9999 : n - 1,
			(n % 1000) * 10 + (n / 1000),
			(n % 10) * 1000 + (n / 10)
		};
		string chars[] = {"D", "S", "L", "R"};
		for (int i = 0; i < 4; i++)
		{
			if (visited[nums[i]]) continue;

			visited[nums[i]] = true;
			q.push(make_pair(nums[i], str + chars[i]));
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t = 0;
	cin >> t;

	while (t--)
	{
		int a,b;
		cin >> a >> b;

		visited.assign(10000, false);
		solve(a, b);
	}

	return 0;
}