package com.gylhaut.spring_boot_start_demo.util;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySQLDatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String enabledDBType = System.getProperty("dbType"); // 获得系统参数 dbType
        // 如果该值等于MySql，则条件成立
        return (enabledDBType != null && enabledDBType.equalsIgnoreCase("MySql"));
    }
}