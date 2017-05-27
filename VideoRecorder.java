
/**
 * @author xue yang
 *
 */
public class VideoRecorder implements VideoInfo, BorrowerInfo {
	private int videoID, borrowerID;
	private String videoTitle, borrowerName;
	private boolean flag;

	public VideoRecorder(int videoID, String videoTitle, boolean flag, int borrowerID, String borrowerName) {
		this.videoID = videoID;
		this.videoTitle = videoTitle;
		this.flag = flag;
		this.borrowerID = borrowerID;
		this.borrowerName = borrowerName;
	}

	// video ID
	public void setVideoID(int vID) {
		videoID = vID;
	}

	public int getVideoID() {
		return videoID;
	}

	// video title
	public void setvideoTitle(String vTitle) {
		videoTitle = vTitle;
	}

	public String getvideoTitle() {
		return videoTitle;
	}

	// video flag
	public void setVideoFlag() {
		flag = true;
	}

	public boolean getVideoFlag() {
		return flag;
	}

	// borrower ID
	public void setBorrowerID(int bID) {
		borrowerID = bID;
	}

	public int getBorrowerID() {
		// TODO Auto-generated method stub
		return borrowerID;
	}

	// borrow title
	public void setborrowerName(String bName) {
		borrowerName = bName;
	}

	public String getborrowerName() {
		return borrowerName;
	}

	// video info to string
	public String toString() {
		String videoInfo = videoID + "\t" + videoTitle + "\t" + flag;
		if (flag != false) {
			videoInfo += "\t" + borrowerID + "\t" + borrowerName;
		}
		return videoInfo;
	}

}
