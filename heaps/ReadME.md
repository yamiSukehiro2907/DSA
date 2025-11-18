Heap:
- Always a complete binary tree (All level nodes have exactly 2 child except the last level  having the childs in leftmost)
- each node is either min/max of that subtree


## O(N) Priority Queue Constructor from Unsorted_array

- Initially we were moving up to down due to which as number of nodes increases at a level total time also increases **(O(N log N))**
- We assume that the left side and right side subtrees are already valid heaps
- We need the last internal node (last node with at least one child)
- If i is the index of a node then its children are at (2 * i + 1) && (2 * i + 2)
- The last node is (N - 1) & it's **parent is (N - 2) / 2 which is our start node of fixing**
- We will start from here and heapifyDown as we move upward toward index 0
- For the level closest to leaves max swaps is 1, then level above that has max swaps 2, and so on
- But as we move upward each level has almost 50% fewer nodes than the level below
- Giving us the equation as **Sigma(i=1, i=log(N)) N(i - 1)/(2^i)** where i represents the level and (i-1) is the max swaps at that level
- When we solve this we get **N - log(N) - 1**, giving us Time complexity of **O(N)**