import java.util.Random;

public class RandomName {
	
	int voice, maxLength, minLength;
	private String user;
	Random rand = new Random();
	private static final String VERSION = "random name generator v1.1 \t \t \t ©2022 phi";
	
	public String generateName() {
		
		int length = rand.nextInt(minLength - 2, maxLength - 1), i = 0;
		String name = "";
		Letter letter;
		
		while (name.length() == 0) { // generate first letter
			letter = new Letter(true, rand.nextInt(25));
			if (letter.getLetter() != 'Q' && letter.getLetter() != 'X') {
				name += letter.getLetter();
			}
		}
		
		while (i < length) {  // generate middle letters
			letter = new Letter(false, rand.nextInt(25));
			//System.out.println(rl.valid(name));
			if (letter.isValid(name)) {
				name += letter.getLetter();
				i++;
			}
		}
		
		while (true) { // generate last letter
			letter = new Letter(false, rand.nextInt(25));
//			System.out.println("" + letter.getLetter() + " " + name + " " + letter.isValidLast(name));
			if (letter.isValidLast(name)) {
				name += letter.getLetter();
				break;
			}
		}
		
		return name;
	}
	
	public void tts(String name) throws Exception {
		if (voice == 1) {
			VoiceRSS.tts(name);
			PlayAudio.playAudio("voice.mp3");
		}
		else if (voice == 2) {
			FreeTTS.tts(name);
		}
	}
	
	
//	public static void main(String[] args) throws Exception{
//		
//		RandomName rng = new RandomName(3, 7, 1, "");
//		
//		String name = rng.generateName();
//		
//		rng.voice=2;
//		rng.tts(name);
////		name = rng.generateName();
////		rng.tts(name);
//		
////		RandomNameUI ui = new RandomNameUI(rng);
////		ui.setName(name);
////		ui.display(rng);
//		
//		S.pl(name);
//			
//	}
	
	public RandomName(int minLength, int maxLength, int voice, String user) {
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.voice = voice;
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public static String getVersion() {
		return VERSION;
	}
	
	public int getVoice() {
		return voice;
	}

}
