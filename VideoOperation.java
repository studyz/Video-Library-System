
/**
 * @author xue yang
 *
 */
import java.util.*;
import java.util.regex.*;

public class VideoOperation extends DataHandler {
	Scanner sc = new Scanner(System.in);

	// list Video recorder, read all videos recorder from file
	public void listVideo() {
		super.printArrayList(super.readIntoArrayList());
	}

	// borrow Video, modify video recorder borrorwer part, flag, add borrower ID
	// and borrower Name
	public void borrowVideo() {
		System.out.print("plz enter video ID you wanna borrow: ");

		Hashtable<Integer, VideoRecorder> videos = super.readIntoHashTable();
		int borrowVideoID = sc.nextInt();
		if (isExist(borrowVideoID, "") == true) {
			if (videos.get(borrowVideoID).getVideoFlag() == false) {
				Scanner scan = new Scanner(System.in);
				System.out.print("plz enter borrower ID and Borrow Name split wih tab: ");
				String rawinput = scan.nextLine();
				try {
					int newBorrowerID = Integer.parseInt(rawinput.split("\t")[0]);
					String newborrowerName = rawinput.split("\t")[1];

					videos.get(borrowVideoID).setVideoFlag();
					videos.get(borrowVideoID).setBorrowerID(newBorrowerID);
					videos.get(borrowVideoID).setborrowerName(newborrowerName);
					// rw.printVideoList(videos);
					super.writeHashMap(videos);
				} catch (Exception e) {
					System.out.println("Invalid Input!!");
				}

			} else {
				System.out.println("Video has been borrowed!!");
			}

		} else {
			System.out.println("Please input valid video ID!!");
		}
	}

	// add Video recorder
	public void addVideo() {
		System.out.print("plz enter video ID and video title split with tab: ");
		String input = sc.nextLine();
		try {
			int newVideoID = Integer.parseInt(input.split("\t")[0]);
			String newVideoName = input.split("\t")[1];

			if (isExist(newVideoID, newVideoName) == false) {
				System.out.println("New Video is: " + newVideoID + "\t" + newVideoName);
				ArrayList<VideoRecorder> videoList = super.readIntoArrayList();
				VideoRecorder newVideo = new VideoRecorder(newVideoID, newVideoName, false, 0, "null");
				videoList.add(newVideo);
				super.writeArrayList(videoList);
				// rw.printVideoArrayList(videoList);
			} else {
				System.out.println("Video is alrady exist!!");
			}
		} catch (Exception e) {
			System.out.println("Invalid Input!!");
		}
	}

	// modify Video recorder, modify video ID & video Title
	public void modifyVideo() {

		ArrayList<VideoRecorder> videos = super.readIntoArrayList();
		super.printArrayList(videos);
		System.out.print("Please enter Video ID you wanna modify: ");
		int delVideoID = sc.nextInt();
		if (isExist(delVideoID, "") == true && videos.size() != 0) {
			System.out.print("Please enter new info split with tab: ");
			Scanner scan = new Scanner(System.in);
			String newInfo = scan.nextLine();
			try {
				int newVideoID = Integer.parseInt(newInfo.split("\t")[0]);
				String newVideoName = newInfo.split("\t")[1];

				if (delVideoID == newVideoID || isExist(newVideoID, newVideoName) == false) {
					System.out.println("New Video is: " + newVideoID + "\t" + newVideoName);
					Hashtable<Integer, VideoRecorder> videolist = super.readIntoHashTable();
					videolist.get(delVideoID).setVideoID(newVideoID);
					videolist.get(delVideoID).setvideoTitle(newVideoName);
					// rw.printVideoList(videolist);
					super.writeHashMap(videolist);
				} else {
					System.out.println("Info has alrady exist!!");
				}

			} catch (Exception e) {
				System.out.println("Invalid Input!!");
			}

		}
	}

	// delete Video recorder, delete video by video ID
	public void deleteVideo() {
		ArrayList<VideoRecorder> videos = super.readIntoArrayList();
		super.printArrayList(videos);
		System.out.print("Please enter Video ID to delete video: ");
		int delVideoID = sc.nextInt();
		if (isExist(delVideoID, "") == true && videos.size() != 0) {
			for (VideoRecorder video : videos) {
				if (video.getVideoID() == delVideoID) {
					videos.remove(video);
					// need to write into file here
					// rw.printVideoArrayList(videos);
					super.writeArrayList(videos);
					break;
				}
			}

		} else {
			System.out.println("Please enter valid video ID!!");
		}

	}

	// search Video recorder By video ID
	public void searchVideoByID() {

		System.out.print("Please enter video ID: ");
		int rawID = sc.nextInt();
		ArrayList<VideoRecorder> resulltList = new ArrayList<VideoRecorder>();
		for (VideoRecorder video : super.readIntoArrayList()) {
			if (rawID == video.getVideoID()) {
				resulltList.add(video);
			}
		}
		if (resulltList.size() != 0) {
			super.printArrayList(resulltList);
		} else {
			System.out.println("id video not exist!!");
		}
	}

	// search Video recorder By video Title
	public void searchVideoByTitle() {

		System.out.print("Please enter video title: ");
		String rawTitle = sc.next();
		ArrayList<VideoRecorder> resulltList = new ArrayList<VideoRecorder>();
		for (VideoRecorder video : super.readIntoArrayList()) {
			Pattern p = Pattern.compile(rawTitle.toLowerCase());
			Matcher m = p.matcher(video.getvideoTitle().toLowerCase());
			if (m.find()) {
				resulltList.add(video);
			}
		}
		if (resulltList.size() != 0) {
			super.printArrayList(resulltList);
		} else {
			System.out.println("title video not exist!!");
		}
	}

	// check video recorder in database
	public boolean isExist(int newVideoID, String newVideoTitle) {
		ArrayList<VideoRecorder> videoList = super.readIntoArrayList();
		int flag = 0;

		for (VideoRecorder video : videoList) {
			if (video.getvideoTitle().toLowerCase().equals(newVideoTitle.toLowerCase())
					|| video.getVideoID() == newVideoID) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

}
