/**
Binary Tree
A Binary Tree is a data structure that stores information as a tree, but each node
stores pointers for up to two more nodes.
A Binary Tree is a data structure in which each node points to two other nodes, referred 
to as its left child and its right child. 

@author	Daria Fradkin
@version	December 9, 2015
*/

//import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Iterable;

public class BinaryTree<E> implements Iterable<E>
{
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;

	/**
	Default constructor. Initializes with pointers.
	
	@param	v	value stored of type E
	@param	l	left pointer
	@param	r	right pointer
	*/
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
	Default constructor. Initializes without pointers.
	Set value equal to v, left and right are null
	
	@param	v	value stored of type E
	*/
	public BinaryTree(E v)
	{
		value=v;
		left=null;
		right=null;
	}

	/**
	Default constructor. Initializes without pointers and null object.
	Value, left, and right are all null
	
	@param	v	value stored of type E
	*/
	public BinaryTree()
	{
		value=null;
		left=null;
		right=null;
	}

	//Accessors:
	
	/**
	Left accessor
	
	@return	left pointer
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/**
	Right accessor
	
	@return	right pointer
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
	Left accessor
	
	@return	left pointer
	*/
	public E value()
	{
		return value;
	}

	//Modifiers:
	
	/**
	Sets the left pointer
	
	@param	node	tree to point to
	*/
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	/**
	Sets the right pointer
	
	@param	node	tree to point to
	*/	
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}

	/**
	Sets the value
	
	@param	val	value to set to of type E
	*/	
	public void setValue(E val)
	{
		value = val;
	}

	/**
	Checks if tree is a leaf, if it has no children
	If it doesn't point to anymore trees
	
	@return true if leaf
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);
	}
	
	/**
	Return number of descendants of node, including current node
	
	@return	size
	*/
	public int size()
	{
		if (isLeaf())
			return 1;
		else if (left == null)
			return 1 + right.size();
		else if (right == null)
			return 1 + left.size();
		else
			return 1 + left.size() + right.size();
		//return 1 + left.size() + right.size();
	}

	//Iterators:
	
	/**
	Iterates through list using inorderIterator
	
	@return	Iterator<E>
	*/
	public Iterator<E> iterator()
	{
		return inorderIterator();
	}
	
	/**
	Iterates through list using preorderIterator
	value, left, right
	
	@return	Iterator<E>
	*/
	public Iterator<E> preorderIterator()
	{
		return new PreorderIterator<E>(this);
	}
	
	/**
	Iterates through list using inorderIterator
	left, value, right
	
	@return	Iterator<E>
	*/
	public Iterator<E> inorderIterator()
	{
		return new InorderIterator<E>(this);
	}
	
	/**
	Iterates through list using inorderIterator
	left, right, value
	
	@return	Iterator<E>
	*/
	public Iterator<E> postorderIterator()
	{
		return new PostorderIterator<E>(this);
	}
	
	/**
	toString method
	value(left, right)
	
	@return	String representation of list
	*/
	public String toString()
	{
		//had to add output because couldn't call toString on output if value is null
		String output;
		if (value == null)
			output = "Null";
		else
			output = value.toString();
		if (isLeaf())
			return output;
		else if (left == null)
			return output + "(" + right.toString() + ")";
		else if (right == null)
			return output + "(" + left.toString() + ")";
		else
			return output + "(" + left.toString() + "," + right.toString() + ")";
	}

	/**
	Return the maximum path length to a descendent
	
	@return	integer
	*/
	public int height()
	{
		if (isLeaf())
			return 0;
		else if (left == null)
			return right.height() + 1;
		else if (right == null)
			return left.height() + 1;
		if (right.height() > left.height())
			return right.height() + 1;
		return left.height() + 1;
		//or you can use Math.max()
	}

	/**
	Checks if each level is full
	Return true if adding a node to tree would increase its height
	
	@return	true if full
	*/
	public boolean isFull()
	{
		
		//if isLeaf //should not be called unless size = 1
		//	retun true
		//if height() == 1	
		if (isLeaf())
			return true;
		else if (left == null)
			return false;
		else if (right == null)
			return false;
		return (right.height() == left.height()) && right.isFull() && left.isFull();
		//left and right have to be the same height
	}

	/**
	Checks if the tree has been added left to right
	Return true if tree has minimal height and any holes in the tree 
	appear in the last level to the right
	
	@return	true if complete
	*/
	public boolean isComplete()
	{
		if (isLeaf())
			return true;
			//right
		else if (left == null)
			return false;
		else if (right == null)
			return left.isLeaf();
		if (left.height() - right.height() == 1)
			return left.isComplete() && right.isFull();
		if (left.height() == right.height())
			return left.isFull() && right.isComplete();
		else
			return false;
		//return isFull() || (left.size() > right.size() && left.isComplete() && right.isComplete());
	}

	/**
	Return true if the difference of heights of subtrees at every node 
	is no greater than one
	
	@return	true if balanced
	*/
	public boolean isBalanced()
	{
		if (isLeaf())
			return true;
		else if (left == null)
			return right.isLeaf();
		else if (right == null)
			return left.isLeaf();
		else
			return (Math.abs(left.height() - right.height()) < 2) && right.isBalanced() && left.isBalanced();
	}
}