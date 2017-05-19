/**
 * @author xue yang
 *
 */
import java.util.*;


public interface DataInterface {
	public ArrayList<Video> readIntoArrayList();

	public Hashtable<Integer, Video> readIntoHashTable();

	public void writeArrayList(ArrayList<Video> videoList);

	public void writeHashMap(Hashtable<Integer, Video> videoList);

	public void printArrayList(ArrayList<Video> videoList);

	public void printhHashTable(Hashtable<Integer, Video> videoList);

}
