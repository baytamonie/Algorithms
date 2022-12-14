class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;

    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int firstElement, int secondElement) {
        if (firstElement < 0 || secondElement < 0)
            return false;
        if (firstElement >= id.length || secondElement >= id.length)
            return false;
        return root(firstElement) == root(secondElement);
    }

    public void uninon(int firstElement, int secondElement) {
        if (firstElement < 0 || secondElement < 0)
            return;
        if (firstElement >= id.length || secondElement >= id.length)
            return;
        if (id[firstElement] == id[secondElement])
            return;
        int rootFirstElement = id[firstElement];
        int rootSecondElement = id[secondElement];
        id[rootFirstElement] = rootSecondElement;
    }

}