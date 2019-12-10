package querycheck;

import java.lang.annotation.*;

/**
 * 请求参数必填
 *      - 注解的方法类上必须有{@link QueryInterface}，否则无效。
 * @author yihrmc @stu.red
 * @date 2019/11/28 17:01
 * @see QueryInterface
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface QueryRequired {

    /**
     * 字段描述名称 <br/>
     *      - 默认使用当前字段名
     * @return
     */
    String fieldText() default "";

    /**
     * 字段标记
     * @return
     */
    Class<? extends Mark>[] marks() default {};

}
