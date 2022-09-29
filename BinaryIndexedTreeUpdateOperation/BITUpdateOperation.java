package BinaryIndexedTreeUpdateOperation;

public class BITUpdateOperation {
    final static int Max = 1000;
    static int BITree[] = new int[Max];

    public static void updateBIT(int number, int index, int val) {
        index = index + 1;

        while (index <= number) {
            BITree[index] += val;

            index += index & (-index);
        }
    }

    public void constructBITree(int numbers[]) {
        for (int i = 1; i <= numbers.length; i++) {
            BITree[i] = 0;
        }
        for (int i = 0; i < numbers.length; i++) {
            updateBIT(numbers.length, i, numbers[i]);
        }
    }

    public static void main(String[] args) {
        int total[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        BITUpdateOperation num = new BITUpdateOperation();
        num.constructBITree(total);
        updateBIT(total.length, 2, 35);
    }
}
