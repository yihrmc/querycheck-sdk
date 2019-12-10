package querycheck;

import com.sun.istack.internal.NotNull;

/**
 * 字段验证工厂
 * @author yihrmc @stu.red
 * @date 2019/11/29 17:31
 */
public abstract class ValidationFieldFactory {

    private static ValidationFieldFactory instance;
    private static RuntimeException initialCallPosition;

    public static void setInstance(@NotNull ValidationFieldFactory instance) {
        if (ValidationFieldFactory.instance != null) {
            throw new RuntimeException("不能重复设置实例", initialCallPosition);
        }
        ValidationFieldFactory.instance = instance;
        initialCallPosition = new RuntimeException();
    }

    public static ValidationFieldFactory getInstance() {
        return instance;
    }

    public String checkNull(FieldList fieldList) {
        int length = fieldList.getLength();
        for (int i = 0; i < length; i++) {
            if (fieldList.getFieldValue(i) == null) {
                return "字段" + fieldList.getFieldText(i) + "不能为空!";
            }
        }
        return null;
    }

}
