package BinaryNode;

public class BinaryTree<T extends Comparable> {
    public BinaryNode<T> root;
    public BinaryTree()
    {
        this.root=null;
    }
    public boolean isEmpty()
    {
        return this.root==null;
    }
    public void preorder()  //先根
    {
        preorder(this.root);
    }
    public void preorder(BinaryNode<T> p)
    {
        if (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    public int size()  //叶子
    {
        size(this.root);
        System.out.println();
        return n;
    }
    private int n;
    public int size(BinaryNode<T> p)
    {
        if (p!=null)
        {
            n++;
            size(p.left);
            size(p.right);
        }
        return n;
    }

    public void inorder()  //中根
    {
        inorder(this.root);
    }
    public void inorder(BinaryNode<T> p)
    {
        if (p!=null)
        {
            inorder(p.left);
            System.out.print(p.data.toString()+" ");
            inorder(p.right);
        }
    }

    public void postorder()  //后根
    {
        inorder(this.root);
    }
    public void postorder(BinaryNode<T> p)
    {
        if (p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");
        }
    }

    public BinaryTree(T[] prelist)
    {
        this.root=create(prelist);
    }
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p=null;
        if (i<prelist.length)
        {
            T elem=prelist[i++];
            if (elem !=null)
            {
                p=new BinaryNode<T>(elem);
                p.left=create(prelist);
                p.right=create(prelist);
            }
        }
        return p;
    }

    public int leaf()  //叶子
    {
        leaf(this.root);
        System.out.println();
        return j;
    }
    private int j;
    public int leaf(BinaryNode<T> p)
    {
        if (p!=null)
        {
            if (p.left==null&&p.right==null)
            {
                j++;
            }
            leaf(p.left);
            leaf(p.right);
        }
        return j;
    }
    public int height()  //树高
    {
        return height(this.root);
    }
    public int height(BinaryNode<T> p)
    {
        if (p==null)
        {
            return 0;
        }
        int L_height=height(p.left);
        int R_height=height(p.right);
        int height;
        if (L_height>=R_height)
        {
            height=L_height+1;
        }else
        {
            height=R_height+1;
        }
        return height;
    }

    public BinaryNode<T> search(T i)  //查找
    {
        return search(this.root,i);
    }
    public BinaryNode<T> search(BinaryNode<T> p ,T i) {
        T value;
        if (p==null)
        {
            return null;
        }
        else {
            if (p.data.equals(i))
            {
                return p;
            }else
            {
                if (search(p.left,i)!=null)
                {
                    return p;
                }else if (search(p.right,i)!=null)
                {
                    return p;
                }else
                    return null;
            }
        }
    }


    public static void main(String[] args) {
        String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,"F","H"};
        BinaryTree<String> bit=new BinaryTree<String>(prelist);
        System.out.println("先根:");bit.preorder();
        System.out.println("中根:");bit.inorder();
        System.out.println("后根:");bit.postorder();
        System.out.println("总节点数:"+bit.size());
        System.out.println("叶子节点数:"+bit.leaf());
        System.out.println(bit.height());
        System.out.println(bit.search("D"));
    }
}
