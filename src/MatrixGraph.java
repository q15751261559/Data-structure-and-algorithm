public class MatrixGraph<T> extends AbstractGraph<T> {
    protected Matrix matrix;
    public MatrixGraph(){
        super();
        this.matrix=new Matrix(0,0);
    }
    public MatrixGraph(T[] vertexes){
        this();
        for(int i=0;i<vertexes.length;i++)
            this.insert(vertexes[i]);
    }
    public MatrixGraph(T[]vertexex,Triple[] edges)
    {
        this(vertexex);
        for(int j=0;j<edges.length;j++)
            this.insert(edges[j]);
    }
    public String toString(){
        String str=super.toString()+"邻接矩阵:  \n";
        int n=this.vertexCount();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(this.matrix.get(i,j)==MAX_Weight)
                    str+="     ∞";
                else
                    str+=String.format("%6d",this.matrix.get(i,j));
            }
            str+="\n";
        }
        return str;
    }
    public int insert(T x){
        this.vertexlist.insert(x);
        int i=this.vertexlist.size()-1;
        if(i>=this.matrix.getRows())
            this.matrix.setRowsColumns(i+1,i+1);
        for(int j=0;j<i;j++){
            this.matrix.set(i,j,MAX_Weight);
            this.matrix.set(j,i,MAX_Weight);
        }
        return i;
    }
    public void insert(int i,int j,int w){
        if(i!=j){
            if(w<=0||w>MAX_Weight)
                w=MAX_Weight;
            this.matrix.set(i,j,w);
        }
        else
            throw new IllegalArgumentException("不能插入自身环,i="+i+",j="+j);
    }
    public void insert(Triple edge){
        this.insert(edge.row,edge.column,edge.value);
    }
    public void remove(int i,int j){
        if(i!=j)
            this.matrix.set(i,j,MAX_Weight);
    }
    public void remove(Triple edge){
        this.remove(edge.row,edge.column);
    }
    public T remove(int i){
        int n=this.vertexCount();
        if(i>=0&&i<n){
            T x=this.vertexlist.get(n-1);
            this.vertexlist.set(i,x);
            x=this.vertexlist.remove(n-1);
            for(int j=0;j<n;j++)
                this.matrix.set(i,j,this.matrix.get(n-1,j));
            for(int j=0;j<n;j++)
                this.matrix.set(j,i,matrix.get(j,n-1));
            this.matrix.setRowsColumns(n-1,n-1);
            return x;
        }
        else
            throw new IndexOutOfBoundsException("i="+i);
    }
    public int weight(int i,int j){
        return this.matrix.get(i,j);
    }
    protected int next(int i,int j){
        int n=this.vertexCount();
        if(i>=0&&i<n&&j>=-1&&j<n&&i!=j)
            for(int k=j+1;k<n;k++)
                if(this.matrix.get(i,k)>0&&this.matrix.get(i,k)<MAX_Weight)
                    return k;
        return -1;
    }
    public static void main(String[] args) {
        String [] vertexes={"A","B","C","D","E","F"};
        Triple[] edges = {new Triple(0,1,45),
                new Triple(0,2,28),
                new Triple(0,3,10),
                new Triple(1,0,45),
                new Triple(1,2,12),
                new Triple(1,4,21),
                new Triple(2, 0, 28),
                new Triple(2, 1, 12),
                new Triple(2, 3, 17),
                new Triple(2, 4, 26),
                new Triple(3, 0, 10),
                new Triple(3, 2, 17),
                new Triple(3, 4, 15),
                new Triple(3, 5, 13),
                new Triple(4, 1, 21),
                new Triple(4, 2, 26),
                new Triple(4, 3, 15),
                new Triple(4, 5, 11),
                new Triple(5, 3, 13),
                new Triple(5, 4, 11)};
        MatrixGraph<String>graph=new MatrixGraph<String>(vertexes,edges);
        System.out.println(graph.toString());
        graph.toString();

        int index=graph.search("B");
        int rowCount=graph.vertexCount();
        int degreeCount=0;
        for (int i = 0; i < rowCount; i++) {
            if(graph.matrix.get(index,i)!=0&&graph.matrix.get(index,i)!=MAX_Weight){
                degreeCount++;
            }
        }
        System.out.println(degreeCount);


    }
}
