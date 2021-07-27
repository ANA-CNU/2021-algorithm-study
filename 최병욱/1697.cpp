#include <iostream>
#include <queue>
using namespace std;
int N, K;
bool check[100001];

bool valid(int n)
{
	return n >= 0 && n <= 100000 && !check[n];
}

int main()
{
	cin >> N >> K;

	int answer = 0;
	queue<int> q;
	q.push(N);
	check[N] = true;
	while (true)
	{
		int size = q.size();
		for (int i = 0; i < size; i++)
		{
			int num = q.front();
            q.pop();
			if (num == K)
			{
				cout << answer << '\n';
				return 0;
			}

			if (valid(num + 1))
			{
				check[num + 1] = true;
				q.push(num + 1);
			}
			if (valid(num - 1))
			{
				check[num - 1] = true;
				q.push(num - 1);
			}
			if (valid(num * 2))
			{
				check[num * 2] = true;
				q.push(num * 2);
			}
		}

		answer++;
	}

	return 0;
}
