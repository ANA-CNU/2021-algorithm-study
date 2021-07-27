#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int mat[8001] = {0};
	double sum;
	int maximum = 0;
	vector<int> nums(n, 0);
	for (int i = 0; i < n; i++)
	{
		cin >> nums[i];
		sum += nums[i];
		mat[nums[i] + 4000]++;
		maximum = max(maximum, mat[nums[i] + 4000]);
	}

	sort(nums.begin(), nums.end());

	vector<int> freqs;
	for (int i = nums.front(); i <= nums.back(); i++)
	{
		if (maximum == mat[i + 4000])
		{
			freqs.push_back(i);
		}
	}

	cout << round(sum / n) << '\n' <<
	nums[nums.size() / 2] << '\n' <<
	(freqs.size() >= 2 ? freqs[1] : freqs.front()) << '\n'<<
	nums.back() - nums.front() << '\n';

	return 0;
}