package leetcode.editor.cn;

/**
 * @Date 2020/10/23
 * @Author zhangdianyang
 * @Description
 */
class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    public B() {
        try {
            System.out.print("c");
            return;
        } catch (Exception e) {

        } finally {
            System.out.print("c");
        }
        System.out.print("b");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        System.out.println("\n------");
        ab = new B();
        System.out.println("\n------");
        A abc = new A();
    }
}
