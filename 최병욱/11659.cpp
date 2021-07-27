#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	int sum = 0;
	vector<int> arr(n + 1, 0);
	for (int i = 1; i <= n; i++)
	{
		int num;
		cin >> num;
		sum += num;
		arr[i] = sum;
	}

	for (int it = 0; it < m; it++)
	{
		int i , j;
		cin >> i >> j;
		// j까지의 구간의 합에서 i 이전까지의 구간의 합을 뺴주면 답이 간단하게 나옴.
		// 말 그대로 구간에서 구간을 빼는 공식
		cout << arr[j] - arr[i - 1] << '\n';
	}

	return 0;
}