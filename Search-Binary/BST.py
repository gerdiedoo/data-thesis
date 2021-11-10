from TreeNode import *
from BaseTree import *


class BST(Tree):
    def insert_helper(self, node, val):
        if not node:
            node = Node(val)
            return node
        if val < node.val:
            node.left = self.insert_helper(node.left, val)
        elif val > node.val:
            node.right = self.insert_helper(node.right, val)
        return node

    def insert(self, val):
        self.root = self.insert_helper(self.root, val)

