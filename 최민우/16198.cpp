/**
 * @file 16198.cpp
 * @author choi-min-woo (dandalf@o.cnu.ac.kr)
 * @brief 순열은 나빠
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
vector<int> field, choose;
vector<bool> active;

int first(int index) {
  if (active[index])
    return field[index];
  else
    return first(index - 1);
}

int last(int index) {
  if (active[index])
    return field[index];
  else
    return last(index + 1);
}

int got(int index) {
  active[index] = false;
  return first(index - 1) * last(index + 1);
}

int go() {
  int ret = 0;
  for (auto index : choose) ret += got(index);
  return ret;
}

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
  active.resize(n, true);

  for (auto &e : field) cin >> e;
  for (int i = 1; i < n - 1; i++) choose.push_back(i);

  int result = INT_MIN;
  do {
    for (int i = 0; i < n; i++) active[i] = true;
    result = max(result, go());
  } while (next_permutation(choose.begin(), choose.end()));

  cout << result << '\n';

  return 0;
}