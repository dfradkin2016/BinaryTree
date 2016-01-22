/**
Twenty Questions
Twenty Questions creates a simple question game with a binary tree.
Every time the game is run, it resets the tree to one question - is it alive?
To press yes - use Y, y, yes, or Yes. No is any other key.
All leaf nodes hold an object to ask for.
Other trees (trees with children) hold a full question.

@author	Daria Fradkin
@version	January 5, 2016
*/

import java.util.Scanner;


public class TwentyQuestions
{
	//root never changes what it points to
	//needed when restarting the game
	private BinaryTree<String> root;
	private BinaryTree<String> tree;
	private Scanner in;
	
	/**
	Main method. 
	*/
	public static void main(String[] args)
	{
		TwentyQuestions g = new TwentyQuestions();
		g.game();
	}
	
	/**
	Method that implements the game.
	*/
	private void game()
	{
		in = new Scanner(System.in);
		init("Is it alive?");
		System.out.println("Hello and welcome to my game of questions!");
		System.out.println("To answer yes, type Yes, Y, yes, or Y.");
		while (true)
		{
			System.out.println("Now think of an object, it can be anything!!");
			//Asks
			while (!tree.isLeaf())
			{
				askQ();
			}
			askO();
		}
	}
	
	/**
	Initializes root.
	
	@param	First question
	*/
	private void init(String q)
	{
		root = new BinaryTree<String>(q);
		root.setRight(new BinaryTree<String>("dog"));
		root.setLeft(new BinaryTree<String>("computer"));
		tree = root;
	}
	
	/**
	Asks the question. 
	Can only be used when tree is not a leaf.
	*/
	private void askQ() //ask question
	{
		System.out.println(tree.value());
		String output = in.nextLine();
		if (output.equals("Yes") || output.equals("Y") || output.equals("yes") || output.equals("y"))
		{
			tree = tree.right();
		}
		else
		{
			tree = tree.left();
		}
	}
	
	/**
	Guess the object.
	Last Question.
	Can only be used when tree is a leaf.
	Last thing called before restarting code.
	*/
	private void askO()
	{
		System.out.println("Is it a " + tree.value() + "?");
		String output = in.nextLine();
		if (output.equals("Yes") || output.equals("Y") || output.equals("yes") || output.equals("y"))
		{
			System.out.println("HA I WIN");
		}
		else
			addNew();
		startOver();
	}
	
	/**
	Adds new things to tree/root.
	Called when did not have answer in tree.
	*/
	private void addNew()
	{
		//ASK THE USER, answer - output1
		System.out.println("Okay you got me. What was it?");
		String output1 = in.nextLine();
		//ASK THE USER, question - output2
		System.out.println("What is a question that would differentiate it from a " + tree.value() + "?");
		System.out.println("(For a " + output1 + ", the answer should be yes.)");
		String output2 = in.nextLine();
		BinaryTree<String> q = new BinaryTree<String>(tree.value());
		tree.left = q;
		tree.setValue(output2);
		tree.setRight(new BinaryTree<String>(output1));
	}
	
	/**
	Restarts the game, but keeps root the same.
	*/
	private void startOver()
	{
		System.out.println("Do you want to play again?");
		String output = in.nextLine();
		if (output.equals("Yes") || output.equals("Y") || output.equals("yes") || output.equals("y"))
		{
			tree = root;
			System.out.println("");
		}
		else
			System.exit(0);
	}
}