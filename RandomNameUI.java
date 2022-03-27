import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class RandomNameUI extends JFrame {

	private JPanel contentPane;
	private String name = "";
	private DefaultListModel<String> maleListModel = new DefaultListModel<String>();
	private DefaultListModel<String> femaleListModel = new DefaultListModel<String>();
	private DefaultListModel<String> discardListModel = new DefaultListModel<String>();
	private JLabel lblName, lblTotal1, lblTotal2, lblTotal3;
	
	private int t1, t2, t3;
	private String total1, total2, total3;
	
	private RandomName rng;
	private File fileMale, fileFemale, fileDiscard;
	
//	public void setName(String newName) {
//		name = newName;
//	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		RandomName rng = new RandomName(3, 7, 1, "");
//		display(rng);
//	}
	
	public static void display(RandomName rng) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomNameUI frame = new RandomNameUI(rng);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void display2(RandomName rng) {
		RandomNameUI frame = new RandomNameUI(rng);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public RandomNameUI(RandomName rngArg) {
		
		rng = rngArg;
		name = rng.generateName();
		fileMale = new File("./data/" + rng.getUser() + "_male.txt");
		fileFemale = new File("./data/" + rng.getUser() + "_female.txt");
		fileDiscard = new File("./data/" + rng.getUser() + "_discard.txt");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 400);
		setLocationRelativeTo(null);
		setTitle(RandomName.getVersion());
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel(name);
		lblName.setBounds(10, 10, 476, 41);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("HP Simplified", Font.PLAIN, 35));
		contentPane.add(lblName);
		
		lblTotal1 = new JLabel(total1);
		lblTotal1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal1.setBounds(60, 333, 130, 13);
		contentPane.add(lblTotal1);
		
		lblTotal2 = new JLabel(total2);
		lblTotal2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal2.setBounds(203, 335, 130, 13);
		contentPane.add(lblTotal2);
		
		lblTotal3 = new JLabel(total3);
		lblTotal3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal3.setBounds(346, 337, 130, 13);
		contentPane.add(lblTotal3);
		
		JButton btnMale = new JButton("male");
		btnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addName(maleListModel);
			}
		});
		btnMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMale.setBounds(50, 312-30, 130, 41);
		contentPane.add(btnMale);
		
		JButton btnDiscard = new JButton("discard");
		btnDiscard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addName(discardListModel);
			}
		});
		btnDiscard.setBounds(193, 312-30, 130, 41);
		contentPane.add(btnDiscard);
		
		JButton btnFemale = new JButton("female");
		btnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addName(femaleListModel);
			}
		});
		btnFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFemale.setBounds(336, 312-30, 130, 41);
		contentPane.add(btnFemale);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 100, 130, 168);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(193, 100, 130, 168);
		contentPane.add(scrollPane2);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(336, 100, 130, 168);
		contentPane.add(scrollPane3);
		
		JList<String> maleList = new JList<String>();
		maleList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(maleList);
		maleList.setModel(maleListModel);
		maleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		JList<String> femaleList = new JList<String>();
		femaleList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane3.setViewportView(femaleList);
		femaleList.setModel(femaleListModel);
		femaleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		JList<String> discardList = new JList<String>();
		discardList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane2.setViewportView(discardList);
		discardList.setModel(discardListModel);
		discardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maleList.getSelectedIndex() >= 0) {
					maleListModel.remove(maleList.getSelectedIndex());
					t1 -= 1;
					total1 = "total: " + t1;
					lblTotal1.setText(total1);
				}
			};
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setColumnHeaderView(btnDelete);
		
		JButton btnDelete2 = new JButton("delete");
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (discardList.getSelectedIndex() >= 0) {
					discardListModel.remove(discardList.getSelectedIndex());
					t2 -= 1;
					total2 = "total: " + t2;
					lblTotal2.setText(total2);
				}
			}
		});
		btnDelete2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane2.setColumnHeaderView(btnDelete2);
		
		JButton btnDelete3 = new JButton("delete");
		btnDelete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (femaleList.getSelectedIndex() >= 0) {
					femaleListModel.remove(femaleList.getSelectedIndex());
					t3 -= 1;
					total3 = "total: " + t3;
					lblTotal3.setText(total3);
				}
			}
		});
		btnDelete3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane3.setColumnHeaderView(btnDelete3);
		
		loadNames();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveNames();
				System.exit(0);
			}
		});
		
		tts();
		
	}
	
	private void loadNames() {
		
		SaveLoadText.loadText(fileMale, maleListModel);
		SaveLoadText.loadText(fileFemale, femaleListModel);
		SaveLoadText.loadText(fileDiscard, discardListModel);
		
		t1 = maleListModel.getSize();
		t2 = discardListModel.getSize();
		t3 = femaleListModel.getSize();
		
		total1 = "total: " + t1;
		total2 = "total: " + t2;
		total3 = "total: " + t3;
		
		lblTotal1.setText(total1);
		lblTotal2.setText(total2);
		lblTotal3.setText(total3);
	}
	
	private void saveNames() {
		
		SaveLoadText.saveText(fileMale, maleListModel);
		SaveLoadText.saveText(fileFemale, femaleListModel);
		SaveLoadText.saveText(fileDiscard, discardListModel);
		
	}
	
	private void addName(DefaultListModel<String> model) {
		model.addElement(name);
		
		do {
			name = rng.generateName();	
		} while ((maleListModel.contains(name) || discardListModel.contains(name) || femaleListModel.contains(name)));	
		
		lblName.setText(name);
		
		if (model == maleListModel) {
			t1 += 1;
			total1 = "total: " + t1;
			lblTotal1.setText(total1);
		} else if (model == discardListModel) {
			t2 += 1;
			total2 = "total: " + t2;
			lblTotal2.setText(total2);
		} else if (model == femaleListModel) {
			t3 += 1;
			total3 = "total: " + t3;
			lblTotal3.setText(total3);
		} 
		
		tts();
		
	}
	
	public void tts() {
		if (rng.getVoice() != 0) {
			contentPane.update(contentPane.getGraphics());
		}
		
		try {
			rng.tts(name);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
