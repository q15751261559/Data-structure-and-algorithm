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
        String str = "Huffman树的节点数组：";
        for (int i = 0; i < this.element.length; i++) {
            str += this.element[i].toString() + ",";
        }
        str += "\nHuffman编码： ";
        for (int i = 0; i <this.charset.length(); i++) { 
            str+=this.charset.charAt(i)+"："+huffmanCode(i)+"，";
        }
        return str;
    }

    public String encode(String text)
    {
        String compressed="";                    //被压缩的数据，以字符串显示
        for(int i=0; i<text.length(); i++)
        {
            int j=text.charAt(i)-'A';  //获得当前字符在默认字符集（从A开始的n个字符）中的序号，O(1)
            compressed += this.huffmanCode(j);   //在Huffman树中获得第j个字符的编码
        }
        return compressed;
    }
    //说明：
    //（1）设置默认字符集合的目的是，为字符集合设置一个计算公式，使得由字符查找序号的计算时间是O(1)。
    //（2）对于任意字符集合，压缩时，已知一个字符，如何知道该字符在字符集合中的序号？
    //    解决，第8章，使用散列映射，建立从字符到序号一对一的映射。

    //数据解压缩，将压缩compressed中的0/1序列进行Huffman译码，返回译码字符串
    public String decode(String compressed)
    {
        String text="";
        int node=this.element.length-1;          //node搜索一条从根到达叶子的路径
        for(int i=0; i<compressed.length(); i++)
        {
            if(compressed.charAt(i)=='0')        //根据0、1分别向左或右孩子走
                node = element[node].left;
            else
                node = element[node].right;
            //if(element[node].isLeaf())           //到达叶子结点
            {
                text += this.charset.charAt(node);    //已知字符序号，获得一个字符，O(1)
                node = this.element.length-1;    //node再从根结点开始
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
