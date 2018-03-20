package blackjack.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopupDisplay 
{
	
	private String windowTitle;
	private ImageIcon icon;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/cartoonCards.jpg"));
		windowTitle = "Popup";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	public String getResponse(String question)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
}

