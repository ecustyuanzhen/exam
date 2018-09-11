import java.util.*;

/**
 * @Author:zhenyuan
 * @Date:Created in 上午10:12 2018/8/25
 */

public class toutiao1 {
    static List<Set> setList = new ArrayList<>();
    static List<String> stringList = new ArrayList<>();


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        Set<String> set;
        int num = Integer.parseInt(sc.nextLine());
        Boolean b = false;
        for (int i = 0;i<num;i++){
            String s = sc.nextLine().replaceAll(" ","");
            stringList.add(s);
        }

        for (int i =0;i<num;i++){
            String s = stringList.get(i);
            if (0==setList.size()){
                set = new HashSet<>();
                set.add(i+1+"");
                set = addAll(set,s);
                setList.add(set);
            }else {
                for (int p=0;p<setList.size();p++){
                    set = setList.get(p);
                    if (set.contains((i+1+"").charAt(0))){
                        set = addAll(set,s);
                        b=true;
                        break;
                    }else {
                        for (int j=0;j<s.length()-1;j++){
                            if (set.contains(s.charAt(j))){
                                set = addAll(set,s);
                                p=setList.size();
                                b=true;
                                break;
                            }
                        }

                    }
                    if (b){
                        b=false;
                    }
                }

                if (!b){
                    Set<String> newSet = new HashSet<>();
                    newSet = addAll(newSet,s);
                    setList.add(newSet);
                }

            }
        }

        System.out.println(setList.size());
    }

    public static Set addAll(Set set,String s){
        for (int j=0;j<s.length()-1;j++){
            set.add(s.charAt(j));
        }
        return set;
    }

}
