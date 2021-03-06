package com.lcvc.new_coronavirus_report;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableScheduling //开启基于注解的定时任务支持
@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加该注解。开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven>
@MapperScan("com.lcvc.new_coronavirus_report.dao")//与dao层的接口@Mapper二选一写上即可(主要作用是扫包)，扫描的是mapper.xml中namespace指向值的包位置
public class NewCoronavirusReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewCoronavirusReportApplication.class, args);
    }

}
