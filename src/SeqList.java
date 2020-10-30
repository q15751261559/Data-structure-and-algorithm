
public class SeqList<T>{
protected int n;
protected Object[] element;
private static final int MIN_CARPACTIY=16;
public SeqList(int length)
{
	if(length<MIN_CARPACTIY)
		length=MIN_CARPACTIY;
	this.element=new Object[length];
	this.n=0;
}
public SeqList()
{
	this(MIN_CARPACTIY);
}
public SeqList(T[] values)
{
	this(values.length*2);
	for(int i=0;i<values.length;i++)
	{
		if(values[i]!=null)
		{
			this.element[this.n++]=values[i];
		}
    }
}

public boolean isEmpty()
{
	return this.n==0;
}

public int size()
{
	return this.n;
}

public T get(int i)
{
	if(i>=0 && i<this.n)
		return (T)this.element[i];
	return null;
}
public void set(int i,T x)
{
	if(x==null)
		throw new NullPointerException("x==null");
	if(i>=0 && i<this.n)
		this.element[i]=x;
	else
		throw new java.lang.IndexOutOfBoundsException(i+"");
}


public int insert(int i,T x)
{
	if(x==null)
		return -1;
	if(i<0)
		i=0;
	if(i>this.n)
		i=this.n;
	Object[] source =this.element;
	if(this.n==element.length)
	{
	this.element=new Object[source.length*2];
	for(int j=0;j<i;j++)
		this.element[j]=source[j];
	}
	for(int j=this.n-1;j>=i;j--)
		this.element[j+1]=source[j];
	this.element[i]=x;
	this.n++;
	return i;
}
public int insert(T x)
{
	return this.insert(this.n,x);
}
public T remove(int i){
	if(i>=0 && i<this.n){
		T x=(T) this.element[i];
		for(int j=i;j<this.n-1;j++) {
			this.element[j]=this.element[j+1];
		}
			this.element[this.n-1]=null;
			this.n--;
			return x;
	}
	return null;
}

public void clear()
{
	this.n=0;
}
public int search(T key)
{
	for(int i=0;i<this.n;i++)
	{
	if(key.equals(this.element[i]))
		return i;
	}
	return -1;
}
public T remove(T key) {
	return this.remove(this.search(key));
}

public String toString()
{
	String str=this.getClass().getName()+"(";
	if(this.n>0)
		str += this.element[0].toString();
	for(int i=1;i<this.n;i++)
		str +=","+this.element[i].toString();
	return str+")";
}

	public int BinarySearch(T key,int i)
	{
		int k=0;
		int j=(k+i)/2;
		while (!key.equals(this.element[j]))
		{
			if ((Integer)key<(Integer) this.element[j])
			{
				i=j;
				j=(k+i)/2;
			}
			if((Integer)key>(Integer) this.element[j])
			{
				k=j;
				j=(k+i)/2;
			}
			if (j==i-1&&(Integer)key!=(Integer) this.element[j])
			{
				break;
			}
		}
		if (key.equals(this.element[j]))
		{
			return j;
		}else
		{
			return -1;
		}
	}
public static void main(String[] args) {
//	String[] values= {"A","B","C","D","E"};
//	SeqList<String> lista=new SeqList<String>(values);
//	System.out.println("数组"+lista.toString());
//	lista.insert("8889");
//	System.out.println("插入"+lista.toString());
//	lista.remove(1);
//	System.out.println("删除"+lista.toString());
//	lista.remove("8889");
//	System.out.println("删除值之后"+lista.toString());
	Integer[] num=new Integer[100];
	int j=0;
	for (int i=0;i<100;i++)
	{
		if (i%2==1) {
			num[i] = i + 1;
			j++;
		}
	}
	SeqList<Integer> lista=new SeqList<>(num);
	System.out.println("数组"+lista.toString());
	System.out.println("数组下标为"+lista.BinarySearch(77,j));
}

}
