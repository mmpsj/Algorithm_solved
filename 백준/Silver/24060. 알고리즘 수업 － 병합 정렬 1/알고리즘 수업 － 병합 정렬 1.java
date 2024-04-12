import java.io.*;
import java.util.*;

public class Main {

    static int cnt;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        num = -1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr, 0, n - 1);
        System.out.println(num);
    }

    public static void merge_sort(int[] arr, int start, int end) {
        if (end > start) {
            int h = (start + end) / 2;
            merge_sort(arr, start, h);
            merge_sort(arr, h + 1, end);
            merge(arr, start, h, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                cnt--;
                if (cnt == 0) num = arr[j];
                k++; j++;
            } else {
                temp[k] = arr[i];
                cnt--;
                if (cnt == 0) num = arr[i];
                k++; i++;
            }
        }
        if (i <= mid) {
            for (; i <= mid; i++) {
                temp[k++] = arr[i];
                cnt--;
                if (cnt == 0) num = arr[i];
            }
        }
        if (j <= end) {
            for (; j <= end; j++) {
                temp[k++] = arr[j];
                cnt--;
                if (cnt == 0) num = arr[j];
            }
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
    }

}