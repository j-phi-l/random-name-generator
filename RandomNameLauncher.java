import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class RandomNameLauncher extends JFrame {

	private JPanel contentPane;
	
	private DefaultComboBoxModel<String> minModel = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> maxModel = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> userModel = new DefaultComboBoxModel<String>();
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnTTS1, rdbtnTTS2, rdbtnTTS3;
	
	int voice, maxLength, minLength; // 0: off, 1: voiceRSS, 2: freeTTS
	private String user;
	private File fileUsers = new File("./data/users.txt");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RandomNameLauncher frame = new RandomNameLauncher();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void main(String[] args) {
		new File("./data").mkdirs();
		RandomNameLauncher frame = new RandomNameLauncher();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public RandomNameLauncher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 451);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][100px][100px]", "[][][][][][][][][][][][][][][][][200px]"));
		setTitle(RandomName.getVersion());
		
		for (Integer i=3; i<11; i++) {
			minModel.addElement(i.toString());
			maxModel.addElement(i.toString());
		}
		
		JLabel lblLength = new JLabel("length");
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblLength, "cell 1 1");
		
		JLabel lblMinLength = new JLabel("min");
		lblMinLength.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMinLength, "cell 0 2,growx,aligny top");
		
		JLabel lblMaxLength = new JLabel("max");
		lblMaxLength.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMaxLength, "cell 1 2,growx,aligny top");
		
		JComboBox<String> minList = new JComboBox<String>();
		contentPane.add(minList, "cell 0 3,alignx center,growy");
		minList.setModel(minModel);
		
		JComboBox<String> maxList = new JComboBox<String>();
		contentPane.add(maxList, "cell 1 3,alignx center,growy");
		maxList.setModel(maxModel);
		
		maxList.setSelectedIndex(4);
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "cell 0 5 3 1,growx");
		
		JLabel lblVoice = new JLabel("voice (TTS)");
		lblVoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblVoice, "cell 1 6");
		
		rdbtnTTS1 = new JRadioButton("VoiceRSS");
		buttonGroup.add(rdbtnTTS1);
		contentPane.add(rdbtnTTS1, "cell 0 8");
		
		rdbtnTTS2 = new JRadioButton("FreeTTS");
		buttonGroup.add(rdbtnTTS2);
		contentPane.add(rdbtnTTS2, "cell 1 8");
		
		rdbtnTTS3 = new JRadioButton("off");
		buttonGroup.add(rdbtnTTS3);
		contentPane.add(rdbtnTTS3, "cell 2 8");
		rdbtnTTS3.setSelected(true);
		
		JSeparator separator_1 = new JSeparator();
		contentPane.add(separator_1, "cell 0 10 3 1,growx");
		
		JLabel lblUser = new JLabel("user");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblUser, "cell 1 11");
		
		JComboBox<String> userBox = new JComboBox<String>();
		contentPane.add(userBox, "cell 0 13 2 1,growx");
		userBox.setModel(userModel);
		
		JButton btnNewUser = new JButton("new");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("input new user name:");
				if (userModel.getIndexOf(input) >= 0) {
					JOptionPane.showMessageDialog(null, "user name already exists!");
					userModel.setSelectedItem(input);
				} else {
					userModel.addElement(input);
					userModel.setSelectedItem(input);
				}
			}
		});
		contentPane.add(btnNewUser, "cell 2 13");
		
		JButton btnLaunch = new JButton("launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launch();
			}
		});
		btnLaunch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					launch();
				}
			}
		});
		btnLaunch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnLaunch, "cell 1 16");
		btnLaunch.requestFocus();
		
		minList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selMin = minModel.getSelectedItem().toString();
				String selMax = maxModel.getSelectedItem().toString();
				String minMax = maxModel.getElementAt(0);

				if (Integer.valueOf(selMin) >= Integer.valueOf(minMax)) {
					maxModel.removeAllElements();
					for (Integer i=Integer.valueOf(selMin); i<11; i++) {
						maxModel.addElement(i.toString());
					}
				}
				else if (maxModel.getSize() < minModel.getSize()) {
					maxModel.removeAllElements();
					for (Integer i=Integer.valueOf(selMin); i<11; i++) {
						maxModel.addElement(i.toString());
					}
				}
				if (maxModel.getIndexOf(selMax) >= 0) {
					maxList.setSelectedIndex(maxModel.getIndexOf(selMax));
				}
			}
		});
		
		btnLaunch.requestFocus();
		
		load();
		
//		minList.set
		

	}
	
	public void launch() {
		
		if (rdbtnTTS1.isSelected()) {
			voice = 1;
		} else if (rdbtnTTS2.isSelected()) {
			voice = 2;
		} else {
			voice = 0;
		}
		
		minLength = Integer.valueOf(minModel.getSelectedItem().toString());
		maxLength = Integer.valueOf(maxModel.getSelectedItem().toString());
		
		if (userModel.getSelectedItem().toString().equals("DEFAULT")) {
			user = "";
		} else {
			user = userModel.getSelectedItem().toString();
		}
		
		save();
		
		RandomName rng = new RandomName(minLength, maxLength, voice, user);
		RandomNameUI.display(rng);
		this.dispose();
		
	}
	
	private void load() {
		
		userModel.addElement("DEFAULT");
		SaveLoadText.loadText(fileUsers, userModel);
		
	}
	
	private void save() {
		
		userModel.removeElement("DEFAULT");
		SaveLoadText.saveText(fileUsers, userModel);
		
	}

}
