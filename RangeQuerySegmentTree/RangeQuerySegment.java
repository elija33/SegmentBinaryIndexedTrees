package RangeQuerySegmentTree;

public class RangeQuerySegment {
    // qs and qe is user input
    // ss and se is starting and ending indexes of range represented by current
    // node. ss = 0 and se = length-1
    // si is the index of current node. si = 0.
    public static int CST(int start, int end, int indexs, int number[], int numbers[]) {
        if (start == end) {
            numbers[indexs] = number[start];
            return number[start];
        }

        int mid = (start + end) / 2;
        numbers[indexs] = CST(start, mid, 2 * indexs + 1, number, numbers)
                + CST(mid + 1, end, 2 * indexs + 2, number, numbers);
        return numbers[indexs];
    }

    public static int getSumRec(int EnterNumber, int EnterNumbers, int start, int end, int indexes, int numbers[]) {
        if (end < EnterNumber || start > EnterNumbers) {
            return 0;
        }
        if (EnterNumber <= start && EnterNumbers >= end) {
            return numbers[indexes];
        }
        int mid = (start + end) / 2;
        return getSumRec(EnterNumber, EnterNumbers, start, mid, 2 * indexes + 1, numbers)
                + getSumRec(EnterNumber, EnterNumbers, mid + 1, end, 2 * indexes + 2, numbers);
    }

    public static void main(String[] args) {
        int number[] = { 10, 20, 30, 40 };
        int num = 4;
        int numbers[] = new int[4 * num];
        CST(0, num - 1, 0, number, numbers);
        System.out.println(getSumRec(0, 2, 0, 3, 0, numbers));

    }
}
