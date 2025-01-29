package javas.basics;

class Edge {
    public final int fromNode;
    public final int toNode;

    private Edge(int fromNode, int toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Edge edge = (Edge) o; 
        return this.fromNode == edge.fromNode && this.toNode == edge.toNode;
    }

    @Override
    public int hashCode() {
        return (int) (fromNode * 100000L * toNode) % 1000000007;
    }

    @Override
    public String toString() {
        return ("From node: " + this.fromNode + " To node: " + this.toNode);
    }

    public static Edge createEdge(int fromNode, int toNode) {
        return new Edge(fromNode, toNode);
    }
}

