class QuickFindUF {

    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public void union(int firstElement, int secondElement) {

        if (firstElement < 0 || secondElement < 0)
            return;
        if (firstElement >= id.length || secondElement >= id.length)
            return;
        if (id[firstElement] == id[secondElement])
            return;

        int fId = id[firstElement];
        int sId = id[secondElement];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == fId)
                id[i] = sId;
        }

    }

    public boolean connected(int firstElement, int secondElement) {
        if (firstElement < 0 || secondElement < 0)
            return false;
        if (firstElement >= id.length || secondElement >= id.length)
            return false;

        return id[firstElement] == id[secondElement];
    }

}