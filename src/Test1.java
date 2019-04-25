import java.util.*;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/16 20:21
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Map<Integer, num> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String[] n = a.split("/");
        int hashsize = Integer.parseInt(n[0]);
        String[] n1 = n[1].split(",");
        for (int i = 0; i < n1.length; i++) {
            if (n1[i].contains("-")) {
                String[] n2 = n1[i].split("-");
                for (int j = Integer.parseInt(n2[0]); j <= Integer.parseInt(n2[1]); j++) {
                    list.add(j);
                }
            } else {
                list.add(Integer.valueOf(n1[i]));
            }
        }

        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            int position = list.get(i) % hashsize;
            if (map.containsKey(position)) {
                map.get(position).sum++;
                map.get(position).index = position;
                map.get(position).value.add(list.get(i));
            } else {
                map.put(position, new num(position, 1, list.get(i)));
            }

            if (map.containsKey(max)) {
                if (map.get(max).sum < map.get(position).sum) {
                    max = position;
                } else if (map.get(max).sum == map.get(position).sum) {
                    max = max > position ? position : max;
                }
            }
        }

        System.out.print(map.get(max).sum + "-" + max + "-");
        for (int i = map.get(max).value.size() - 1; i >= 0; i--) {
            System.out.print(map.get(max).value.get(i) + " ");
        }

    }

    static class num {
        int index;
        List<Integer> value = new ArrayList<>();
        int sum = 0;


        public num(int index, int sum, int num) {
            this.index = index;
            this.sum = sum;
            value.add(num);
        }


    }
}
