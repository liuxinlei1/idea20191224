package com.wxx.hashmap;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 14:28
 */
public class Hano {

    public static void main(String[] args) {
        
        hanoid(2,'a','b', 'c');
        
        
    }

    //将n个盘, 从a上经b移到c上
    public static void hanoid(int n, char a, char b, char c) {
        if (n<=0){
            return;
        }
        
        //1.将a上的n-1(从最顶上开始往下)个盘经b移动到c上
        hanoid(n-1,a,b,c);
        
        //2.将a上剩余的一个盘移到c上
        move(a,c);
        
        //3.将b上的n-1个经a移到c上
        hanoid(n-1,b,a,c);
    }


    //从a移动b上
    public static void move(char a, char b) {
        System.out.println(a+"---->"+b);
    }
    
    
}
