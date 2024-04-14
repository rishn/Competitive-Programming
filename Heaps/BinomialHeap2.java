// BINOMIAL HEAP
import java.util.*;

// Class for each node in the Binomial Heap
class Tree {
	public int value;
	public Tree parent;
	public List<Tree> children;
	public int degree;
	public boolean marked;

	public Tree(int value) {
		this.value = value;
		parent = null;
		children = new ArrayList<>();
		degree = 0;
		marked = false;
	}
}

// Class for the Binomial Heap data structure
class BinomialHeap {
	public List<Tree> trees;
	public Tree min_node;
	public int count;

	// Constructor for the Binomial Heap
	public BinomialHeap() {
		min_node = null;
		count = 0;
		trees = new ArrayList<>();
	}

	// Check if the heap is empty
	public boolean isEmpty() {
		return min_node == null;
	}

	// Find the minimum value in the heap
	public void findMin() {
		min_node = null;
		for (Tree tree : trees) {
			if (min_node == null || tree.value < min_node.value) {
				min_node = tree;
			}
		}
	}

	// Merge two binomial heaps
	public void merge(BinomialHeap other_heap) {
		trees.addAll(other_heap.trees);
		count += other_heap.count;
		findMin();
	}

	// Insert a new value into the heap
	public void insert(int value) {
		Tree node = new Tree(value);
		BinomialHeap heap = new BinomialHeap();
		heap.trees.add(node);
		merge(heap);
	}

	// Get the minimum value in the heap
	public int peek() {
		return min_node.value;
    }

	// Extract the minimum value from the heap
	public int extract() {
		Tree minNode = min_node;
		trees.remove(minNode);
		BinomialHeap heap = new BinomialHeap();
		heap.trees = minNode.children;
		merge(heap);
		findMin();
		count -= 1;
		return minNode.value;
	}

	// Perform the bubbling up operation
	public void bubbleUp(Tree node) {
		Tree parent = node.parent;
		while (parent != null && node.value < parent.value) {
			int temp = node.value;
			node.value = parent.value;
			parent.value = temp;
			node = parent;
			parent = node.parent;
		}
	}

	// Decrease the key of a node
	public void reduceKey(Tree node, int new_value) {
		if (new_value > node.value)
			throw new IllegalArgumentException("New value is greater than the current value");
		node.value = new_value;
		bubbleUp(node);
	}

	// Delete a specific node from the heap
	public void delete(int value) {
		reduceKey(new Tree(value), Integer.MIN_VALUE);
		extract();
	}

	// Link two trees together
	public void link(Tree tree1, Tree tree2) {
		if (tree1.value > tree2.value) {
			Tree temp = tree1;
			tree1 = tree2;
			tree2 = temp;
		}
		tree2.parent = tree1;
		tree1.children.add(tree2);
		tree1.degree += 1;
	}

	// Consolidate the trees in the heap
	public void consolidate() {
		int max_degree = (int) Math.floor(Math.log(count) / Math.log(2)) + 1;
		Tree[] degree_to_tree = new Tree[max_degree + 1];

		while (!trees.isEmpty()) {
			Tree current = trees.get(0);
			trees.remove(0);
			int degree = current.degree;
			while (degree_to_tree[degree] != null) {
				Tree other = degree_to_tree[degree];
				degree_to_tree[degree] = null;
				if (current.value < other.value) {
					link(current, other);
				} else {
					link(other, current);
					current = other;
				}
				degree++;
			}
			degree_to_tree[degree] = current;
		}

		min_node = null;
		trees.clear();
		for (Tree tree : degree_to_tree) {
			if (tree != null) {
				trees.add(tree);
				if (min_node == null || tree.value < min_node.value) {
					min_node = tree;
				}
			}
		}
	}

	// Get the size of the heap
	public int size() {
		return count;
	}
}

class Binomial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create binomial heap
        BinomialHeap bh = new BinomialHeap();
        
        // Read n
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            bh.insert(sc.nextInt());
        
        System.out.println(bh.extract());

        bh.delete(sc.nextInt());
        
        System.out.println(bh.extract());
    }
}
