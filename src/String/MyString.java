package String;

public final class MyString {

    private final char[] value;


    public MyString(java.lang.String s) {
        this.value = new char[s.length()];
        for (int i = 0; i < this.value.length; i++)
            this.value[i] = s.charAt(i);
    }

    //以value数组从1开始的n个字符构造串，i>=0,n>=0,i+n<value.length
    //若i或n指定序号越界，则抛出字符串越界异
    public MyString(char[] value, int i, int n) {
        if (i >= 0 && n >= 0 && i + n <= value.length) {
            this.value = new char[n];
            for (int j = 0; j < n; j++)
                this.value[j] = value[i + j];
        } else
            throw new StringIndexOutOfBoundsException("i=" + i + ",n=" + n + ",i+n=" + (i + n));
    }
    public MyString(char[] value){
        this(value,0,value.length);
    }
    public MyString(MyString s){
        this(s.value);
    }
    public int length(){
        return this.value.length;
    }
    public  java.lang.String toString(){
        return new String(this.value);
    }
    public char charAt(int i){
        if(i>=0&&i<this.value.length)
            return this.value[i];
        throw new StringIndexOutOfBoundsException(i);
    }
    public MyString substring(int begin,int end){
        if(begin==0&&end==this.value.length)
            return this;
        return new MyString(this.value,begin,end-begin);
    }
    public MyString substring(int begin){
        return substring(begin,this.value.length);

    }
    public MyString concat(MyString s){
        if(s==null||s.equals(""))
            s=new MyString(this.value);
        char[] buffer = new char[this.value.length+s.length()];
        int i;
        for(i=0;i<this.value.length;i++)
            buffer[i]=this.value[i];
        for(int j=0;j<s.value.length;j++)
            buffer[i+j]=s.value[j];
        return new MyString(buffer);
    }
    public int indexOf(MyString pattern){
        return this.indexOf(pattern,0);
    }
    public int indexOf(MyString pattern ,int begin){
        int n=this.length(),m=pattern.length();
        if(begin<0)
            begin=0;
        if(n==0||n<m||begin>=n)
            return  -1;
        int i=begin,j=0;
        while (i<n&&j<m)
        {
            if(this.charAt(i)==pattern.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i=i-j+1;
                j=0;
                if(i>n-m)
                    break;
            }
        }
        return j==m?i-m:-1;
    }

    public static void main(String[] args) {
        MyString target =new MyString("aababcd"),pattern=new MyString("abcd");
        System.out.println("\""+target+"\".indexOf(\""+pattern+"\")="+target.indexOf(pattern));
    }
}