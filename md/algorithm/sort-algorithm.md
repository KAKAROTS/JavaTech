# 排序算法
1.冒泡排序
```java
public class SortTest {
    public void sort() {
        int arr[] = {3, 5, 1, 9, 0, 45, 3, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
```



2.快速排序
```java
public class SortTest {
    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int base = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= base) {
                r--;
            }
            while (l < r && arr[l] <= base) {
                l++;
            }
            if (l < r) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = base;
        qsort(arr, left, l - 1);
        qsort(arr, r + 1, right);
    }
}


```