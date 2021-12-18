import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;




// I spent a long time on this and could not figure it out for the life of me
// My program kept getting stuck repeating the same changes over and over again
// Though, it does work for a few shorter paths (ones that avoid the bottom left)
// :'(


public class Dijkstra {
	static int totalCost;
	
	public static void shortestPath
	(HashMap<String, Vertex> vertices, Vertex fv, Vertex tv) {
		PriorityQueue<String,Integer> paths = new PriorityQueue<String,Integer>();
		Graph map = new Graph("MapInformationXY.txt",50,25,28);
		int z = 0;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int[] repeats = new int[150];
		int count = 0;
		while (z < 100) {
			
			if(z == 0) {
			 edges = map.getEdges(fv);
			} else {
				edges = map.getEdges(map.getVertex("" + paths.peekName().charAt(paths.peekName().length()  - 1)));
				if(edges.size() == 0) {
					z++;
					System.out.println(paths.peekName());
					System.out.println("No edges to explore, moving on.");
					continue;
				}
			}
			if (paths.getSize() >= paths.getCapacity()) paths.resize();
			
			
			
			if(z == 0) {
			for (int i = 0; i < edges.size(); i++) {
				int tmpDist = edges.get(i).distCost;
				int tmpTime = edges.get(i).timeCost;
				paths.add(fv.symbol, edges.get(i).toVertex.toString(), 
					Graph.useDistCost ? tmpDist : tmpTime);
				}
				System.out.println(paths);
				z++;
				continue;
				
			}
			if(paths.peekName().contains(tv.symbol)) {
				System.out.println("Solution Found!!!!!");
				break;
			}
			
			
			
			
			//System.out.println(paths.peekName().charAt(paths.peekName().length() - 1));
			if(paths.peekName().charAt(paths.peekName().length() - 1)==('F') && tv.symbol != "M") {
				int tmpDist1 = edges.get(1).distCost;
				int tmpTime1 = edges.get(1).timeCost;
				paths.edit(fv.symbol,edges.get(1).toVertex.toString(),
						Graph.useDistCost ? tmpDist1 : tmpTime1);
				System.out.println(paths);
				z++;
				continue;
			}
			
			/*if(paths.peekName().charAt(paths.peekName().length() - 1)==('R') && tv.symbol != "F") {
				
				z++;
				continue;
	
			}*/
			
			if(paths.peekName().length() > 2 && paths.peekName().contains("" + paths.peekName().charAt(paths.peekName().length()  - 2))
					&& paths.peekName().charAt(paths.peekName().length() - 2)==('G')) {
				int tmpDist1 = edges.get(1).distCost;
				int tmpTime1 = edges.get(1).timeCost;
				paths.edit(fv.symbol,edges.get(1).toVertex.toString(),
						Graph.useDistCost ? tmpDist1 : tmpTime1);
				System.out.println(paths);
				z++;
				continue;
			}
			
			int tmpDist1 = edges.get(0).distCost;
			int tmpTime1 = edges.get(0).timeCost;
			paths.edit(fv.symbol,edges.get(0).toVertex.toString(),
					Graph.useDistCost ? tmpDist1 : tmpTime1);
			System.out.println(paths);
			
			z++;
		
		}
	}
}
