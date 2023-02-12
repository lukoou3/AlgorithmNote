from __future__ import annotations

def binary_search(sorted_collection: list[int], item: int) -> int:
    """Pure implementation of binary search algorithm in Python
    Be careful collection must be ascending sorted, otherwise result will be
    unpredictable
    :param sorted_collection: some ascending sorted collection with comparable items
    :param item: item value to search
    :return: index of found item or -1 if item is not found
    """
    left = 0
    right = len(sorted_collection) - 1

    while left <= right:
        midpoint = left + (right - left) // 2
        current_item = sorted_collection[midpoint]
        if current_item == item:
            return midpoint
        elif item < current_item:
            right = midpoint - 1
        else:
            left = midpoint + 1

    return - 1


def binary_search_by_recursion(
    sorted_collection: list[int], item: int, left: int, right: int
    ) -> int:
    """Pure implementation of binary search algorithm in Python by recursion
    Be careful collection must be ascending sorted, otherwise result will be
    unpredictable
    First recursion should be started with left=0 and right=(len(sorted_collection)-1)
    :param sorted_collection: some ascending sorted collection with comparable items
    :param item: item value to search
    :return: index of found item or -1 if item is not found
    """
    if left > right:
        return -1

    midpoint = int((left + right) / 2)

    if sorted_collection[midpoint] == item:
        return midpoint
    elif sorted_collection[midpoint] > item:
        return binary_search_by_recursion(sorted_collection, item, left, midpoint - 1)
    else:
        return binary_search_by_recursion(sorted_collection, item, midpoint + 1, right)


if __name__ == '__main__':
    sorted_array = [0, 5, 7, 9, 10, 15, 20]
    keys = [0, 15, 27]
    for key in keys:
        print((key,
               binary_search(sorted_array, key),
               binary_search_by_recursion(sorted_array, key, 0, len(sorted_array) - 1)
               ))
