/**
 * @file 15658.cpp
 * @author choi-min-woo (dandalf@o.cnu.ac.kr)
 * @brief Note : N - 1, not N
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
vector<int> opers;
int oper[4];

int MAX = INT_MIN;
int MIN = INT_MAX;

int calculate() {
  int ret = field[0];
  for (int i = 1; i < n; i++) {
    if (opers[i - 1] == 0) ret += field[i];
    if (opers[i - 1] == 1) ret -= field[i];
    if (opers[i - 1] == 2) ret *= field[i];
    if (opers[i - 1] == 3) ret /= field[i];
  }
  return ret;
}

void choose(int index) {
  if (index == n - 1) {
    int calc = calculate();
    MAX = max(MAX, calc);
    MIN = min(MIN, calc);
    return;
  }
  for (int i = 0; i < 4; i++) {
    if (oper[i] > 0) {
      oper[i] -= 1;
      opers[index] = i;
      choose(index + 1);
      oper[i] += 1;
    }
  }
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
  opers.resize(n - 1);
  for (auto &e : field) cin >> e;
  for (auto &e : oper) cin >> e;

  choose(0);
  cout << MAX << '\n';
  cout << MIN << '\n';

  return 0;
}