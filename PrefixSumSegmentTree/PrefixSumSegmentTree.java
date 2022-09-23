package PrefixSumSegmentTree;

public class PrefixSumSegmentTree {

    public static int getSum(int pre_add[], int num, int nums) {
        if (num == 0) {
            return pre_add[nums];
        } else {
            return pre_add[nums] - pre_add[num - 1];
        }
    }

    public static void update(int pre_add[], int number[], int num, int nums) {
        int diff = nums - number[num];
        for (int j = num; j < pre_add.length - 1; j++) {
            pre_add[j] += diff;
        }
    }

    public static void initialize(int pre_add[], int number[]) {
        pre_add[0] = number[0];
        for (int i = 1; i < number.length - 1; i++) {
            pre_add[i] = pre_add[i - 1] + number[i];
        }
    }

    public static void main(String[] args) {
        int number[] = { 10, 20, 30, 40, 50 };
        int num = 5;
        int pre_add[] = new int[num];

        initialize(pre_add, number);

        System.out.println();
        System.out.print(getSum(pre_add, 0, 2) + " ");
        System.out.print(getSum(pre_add, 1, 3) + " ");

        update(pre_add, number, 1, 60);

        System.out.println();
        System.out.print(getSum(pre_add, 0, 2) + " ");
        System.out.print(getSum(pre_add, 1, 3) + " ");
    }
}