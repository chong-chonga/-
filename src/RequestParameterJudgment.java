import org.junit.Test;

/**
 * @author 悠一木碧
 */
public class RequestParameterJudgment {

    /**
     * 正则表达式验证昵称
     * @param testName
     * @return
     */
    public static boolean isCorrectFormatUsername(String testName) {
        if(null == testName){
            return false;
        }
        // 昵称格式：限16个字符，支持中英文、数字、减号或下划线
        String regStr = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,20}$";
        return testName.matches(regStr);
    }

    /**
     * 正则表达式验证密码
     * @param testPassword
     * @return
     */
    public static boolean isCorrectFormatPassword(String testPassword) {
        if(null == testPassword){
            return false;
        }
        // 6-20 位，字母、数字、字符
        //String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){6,20}$";
        return testPassword.matches(regStr);
    }

    @Test
    public void test() {
        System.out.println(isCorrectFormatPassword(null));
    }




}
