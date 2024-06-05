package org.example;

import java.util.ArrayList;
import java.util.List;

public class AttackTreeNode {
    public String description;
    public double estimatedCost;
    public double probabilityOfSuccess;
    public List<AttackTreeNode> children;

    public AttackTreeNode(String description, double estimatedCost, double probabilityOfSuccess) {
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.probabilityOfSuccess = probabilityOfSuccess;
        this.children = new ArrayList<>();
    }
    public void addChild(AttackTreeNode child) {
        children.add(child);
    }
    public List<AttackTreeNode> getChildren() {
        return children;
    }
    public double getRisk() {
        return estimatedCost * probabilityOfSuccess;
    }
    public String getDescription() {
        return description;
    }


}
