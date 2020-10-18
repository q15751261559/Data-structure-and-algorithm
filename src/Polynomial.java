public class Polynomial  {
    public Object coefficient;
    public Object variable;
    public Polynomial next;
    public Polynomial(Object coefficient, Object variable,Polynomial next)
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
