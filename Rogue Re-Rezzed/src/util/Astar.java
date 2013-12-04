
package util;

import core.Rogue;
import entity.RogueEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Torri
 */
public class Astar {
    private Comparator<Node> nodeSort = new Comparator<Node>(){
        @Override
        public int compare(Node n0,Node n1){
            if(n1.fCost<n0.fCost) return 1;
            if(n1.fCost>n0.fCost) return -1;
            return 0;
        }
    };
    public List<Node> findPath(Vector2i start,Vector2i goal){
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();
        Node current = new Node(start,null,0,getDist(start,goal));
        openList.add(current);
        while(openList.size()>0){
            Collections.sort(openList, nodeSort);
            current = openList.get(0);
            if(current.tile.equals(goal)){
                List<Node> path = new ArrayList<>();
                while(current.parent!=null){
                    path.add(current);
                    current = current.parent;
                }
                openList.clear();
                closedList.clear();
                return path;
            }
            openList.remove(current);
            closedList.add(current);
            for(int i=0;i<9;i++){
                if(i==4)continue;
                int x = current.tile.getX();
                int y = current.tile.getY();
                int xi = (i%3)-1;
                int yi = (i/3)-1;
                if(Rogue.getLevel().board[x+xi][y+yi]) continue;
                Vector2i a = new Vector2i(x+xi,y+yi);
                double gCost = current.gCost + getDist(current.tile,a);
                double hCost = getDist(a,goal);
                Node node = new Node(a,current, gCost, hCost);
                if(vecInList(closedList,a) /*&& gCost>=current.gCost*/) continue;
                if(!vecInList(openList,a) /*|| gCost<current.gCost*/) openList.add(node);
            }
        }
        closedList.clear();
        return null;
    }
    private boolean vecInList(List<Node> list, Vector2i v){
        for(Node n:list){
            if(n.tile.equals(v)) return true;
        }
        return false;
    }
    private double getDist(Vector2i v1,Vector2i v2){
        double dx = v1.getX()-v2.getY();
        double dy = v1.getY()-v2.getY();
        return Math.sqrt((dx*dx)+(dy+dy));
    }
}
