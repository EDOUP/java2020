package leetcode.editor;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/3 23:00
 */
public class Code470 {

    public static void main(String[] args) {
        Code470 code470 = new Code470();
        for (int i = 0; i < 100; i++) {
            System.out.println(code470.rand10());
        }
    }

    public int rand10() {
        return rand7() * 7;
    }

    public int rand7() {
        return (int) (Math.random() * 7 + 1);
    }
}
