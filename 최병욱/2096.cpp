// [내려가기](https://www.acmicpc.net/problem/2096)
// DP 최적화 문제
// 푸는방법을 알아내는데는 오래걸리지않았지만 cout & cin으로 풀려고 시도해서 시간이 오래걸린 문제
// 메모리 조금 주면 다음부턴 무조건 scanf랑 printf로 박아야할것같다..

#include <vector>
#include <cstdio>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	vector<int> maxDP(3, 0);
	vector<int> minDP(3, 0);
	for (int i = 0; i < n; i++){
		vector<int> nums(3, 0);
		scanf("%d %d %d", &nums[0], &nums[1], &nums[2]);
		
		vector<int> temp(maxDP);
		maxDP[0] = nums[0] + max(temp[0], temp[1]);
		maxDP[1] = nums[1] + max(temp[0], max(temp[1], temp[2]));
		maxDP[2] = nums[2] + max(temp[1], temp[2]);
		
		vector<int> temp2(minDP);
		minDP[0] = nums[0] + min(temp2[0], temp2[1]);
		minDP[1] = nums[1] + min(temp2[0], min(temp2[1], temp2[2]));
		minDP[2] = nums[2] + min(temp2[1], temp2[2]);
	}
	
	printf("%d %d", max(maxDP[0], max(maxDP[1], maxDP[2])), min(minDP[0], min(minDP[1], minDP[2])));
}
