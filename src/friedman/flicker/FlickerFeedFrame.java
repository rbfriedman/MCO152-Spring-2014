package friedman.flicker;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame implements Runnable {
	private JPanel jpImages;
	private ArrayList<JLabel> jlbArray;
	private JScrollPane scrollPane;
	private static final long serialVersionUID = 1L;

	public FlickerFeedFrame() {
		jpImages = new JPanel();
		GridLayout myLayout = new GridLayout(1, 20);
		myLayout.setHgap(5);
		jpImages.setLayout(myLayout);
		jlbArray = new ArrayList<JLabel>(20);
		setUpJLabelArray();

		setApplicationImageIcon();

		scrollPane = new JScrollPane(jpImages);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);

		DownloadFlickerFeedThread frame = new DownloadFlickerFeedThread(this);
		frame.start();
		this.setTitle("Flicker");
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setApplicationImageIcon() {
		// TODO Auto-generated method stub
		DownloadImageIcon iconThread = new DownloadImageIcon(this);
		iconThread.start();
	}

	private void setUpJLabelArray() {
		// TODO Auto-generated method stub
		JLabel temp;
		for (int i = 0; i < 20; i++) {
			temp = new JLabel();
			jlbArray.add(temp);
			jpImages.add(temp);
		}
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {
		Photos photos = feed.getItems();

		for (int i = 0; i < 20; i++) {
			jlbArray.add(new JLabel());
			DownloadImageThread d = new DownloadImageThread(jlbArray.get(i),
					photos.get(i).getMedia().getImageLink());
			d.start();
			System.out.println(photos.get(i).getMedia().getImageLink());

		}

	}

	public static void main(final String args[]) {
		new FlickerFeedFrame().setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
