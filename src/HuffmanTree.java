public class HuffmanTree {
    private String charset;
    private TirElement[] element;

    public HuffmanTree(int[] weights) {
        this.charset = "";
        int n = weights.length;
        for (int i = 0; i < weights.length; i++) {
            this.charset += (char) ('A' + i);
        }
        this.element = new TirElement[2 * n - 1];
        for (int i = 0; i < n; i++) {
            this.element[i] = new TirElement(weights[i]);
        }
        for (int i = n; i < 2 * n - 1; i++) {
            int min1 = java.lang.Integer.MAX_VALUE, min2 = min1;
            int x1 = -1, x2 = -1;
            for (int j = 0; j < i; j++) {
                if (this.element[j].parent == -1) {
                    if (this.element[j].data < min1) {
                        min2 = min1;
                        x2 = x1;
                        min1 = this.element[j].data;
                        x1 = j;
                    } else if (this.element[j].data < min2) {
                        min2 = element[j].data;
                        x2 = j;
                    }
                }
            }
            this.element[x1].parent = i;
            this.element[x2].parent = i;
            this.element[i] = new TirElement(min1 + min2, -1, x1, x2);
        }

    }
    private String huffmanCode(int i) {
        int n = 8;
        char[] code = new char[n];
        int child = i, parent = this.element[child].parent;
        for (i = n - 1; parent != -1; i--) {
            code[i] = (element[parent].left == child) ? '0':'1';
            child = parent;
            parent = element[child].parent;
        }
        return new String(code, i + 1, n - 1 - i);
    }

    public String toString() {
        String str = "Huffman���Ľڵ����飺";
        for (int i = 0; i < this.element.length; i++) {
            str += this.element[i].toString() + ",";
        }
        str += "\nHuffman���룺 ";
        for (int i = 0; i <this.charset.length(); i++) { 
            str+=this.charset.charAt(i)+"��"+huffmanCode(i)+"��";
        }
        return str;
    }

    public String encode(String text)
    {
        String compressed="";                    //��ѹ�������ݣ����ַ�����ʾ
        for(int i=0; i<text.length(); i++)
        {
            int j=text.charAt(i)-'A';  //��õ�ǰ�ַ���Ĭ���ַ�������A��ʼ��n���ַ����е���ţ�O(1)
            compressed += this.huffmanCode(j);   //��Huffman���л�õ�j���ַ��ı���
        }
        return compressed;
    }
    //˵����
    //��1������Ĭ���ַ����ϵ�Ŀ���ǣ�Ϊ�ַ���������һ�����㹫ʽ��ʹ�����ַ�������ŵļ���ʱ����O(1)��
    //��2�����������ַ����ϣ�ѹ��ʱ����֪һ���ַ������֪�����ַ����ַ������е���ţ�
    //    �������8�£�ʹ��ɢ��ӳ�䣬�������ַ������һ��һ��ӳ�䡣

    //���ݽ�ѹ������ѹ��compressed�е�0/1���н���Huffman���룬���������ַ���
    public String decode(String compressed)
    {
        String text="";
        int node=this.element.length-1;          //node����һ���Ӹ�����Ҷ�ӵ�·��
        for(int i=0; i<compressed.length(); i++)
        {
            if(compressed.charAt(i)=='0')        //����0��1�ֱ�������Һ�����
                node = element[node].left;
            else
                node = element[node].right;
            //if(element[node].isLeaf())           //����Ҷ�ӽ��
            {
                text += this.charset.charAt(node);    //��֪�ַ���ţ����һ���ַ���O(1)
                node = this.element.length-1;    //node�ٴӸ���㿪ʼ
            }
        }
        return text;
    }
    public static void main(String[] args) {
        String text="AAAABBBCDDBBAAA";
        int[] weights={7,5,1,2};
        HuffmanTree Huffmantree=new HuffmanTree(weights);
        System.out.println(Huffmantree.toString());
    }
}
