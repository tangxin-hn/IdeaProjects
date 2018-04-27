package p33;

public class SequenceOfBST {
    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence==null || sequence.length==0)
            return false;
        return VerifySequenceOfBST(sequence,0,sequence.length-1);

    }
    public static boolean VerifySequenceOfBST(int[] sequence,int start,int end) {
        if (start>=end)
            return true;
        int pos = 0;
        for (pos=start;pos<end;pos++) {
            if (sequence[pos]>sequence[end]) {
                break;
            }
        }
        for (int i=pos;i<end;i++) {
            if (sequence[i]<sequence[end])
                return false;
        }
        return VerifySequenceOfBST(sequence,start,pos-1) && VerifySequenceOfBST(sequence,pos,end-1);
    }
}
