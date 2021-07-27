#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	queue<int> q;
	for (int i = 1; i <= n; i++)
	{
		q.push(i);
	}

	while(q.size() != 1)
	{
		q.pop();
		int front = q.front();
		q.pop();
		q.push(front);
	}

	cout << q.front() << endl;

	return 0;
}