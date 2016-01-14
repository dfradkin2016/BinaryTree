//Daria Fradkin
//December 9, 2015

public class BTRunner
{
	public static void main(String[] args)
	{
		BinaryTree<String> myTree = new BinaryTree<String>("hi");
		System.out.println(myTree);
		System.out.println(myTree.height());
		System.out.println(myTree.size());
		BinaryTree<String> t0 = new BinaryTree<String>("zero");
		BinaryTree<String> t1 = new BinaryTree<String>("one");
		BinaryTree<String> t2 = new BinaryTree<String>("two");
		BinaryTree<String> t3 = new BinaryTree<String>("three");
		BinaryTree<String> t4 = new BinaryTree<String>("four");
		BinaryTree<String> t5 = new BinaryTree<String>("five");
		BinaryTree<String> t6 = new BinaryTree<String>("six");
		BinaryTree<String> t7 = new BinaryTree<String>("seven");
		BinaryTree<String> t8 = new BinaryTree<String>("eight", t0, t1);
		BinaryTree<String> t9 = new BinaryTree<String>("nine", t2, t3);
		BinaryTree<String> t10 = new BinaryTree<String>("ten", t4, t5);
		BinaryTree<String> t11 = new BinaryTree<String>("eleven", t6, t7);
		BinaryTree<String> t12 = new BinaryTree<String>("twelve", t8, t9);
		BinaryTree<String> t13 = new BinaryTree<String>("thirteen", t10, t11);
		BinaryTree<String> t14 = new BinaryTree<String>("fourteen", t12, t13);
		System.out.println(t14);
		System.out.println(t14.height());
		System.out.println(t14.size());
		System.out.println(t14.isFull()); //true
		/*
		         14
		   12         13
		 8    9     10   11
		0 1  2 3   4 5  6 7
		*/
		t11.setRight(null);
		System.out.println(t14);
		/*
		         14
		   12         13
		 8    9     10   11
		0 1  2 3   4 5  6 
		*/
		System.out.println(t14.isFull()); //false
		t11.setLeft(null);
		System.out.println(t14);
		/*
		         14
		   12         13
		 8    9     10   11
		0 1  2 3   4 5   
		*/
		System.out.println(t14.isFull()); //false
		System.out.println(t14.isComplete()); //true
		t10.setLeft(null);
		System.out.println(t14);
		/*
		         14
		   12         13
		 8    9     10   11
		0 1  2 3     5   
		*/
		System.out.println(t14.isComplete()); //false
		System.out.println(t14.isBalanced()); //true
		t13.setRight(null);
		System.out.println(t14);
		/*
		         14
		   12         13
		 8    9     10   
		0 1  2 3     5   
		*/
		System.out.println(t14.isBalanced()); //false
		for(String s : t14)
		{
			System.out.println(s);
		}
	}
}