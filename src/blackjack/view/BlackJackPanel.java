package blackjack.view;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import blackjack.controller.BlackJackController;

public class BlackJackPanel extends JPanel
{
	private BlackJackController appController;
	private SpringLayout appLayout;
	private JScrollPane gameplayArea;
	
	private JTextArea gameArea;
	private JTextArea dealerCards;
	private JTextArea dealerScore;
	
	private JTextArea playerCards;
	private JTextArea playerScore;
	private int cash;
	private JTextArea playerCash;
	
	public BlackJackPanel(BlackJackController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		dealerCards = new JTextArea("--");
		dealerScore = new JTextArea("0");
		
		playerCards = new JTextArea("--");
		playerScore = new JTextArea("0");
		
		cash = 500;
		playerCash = new JTextArea(cash + "$");
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	public void setupPanel()
	{
		this.setBackground(new Color(100, 0, 0));
		this.setLayout(appLayout);
		
		this.add(dealerCards);
		this.add(dealerScore);
		this.add(playerCards);
		this.add(playerScore);
		this.add(playerCash);
	}
	
	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, dealerCards, 61, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, dealerCards, 61, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, dealerCards, -6, SpringLayout.WEST, dealerScore);
		appLayout.putConstraint(SpringLayout.WEST, dealerScore, 206, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, dealerScore, -210, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, dealerScore, 61, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, playerCards, 86, SpringLayout.SOUTH, dealerCards);
		appLayout.putConstraint(SpringLayout.WEST, playerCards, 0, SpringLayout.WEST, dealerCards);
		appLayout.putConstraint(SpringLayout.EAST, playerCards, -250, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, playerCards, 86, SpringLayout.SOUTH, dealerCards);
		appLayout.putConstraint(SpringLayout.WEST, playerCards, 0, SpringLayout.WEST, dealerCards);
		appLayout.putConstraint(SpringLayout.EAST, playerCards, -250, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, playerScore, 0, SpringLayout.NORTH, playerCards);
		appLayout.putConstraint(SpringLayout.WEST, playerScore, 0, SpringLayout.WEST, dealerScore);
		appLayout.putConstraint(SpringLayout.EAST, playerScore, 0, SpringLayout.EAST, dealerScore);
		appLayout.putConstraint(SpringLayout.NORTH, playerCash, 0, SpringLayout.NORTH, playerCards);
		appLayout.putConstraint(SpringLayout.WEST, playerCash, 18, SpringLayout.EAST, playerScore);
		appLayout.putConstraint(SpringLayout.SOUTH, playerCash, 179, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, playerCash, -158, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		
	}
	
	public void startNewRound()
	{
		
	}
	
	public void setupScrollPane()
	{

	}
}
