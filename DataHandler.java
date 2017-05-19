/**
 * @author xue yang
 *
 */
import java.io.*;
import java.util.*;

public class DataHandler implements DataInterface {

	@Override
	public ArrayList<Video> readIntoArrayList() {
		ArrayList<Video> videoList = new ArrayList<Video>();
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
				Video item = new Video(vID, vTitle, vFlag, bID, bName);
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
	public Hashtable<Integer, Video> readIntoHashTable() {
		Hashtable<Integer, Video> videoList = new Hashtable<Integer, Video>();
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
				Video item = new Video(vID, vTitle, vFlag, bID, bName);
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
	public void writeArrayList(ArrayList<Video> videoList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (Video video : videoList) {
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
	public void writeHashMap(Hashtable<Integer, Video> hashList) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (Video video : hashList.values()) {
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
	public void printArrayList(ArrayList<Video> arrayList) {
		String line = "Vid\tVtitle\t\tflag\tbid\tbname\n------------------------------------\n";
		for (Video item : arrayList) {
			line += item.getVideoID() + "\t" + item.getvideoTitle() + "\t" + item.getVideoFlag();
			if (item.getVideoFlag() != false) {
				line += "\t" + item.getBorrowerID() + "\t" + item.getborrowerName() + "\n";
			} else {
				line += "\n";
			}

		}
		System.out.print(line);

	}

	@Override
	public void printhHashTable(Hashtable<Integer, Video> hashList) {
		String line = "";

		for (Video item : hashList.values()) {
			line = item.toString();
			System.out.println(line);
		}

	}

}
