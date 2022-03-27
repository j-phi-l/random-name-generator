

public class Letter {
	
	private char c;
	
	Letter(boolean b, int n){
		
		if (b) {
			c = (char) (0x0041 + n);
		}
		else {
			c = (char) (0x0061 + n);
		}
	}
	
	static boolean isVocal(char c) {
		switch (c) {
		case 'a':
		case 'e':
		case 'u':
		case 'i':
		case 'o':
		case 'A':
		case 'E':
		case 'I':
		case 'U':
		case 'O':
			return true;
		default:
			return false;
		}
	}
	
	boolean isVocal() {
		return isVocal(c);
	}
	
	char getLetter(){
		return c;
	}
	
	boolean isValid(String s) {
		
		if (c == 'q' || c == 'x') {
			return false;
		}
		
		int l = s.length() - 1;
		
		if (l == 0) {
			return isValidFirst(s);
		}
		else {
			boolean valid = true;
			
			if (isVocal() && isVocal(s.charAt(l)) && isVocal(s.charAt(l - 1))) {
				return false;
			}
			else if (!isVocal() && !isVocal(s.charAt(l)) && !isVocal(s.charAt(l - 1))) {
				return false;
			}
			else if (!isVocal() && (s.charAt(l) == 'w' || s.charAt(l) == 'v')) {
				return false;
			}
			else if (!isVocal(s.charAt(l)) && (c == 'q' || c == 'x')) {
				return false;
			}
			else if (s.charAt(l) == 'j' && !isVocal()) {
				return false;
			}
			else if (s.charAt(l) == c && !isVocal()) {
				switch (c) {
				case 'q':
				case 'w':
				case 'r':
				case 'd':
				case 'h':
				case 'j':
				case 'y':
				case 'x':
				case 'v':
					return false;
				}
			}
			
			return valid;
		}
	}
	
	boolean isValidFirst(String s){
		
		char fl = s.charAt(0);
		boolean valid = true;
		
		if (!isVocal(fl) && !isVocal()) {
			valid = false;
		}
		else {
			return valid;
		}
		
		switch (c) {
		case 'c':
		case 'k':
		case 'm':
		case 'n':
		case 'p':
		case 't':
			if (fl == 'S') {
//				System.out.print(c + " ");
//				System.out.println("case ckmnpt");
				valid = true;
			}
			break;
		case 'h':
			if (fl == 'S' || fl == 'C' || fl == 'T') {
//				System.out.print(c + " ");
//				System.out.println("case h");
				valid = true;
			}
			break;
		case 'j':
			if (fl == 'D') {
//				System.out.print(c + " ");
//				System.out.println("case j");
				valid = true;
			}
			break;
		case 'l':
			if (fl == 'S' || fl == 'C' || fl == 'K' || fl == 'Z') {
//				System.out.print(c + " ");
//				System.out.println("case l");
				valid = true;
			}
			break;
		case 'r':
			if (fl == 'S' || fl == 'C' || fl == 'K' || fl == 'T' || fl == 'D' || fl == 'F') {
//				System.out.print(c + " ");
//				System.out.println("case r");
				valid = true;
			}
			break;
		}
		return valid;
	}
	
	boolean isValidLast(String s) {
		
		if (!isValid(s)) {
			return false;
		}
		
		if (isVocal()) {
			return true;
		}
		
//		boolean valid = true;
		int l = s.length() - 1;
		
		if (isVocal(s.charAt(l))) {
			if (c == 'j' || c == 'v' || c == 'w' || c == 'y') {
				return false;
			}
			else {
				return true;
			}
		}
		
		switch(c) {
		case 'b':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h');
		case 'c':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'l' || s.charAt(l) == 's'); 
		case 'd':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'l');
		case 'f':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'l' || s.charAt(l) == 'h' || s.charAt(l) == 'f');
		case 'g':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h');
		case 'h':
			return (s.charAt(l) == 'c' || s.charAt(l) == 's');
		case 'k':
			return (s.charAt(l) == 'c' || s.charAt(l) == 'l' || s.charAt(l) == 'r' || s.charAt(l) == 's' || s.charAt(l) == 'n');
		case 'l':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'l');
		case 'm':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'm');
		case 'n':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'n');
		case 'p':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'p' || s.charAt(l) == 's' || s.charAt(l) == 'm');
		case 's':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 's' || s.charAt(l) == 'p' || s.charAt(l) == 'l' || s.charAt(l) == 't' || s.charAt(l) == 'c' || s.charAt(l) == 'k' || s.charAt(l) == 'n' || s.charAt(l) == 'm');
		case 'r':
			return (s.charAt(l) == 'h');
		case 't':
			return (s.charAt(l) == 'r' || s.charAt(l) == 'h' || s.charAt(l) == 'n' || s.charAt(l) == 'm' || s.charAt(l) == 'k' || s.charAt(l) == 'f' || s.charAt(l) == 'b' || s.charAt(l) == 'p' || s.charAt(l) == 's' || s.charAt(l) == 't');
		default:
			return false;
		}	
	}
}
