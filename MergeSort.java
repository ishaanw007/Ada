
class MergeSort {

  void merge(int arr[], int l, int mid, int r) {

    int len1 = mid - l+ 1;
    int len2 = r - mid;

    int leftArr[] = new int[len1];
    int rightArr[] = new int[len2];

    for (int i = 0; i < len1; i++)
      leftArr[i] = arr[l + i];
    for (int j = 0; j < len2; j++)
      rightArr[j] = arr[mid + 1 + j];

    int i=0, j=0, k=1;
   

    while (i < len1 && j < len2) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k] = leftArr[i];
        i++;
      } 
      else 
      {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }

    while (i < len1) {
      arr[k] = leftArr[i];
      i++;
      k++;
    }

    while (j < len2) 
    {
      arr[k] = rightArr[j];
      j++;
      k++;
    }
  }

  void mergeSort(int arr[], int s, int r) {
    if (s < r) {

      int mid = (s + r) / 2;

      mergeSort(arr, s, mid);
      mergeSort(arr, mid + 1, r);

      merge(arr, s, mid, r);
    }
  }

  static void display(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) {
    int arr[] = { 6, 5, 12, 10, 9, 1 };

    MergeSort ms = new MergeSort();
    
    System.out.println("Original array");
    display(arr);    
    
    ms.mergeSort(arr, 0, arr.length - 1);

    System.out.println("Sorted array");
    display(arr);
  }
}

