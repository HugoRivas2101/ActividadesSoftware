package org.example;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crear nodos
        AttackTreeNode root = new AttackTreeNode("Root", 100, 0.5);
        AttackTreeNode nodeA = new AttackTreeNode("Node A", 50, 0.3);
        AttackTreeNode nodeB = new AttackTreeNode("Node B", 70, 0.2);
        AttackTreeNode nodeC = new AttackTreeNode("Node C", 30, 0.4);
        AttackTreeNode nodeD = new AttackTreeNode("Node D", 20, 0.1);
        AttackTreeNode nodeE = new AttackTreeNode("Node E", 80, 0.6);

        // Construir el árbol
        root.addChild(nodeA);
        root.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);

        AttackTree attackTree = new AttackTree(root);

        // Añadir un nodo hijo a Node B
        attackTree.addChild4Node("Node B", nodeE);

        // Buscar nodos
        System.out.println("Buscando 'Node C':");
        AttackTreeNode foundNodeC = attackTree.searchNode("Node C");
        if (foundNodeC != null) {
            System.out.println("Nodo encontrado: " + foundNodeC.getDescription());
        } else {
            System.out.println("Nodo no encontrado");
        }

        System.out.println("\nBuscando 'Node E':");
        AttackTreeNode foundNodeE = attackTree.searchNode("Node E");
        if (foundNodeE != null) {
            System.out.println("Nodo encontrado: " + foundNodeE.getDescription());
        } else {
            System.out.println("Nodo no encontrado");
        }

        // Calcular el riesgo total
        double totalRisk = attackTree.calculateTotalRisk();
        System.out.println("\nRiesgo total del árbol de ataque: " + totalRisk);

        // Encontrar la ruta crítica
        List<AttackTreeNode> criticalPath = attackTree.findCriticalPath();
        System.out.println("\nRuta crítica:");
        for (AttackTreeNode node : criticalPath) {
            System.out.println("Nodo: " + node.getDescription() + ", Riesgo: " + node.getRisk());
        }

        // Calcular el riesgo total a lo largo de la ruta crítica
        double criticalPathRisk = 0;
        for (AttackTreeNode node : criticalPath) {
            criticalPathRisk += node.getRisk();
        }
        System.out.println("\nRiesgo total de la ruta crítica: " + criticalPathRisk);
    }
}