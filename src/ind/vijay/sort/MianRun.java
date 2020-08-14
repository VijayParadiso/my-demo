package ind.vijay.sort;

public class MianRun {
    public static void main(String[] args) {
        long start = 0, end = 0;
        int[] src, target;

        src = NumUtils.genRandomArs(100000, 1000000);
        NumUtils.display(src, 1);
        start = System.currentTimeMillis();
        target = Algorithm.SelectSort(src);
        end = System.currentTimeMillis();
        NumUtils.display(target, 2);
        System.out.println("选择排序 耗时: " + (end - start) + " ms");

        src = NumUtils.genRandomArs(100000, 1000000);
        NumUtils.display(src, 1);
        start = System.currentTimeMillis();
        target = Algorithm.InsertSort(src);
        end = System.currentTimeMillis();
        NumUtils.display(target, 2);
        System.out.println("插入排序 耗时: " + (end - start) + " ms");

        src = NumUtils.genRandomArs(100000, 1000000);
        NumUtils.display(src, 1);
        start = System.currentTimeMillis();
        target = Algorithm.ShellSort(src);
        end = System.currentTimeMillis();
        NumUtils.display(target, 2);
        System.out.println("希尔排序 耗时: " + (end - start) + " ms");
    }
}
