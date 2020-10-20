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
        SeqStack<String> num1=new SeqStack<>(24);
        num1.push("1");
        num1.push("2");
        num1.push("3");
        System.out.println(num1.toString());
    }
}
