/**
PreorderIterator

root, left, right
@author	Daria Fradkin
@version	December 14, 2015
*/

import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class PreorderIterator<E> implements Iterator<E>
{
	//private BinaryTree<E> tree;
	private Queue<E> values;
	
	/**
	Constructor. Initializes values in the correct order to a Queue.

	@param	t	tree
	*/
	public PreorderIterator(BinaryTree<E> t)
	{
		values = new LinkedList<E>();
		addItem(t);
	}
	
	/**
	Adds each item in the correct order to a Queue.
	Value, left, right

	@param	t	tree
	*/
	private void addItem(BinaryTree<E> tree)
	{
		if (tree.isLeaf())
		{
			values.offer(tree.value());
		}
		else if (tree.right() == null)
		{
			values.offer(tree.value());
			addItem(tree.left());
		}
		else if (tree.left() == null)
		{
			values.offer(tree.value());
			addItem(tree.right());
		}
		else
		{
			values.offer(tree.value());
			addItem(tree.left());
			addItem(tree.right());
		}
	}
	
	/**
	Checks if there is another value
	
	@return	Whether there is another value
	*/
	public boolean hasNext()
	{
		return !values.isEmpty();
	}
	
	/**
	Returns next value
	
	@return	Next value of type E
	*/	
	public E next()
	{
		if (!hasNext())
			throw new NoSuchElementException("No next term.");
		return values.poll();
	}
}