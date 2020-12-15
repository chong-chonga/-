package cn.leetcode.string;

/**
 * @author 悠一木碧
 */
public class GrayCode {
    private String[] generate(int n) {
        String[] sequences = {"0", "1"};

        for (int i = 2; i <= n; i++) {
            int numberOfIncreasedSequences = sequences.length;
            String[] newSequences = new String[numberOfIncreasedSequences * 2];
            for(int j = 0; j < numberOfIncreasedSequences; j++){
                newSequences[j] = "0" + sequences[j];
            }
            for(int j = 0; j < numberOfIncreasedSequences; j++){
                newSequences[j + numberOfIncreasedSequences] =
                        "1" + sequences[numberOfIncreasedSequences - j - 1];
            }
            sequences = newSequences;

        }

        return sequences;
    }
}

