public abstract class AbstractGraph<T> implements Graph<T> {
    protected static final int MAX_Weight=0x0000ffff;
    protected SeqList<T> vertexlist;
    public AbstractGraph()
    {
        this.vertexlist=new SeqList<T>();
    }
    public int vertexCount()
    {
        return this.vertexlist.size();
    }
    public String toString()
    {
        return "¶¥µã¼¯ºÏ£º"+this.vertexlist.toString()+"\n";
    }
    public T get(int i)
    {
        return this.vertexlist.get(i);
    }
    public void set(int i,T x)
    {
        this.vertexlist.set(i,x);
    }
    public int search(T key)
    {
        return this.vertexlist.search(key);
    }
    public T remove(T key)
    {
        return this.remove(this.search(key));
    }
    protected abstract int next(int i,int j);
    public T remove(int i) {
        return null;
    }
    public void remove(int i, int j) { }
    public int weight(int i, int j) {
        return 0;
    }
    public void DFSTraverse(int i) { }
    public void BFSTraverse(int i) { }
    public void minSpanTree() { }
    public void shortestPath(int i) { }
    public void shortestPath() { }
}