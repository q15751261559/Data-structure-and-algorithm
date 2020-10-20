public final class LinkedStack<T extends java.lang.Comparable> implements Stack<T> {
    private SinglyList<T> list;

    public LinkedStack(){
        this.list=new SinglyList<T>();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }

    public void push(T x){
        this.list.insert(0,x);
    }
    public T peek(){
        return this.list.get(0);
    }
    public T pop(){
        return this.list.remove(0);
    }

    public String toString()
    {
        String str=this.getClass().getName()+"(";
        for(Node<T> p=this.list.head.next;p!=null;p=p.next)
            str +=p.data.toString()+(p.next!=null?",":"");
        return str+")";
    }
    public static void main(String[] args) {
        LinkedStack<String> str=new LinkedStack<>();
        System.out.println(str.isEmpty());
        str.push("A");
        str.push("B");
        str.push("C");
        System.out.println(str.toString());
        System.out.println(str.peek());
        System.out.println(str.pop());
        System.out.println(str.toString());
    }
}