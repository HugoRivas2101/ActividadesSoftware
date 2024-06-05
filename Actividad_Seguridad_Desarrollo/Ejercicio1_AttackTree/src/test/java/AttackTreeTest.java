import org.example.AttackTree;
import org.example.AttackTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AttackTreeTest {

    private AttackTreeNode root;
    private AttackTreeNode nodeA;
    private AttackTreeNode nodeB;
    private AttackTreeNode nodeC;
    private AttackTreeNode nodeD;
    private AttackTreeNode nodeE;
    private AttackTree attackTree;

    @BeforeEach
    public void setUp() {
        root = new AttackTreeNode("Root", 100, 0.5);
        nodeA = new AttackTreeNode("Node A", 50, 0.3);
        nodeB = new AttackTreeNode("Node B", 70, 0.2);
        nodeC = new AttackTreeNode("Node C", 30, 0.4);
        nodeD = new AttackTreeNode("Node D", 20, 0.1);
        nodeE = new AttackTreeNode("Node E", 80, 0.6);

        root.addChild(nodeA);
        root.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);

        attackTree = new AttackTree(root);
    }

    @Test
    public void testCalculateTotalRisk() {
        double totalRisk = attackTree.calculateTotalRisk();
        double expectedRisk = root.getRisk() + nodeA.getRisk() + nodeB.getRisk() + nodeC.getRisk() + nodeD.getRisk();
        assertEquals(expectedRisk, totalRisk, 0.001);
    }

    @Test
    public void testSearchNode_Found() {
        AttackTreeNode result = attackTree.searchNode("Node C");
        assertNotNull(result);
        assertEquals("Node C", result.getDescription());
    }

    @Test
    public void testSearchNode_NotFound() {
        AttackTreeNode result = attackTree.searchNode("Non-existent Node");
        assertNull(result);
    }

    @Test
    public void testSearchNode_Root() {
        AttackTreeNode result = attackTree.searchNode("Root");
        assertNotNull(result);
        assertEquals("Root", result.getDescription());
    }

    @Test
    public void testAddChild4Node() {
        attackTree.addChild4Node("Node B", nodeE);
        AttackTreeNode result = attackTree.searchNode("Node E");
        assertNotNull(result);
        assertEquals("Node E", result.getDescription());
    }

}
