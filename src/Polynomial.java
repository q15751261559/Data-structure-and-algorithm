public class Polynomial<T>  {
    public T coefficient;
    public T variable;
    public Polynomial<T> next;
    public Polynomial(T coefficient,T variable,Polynomial<T> next)
    {
        this.coefficient=coefficient;
        this.variable=variable;
        this.next=next;
    }
    public Polynomial()
    {
        this(null,null,null);
    }
    public String toString()
    {
        return this.coefficient.toString()+this.variable.toString();
    }
}
