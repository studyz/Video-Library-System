
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class ReadWrite {
	// read data into hashtable
	public Hashtable<Integer, Video> readIntoHashWithID() {
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

	// read data into arraylist
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

	// write file by ArrayList
	public void writeArrayList(ArrayList<Video> videoList) {
		// PrintWriter output;
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

	// write file by hashmap
	public void writeHashMap(Hashtable<Integer, Video> videoList) {
		// PrintWriter output;
		try {
			PrintWriter output = new PrintWriter(new FileWriter("videodata.dat"));
			String allData = "";
			for (Video video : videoList.values()) {
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

	// toString by ArrayList
	public void printVideoArrayList(ArrayList<Video> list) {
		String line = "Vid\tVtitle\t\tflag\tbid\tbname\n------------------------------------\n";
		for (Video item : list) {
			line += item.getVideoID() + "\t" + item.getvideoTitle() + "\t" + item.getVideoFlag();
			if (item.getVideoFlag() != false) {
				line += "\t" + item.getBorrowerID() + "\t" + item.getborrowerName() + "\n";
			} else {
				line += "\n";
			}

		}
		System.out.print(line);
	}

	// toString by hash map
	public void printVideoList(Hashtable<Integer, Video> videolist) {
		String line = "";

		for (Video item : videolist.values()) {
			line = item.toString();
			System.out.println(line);
		}
	}
}