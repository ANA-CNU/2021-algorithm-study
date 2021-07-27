#include <iostream>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	int scores[1000];
	int m = 0;
	for (int i = 0; i < n; i++)
	{
		int score = 0;
		cin >> score;
		if (m < score)
			m = score;

		scores[i] = score;
	}

	float sum = 0;
	for (int i = 0; i < n; i++)
	{
		float mod = scores[i] / (m * 1.0) * 100;
		sum += mod;
	}

	cout << sum / n << endl;

	return 0;
}
