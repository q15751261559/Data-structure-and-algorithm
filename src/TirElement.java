public class TirElement {
    int data;
    int parent,left,right;
    public TirElement(int data,int parent,int left,int right){
        this.data=data;
        this.parent=parent;
        this.left=left;
        this.right=right;
    }
    public TirElement(int data){
        this.data=data;
        this.parent=-1;
        this.left=-1;
        this.right=-1;
    }

    public String toString()
    {
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }
/*    public boolean isLeaf()
    {
        return this.left==-1 && this.right==-1;
    }*/
}
