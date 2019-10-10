package com.alibaba.demo.config;

import com.google.common.collect.Lists;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.List;


@Configuration
@MapperScan(basePackages = "com.alibaba.demo", sqlSessionFactoryRef = "sqlSessionFactory")
public class DatasourceConfig {
    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password,
        @Value("${spring.datasource.driver}") String driver) throws Exception {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setPoolMaximumIdleConnections(4);
        dataSource.setPoolMaximumActiveConnections(30);
        dataSource.setDriver(org.postgresql.Driver.class.getCanonicalName());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(
        @Qualifier("dataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        List<Resource> resourceList = Lists.newArrayList(
            new PathMatchingResourcePatternResolver().getResources("classpath:persistence/mapper/**/*.xml"));

        sqlSessionFactoryBean.setMapperLocations(resourceList.toArray(new Resource[0]));
        sqlSessionFactoryBean.setConfigLocation(
            new PathMatchingResourcePatternResolver().getResource("classpath:persistence/mybatis/config.xml"));


        return sqlSessionFactoryBean.getObject();
    }
}
