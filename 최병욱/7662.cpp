// [이중 우선순위 큐](https://www.acmicpc.net/problem/7662)
// 최대힙과 최소힙을 사용해서 푸는 문제
// 처음에 제목을 보고 힌트를 얻어서 우선순위 큐 두개를 써서 풀까 생각헀었지만 아이디어 구체화에 실패.
// dequeue로 풀려고 시도하다가 시간초과를 계속 받아서 타 블로그의 설명을 읽고 푼 문제
// 트리 개념의 자료구조에 아직까지도 약한것 같다고 생각이든다. 트리 개념의 문제를 좀 더 많이 풀어보자.

#include <bits/stdc++.h>
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

		bool valid[k];
		priority_queue<pair<int, int>> max_pq;
		priority_queue<pair<int, int>,vector<pair<int, int>>,greater<pair<int, int>>> min_pq;
		while (k--)
		{
			string cmd;
			int num;
			cin >> cmd >> num;

			if (cmd == "I")
			{
				max_pq.push(make_pair(num, k));
				min_pq.push(make_pair(num, k));
				valid[k] = true;
			}
			else
			{
				if (min_pq.empty() && max_pq.empty()) continue;

				int idx = num > 0 ? max_pq.top().second : min_pq.top().second;
				valid[idx] = false;
				while (!max_pq.empty() && !valid[max_pq.top().second])
					max_pq.pop();

				while (!min_pq.empty() && !valid[min_pq.top().second])
					min_pq.pop();
			}
		}

		if (min_pq.empty() && max_pq.empty())
			cout << "EMPTY" << '\n';
		else
			cout << max_pq.top().first << ' ' << min_pq.top().first << '\n';
	}

	return 0;
}