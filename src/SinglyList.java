import com.sun.deploy.security.SelectableSecurityManager;
import java.util.ArrayList;

public class SinglyList<T extends Comparable> extends Object {
	public Node<T> head;
	public SinglyList()
	{
		this.head=new Node<T>();
	}
	public SinglyList(T[] values)
	{
		this();
		Node<T> rear=this.head;
		for(int i=0;i<values.length;i++)
		{
			if(values[i]!=null)
				rear.next=new Node<T>(values[i],null);
			    rear=rear.next;
		}
	}

	public boolean isEmpty() {
		return this.head.next == null;
	}

	public String toString()
	{
		String str=this.getClass().getName()+"(";
		for(Node<T> p=this.head.next;p!=null;p=p.next)
			str +=p.data.toString()+(p.next!=null?",":"");
		return str+")";
	}

	public T get(int i)
	{
		Node<T> p = this.head.next;
		for (int j = 0; p != null && j < i; j++) {
			p = p.next;
		}
		return (i >= 0 && p != null) ? p.data : null;
	}

	public int size() {
		int i = 0 ;
		Node<T> p = head.next;
		while ( p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	public void set(int i,T x)
	{
		if(x==null)
			throw new NullPointerException("x==null");
		Node<T> front=this.head.next;
		int j=0;
		if(i<0)
			throw new NullPointerException("值不能小于0");
		while(j<=i) {
			if (j==i) {
				front.data = x;
				return;
			}
			if (front.next!=null)
			{
				front=front.next;
				j++;
			}
			else{
				throw new NullPointerException("超出范围");
			}
		}
	}

	public Node<T> insert(int i, T x) {
		if (x == null)
			throw new NullPointerException("x==null");
		Node<T> front = this.head;
		for (int j = 0; front.next != null && j < i; j++) {
			front = front.next;
		}
		front.next = new Node<T>(x, front.next);
		return front.next;
	}

	public Node<T> insert(T t) {
		return insert(java.lang.Integer.MAX_VALUE, t);
	}

	public Node<T> search(T key)
	{
		if(key==null){
			return null;
		}
		int i=0;
		Node<T> front=this.head;
		while (key!=front.data)
		{
			front=front.next;
			i++;
			if (front.data==key)
			{
				i=i-1;
				System.out.println("数组下标为"+i);
				return front;
			}
			if (front.next==null)
				break;
		}
		return null;
	}

	public T remove(int i) {
		Node<T> front = this.head;
		for (int j = 0; j < i && front.next != null; j++) {
			front = front.next;
		}
		if(i>=0 && front.next != null){
			T x = front.next.data;
			front.next = front.next.next;
			return x;
		}
		return null;
	}
	public T remove(T key)
	{
		if(key==null){
			return null;
		}
		Node<T> front=this.head;
		if (key==front.next.data)
		{
			T x=front.next.data;
			front.next=front.next.next;
			return x;
		}
			while (front.next.next!=null)
			{
				front=front.next;
				if (front.next.data==key)
				{
					T x=front.next.data;
					front.next=front.next.next;
					return x;
				}
			}
			return null;
	}
	public  void Reverse1()     //双指针链表倒序
	{
		Node <T> p=this.head.next,q;
		this.head.next=null;
		while(p!=null) {
			q = p.next;
			p.next = this.head.next;
			this.head.next = p;
			p = q;
		}
	}
	public  void Reverse2()     //三指针链表倒序
	{
		Node <T> p=this.head.next,q=null,front=null;
		while(p!=null)
		{
			q=p.next;
			p.next=front;
			front=p;
			p=q;
		}
		this.head.next=front;
	}
//	public boolean equals(Object anObject)  //重写equals
//	{
//		String str=this.toString();
//		String str2=anObject.toString();
//		System.out.println(this.toString());
//		return str.equalsIgnoreCase(str2);
//	}
//	public int CompareTo(Object anObject)   //添加compareTo方法
//	{
//		String str=this.toString();
//		String str2=anObject.toString();
//		if (str.compareTo(str2)<0)
//			return -1;
//		else if (str.compareTo(str2)>0)
//			return 1;
//		else
//			return 0;
//	}
	public Node<T> Merge1(SinglyList list2)  //不重复
	{
		Node<T> p,q,t,s;
		p=this.head.next;
		t=this.head;
		q=list2.head.next;
		s=q.next;
		if (p==null)
		{
			return (list2.head);
		}
		if (q==null)
		{
			return (this.head);
		}
		while (p!=null && q!=null)
		{
			if (p.data.equals(q.data)){
				p = p.next;
				q = q.next;
				t = t.next;

				if (s == null) {
					break;
				} else {
					s = s.next;
				}
			}else if (p.data.compareTo(q.data)>0)
			{
				q.next=t.next;
				t.next=q;
				t=t.next;
				if (s==null)
				{
					break;
				}
				q=s;
				s=s.next;
			}else if (p.data.compareTo(q.data)<0)
			{
//				System.out.println(p.data.compareTo(q.data));
				p=p.next;
				t=t.next;
			}
			if (p==null)
			{
				t.next=q;
			}
		}
		return this.head;
	}

	public Node<T> Merge2(SinglyList list2)  //重复
	{
		Node<T> p,q,t,s,z;
		p=this.head.next;
		t=this.head;
		q=list2.head.next;
		s=q.next;
		if (p==null)
		{
			return (list2.head);
		}
		if (q==null)
		{
			return (this.head);
		}
		while (p!=null && q!=null)
		{
			if (p.data.equals(q.data)){
				p = p.next;
				z=q;
				q = q.next;
				z.next=t.next;
				t.next=z;
				t = z.next;
				if (s == null) {
					break;
				} else {
					s = s.next;
				}
			}else if (p.data.compareTo(q.data)>0)
			{
				q.next=t.next;
				t.next=q;
				t=t.next;
				if (s==null)
				{
					break;
				}
				q=s;
				s=s.next;
			}else if (p.data.compareTo(q.data)<0)
			{
//				System.out.println(p.data.compareTo(q.data));
				p=p.next;
				t=t.next;
			}
			if (p==null)
			{
				t.next=q;
			}
		}
		return this.head;
	}
//1
	public void quChong(){
		Node<T> p,q;
		p=this.head.next;
		while (p!=null)
		{
			q=p;
			while (q.next!=null)
			{
				if (q.next.data.equals(p.data))
				{
					q.next=q.next.next;
				}else
				{
					q=q.next;
				}
			}
			p=p.next;
		}
	}
//	2
	public void hebing(SinglyList<T> list2){
		Node<T> p,q,t;
		q=list2.head.next;
		while (q!=null)
		{
			t=q.next;
			p=this.head.next;
			while (p!=null)
			{
				if (p==this.head.next&&q.data.compareTo(p.data)<0)
				{
					q.next=p;
					this.head.next=q;
					break;
				}
				if (p.next==null)
				{
					p.next=q;
					q.next=null;
					break;
				}
				if ((q.data.compareTo(p.data)>0||q.data.equals(p.data))&&q.data.compareTo(p.next.data)<0)
				{
					q.next=p.next;
					p.next=q;
					break;
				}
				p=p.next;
			}
			q=t;
		}
	}
	public void shanchu(T value)
	{
		Node<T> p,head;
		head=this.head;
		p=head.next;
		while (p!=null)
		{
            if (p.data.equals(value))
			{
				head.next=p.next;
			}
            head=head.next;
            if (head==null) {
				break;
			}
            p=head.next;
		}
	}
	public static void main(String[] args) {
		Integer[] number1={1,1,1};
		Integer[] number2={2,4,6,6,6,6};
		SinglyList<Integer> num1=new SinglyList<>(number1);
//		SinglyList<Integer> num2=new SinglyList<>(number2);
		num1.quChong();
		System.out.println(num1);
//		num1.shanchu(11);
//		num1.hebing(num2);
//		System.out.println(num1);
//		String[] value = { "1","2","3","4"};
//		SinglyList<String> seq1 = new SinglyList<String>(value);
//		System.out.println("原数组"+seq1.toString());
//		seq1.set(3,"jiahui");
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.search("a"));
//		System.out.println(seq1.remove(1));
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.remove("jiahui"));
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.size());
//		seq1.Reverse1();
//		System.out.println("数组"+seq1.toString());
//		seq1.Reverse2();
//		System.out.println("数组"+seq1.toString());
//		Integer[] number2={8,11,328,4517};
//		SinglyList<Integer> num1=new SinglyList<>(number1);
//		SinglyList<Integer> num2=new SinglyList<>(number2);
//		System.out.println("一数组"+num1.toString());
//		System.out.println("二数组"+num2.toString());
//		num1.Merge1(num2);
//		System.out.println("非重复合并链表"+num1.toString());
//		num1.Merge2(num2);
//		System.out.println("重复合并链表"+num1.toString());
	}
}
