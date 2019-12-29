package com.wxx.hashmap;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 14:58
 */
public class Cell {
    public static void main(String[] args) {
        int i = new Cell().allCells(4);
        System.out.println(i);
    }

    /**
     * 求第n小时候细胞的数量
     * @param n
     * @return
     */
    public  int allCells(int n){
        return aCell(n)+bCell(n)+cCell(n);
    }
    
    
    /**
     * a状态的细胞数
     * @param n
     * @return
     */
    private int aCell(int n){
        if (n==1){
            return 1;
        }else {
            return aCell(n-1)+bCell(n-1)+cCell(n-1);
        }
    }

    /**
     * b状态的细胞数
     * @param n
     * @return
     */
    private int bCell(int n){
        if (n==1){
            return 0;
        }else {
            return aCell(n-1);
        }
    }

    /**
     * c状态的细胞数
     */
    private int cCell(int n){
        if (n== 1 || n==2){
            return 0;
        }else {
            return bCell(n-1);
        }
    }
}
