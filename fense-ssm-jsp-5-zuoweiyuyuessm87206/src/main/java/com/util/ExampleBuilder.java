package com.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * MyBatis工具类
 */
public class ExampleBuilder<E, C> {

    private Class<E> exampleClass;

    private Class<C> criteriaClass;

    private ExampleBuilder(Class<E> exampleClass, Class<C> criteriaClass) {
        this.exampleClass = exampleClass;
        this.criteriaClass = criteriaClass;
    }

    /**
     * 创建ExampleBuilder对象
     */
    public static <E, C> ExampleBuilder<E, C> create(Class<E> exampleClass, Class<C> criteriaClass) {
        return new ExampleBuilder<>(exampleClass, criteriaClass);
    }

    /**
     * 构建Example包装类
     */
    public ExamplePack<E, C> buildExamplePack(Object model) {
        return buildExamplePack(model, true);
    }

    /**
     * 构建Example包装类
     */
    public ExamplePack<E, C> buildExamplePack(Object model, Boolean isStrLike) {
        try {
            E example = exampleClass.newInstance();
            Method createCriteria = exampleClass.getMethod("createCriteria");
            Object criteria = createCriteria.invoke(example);
            if (model == null) {
                return new ExamplePack<>(example, (C) criteria);
            }
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(Boolean.TRUE);
                Object value = field.get(model);
                if (value != null && !"".equals(value)) {
                    String name = field.getName();
                    String strFormat = "and%sEqualTo";//默认查询条件为值相等,字符串则为模糊查询
                    if (isStrLike && field.getType().getTypeName().equals("java.lang.String")) {
                        strFormat = "and%sLike";
                        value = "%" + value + "%";
                    }
                    Method andMethod = criteria.getClass().getMethod(String.format(strFormat, name.substring(0, 1).toUpperCase() + name.substring(1)), field.getType());
                    andMethod.invoke(criteria, value);
                }
            }
            // 代码警告说明：编译阶段无法预知criteria所属类型
            return new ExamplePack<>(example, (C) criteria);
        } catch (Exception e) {
            throw new RuntimeException("Method 'toExample' of class ExampleBuilder throw an exception", e);
        }
    }

    /**
     * Example包装类，方便获取Example实例和当前构造的Criteria实例
     */
    public static class ExamplePack<E, C> {

        private E example;

        private C criteria;

        public ExamplePack(E example, C criteria) {
            this.example = example;
            this.criteria = criteria;
        }

        public E getExample() {
            return example;
        }

        public C getCriteria() {
            return criteria;
        }

    }
}
