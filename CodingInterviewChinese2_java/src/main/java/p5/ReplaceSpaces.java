package p5;

public class ReplaceSpaces {
    void replaceBlank(char[] str)
    {
        if (str==null)
            return;
        int length=0,numberOfBlank=0;
        for (int i=0;i<str.length && str[i]!=0;i++) {
            length++;
            if (str[i]==' ')
                numberOfBlank++;
        }
        int newLength = length+numberOfBlank*2;
        if (newLength>str.length)
            return;
        while (length>=0 && length<newLength) {
            if (str[length]==' ') {
                str[newLength--] = '0';
                str[newLength--] = '2';
                str[newLength--] = '%';
                length--;
            } else {
                str[newLength--] = str[length--];
            }
        }
    }
}
