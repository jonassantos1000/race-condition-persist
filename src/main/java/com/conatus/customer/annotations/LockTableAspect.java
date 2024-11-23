package com.conatus.customer.annotations;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LockTableAspect {

    private final JdbcTemplate jdbcTemplate;

    @Pointcut("@annotation(LockTable)")
    public void lockTableMethods() {}

    @Before("lockTableMethods() && @annotation(lockTable)")
    @Transactional
    public void lockTable(LockTable lockTable) {
        String tableName = lockTable.value();
        if (!tableName.isEmpty()) {
            String lockSql = "BEGIN; LOCK TABLE " + tableName + " IN ACCESS EXCLUSIVE MODE;";
            log.info(System.lineSeparator() + "Hibernate:");
            log.info(System.lineSeparator() + "		" + lockSql);
            jdbcTemplate.execute(lockSql);
        }
    }
}
