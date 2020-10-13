public final class SeqStack<T> {
    private  SeqList<T> list;
    public SeqStack(int length)
    {
        this.list=new SeqList<T>(length);
    }
    public SeqStack()
    {
        this(64);
    }
    public boolean isEmpty()
    {
        return  this.list.isEmpty();
    }
    public void push(T x)
    {
        this.list.insert(x);
    }
    public T peek()
    {
        return this.list.get(list.size()-1);
    }
    public T pop()
    {
        return this.list.remove(list.size()-1);
    }
    public String toString()
    {
        return this.list.toString();
    }

    public static void main(String[] args)
    {
        String[] value= {"A","B","C","D","E"};
//        SeqStack<String> seq1=new SeqStack<String>(value);
    }
}
