import javax.swing.WindowConstants;

public class Ask {

	public static void main(String[] args) {
		Extractor extractor = new Extractor(System.getProperty("user.dir"));
		AskFrame askFrame = new AskFrame(extractor);
		askFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		askFrame.pack();
		askFrame.setMinimumSize(askFrame.getSize());
		askFrame.setVisible(true);
	}

}
