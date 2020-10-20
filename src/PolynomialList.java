import java.lang.Comparable;
public class PolynomialList extends Object {
    public Polynomial head;

    public PolynomialList() {
        this.head = new Polynomial();
    }

    public PolynomialList(Object[] values) {
        this();
        Polynomial rear = this.head;
        for (int i = 0; i < values.length; i++) {
            String spl1[]=values[i].toString().split(" ");
//            System.out.println(spl1[0]);
            if (values[i] != null)
                rear.next = new Polynomial(Integer.parseInt(spl1[0]), spl1[1], null);
            rear = rear.next;
        }
    }

    public String toString() {
        String str = "(";
        for (Polynomial p = this.head.next; p != null; p = p.next) {
            String addition;  //加法符号
            if (p != this.head.next && (Integer) p.coefficient > 0) {
                addition = "+";
            } else {
                addition = "";
            }
            if ((Integer) p.coefficient==1) {
                str +=addition +p.variable.toString();
            }else if ((Integer) p.coefficient==-1)
            {
                str +="-"+p.variable.toString();
            }
            else
            {
                str += addition + p.coefficient.toString() + p.variable.toString();
            }
        }
        return str + ")";
    }

    public void Add(Polynomial list1, Polynomial list2) {
        list1.coefficient = (Integer) list1.coefficient + (Integer) list2.coefficient;
    }

    public PolynomialList PolynomialAddAndSubtract(String Symbol,PolynomialList list2)
    {
        Polynomial p, q, s,t;
        t=this.head;
        p = this.head.next;
        q = list2.head.next;
        if (p == null) {
            return (list2);
        }
        if (q == null) {
            return (this);
        }
        if (Symbol.equals("-"))  //判断加减法
        {
            while (q!=null)  //减法去括号并求list2数组全部系数的相反数
            {
                q.coefficient=(Integer)q.coefficient*-1;
                q=q.next;
            }
        }
        q=list2.head.next;   //重置q为第一个节点
        while (p != null && q != null) {
            while (!p.variable.toString().equals(q.variable.toString()) && p.next != null) { //遍历this多项式寻找指数相同的节点
                t=t.next;
                p = p.next;
            }
            if (p.variable.toString().equals(q.variable.toString())) {    //如果指数相同则相加
                Add(p, q);
                if ((Integer) p.coefficient==0)  //如果系数为0则删除此单项式
                {
                    t.next=t.next.next;
                    p = this.head.next;
                }else {
                    p = this.head.next;
                    t=this.head;
                }
                q=q.next;
            } else if (p.next==null)    //如果遍历完毕仍未找到相同系数的单项式则将此单项式插入this链表后方
            {
                s=q.next;
                q.next = null;
                p.next=q;
                q=s;
                p = this.head.next;
                t=this.head;
            }
        }
        return this;
    }
    public static int Recursion(int n)
    {
        if (n==1)
            return 1;
        return Recursion(n-1)*n;
    }
    public static int Recursion1(int n)
    {
        if (n==1)
            return 1;
        int i=n;
        while (i>1)
        {
            n=n*(i-1);
            i--;
        }
        return n;
    }
    public static int Recursion2(int n)
    {
        if (n==1)
            return 1;
        int i=n;
        while (i<5)
        {
            n=n*(i+1);
            i++;
        }
        return n;
    }
    public static void main(String[] args) {
//        Object[] number1={"2 x^2","-3 x^3","4 x^4"};
//        Object[] number2={"2 x^2","-3 x^3","4 x^4"};
////        String spl1[]=number1[1].toString().split(" ");
////        System.out.println(spl1[0]);
//        PolynomialList num1=new PolynomialList(number1);
//        PolynomialList num2=new PolynomialList(number2);
//        System.out.println(num1.toString());
//        System.out.println(num2.toString());
////        System.out.println(num1.PolynomialAddAndSubtract("+",num2).toString());
        System.out.println(Recursion1(5));
//        Recursion1(1);
        System.out.println(Recursion1(5));

    }
}
