
/**
 * @author xue yang
 *
 */
import java.util.*;

public interface DataInterface {
	public ArrayList<VideoRecord> readIntoArrayList();

	public Hashtable<Integer, VideoRecord> readIntoHashTable();

	public void writeArrayList(ArrayList<VideoRecord> videoList);

	public void writeHashMap(Hashtable<Integer, VideoRecord> videoList);

	public void printArrayList(ArrayList<VideoRecord> videoList);

	// public void printhHashTable(Hashtable<Integer, VideoRecorder> videoList);

}
