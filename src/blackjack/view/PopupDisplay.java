package blackjack.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopupDisplay 
{
	
	private String windowTitle;
	
	public PopupDisplay()
	{
		windowTitle = "Popup";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, null);
	}
	public String getResponse(String question)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, null, null, "");
		return answer;
	}
}

