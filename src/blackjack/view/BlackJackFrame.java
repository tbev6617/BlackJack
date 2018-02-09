package blackjack.view;

import javax.swing.JFrame;
import blackjack.controller.BlackJackController;

public class BlackJackFrame extends JFrame
{
	private BlackJackController appController;
	private BlackJackPanel appPanel;
	public BlackJackFrame(BlackJackController appController)
	{
		super();
		this.appController = appController;
		appPanel = new BlackJackPanel(appController);
		setupFrame();
	}
	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Black Jack");
		this.setSize(500, 300);
		this.setResizable(true);
		this.setVisible(true);	
	}
}
