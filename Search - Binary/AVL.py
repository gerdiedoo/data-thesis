from TreeNode import *
from BaseTree import *


def height(node):
    if not node:
        return 0
    if node.left and not node.right:
        return height(node.left) + 1
    if not node.left and node.right:
        return height(node.right) + 1
    if node.left and node.right:
        return max(height(node.left), height(node.right)) + 1
    return 0


def adjust_height(node):
    if not node:
        return
    node.height = max(height(node.left), height(node.right)) + 1


def balance_factor(node):
    if not node:
        return 0
    return height(node.left) - height(node.right)


def left_left_rotation(node):
    l = node.left
    lr = l.right
    node.left = lr
    l.right = node
    return l


def right_right_rotation(node):
    r = node.right
    rl = r.left
    node.right = rl
    r.left = node
    return r


def left_right_rotation(node):
    l = node.left
    lr = l.right
    lrl = lr.left
    lrr = lr.right
    l.right = lrl
    lr.left = l
    node.left = lr

    node.left = lrr
    lr.right = node

    return lr


def right_left_rotation(node):
    r = node.right
    rl = r.left
    rll = rl.left
    rlr = rl.right
    r.left = rlr
    rl.right = r
    node.right = rl

    node.right = rll
    rl.left = node

    return rl


def balance(node):
    if balance_factor(node) > 1:
        if balance_factor(node.left) > 0:
            return left_left_rotation(node)
        else:
            return left_right_rotation(node)
    elif balance_factor(node) < -1:
        if balance_factor(node.right) < 0:
            return right_right_rotation(node)
        else:
            return right_left_rotation(node)
    return node


class AVL(Tree):
    def insert_helper(self, node, val):
        if not node:
            node = Node(val)
            return node
        if val < node.val:
            node.left = self.insert_helper(node.left, val)
        elif val > node.val:
            node.right = self.insert_helper(node.right, val)
        adjust_height(node)
        node = balance(node)
        return node

    def insert(self, val):
        self.root = self.insert_helper(self.root, val)
