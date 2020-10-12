


public class SeqList1<T> {

	public int n;
	public Object[] element;
	public static final int MIN_CAPACITY = 16;

	// ���췽��1���������������鳤��
	public SeqList1(int lengh) {
		if (lengh < MIN_CAPACITY) {
			lengh = MIN_CAPACITY;
		}
		this.element = new Object[lengh];
		this.n = 0;
	}

	// �޲ι��췽��
	public SeqList1() {
		this(MIN_CAPACITY);
	}

	// ���췽��2����T���͵�����
	public SeqList1(T[] values) {
		this(values.length * 2);
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				this.element[this.n++] = values[i];
			}
		}
	}

	// �ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.n == 0;
	}

	// ����Ԫ�ظ���
	public int size() {
		return this.n;
	}

	// ���ص�i��Ԫ��
	public T get(int i) {
		if (i >= 0 && i < this.n) {
			return (T) this.element[i];
		}
		return null;
	}

	// ���õ�i��Ԫ��Ϊx
	public void set(int i, T x) {
		if (x == null) {
			throw new NullPointerException("x=null");
		}
		if (i >= 0 && i < this.n) {
			this.element[i] = x;
		} else {
			throw new java.lang.IndexOutOfBoundsException(i + "");
		}
	}

	// �ڵ�i��λ�ò���x
	public int insert(int i, T x) {
		if (x == null)
			return -1;
		if (i < 0)
			i = 0;
		if (i > this.n)
			i = this.n;
		Object[] source = this.element;
		if (this.n == source.length) {
			this.element = new Object[source.length * 2];
			for (int j = 0; j < i; j++) {
				this.element[j]=source[i];
			}
		}
		for (int j = this.n-1; j >=i; j--) {
			this.element[j+1]=source[j];
		}
		this.element[i]=x;
		this.n++;
		return i;
	}
	//������������x
	public int insert(T x) {
		return this.insert(this.n,x);
	}


	
	//ɾ����i��Ԫ��
	public T remove(int i) {
		if(i>=0&&i<this.n) {
			T x=(T) this.element[i];
			for (int j = i; j < this.n-1; j++) {
				this.element[j]=this.element[j+1];
			}
			this.element[this.n-1]=null;
			this.n--;
			return x;
		}
		return null;
	}
	
	//���Ҷ�Ӧ�ؼ��ֵ��±�
	public int serach(T key) {
		for (int i = 0; i <this.n; i++) {
			if (key.equals(this.element[i])) {
				return i;
			}
		}
		return -1;
	}
	
	//����ֵ����ɾ������
	public T remove(T key) {
		return this.remove(this.serach(key));
	}

	// ��дtostring�ķ���,�������ӡ����
	public String tosString() {
		String str = this.getClass().getName() + "(";
		if (this.n > 0)
			str += this.element[0].toString();
		for (int i = 1; i < this.n; i++) {
			str += "," + this.element[i].toString();
		}
		return str + ")";
	}
	public static void main(String[] args) {
		String[] value = { "a", "b", "c", "d" };
		SeqList1<String> seq1 = new SeqList1<String>(value);
		System.out.println("ԭ����"+seq1.tosString());
		seq1.insert("qwq");
		System.out.println("����֮��"+seq1.tosString());
		seq1.remove(1);
		System.out.println("ɾ��֮��"+seq1.tosString());
		seq1.remove("qwq");
		System.out.println("ɾ��ֵ֮��"+seq1.tosString());
	}
}
