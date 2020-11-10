public class Matrix {
    private int rows,columns;
    private int[][] element;
    private static final int MIN_CAPACITY=6;
    public Matrix(int m,int n)
    {
        if (m>=0&&n>=0)
        {
            this.rows=m;
            this.columns=n;
            if (m<MIN_CAPACITY)
                m=MIN_CAPACITY;
            if (n<MIN_CAPACITY)
                n=MIN_CAPACITY;
            this.element=new int[m][n];
        }
        else
            throw new IllegalArgumentException("矩阵行列数不能<0，m="+m+",n="+n);
    }
    public Matrix(int n)
    {
        this(n,n);
    }
    public Matrix(int m,int n, int[][] values)
    {
        this(m,n);
        for (int i=0;i<values.length&&i<m;i++)
            for (int j=0;j<values[i].length&&j<n;j++)
                this.element[i][j]=values[i][j];
    }
    public int getRows()
    {
        return this.rows;
    }
    public int getColumns()
    {

    }
}
