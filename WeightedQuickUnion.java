public class WeightedQuickUnion {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
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
        if (sz[rootFirstElement] < sz[rootSecondElement]) {
            id[rootFirstElement] = rootSecondElement;
            sz[rootSecondElement] += sz[rootFirstElement];
        } else {
            id[rootSecondElement] = rootFirstElement;
            sz[rootFirstElement] += sz[rootSecondElement];
        }
    }
}
