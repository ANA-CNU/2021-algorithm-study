// [회의실 배정](https://www.acmicpc.net/problem/1931)
// 그리디 알고리즘의 대표 문제
// 회의 종료시간이 짧은것 순으로 정렬을 해서 이후에 회의를 할수있는 가능성을 최대한으로 열어둔다.
// 푸는법만 알면 꽤나 쉽게 풀수있는 문제

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++)
	{
		int start, end;
		cin >> start >> end;
		v.push_back(make_pair(end, start));
	}

	sort(v.begin(), v.end());
	int last = -1;
	int answer = 0;
	for (int i = 0; i < v.size(); i++)
	{
		auto p = v[i];
		if (last <= p.second)
		{
			last = p.first;
			answer++;
		}
	}

	cout << answer << '\n';

	return 0;
}
