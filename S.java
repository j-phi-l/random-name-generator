import java.util.ArrayList;

/**
 * provides a shorter alternative to the System.out.print() and System.out.println()
 * commands, as well as equivalent commands for arrays and ArrayLists.
 */
public class S {
	
	
	// System.out.print()
	public static void p(int i) {
		System.out.print(i);
	}
	public static void p(long i) {
		System.out.print(i);
	}
	public static void p(short i) {
		System.out.print(i);
	}
	public static void p(byte i) {
		System.out.print(i);
	}
	public static void p(float i) {
		System.out.print(i);
	}
	public static void p(double i) {
		System.out.print(i);
	}
	public static void p(char i) {
		System.out.print(i);
	}
	public static void p(String i) {
		System.out.print(i);
	}
	public static void p(ArrayList a) {
		if (a.isEmpty()) {
			p("empty");
		}
		else {
			String str = "";
			for (int i=0; i<a.size()-1; i++) {
				str += a.get(i).toString() + ", ";
			}
			str += a.get(a.size()-1).toString();
			p(str);
		}
	}
	public static void p(int[] a) {
		if (a.length == 0) {
			p("empty");
		}
		else {
			String str = "";
			for (int i=0; i<a.length-1; i++) {
				str += a[i] + ", ";
			}
			str += a[a.length-1];
			p(str);
		}
	}
	public static void p(double[] a) {
		if (a.length == 0) {
			p("empty");
		}
		else {
			String str = "";
			for (int i=0; i<a.length-1; i++) {
				str += a[i] + ", ";
			}
			str += a[a.length-1];
			p(str);
		}
	}
	
	// System.out.println()
	public static void pl(int i) {
		System.out.println(i);
	}
	public static void pl(long i) {
		System.out.println(i);
	}
	public static void pl(short i) {
		System.out.println(i);
	}
	public static void pl(byte i) {
		System.out.println(i);
	}
	public static void pl(float i) {
		System.out.println(i);
	}
	public static void pl(double i) {
		System.out.println(i);
	}
	public static void pl(char i) {
		System.out.println(i);
	}
	public static void pl(String i) {
		System.out.println(i);
	}
	public static void pl(ArrayList a) {
		if (a.isEmpty()) {
			pl("null");
		}
		else {
			String str = "";
			for (int i=0; i<a.size()-1; i++) {
				str += a.get(i).toString() + ", ";
			}
			str += a.get(a.size()-1).toString();
			pl(str);
		}
	}
	public static void pl(int[] a) {
		if (a.length == 0) {
			pl("empty");
		}
		else {
			String str = "";
			for (int i=0; i<a.length-1; i++) {
				str += a[i] + ", ";
			}
			str += a[a.length-1];
			pl(str);
		}
	}
	public static void pl(double[] a) {
		if (a.length == 0) {
			pl("empty");
		}
		else {
			String str = "";
			for (int i=0; i<a.length-1; i++) {
				str += a[i] + ", ";
			}
			str += a[a.length-1];
			pl(str);
		}
	}

	
}
