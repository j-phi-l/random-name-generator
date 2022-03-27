import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * provides static methods for saving/loading data from/to a DefaultComboBoxModel<String> or a DefaultListModel<String> 
 * to/from a simple text file.
 */
public class SaveLoadText {
	
public static void loadText(File file, DefaultComboBoxModel<String> model) {
	
	BufferedReader in = null;
	
	if (!file.exists()) {
		try {
			file.createNewFile();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	} else {
		String userLine;
		try {
			in = new BufferedReader(new FileReader(file));
			while ((userLine = in.readLine()) != null) {
				model.addElement(userLine);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch(IOException ex) {
					ex.printStackTrace();
				}
		}
	}	
}

public static void loadText(File file, DefaultListModel<String> model) {
	
	BufferedReader in = null;
	
	if (!file.exists()) {
		try {
			file.createNewFile();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	} else {
		String userLine;
		try {
			in = new BufferedReader(new FileReader(file));
			while ((userLine = in.readLine()) != null) {
				model.addElement(userLine);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch(IOException ex) {
					ex.printStackTrace();
				}
		}
	}	
}

public static void saveText(File file, DefaultListModel<String> model) {
	
	BufferedWriter out = null;
	
	try {
		out = new BufferedWriter(new FileWriter(file));
		for (int i=0; i<model.getSize(); i++) {
			out.write(model.get(i));
			out.newLine();
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally {
		if (out != null) {
			try {
				out.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}	
}

public static void saveText(File file, DefaultComboBoxModel<String> model) {
	
	BufferedWriter out = null;
	
	try {
		out = new BufferedWriter(new FileWriter(file));
		for (int i=0; i<model.getSize(); i++) {
			out.write(model.getElementAt(i));
			out.newLine();
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally {
		if (out != null) {
			try {
				out.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}	
}

}
