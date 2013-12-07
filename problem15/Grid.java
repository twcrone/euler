import java.util.*;

class Grid {

  int size;

  public Grid(int size) {
    this.size = size;
  }

  public int solve() {
    List<Map<String, Integer>> heads = new ArrayList();
    Map<String, Integer> head = new HashMap<String, Integer>();
    head.put("x", 0);
    head.put("y", 0);
    heads.add(head);
    int paths = calculateAllNextHeads(heads);
    return paths;
  }
  
  private List calculateNextHeads(Map point) {
    List nextHeads = new ArrayList();
    if((Integer)point.get("x") < this.size) {
      Map newPoint = new HashMap();
      newPoint.put("x", (Integer)point.get("x") + 1);
      newPoint.put("y", (Integer)point.get("y"));
      nextHeads.add(newPoint);
    }
    if((Integer)point.get("y") < this.size) {
      Map newPoint = new HashMap();
      newPoint.put("x", (Integer)point.get("x"));
      newPoint.put("y", (Integer)point.get("y") + 1);
      nextHeads.add(newPoint);
    }
    return nextHeads;
  }


  private int calculateAllNextHeads(List heads) {
    List allNextHeads = new ArrayList();
    List nextHeads;
    for(Object head : heads) {
      nextHeads = calculateNextHeads((Map)head);
      allNextHeads.addAll(nextHeads);
    }
    if(allNextHeads.isEmpty()) {
      return heads.size();
    }
    else {
      System.out.println(heads.size());
      return calculateAllNextHeads(allNextHeads);
    }
  }

  public static void main(String[] args) {
    int dimension = new Integer(args[0]);
    Grid grid = new Grid(dimension);
    int paths = grid.solve();
    System.out.println("Hello, solution for " + dimension + " is " + paths);
  }  
}