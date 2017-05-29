
/**
 * @author xue yang
 *
 */
import java.io.*;
import java.util.*;

public class VideoSystemStarter {
	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String Notice = "=========================\n" + "0.Print Command Lists\n" + "1.List all Videos\n"
				+ "2.Search for Video\n" + "3.Add a New Video\n" + "4.Borrow a Video\n" + "5.Return Video\n"
				+ "6.Modify Video Details\n" + "7.Delete a Video\n" + "8.Exit\n" + "=========================";

		System.out.println(Notice);
		try {
			while (true) {
				System.out.print("Please enter the number for your command: ");

				int command = scan.nextInt();
				VideoOperation vo = new VideoOperation();

				switch (command) {
				case 0:
					System.out.println(Notice);
					break;

				// List video
				case 1:
					vo.listVideo();
					break;
				// search Video
				case 2:
					System.out.println(
							"\nDo you wanna search by\n0.Search by videoID\n1.Search by videoTitle\n=========================");
					int searchCommand = scan.nextInt();
					switch (searchCommand) {
					case 0:
						vo.searchVideoByID();
						break;
					case 1:
						vo.searchVideoByTitle();
						break;
					default:
						System.out.println("invalid inputs! Please input 0 or 1!!!");
					}
					break;

				// add Video
				case 3:
					vo.addVideo();
					break;

				// Borrow Video
				case 4:
					vo.borrowVideo();
					break;

				case 5:
					vo.returnVideo();
					break;

				// modify Video
				case 6:
					vo.modifyVideo();
					break;

				// delete Video
				case 7:
					vo.deleteVideo();
					break;

				// Exit
				case 8:
					System.out.println("Exit");
					System.exit(0);
				default:
					System.out.println("invalid inputs! Please input 0-8!!!");
				}
			}
		} catch (Exception e) {
			System.out.println("Digits only!!");
		}

	}

}
