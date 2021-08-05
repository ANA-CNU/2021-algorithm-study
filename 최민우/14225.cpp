/**
 * @file 14225.cpp
 * @author choi-min-woo (dandalf@o.cnu.ac.kr)
 * @brief O(N 2^N) = O(20 * 2^20) = 0.2s
 * @date 2021-08-05
 *
 * @copyright Copyright (c) 2021
 *
 */

#include <bits/stdc++.h>
#define int long long
#define min3(a, b, c) min(a, min(b, c))
#define max3(a, b, c) max(a, max(b, c))

using namespace std;
typedef pair<int, int> pii;

int n;
vector<int> field;
bool visited[20000001];

int32_t main(void) {
#ifndef ONLINE_JUDGE
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
#endif  // ONLINE_JUDGE
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  cin >> n;
  field.resize(n);
  for (auto &e : field) cin >> e;
  for (int p = 0; p < (1 << n); p++) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (p & (1 << i)) sum += field[i];
    }
    visited[sum] = true;
  }
  for (int i = 1; i <= 20000000; i++) {
    if (!visited[i]) {
      cout << i << '\n';
      return 0;
    }
  }
  return 0;
}