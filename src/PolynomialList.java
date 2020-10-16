public class PolynomialList<T>
{
    public Polynomial<T> head;
    public PolynomialList()
    {
        this.head=new Polynomial<T>();
    }
    public PolynomialList(T[][] values)
    {
        this();
        Polynomial<T> rear=this.head;
        for(int i=0;i<values.length;i++)
        {
            if(values[i]!=null)
                rear.next=new Polynomial<T>(values[i][0],values[i][1],null);
            rear=rear.next;
        }
    }
    public String toString()
    {
        String str=this.getClass().getName()+"(";
        for(Polynomial<T> p=this.head.next;p!=null;p=p.next)
            str +=p.coefficient.toString()+p.variable.toString();
        return str+")";
    }

    public static void main(String[] args) {
        Object[][] number1={{4,"x^2"},{-7,"x^3"}};
        PolynomialList<Object> num1=new PolynomialList<Object>(number1);
        System.out.println(num1.toString());
    }
}
