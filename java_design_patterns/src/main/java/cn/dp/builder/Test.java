package cn.dp.builder;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
        bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }

    /**
     * 正序排序
     * @param array
     * @return
     */
    public static void bubbleSort(int[] array){
        int temp;
        for (int i = 0; i< array.length; i++){
            for (int j = 0; j <array.length -i-1; j++) {
                if (array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] =array[j+1];
                    array[j+1] =temp;
                }
            }
        }
    }
}
