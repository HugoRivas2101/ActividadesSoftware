import org.example.AttackTree;
import org.example.AttackTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTreeNodeTest {

    private AttackTreeNode root;
    private AttackTreeNode nodeA;
    private AttackTreeNode nodeB;
    private AttackTreeNode nodeC;
    private AttackTreeNode nodeD;
    private AttackTree attackTree;

    @BeforeEach
    void setup(){
        root = new AttackTreeNode("Root", 100, 0.5);
        nodeA = new AttackTreeNode("Node A", 50, 0.3);
        nodeB = new AttackTreeNode("Node B", 70, 0.2);
        nodeC = new AttackTreeNode("Node C", 30, 0.4);
        nodeD = new AttackTreeNode("Node D", 20, 0.1);

        root.addChild(nodeA);
        root.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);

        attackTree = new AttackTree(root);
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
    public void testSearchNode_Child(){
        AttackTreeNode result=attackTree.searchNode("Node D");
        assertNotNull(result);
        assertEquals("Node D",result.getDescription());
    }

    @Test
    public void testCalculateTotalRisk() {
        double totalRisk = attackTree.calculateTotalRisk();
        double expectedRisk = root.getRisk() + nodeA.getRisk() + nodeB.getRisk() + nodeC.getRisk() + nodeD.getRisk();
        assertEquals(expectedRisk, totalRisk);
    }

}
