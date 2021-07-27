#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int x, y, w, h;

	cin >> x >> y >> w >> h;

	cout << min(min(x ,abs(w - x)), min(y, abs(h - y))) << endl;

	return 0;
}