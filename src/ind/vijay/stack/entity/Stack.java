package ind.vijay.stack.entity;

import java.util.Arrays;

/**
 * 栈可以用来实现字符串逆序，还可以判断分隔符是否匹配，LIFO
 * 基于数组实现顺序栈，连续存储的线性实现，初始化容量
 */
public class Stack {
    private Object[] objArray;  //栈的容器，使用Object可以实现动态类型
    private int maxSize;
    private int top;

    public Stack() {}

    public Stack(int maxSize) {
        if(maxSize > 0) {
            objArray = new Object[maxSize];
            this.maxSize = maxSize;
            top = -1;   // -1代表空栈，栈内有元素，从0开始
        } else {
            throw new RuntimeException("初始化大小错误：maxSize=" + maxSize + ", maxSize应该大于0");
        }
    }

    /**
     * 栈容器扩容
     */
    public void grow() {
        if(top == maxSize-1) {
            maxSize  = maxSize << 1;   //左移一位，代表乘以 2^1
            objArray = Arrays.copyOf(objArray, maxSize);    // 在原本容器的基础上进行扩容
        }
    }

    /**
     * 查看栈顶
     * @return
     */
    public Object peekTop() {
        if(top != -1) {
            return objArray[top];
        } else {
            throw new RuntimeException("stack is null");
        }
    }

    /**
     * 入栈
     * @param obj
     */
    public void objPush(Object obj) {
        // 扩容
        grow();
        objArray[++top] = obj;
    }

    /**
     * 出栈
     */
    public Object objPop() {
        Object obj = peekTop();

        // 声明原栈顶可以进行GC
        objArray[top--] = null;
        return obj;
    }
}
