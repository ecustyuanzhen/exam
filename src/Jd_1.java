/**
 * @Author:zhenyuan
 * @Date:Created in 下午8:51 2018/9/9
 */

import java.util.*;

public class Jd_1 {

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        String s=reader.nextLine();
        String t=reader.nextLine();
        if(s.length()<t.length()||(s.length()==0&&t.length()==0)){
            System.out.println("0");
            return;
        }
        int ret=0;
        for(int i=0;i<=s.length()-t.length();i++){
            if(same(s.substring(i,i+t.length()),t)) ret++;
        }
        System.out.println(ret);
    }
    private  static boolean same(String s,String t){
        if(s.length()!=t.length())return false;
        if(s.length()==0&&t.length()==0)return true;
        HashMap<Character,Character>s2t=new HashMap<>();
        HashMap<Character,Character>t2s=new HashMap<>();
        int lenth=s.length();
        for(int i=0;i<lenth;i++){
            if(!s2t.containsKey(s.charAt(i))&&!t2s.containsKey(t.charAt(i))){
                s2t.put(s.charAt(i),t.charAt(i));
                t2s.put(t.charAt(i),s.charAt(i));
            }else if(s2t.containsKey(s.charAt(i))&&
                    t2s.containsKey(t.charAt(i))&&
                    s2t.get(s.charAt(i)).equals(t.charAt(i))&&
                    t2s.get(t.charAt(i)).equals(s.charAt(i))){
                continue;
            }else
                return false;
        }
        return true;
    }
}
