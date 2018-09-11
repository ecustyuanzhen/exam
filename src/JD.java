import java.util.*;

/**
 * @Author:zhenyuan
 * @Date:Created in 下午8:07 2018/9/9
 */

public class JD {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Long count = Long.parseLong(sc.nextLine());
        List<Goods> goodsList = new ArrayList<>();

        for (int i=0;i<count;i++){
            String[] s = sc.nextLine().split(" ");
            goodsList.add(new Goods(Long.parseLong(s[0]),Long.parseLong(s[1]),Long.parseLong(s[2])));
        }

        Collections.sort(goodsList,myComparator);

        for (int i=0;i<goodsList.size()-1;i++){
            Goods goods1 = goodsList.get(i);
            Goods goods2 = goodsList.get(i+1);
            if ((goods1.a == goods2.a)||(goods1.b >= goods2.b)||(goods1.c>=goods2.c)){
                goodsList.remove(goods1);
                i = i-1;
            }
        }
        System.out.println(count-goodsList.size());
    }

    public static Comparator<Goods> myComparator = new Comparator<Goods>() {
        @Override
        public int compare(Goods o1, Goods o2) {
            return (int) (o1.a-o2.a);
        }
    };
}



class Goods {
    long a;
    long b;
    long c;
    public Goods(long a, long b, long c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}