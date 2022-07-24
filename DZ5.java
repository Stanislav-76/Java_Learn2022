package DZ_Java;
import java.util.ArrayList;
import java.util.HashMap;


public class DZ5 {
    public static ArrayList<Integer> findPathWave(int x, int y, int fromNode, int toNode) {
        ArrayList<Integer> node = new ArrayList<>();
        node.add(fromNode);        
        HashMap<Integer, Integer> waves = new HashMap<>();
        waves.put(fromNode, 1);
        ArrayList<Integer> nodes = new ArrayList<>();
        while (!waves.containsKey(toNode) && node.size() > 0) {
            nodes = new ArrayList<>(node);
            node.clear();            
            for (int fromNod : nodes) {                
                int pos_x = fromNod % x;
                int pos_y = fromNod / x;
                if (pos_x > 0 && !waves.containsKey(fromNod - 1)) {                    
                    waves.put(fromNod - 1, waves.get(fromNod) + 1);
                    node.add(fromNod - 1);                    
                }
                if (pos_x < x - 1 && !waves.containsKey(fromNod + 1)) {
                    waves.put(fromNod + 1, waves.get(fromNod) + 1);
                    node.add(fromNod + 1);
                }
                if (pos_y > 0 && !waves.containsKey(fromNod - x)) {
                    waves.put(fromNod - x, waves.get(fromNod) + 1);
                    node.add(fromNod - x);
                }
                if (pos_y < y - 1 && !waves.containsKey(fromNod + x)) {
                    waves.put(fromNod + x, waves.get(fromNod) + 1);
                    node.add(fromNod + x);
                }
            }
        }        
        return pathRecovery(x, y, fromNode, toNode, waves);
    }

    public static ArrayList<Integer> pathRecovery(int x, int y, int fromNode, int toNode, HashMap<Integer, Integer> waves) {
        ArrayList<Integer> pathWave = new ArrayList<>();
        if (waves.containsKey(toNode)) {
            pathWave.add(toNode);
            int currentNode = toNode;
            while (currentNode != fromNode) {
                if (waves.containsKey(currentNode - 1) && waves.get(currentNode) - 1 == waves.get(currentNode - 1)) {
                    pathWave.add(currentNode - 1);
                    currentNode -= 1;
                } else {
                    if (waves.containsKey(currentNode + 1)
                            && waves.get(currentNode) - 1 == waves.get(currentNode + 1)) {
                        pathWave.add(currentNode + 1);
                        currentNode += 1;
                    } else {
                        if (waves.containsKey(currentNode - x)
                                && waves.get(currentNode) - 1 == waves.get(currentNode - x)) {
                            pathWave.add(currentNode - x);
                            currentNode -= x;
                        } else {
                            if (waves.containsKey(currentNode + x)
                                    && waves.get(currentNode) - 1 == waves.get(currentNode + x)) {
                                pathWave.add(currentNode + x);
                                currentNode += x;
                            }
                        }
                    }
                }
            }
        }        
        return pathWave;
    }

    public static void main(String[] args) {
        int X = 10;
        int Y = 10;
        int fromNode = 4;  // начальный элемент
        int toNode = 33;   // конечный элемент     
        ArrayList<Integer> path = new ArrayList<>(findPathWave(X, Y, fromNode, toNode));
        System.out.print("Путь ");
        for (int d : path) {
            System.out.print(d + " ");
        }
    }
}