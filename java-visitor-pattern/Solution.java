import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int result = 0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {}

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long result = 1L;
    private int modulo = 1000000007;
    public int getResult() {
        return (int)result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) result = (result * node.getValue()) % modulo;
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) result = (result * leaf.getValue()) % modulo;
    }
}

class FancyVisitor extends TreeVis {
    int nonLeafSum = 0;
    int greenLeafSum = 0;
    public int getResult() {
        return Math.abs(nonLeafSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) nonLeafSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) greenLeafSum += leaf.getValue();
    }
}

public class Solution1 {
    static Map<Integer, Set<Integer>> mapTree = new HashMap<>();
    static int[] values;
    static Color[] colors;
    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        values = new int[n];
        colors = new Color[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            values[i] = x;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            colors[i] = (x == 1) ? Color.GREEN : Color.RED;
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!mapTree.containsKey(a)) mapTree.put(a, new HashSet<Integer>());
            mapTree.get(a).add(b);
            if (!mapTree.containsKey(b)) mapTree.put(b, new HashSet<Integer>());
            mapTree.get(b).add(a);
        }
        Tree root;
        if (n == 1) {
            root = new TreeLeaf(values[0], colors[0], 0);
        } else {
            root = new TreeNode(values[0], colors[0], 0);
        }
        for (Integer x : mapTree.get(1)) {
            mapTree.get(x).remove(1);
            checkTree(x, root);
        }
        return root;
    }

    static void checkTree (int index, Tree parent) {
        if (!mapTree.containsKey(index) || mapTree.get(index).isEmpty()) {
            TreeLeaf leaf = new TreeLeaf(values[index-1], colors[index-1], parent.getDepth()+1);
            ((TreeNode)parent).addChild(leaf);
        } else {
            TreeNode node = new TreeNode(values[index-1], colors[index-1], parent.getDepth()+1);
            ((TreeNode)parent).addChild(node);
            for (Integer x : mapTree.get(index)) {
                mapTree.get(x).remove(index);
                checkTree(x, node);
            }
        }
    }


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
