package ind.vijay.sort;

public class Algorithm {

    /**
     * 选择排序
     * 首先，找到数组中最小的那个元素，
     * 其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
     * 其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
     * 如此往复，直到将整个数组排序
     * @param src
     * @return
     */
    public static int[] SelectSort(int[] src) {
        int len = src.length;
        for (int i=0; i<len-1; i++) {   // 所有数的遍历
            int min = i;
            for(int j=i+1; j<len; j++) {    // 第一层遍历的i+1至末尾的遍历
                if(src[min] > src[j]) min = j;  // 如果索引i(min) 的值 大于 索引j 的值，最小值得索引位j
            }
            // 交换
            int temp = src[i];
            src[i] = src[min];
            src[min] = temp;
        }
        return src;
    }

    /**
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param src
     * @return
     */
    public static int[] InsertSort(int[] src) {
        if(src == null || src.length < 2) {
            return src;
        }

        int n = src.length;
        int preIndex, current;
        for(int i=1; i<n; i++) {
            preIndex = i-1;
            current = src[i];
            while(preIndex >=0 && src[preIndex]>current) {
                src[preIndex+1] = src[preIndex];
                preIndex--;
            }

            // 插进去
            src[preIndex+1] = current;
        }

        return src;
    }

    /**
     * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。
     * @param src
     * @return
     */
    public static int[] ShellSort(int[] src) {
        int len = src.length;

        int temp, gap = len/2;  // gap,每分组元素数量
        while(gap > 0) {
            for(int i=gap; i<len; i++) {
                temp = src[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && src[preIndex] > temp) {
                    src[preIndex+gap] = src[preIndex];
                    preIndex-= gap;
                }
                src[preIndex+gap] = temp;
            }
            gap/=2;

        }
        return src;
    }
}
