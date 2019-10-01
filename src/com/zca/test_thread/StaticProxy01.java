package com.zca.test_thread;

/**
 * 静态代理
 * 1.真实角色
 * 2.代理角色
 * @author Altria
 * Date: 30/9/2019 上午 11:45
 */
public class StaticProxy01 {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}


interface Marry{
    void happyMarry();
}

// 真实角色
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("婚礼进行时...");
    }
}

// 代理角色
class WeddingCompany implements Marry{

    // 有个真实角色对象
    private Marry target;

    WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready(){
        System.out.println("现场布置");
    }
    private void after(){
        System.out.println("现场清理");
    }
}
