import sys

def binary_search(list_, target):
    l = 0
    r = len(list_) - 1
    while l <= r:
        mid = (l + r) // 2
        if list_[mid] == target:
            return 1
        elif list_[mid] > target:
            r = mid - 1
        else:
            l = mid + 1

    return 0


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    num_card_list = sys.stdin.readline().rstrip().split(' ')
    num_card_list = list(map(int, num_card_list))
    num_card_list.sort()
    m = int(sys.stdin.readline())
    have_card_list = sys.stdin.readline().rstrip().split(' ')
    have_card_list = list(map(int, have_card_list))

    for card in have_card_list:
        print(binary_search(list_=num_card_list, target=card), end=' ')
