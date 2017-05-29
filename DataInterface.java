
/**
 * @author xue yang
 *
 */
import java.util.*;

public interface DataInterface {
	public ArrayList<VideoRecorder> readIntoArrayList();

	public Hashtable<Integer, VideoRecorder> readIntoHashTable();

	public void writeArrayList(ArrayList<VideoRecorder> videoList);

	public void writeHashMap(Hashtable<Integer, VideoRecorder> videoList);

	public void printArrayList(ArrayList<VideoRecorder> videoList);

	// public void printhHashTable(Hashtable<Integer, VideoRecorder> videoList);

}
