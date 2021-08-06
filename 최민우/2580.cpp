/**
 * @file 2580.cpp
 * @author choi-min-woo (dandalf@o.cnu.ac.kr)
 * @brief 스도쿠는 3x3 도 확인을 해줘야한다 ㅎㅎ...
 * @date 2021-08-06
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

int field[9][9];
vector<pii> unknown;

bool check(pii pos, int val) {
  for (int i = 0; i < 9; i++) {
    if (field[i][pos.first] == val) return false;
    if (field[pos.second][i] == val) return false;
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        if (field[3 * (pos.second / 3) + j][3 * (pos.first / 3) + k] == val)
          return false;
      }
    }
  }
  return true;
}

bool dfs(int index) {
  if (index == unknown.size()) return true;
  int x, y;
  tie(x, y) = unknown[index];
  for (int i = 1; i <= 9; i++) {
    if (check({x, y}, i)) {
      field[y][x] = i;
      if (dfs(index + 1)) return true;
      field[y][x] = 0;
    }
  }
  return false;
}

int32_t main(void) {
#ifndef ONLINE_JUDGE
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
#endif  // ONLINE_JUDGE
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  for (int y = 0; y < 9; ++y) {
    for (int x = 0; x < 9; ++x) {
      cin >> field[y][x];
      if (field[y][x] == 0) {
        unknown.emplace_back(x, y);
      }
    }
  }
  dfs(0);
  for (int y = 0; y < 9; ++y) {
    for (int x = 0; x < 9; ++x) {
      cout << field[y][x] << ' ';
    }
    cout << '\n';
  }

  return 0;
}