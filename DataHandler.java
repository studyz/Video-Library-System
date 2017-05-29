
/**
 * @author xue yang
 *
 */
import java.io.*;
import java.util.*;

public class DataHandler implements DataInterface {

	@Override
	// read data into a arraylist
	public ArrayList<VideoRecord> readIntoArrayList() {
		ArrayList<VideoRecord> videoList = new ArrayList<VideoRecord>();
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
				VideoRecord item = new VideoRecord(vID, vTitle, vFlag, bID, bName);
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
	// read data into a hashtable
	public Hashtable<Integer, VideoRecord> readIntoHashTable() {
		Hashtable<Integer, VideoRecord> videoList = new Hashtable<Integer, VideoRecord>();
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
				VideoRecord item = new VideoRecord(vID, vTitle, vFlag, bID, bName);
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
	// write data from arraylist
	public void writeArrayList(ArrayList<VideoRecord> videoList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (VideoRecord video : videoList) {
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
	// write data from arrayHasmap
	public void writeHashMap(Hashtable<Integer, VideoRecord> hashList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (VideoRecord video : hashList.values()) {
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
	// print video recorders from arraylist
	public void printArrayList(ArrayList<VideoRecord> arrayList) {
		System.out.println("\n---------------------------------------------------------------");
		System.out.format("%5s%20s %8s %10s %15s\n", "Vid", "Vtitle", "Borrowed", "BorrowerID", "BorrowerName");
		System.out.println("---------------------------------------------------------------");
		// String line = "";
		for (VideoRecord item : arrayList) {
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

}
