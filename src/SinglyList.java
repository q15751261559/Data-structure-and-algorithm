import com.sun.deploy.security.SelectableSecurityManager;

public class SinglyList<T> extends Object {
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
	public String toString()
	{
		String str=this.getClass().getName()+"(";
		for(Node<T> p=this.head.next;p!=null;p=p.next)
			str +=p.data.toString()+(p.next!=null?",":"");
		return str+")";
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
		Node <T> p=this.head.next,succ=null,front=null;
		while(p!=null)
		{
			succ=p.next;
			p.next=front;
			front=p;
			p=succ;
		}
		this.head.next=front;
	}
	public static void main(String[] args) {
		String[] value = { "a" ,"b","C","D"};
		SinglyList<String> seq1 = new SinglyList<String>(value);
		System.out.println("原数组"+seq1.toString());
//		seq1.set(3,"jiahui");
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.search("a"));
//		System.out.println(seq1.remove(1));
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.remove("jiahui"));
//		System.out.println("数组"+seq1.toString());
//		System.out.println(seq1.size());
		seq1.Reverse1();
		System.out.println("数组"+seq1.toString());
		seq1.Reverse2();
		System.out.println("数组"+seq1.toString());
	}
}
