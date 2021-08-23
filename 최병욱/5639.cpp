// [이진 검색 트리](https://www.acmicpc.net/problem/5639)
// 이진 검색트리 구현 문제
// 처음엔 전위 순회의 규칙을 이용해서 풀어봤는데 TC는 통과함. 그래서 제출을 해봤지만 fail.
// 아무리 생각해도 반례를 모르겠어서 테스트케이스를 더 찾아보니 극단적으로 오른쪽으로 치우친(ex: 1 2 3) 트리가 입력되면 출력이 이상해짐.
// 이유는 항상 왼쪽을 다 순회한 후 오른쪽을 순회해서 다시 루트로 올라가는 것으로 로직을 짜서 생겨서임.
// 그래서 수가 들어오면 루트의 서브트리들과 비교해주면서 트리를 구성하는 로직을 짜니 AC를 받음.
// 너무 어렵게 생각해서 고생한 문제.
// 반례를 혼자서 찾는 능력은 아직도 부족한듯하다. 꼼꼼히 모든 경우의 수를 만들어서 해보자.

#include <bits/stdc++.h>
using namespace std;

class Node{
public:
	int value;
	Node* left;
	Node* right;
	Node* parent;

	Node(int _val) : value(_val), left(nullptr), right(nullptr), parent(nullptr) {};
};


void Postorder(Node* root)
{
	if (root == nullptr) return;

	Postorder(root->left);
	Postorder(root->right);
	cout << root->value << '\n';
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	Node* root = nullptr;
	int num;
	while (cin >> num)
	{
		Node *node = new Node(num);
		if (root == nullptr)
		{
			root = node;
			continue;
		}

		Node *current = root;
		while (true)
		{
			if (current->value > node->value)
			{
				if (current->left == nullptr)
				{
					node->parent = current;
					current->left = node;
					break;
				}

				current = current->left;
			}
			else
			{
				if (current->right == nullptr)
				{
					node->parent = current;
					current->right = node;
					break;
				}

				current = current->right;
			}
		}
	}

	Postorder(root);

	return 0;
}