package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BSTMountainAdventure {

    private static final List<String> VALID_SUPPLIES = Arrays.asList("food", "raft", "axe");
    private static final List<String> VALID_OBSTACLES = Arrays.asList("fallen tree", "river");

    public static void main( String [] args ) throws FileNotFoundException {
        BSTMountain tree = new BSTMountain();

        String fileName =args[0];
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
//				System.out.println(line);

                String tokens[] = line.split(" ");
                String label = null;
                Map<String, Integer> supplies = new HashMap<>();
                Map<String, Integer> obstacles = new HashMap<>();
                boolean isObstacleStarted = false;
                int tokensLength = tokens.length;
                for (int i = 0; i < tokensLength; i++) {
                    String eachToken = tokens[i];
                    if (i == 0) {
                        if (eachToken.length() != 1) {
                            throw new IllegalArgumentException("Invalid label");
                        }
                        label = eachToken;
                    }

                    if (VALID_SUPPLIES.contains(eachToken) && !isObstacleStarted) {
                        int val =supplies.getOrDefault(eachToken, 0);
                        supplies.put(eachToken, val+1);
                    }

                    if (VALID_OBSTACLES.contains(eachToken) || "fallen".equalsIgnoreCase(eachToken)) {
                        isObstacleStarted = true;
                        if (("fallen".equalsIgnoreCase(eachToken)) && ((i + 1) < tokensLength)
                                && ("tree".equals(tokens[i + 1]))) {
                            int val = obstacles.getOrDefault("fallen tree",0);
                            obstacles.put("fallen tree", val+1);
                        } else {
                            int val = obstacles.getOrDefault(eachToken, 0);
                            obstacles.put(eachToken,val+1);
                        }
                    }

                }

                //RestStop data = new
                tree.add(new RestStop(label,supplies,obstacles));
            }
        }



        //System.out.println(tree.toStringTree() );
        Hiker hiker = new Hiker(tree.getRoot());

        //System.out.println("Valid paths are");
        hiker.travellingDown();



/*
        tree = new BSTMountain<>(new LengthComparator() );

        tree.add("salmon");
        tree.add("flounder");
        tree.add("grouper");
        tree.add("cod");
        tree.add("carp");
        tree.add("tilapia");
        tree.add("catfish");
        tree.add("bluefish");
        tree.add("tuna");
        tree.add("yellowtail");
        tree.add("herring");
        tree.add("sturgeon");
*/
    }


}
