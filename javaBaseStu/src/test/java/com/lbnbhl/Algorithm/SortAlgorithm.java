package com.lbnbhl.Algorithm;

import org.junit.Test;

import java.math.MathContext;
import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * 经典排序算法
 *
 * @autor wwl
 * @date 2022/8/31-19:42
 */
public class SortAlgorithm {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};

    @Test
    public void bubbleSortTest() {
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        for (int i = 0; i < bubbleSort(a).length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void selectionSortTest() {
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        for (int i = 0; i < selectionSort(a).length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void InsertSortTest(){
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        for (int i = 0; i < InsertSort(a).length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void shellSortTest(){
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        for (int i = 0; i < shellSort(a).length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void mergeSortTest(){
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        for (int i = 0; i < mergeSort(a).length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void quickSortTest(){
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        int j=quickSort(a).length;
        for (int i = 0; i <j ; i++) {
            System.out.println(a[i]);
        }
//        for (int i : quickSort(a)) {
//            System.out.println(i);
//        }
    }

    @Test
    public void heapSortTest(){
        int[] a = {4, 1, 7, 9, 2, 8, 5, 6, 3, 10};
        int[] res=heapSort(a);
        int j=res.length;
        for (int i = 0; i <j ; i++) {
            System.out.println(res[i]);
        }
    }


    /**
     * 冒泡排序
     * @param sourceArray
     * @return
     */
    public int[] bubbleSort(int[] sourceArray) {
        //进行length-1轮
        for (int i = sourceArray.length; i > 1; i--) {
            //每轮比较i-1次
            for (int j = 0; j < i - 1; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = temp;
                }
            }
        }
        return sourceArray;
    }

    /**
     * 选择排序
     * @param sourceArray
     * @return
     */
    public int[] selectionSort(int[] sourceArray) {
        //进行length-1轮
        for (int i = 0; i < sourceArray.length - 1; i++) {
            int min = i;
//            每轮比较length-i-1次
            for (int j = i + 1; j < sourceArray.length - 1; j++) {
                if (sourceArray[min] > sourceArray[j]) {
                    min = j;
                }
            }
            int temp = sourceArray[min];
            sourceArray[min] = sourceArray[i];
            sourceArray[i] = temp;
        }
        return sourceArray;
    }


    /**
     * 插入排序
     * @param sourceArray
     * @return
     */
    public int[] InsertSort(int[] sourceArray) {
//        进行N-1次比较
        for (int i = 0; i < sourceArray.length-1; i++) {
            int j=i;
//            每次从第sourceArrar[i+1]个元素开始比，比较前面的元素到第一个比他小的为止
//            temp表示要插入的数据
            int temp=sourceArray[i+1];
//            每次比较成功说明得向后移动一位
            while( j>=0 && temp<sourceArray[j] ){
                sourceArray[j+1]=sourceArray[j];
                j--;
            }
//            将数据插入，第j+1个位置
            sourceArray[j+1]=temp;
        }
        return sourceArray;
    }

    /**
     * 希尔排序shell排序
     * 这个排序算法的关键在于他是分成n张表，每张表步长为N/n进行直接排序，然后表翻倍直到每个元素单独作为一张表即n个表为止
     * @param sourceArray
     * @return
     */
    public int[] shellSort(int[] sourceArray){
        for (int step = sourceArray.length/2; step >= 1; step/=2) {
//            表的大小是N/step
            for (int i = 0; i < sourceArray.length-step; i+=step) {
//                temp表示要插入的数据
                int temp=sourceArray[i+step];
                int j=i;
                while(j>=0 && sourceArray[j]>sourceArray[i+step]){
                    sourceArray[j+step]=sourceArray[j];
                    j-=step;
                }
                sourceArray[j+step]=temp;
            }
        }
        return sourceArray;
    }

    /**
     * 归并排序(递归法)
     * 先将一个数组以二分的方式分成n个数组，然后
     * ① 将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
     * ② 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
     * ③ 重复步骤②，直到所有元素排序完毕
     * @param sourceArray
     * @return
     */
    public int[] mergeSort(int[] sourceArray){
        int len=sourceArray.length;
        int result[]=new int[len];
        merge(sourceArray,result,0,len-1);
        return sourceArray;
    }
    void merge(int[] sourceArray,int[] result,int start,int end){
        if(start>=end)
            return;
        int len=end-start;
//        len偶数时左右一样，奇数时是左少一
        int mid=(len/2)+start;
        int start1=start;
        int end1=mid;
        int start2=mid+1;
        int end2=end;
//        递归拆分
        merge(sourceArray,result,start1,end1);
        merge(sourceArray,result,start2,end2);
        int k = start;
//        左右两边都在时，排序到最后一个为止
        while (start1 <= end1 && start2 <= end2)
            result[k++] = sourceArray[start1] < sourceArray[start2] ? sourceArray[start1++] : sourceArray[start2++];
        while (start1 <= end1)
            result[k++] = sourceArray[start1++];
        while (start2 <= end2)
            result[k++] = sourceArray[start2++];
        for (k = start; k <= end; k++)
            sourceArray[k] = result[k];

    }

    /**
     * 快速排序
     * 从数列中挑出一个元素，称为 "基准"（pivot）;
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
     */
    public int[] quickSort(int[] sourceArray){
        int i=0,j=sourceArray.length-1;
        quick(sourceArray,i,j);
        return sourceArray;
    }
    void quick(int[] sourceArray,int pivot,int j){
        int i=pivot+1;
        int k=j;
        if (i>=j){
            return;
        }
        while(i<j){
            if(sourceArray[j]>sourceArray[pivot] && sourceArray[i]<sourceArray[pivot]) {
                j--;
                i=j==i?i:i+1;
            }else if (sourceArray[j]>sourceArray[pivot] && sourceArray[i]>=sourceArray[pivot] ){
                j--;
            }else if (sourceArray[j]<=sourceArray[pivot] && sourceArray[i]<sourceArray[pivot]){
                i++;
            }else {
                swap(sourceArray,i,j);
            }
        }
        swap(sourceArray,pivot,j);
        int pivot1=pivot,j1=j-1;
        int pivot2=j+1,j2=k;
        quick(sourceArray,pivot1,j1);
        quick(sourceArray,pivot2,j2);
    }


    /**
     * 堆排序
     * 创建一个堆 H[0……n-1]；
     * 把堆首（最大值）和堆尾互换；
     * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
     * 重复步骤 2，直到堆的尺寸为 1。
     */
    public int[] heapSort(int[] sourceArray){
        int[] arr=Arrays.copyOf(sourceArray,sourceArray.length);
        int len=sourceArray.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] < arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] < arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

}