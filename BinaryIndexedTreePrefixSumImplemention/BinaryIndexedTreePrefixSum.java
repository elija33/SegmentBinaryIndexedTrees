package BinaryIndexedTreePrefixSumImplemention;

public class BinaryIndexedTreePrefixSum {
    final static int Max = 1000;

    static int BITree[] = new int[Max];

    public int getSum(int index) {
        int total = 0;
        index = index + 1;

        while (index > 0) {
            total += BITree[index];
            index -= index & (-index);
        }
        return total;
    }

    public static void updateBIT(int number, int index, int val) {
        index = index + 1;

        while (index <= number) {
            BITree[index] += val;

            index += index & (-index);
        }
    }

    public void constructBITree(int numbers[], int number) {
        for (int i = 1; i <= number; i++) {
            BITree[i] = 0;
        }
        for (int i = 0; i < number; i++) {
            updateBIT(number, i, numbers[i]);
        }
    }

    public static void main(String[] args) {
        int freq[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int number = freq.length;
        BinaryIndexedTreePrefixSum sum = new BinaryIndexedTreePrefixSum();

        sum.constructBITree(freq, number);

        System.out.println("Sum of elements in number[0..5]" + " is " + sum.getSum(5));
        System.out.println("Sum of element in number[1..3]" + " is " + sum.getSum(3));
    }
}
