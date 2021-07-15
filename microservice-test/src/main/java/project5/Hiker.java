package project5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hiker {


    private BSTMountain.BSTNode root;

    public Hiker(BSTMountain.BSTNode root) {
        this.root = root;
    }

    public void travellingDown() {
        if(root == null) {
            return;
        }
        ArrayList<RestStop> path = new ArrayList<>();
        travellingDown(this.root, path);
    }

    private void travellingDown(BSTMountain.BSTNode root, ArrayList<RestStop> path) {

        if(root == null) return;

        RestStop data = null;
        data = root.data;
        if(root == this.root){
            if(!data.obstaclesMap.isEmpty() || !data.suppliesMap.containsKey("food")) return;
            path.add(data);
        } else {

            RestStop prevNode = path.get(path.size()-1);

            Map<String,Integer> resultMap = data.suppliesMap;
            for (Map.Entry<String, Integer> entry : prevNode.suppliesMap.entrySet()) {
                int value = resultMap.getOrDefault(entry.getKey(), 0);
                resultMap.put(entry.getKey(), value+entry.getValue());
            }

            if(data.obstaclesMap.isEmpty() && !data.suppliesMap.containsKey("food")){
                return;
            }else if(data.obstaclesMap.isEmpty() && data.suppliesMap.containsKey("food")){

                int val = data.suppliesMap.get("food") -1;
                data.suppliesMap.put("food", val);
            } else{
                Map<String ,String> mapString = new HashMap<>();
                mapString.put("fallen-tree", "axe");
                mapString.put("river", "raft");

                for (Map.Entry<String, Integer> entry : data.obstaclesMap.entrySet()) {
                    int value = entry.getValue();
                    String key = mapString.get(entry.getKey());
                    int suppliesVal = data.suppliesMap.getOrDefault(key,0);
                    if(suppliesVal < value) return;
                    data.suppliesMap.put(key, suppliesVal-value);
                }
            }
            path.add(data);

        }

        if(root.left == null && root.right == null) {
            if(path.size()%2 ==1)
                printValidPath(path);
            return;
        }

        travellingDown(root.left,new ArrayList<RestStop>(path));
        travellingDown(root.right,new ArrayList<RestStop>(path));
    }

    private void printValidPath(ArrayList<RestStop> path) {
        for(RestStop i: path) {
            System.out.print(i.LABEL + " ");
        }
        System.out.println();
    }

}
