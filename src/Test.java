import java.util.Scanner;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/16 19:30
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] stringInt = s.split(" ");
        int[] a = new int[stringInt.length];
        for (int j = 0; j < a.length; j++) {
            a[j] = Integer.parseInt(stringInt[j]);
        }
        noDegressive(a);
    }

    //1 2 3 4   9 4 2  9 4 5
    public static void noDegressive(int a[]) {
        int num = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                num++;
            }
            if (num >= 2) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
