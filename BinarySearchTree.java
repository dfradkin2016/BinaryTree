//Daria Fradkin
//January 12, 2015

//restriction: has to be comparable
public class BinarySearchTree<E extends Comparable<E>>
{
	//set = all different, can't have duplicates, keys have to be set
	//unlike HashTable, can get Keys back in order
	private BinaryTree<E> root;
	
	//constructor
	public BinarySearchTree(E value)
	{
		root = new BinaryTree<E>(value);
	}
	
	//add
	//if you hit the thing thats in there, returns false
	public boolean add(E value)
	{
		return add(value, root);
	}
	
	private boolean add(E value, BinaryTree<E> root)
	{
		if (value.equals(root.value()))
		{
			return false;
		}
		if (value.compareTo(root.value)>0)
		{
			//right
			if (null == root.right())
			{
				root.setRight(new BinaryTree<E>(value));
				return true;
			}
			else
				return add(value, root.right());
		}
		if (value.compareTo(root.value)<0)
		{
			//left
			if (null == root.left())
			{
				root.setLeft(new BinaryTree<E>(value));
				return true;
			}
			else
				return add(value, root.left());
		}
		return false;
	}
	
	//find
	//pointer thing, want the reference
	//reference that contains E
	public BinaryTree<E> find(E value)
	{
		//System.out.println(root.value());
		return find(value, root);
	}
	
	public BinaryTree<E> find(E value, BinaryTree<E> tree)
	{
		//System.out.println(tree.value());
		//System.out.println(value);
		//System.out.println(value.compareTo(root.value()));//<0);
		if (value.equals(tree.value()))
			return tree;
		if (value.compareTo(tree.value())<0 && null != tree.left())
		{
			return find(value, tree.left());
		}
		if (value.compareTo(tree.value())>0 && null != tree.right())
		{
			return find(value, tree.right());		
		}
		return null;
	}
	
	public String toString()
	{
		return root.toString();
	}
	
	//boolean remove, optional
	
	public static void main(String[] args)
	{
		BinarySearchTree<Integer> x = new BinarySearchTree<Integer>(5);
		x.add(3);
		x.add(7);
		x.add(4);
		x.add(6);
		x.add(2);
		x.add(1);
		for (int n: x.root)
		{
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println(x.find(1).value());
		System.out.println(x.find(2).value());
		System.out.println(x.find(3).value());
		System.out.println(x.find(4).value());
		System.out.println(x.find(5).value());
		System.out.println(x.find(6).value());
		System.out.println(x.find(7).value());
	}
}