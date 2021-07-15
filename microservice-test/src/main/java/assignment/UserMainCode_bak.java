package assignment;

import java.util.HashMap;
import java.util.Map;

public class UserMainCode_bak {

    public int totalParents(int input1, int input2, int[] input3) {
        int totalParents = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<input1 ; i++) {
            if(map.get(input3[i]) == null) {
                map.put(input3[i],1);
            } else {
                map.put(input3[i],map.get(input3[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if((entry.getValue() >= input2 && entry.getKey() != -1)
            || (input2==0 && entry.getKey() == -1)) {
                totalParents++;
            }
        }
        return totalParents;
    }

    public static void main(String[] args) {
        UserMainCode_bak userMainCode = new UserMainCode_bak();
        int[] input1 = {-1};
        int[] input2 = {-1,0,0,0,2,2};
        int[] input3 = {-1,-1};
        System.out.println(userMainCode.totalParents(1, 0,input1));
        System.out.println(userMainCode.totalParents(6, 3,input2));
        System.out.println(userMainCode.totalParents(2, 0,input3));
        String str ;

    }

}
