
/**
 * @author xue yang
 *
 */
import java.io.*;
import java.util.*;

public class DataHandler implements DataInterface {

	@Override
	public ArrayList<VideoRecorder> readIntoArrayList() {
		ArrayList<VideoRecorder> videoList = new ArrayList<VideoRecorder>();
		try {
			Scanner scanFile = new Scanner(new File("videodata.dat"));

			while (scanFile.hasNextLine()) {
				int vID = 0, bID = 0;
				String vTitle = null, bName = null;
				boolean vFlag = false;
				String line = scanFile.nextLine();
				List<String> infoList = Arrays.asList(line.split("\t"));
				vID = Integer.parseInt(infoList.get(0));
				vTitle = infoList.get(1);
				vFlag = Boolean.parseBoolean(infoList.get(2));
				// System.out.println(infoList);
				if (infoList.size() > 3) {
					bID = Integer.parseInt(infoList.get(3));
					bName = infoList.get(4);
				}
				VideoRecorder item = new VideoRecorder(vID, vTitle, vFlag, bID, bName);
				videoList.add(item);
				// videoList.add(item);
			}
			scanFile.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoList;
	}

	@Override
	public Hashtable<Integer, VideoRecorder> readIntoHashTable() {
		Hashtable<Integer, VideoRecorder> videoList = new Hashtable<Integer, VideoRecorder>();
		try {
			Scanner scanFile = new Scanner(new File("videodata.dat"));

			while (scanFile.hasNextLine()) {
				int vID = 0, bID = 0;
				String vTitle = null, bName = null;
				boolean vFlag = false;
				String line = scanFile.nextLine();
				List<String> infoList = Arrays.asList(line.split("\t"));
				vID = Integer.parseInt(infoList.get(0));
				vTitle = infoList.get(1);
				vFlag = Boolean.parseBoolean(infoList.get(2));
				// System.out.println(infoList);
				if (infoList.size() > 3) {
					bID = Integer.parseInt(infoList.get(3));
					bName = infoList.get(4);
				}
				VideoRecorder item = new VideoRecorder(vID, vTitle, vFlag, bID, bName);
				videoList.put(item.getVideoID(), item);
				// videoList.add(item);
			}
			scanFile.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoList;
	}

	@Override
	public void writeArrayList(ArrayList<VideoRecorder> videoList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (VideoRecorder video : videoList) {
				allData += video.toString() + "\n";
			}
			output.println(allData.substring(0, allData.length() - 1));
			output.close();
			System.out.println("Data writing complete!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void writeHashMap(Hashtable<Integer, VideoRecorder> hashList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (VideoRecorder video : hashList.values()) {
				allData += video.toString() + "\n";
			}
			output.println(allData.substring(0, allData.length() - 1));
			output.close();
			System.out.println("Data writing complete!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void printArrayList(ArrayList<VideoRecorder> arrayList) {
		System.out.println("\n---------------------------------------------------------------");
		System.out.format("%5s%20s %8s %10s %15s\n", "Vid", "Vtitle", "Borrowed", "BorrowerID", "BorrowerName");
		System.out.println("---------------------------------------------------------------");
		// String line = "";
		for (VideoRecorder item : arrayList) {
			// line += item.getVideoID() + "\t" + item.getvideoTitle() + "\t" +
			// item.getVideoFlag();
			if (item.getVideoFlag() != false) {
				// line += "\t\t" + item.getBorrowerID() + "\t" +
				// item.getborrowerName() + "\n";
				System.out.format("%5s%20s %8s %10s %15s\n", item.getVideoID(), item.getvideoTitle(),
						item.getVideoFlag(), item.getBorrowerID(), item.getborrowerName());
			} else {
				System.out.format("%5s%20s %8s \n", item.getVideoID(), item.getvideoTitle(), item.getVideoFlag());
				// line += "\n";
			}

		}
		System.out.println("---------------------------------------------------------------");

	}

	@Override
	public void printhHashTable(Hashtable<Integer, VideoRecorder> hashList) {
		String line = "";

		for (VideoRecorder item : hashList.values()) {
			line = item.toString();
			System.out.println(line);
		}

	}

}
