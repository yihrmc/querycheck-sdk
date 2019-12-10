package querycheck;

import java.lang.annotation.*;

/**
 * 查询接口自动化注解 <br/>
 *      - 需要配合编程工具querycheck插件实现自动生成，否则无作用 <br/>
 *      - 主要功能一 被添加{@link QueryInterface}注解的接口，可使用插件进行快速代码转换,快捷键(alt+i)，支持格式：
 *      <ul>
 *          <li> 1. "Type name();" 自动转为 "void setName(Type name);" </li>
 *          <li> 2. "void name(Type name)" 自动转为 "oid setName(Type name);" </li>
 *      </ul>
 *      - 主要功能二 当某些类实现有{@link QueryInterface}注解的接口时，按下快捷键(alt+i)，将自动生成如下内容：
 *      <ul>
 *          <li> 1.自动将接口的setter的字段定义成私有属性。（配合lombok的setter使用） </li>
 *          <li> 2.自动将私有字段的文档注释上增加@see关联 </li>
 *          <li> 3.自动将接口setter方法上，有{@link QueryRequired}注解的方法对应的字段，添加到validation验证方法中 </li>
 *      </ul>
 *
 *  <p>
 *      插件官网下载与教程
 *      https://www.stu.red/plugin/querycheck/
 *  </p>
 *
 * @author yihrmc @stu.red
 * @date 2019/11/28 17:01
 * @use {@link QueryRequired}
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface QueryInterface {

    /**
     * 实现接口的类是否自动生成对应接口指定的字段
     * @return
     */
    boolean createField() default true;

    /**
     * 实现接口的类是否自动生成验证方法
     * @return
     */
    boolean validationMethod() default true;

}
