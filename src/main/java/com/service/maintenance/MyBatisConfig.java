package com.service.maintenance;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

@Configuration
@MapperScan(basePackages = "com.service.maintenance.infrastructure")
public class MyBatisConfig {

    @Autowired
    protected ResourceLoader resourceLoader;
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis.xml"));
        sessionFactory.setMapperLocations(
                ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:mappings/mybatis/*-Mapper.xml"));
        return sessionFactory.getObject();
    }
}
