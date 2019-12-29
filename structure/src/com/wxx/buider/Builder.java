package com.wxx.buider;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 15:35
 */
public class Builder {
    private  List<Sender> list = new ArrayList<Sender>();

    /**
     * 创建MailSender对象集合
     * @param count
     */
    public  void produceMainSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }
    
    /**
     * 创建SmsSender集合
     */
    public  void produceSmsSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

}
