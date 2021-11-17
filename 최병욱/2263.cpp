#include <bits/stdc++.h>
using namespace std;
vector<int> inorder;
vector<int> postorder;
vector<bool> visit(100000, false);

void solve(int start, int end, int root)
{
	cout << root << ' ';

	int inIdx = find(inorder.begin(), inorder.end(), root) - inorder.begin();
	int postIdx = find(postorder.begin(), postorder.end(), root) - postorder.begin();
	int rightLen = end - inIdx;

	if (start <= inIdx -1)
		solve(start, inIdx - 1, postorder[postIdx - rightLen - 1]);

	if (inIdx + 1 <= end)
		solve(inIdx + 1,  end, postorder[postIdx - 1]);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		inorder.push_back(num);
	}

	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		postorder.push_back(num);
	}

	solve(0, n - 1, postorder[n - 1]);

	return 0;
}