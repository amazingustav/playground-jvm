package br.com.amazingapps.playground.algorithms

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BinaryTreeTest {

    private val binaryTree: BinaryTree = BinaryTree()

    @Test
    fun itShouldReturnTrueForEqualTreeNodes() {
        val a = TreeNode(1, null, null)
        val b = TreeNode(1, null, null)

        assertTrue(binaryTree.binaryTreeCompare(a, b))
    }

    @Test
    fun itShouldReturnFalseForNonEqualTreeNodes() {
        val a = TreeNode(1, null, null)
        val c = TreeNode(2, null, null)

        assertFalse(binaryTree.binaryTreeCompare(a, c))
    }
}