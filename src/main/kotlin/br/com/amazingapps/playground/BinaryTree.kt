package br.com.amazingapps.playground

class BinaryTree {
    /**
     * which compares the two trees defined by TreeNodes a and b and returns true if they
     * are equal in structure and in value and false otherwise.
     *
     * Examples
     * Two perfect binary trees with three nodes labeled 1 2 3 are shown to be equal ⟹ true
     *
     * Two perfect binary trees with 3 nodes are shown to be nonequal.
     * The left tree has nodes labeled 1, 2 and 3 and the right tree has nodes labeled 1, 3 and 3 ⟹ false (values are not the same: 2 != 3)
     *
     * Two binary trees, each with 3 nodes labeled 1, 2 and 3.
     * The left tree is perfect while the right tree is a linked list of left children,
     * 1-2-3 from the root to the single leaf ⟹ false (structure is not the same)
     * */
    fun binaryTreeCompare(a: TreeNode?, b: TreeNode?): Boolean = when {
        a == null && b == null -> true
        a == null || b == null -> false
        a.value != b.value -> false
        else -> binaryTreeCompare(a.left, b.left) && binaryTreeCompare(a.right, b.right)
    }
}

class TreeNode(
    val value: Int,
    val left: TreeNode?,
    val right: TreeNode?
)