package leetcode.editor.cn;

/**
 * @Date 2020/10/23
 * @Author zhangdianyang
 * @Description
 */
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

class Human {
    public static void main(String[] args) throws Exception {
//        try {
//            try {
//                throw new Sneeze();
//            } catch (Annoyance a) {
//                System.out.println("Caught Annoyance");
//                throw a;
//            }
//        } catch (Sneeze s) {
//            System.out.println("Caught Sneeze");
//            return;
//        } finally {
//            System.out.println("Hello World!");
//        }
        int n = 2;
        n |= n >>> 1;
        System.out.println(n);
    }
}
