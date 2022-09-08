import java.io.IOException;



public class Main {



	public static void main(String[] args) throws IOException, InterruptedException {
		
		CorruptionBehaviour corruptionThread = new CorruptionBehaviour();
		corruptionThread.start();
		MalwareBehaviour malwareThread = new MalwareBehaviour();
		malwareThread.start();
		
		//10 5-minutes dos attack
		//5 3-minutes integrity attack, internal to the docker, open, modify files

		//7 3-minutes confidentiality attack, read and send tasks outside
		
	}
}