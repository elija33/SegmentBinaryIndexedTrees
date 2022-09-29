package UpdateQuerySegmentTree;

public class UpdateQuerySegmentT {
    // ss is the start
    // se is the end
    // si is the mid of the array
    public static int CST(int start, int end, int indexs, int number[], int numbers[]) {
        if (start == end) {
            numbers[indexs] = number[start];
            return number[start];
        }

        int mid = (start + end) / 2;
        numbers[indexs] = CST(start, mid, 2 * indexs + 1, number, numbers)
                + CST(mid + 1, end, 2 * start + 2, number, numbers);
        return numbers[indexs];
    }

    public static void updateRec(int start, int end, int i, int indexs, int differe, int numbers[]) {
        if (i < start || i > end) {
            return;
        }
        numbers[indexs] = numbers[indexs] + differe;
        if (end > start) {
            int mid = (start + end) / 2;

            updateRec(start, mid, i, 2 * indexs + 1, differe, numbers);
            updateRec(mid + 1, end, i, 2 * indexs + 2, differe, numbers);
        }
    }

    public static void main(String[] args) {
        int number[] = { 10, 20, 30, 40 };
        int num = 4;
        int numbers[] = new int[4 * num];
        CST(0, num - 1, 0, number, numbers);
        updateRec(0, 3, 1, 0, 5, numbers);
    }
}
