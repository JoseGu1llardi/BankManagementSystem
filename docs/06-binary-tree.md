
# Employee Binary Tree

## Overview

I implemented an ordinary Binary Tree to store Employee objects.

Each node contains one Employee and can have up to two children: a left child and a right child.

I did not implement a Binary Search Tree. The assignment requires insertion and traversal in level order, not ordering employees by name.

## EmployeeNode

I created the EmployeeNode class to represent each node in the tree.

Each node stores:
- An Employee object.
- A reference to its left child.
- A reference to its right child.

I made the Employee reference final because it should not change after the node is created.

## Level-Order Insertion

I decided to insert employees using level-order traversal.

I use a Queue because it follows the First-In, First-Out (FIFO) principle.

When inserting an employee, I:
1. Check whether the employee is null.
2. Create a new node.
3. If the tree is empty, make the new node the root.
4. Otherwise, use a queue to visit existing nodes.
5. Insert the new node in the first available left or right position.

This approach fills each level from left to right before moving to the next level.

The time complexity is O(n) because I may need to visit existing nodes to find the first available position.

## Level-Order Traversal

I implemented level-order traversal using a Queue.

I visit the root first, followed by its children from left to right.

I add each visited employee to a list and return the list after processing all nodes.

The time complexity is O(n) because every node is visited once.

## Counting Nodes

I implemented node counting recursively.

For each node, I count:
- The current node.
- All nodes in the left subtree.
- All nodes in the right subtree.

An empty node contributes zero to the count.

The time complexity is O(n).

## Calculating Tree Height

I implemented tree height recursively.

I calculate the height of the left and right subtrees and return one plus the greater height.

I use the following convention:
- An empty tree has height -1.
- A tree with only the root has height 0.
- Each additional level increases the height by one.

I measure height using the number of edges on the longest path from the root to a leaf.

The time complexity is O(n) because every node is visited once.

## Input Validation

I decided to reject null Employee objects during insertion.

If the input is null, the tree throws an IllegalArgumentException and does not change.

## Testing

I created unit tests to verify:
- A new node stores its Employee and has no children.
- The first employee becomes the root.
- Subsequent employees are inserted in level order.
- Level-order traversal returns employees in the expected order.
- Node counting returns the correct result.
- Tree height is correct for empty and non-empty trees.
- Null employees are rejected.

All tests passed successfully.
