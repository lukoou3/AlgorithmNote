from __future__ import annotations

def merge_sort(collection: list) -> list:
    """
    :param collection: some mutable ordered collection with heterogeneous
    comparable items inside
    :return: the same collection ordered by ascending
    """

    def merge(left: list, right: list) -> list:
        """
        Merge left and right.
        :param left: left collection
        :param right: right collection
        :return: merge result
        """

        def _merge():
            while left and right:
                yield (left if left[0] <= right[0] else right).pop(0)
            yield from left
            yield from right

        return list(_merge())

    if len(collection) <= 1:
        return collection
    mid = len(collection) // 2
    return merge(merge_sort(collection[:mid]), merge_sort(collection[mid:]))


if __name__ == '__main__':
    array1 = [0, 5, 3, 2, 2, 10, 8, 6, 7, 6]
    array2 = [2, -5, -45, -2, 5, 5, -10, -5, -4]
    print(merge_sort(array1))
    print(merge_sort(array2))