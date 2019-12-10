package querycheck;

/**
 * FieldList
 * @author yihrmc @stu.red
 * @date 2019/11/29 17:20
 */
public class FieldList {

    private int index;
    private int length;

    private String[] fieldNames;
    private String[] fieldTexts;
    private Object[] fieldValues;

    public FieldList(int length) {
        this.index = 0;
        this.length = length;
        this.fieldNames = new String[length];
        this.fieldTexts = new String[length];
        this.fieldValues = new Object[length];
    }

    public FieldList add(String fieldName, String fieldText, Object value) {
        if (index >= length) {
            throw new RuntimeException();
        }
        this.fieldNames[index] = fieldName;
        this.fieldTexts[index] = fieldText;
        this.fieldValues[index] = value;
        index++;
        return this;
    }

    public int getLength() {
        return length;
    }

    public String getFieldName(int index) {
        return fieldNames[index];
    }

    public String getFieldText(int index) {
        return fieldTexts[index];
    }

    public Object getFieldValue(int index) {
        return fieldValues[index];
    }
}
