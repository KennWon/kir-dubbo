package com.ken.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * Created by Yoco on 2017-02-05.
 */
@Configuration
@EnableTransactionManagement
public class MysqlConfig implements EnvironmentAware {

    private String driverName;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    private Integer druidPoolInit;
    private Integer druidPoolMin;
    private Integer druidPoolMax;


    @Override
    public void setEnvironment(Environment environment) {
        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(environment, "db.");

        this.driverName = resolver.getProperty("driverClassName");
        this.jdbcUrl = resolver.getProperty("community.url");
        this.jdbcUsername = resolver.getProperty("community.username");
        this.jdbcPassword = resolver.getProperty("community.password");

        this.druidPoolInit = Integer.valueOf(resolver.getProperty("pool.size.init"));
        this.druidPoolMin = Integer.valueOf(resolver.getProperty("pool.size.min"));
        this.druidPoolMax = Integer.valueOf(resolver.getProperty("pool.size.max"));
    }

    /**
     * Community 库链接
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource communityDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverName);
        dataSource.setUrl(this.jdbcUrl);
        dataSource.setUsername(this.jdbcUsername);
        dataSource.setPassword(this.jdbcPassword);

        //配置连接池
        dataSource.setInitialSize(druidPoolInit);
        dataSource.setMinIdle(druidPoolMin);
        dataSource.setMaxActive(druidPoolMax);

        try {
            //配置监控统计拦截的filters，wall用于防止sql注入，stat用于统计分析
            dataSource.setFilters("wall,stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean communtiySqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(communityDataSource());

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);
        configuration.setUseColumnLabel(true);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer communityMapperScannerConfigurer() {
        //置扫描Dao接口包,动态实现DAO接口,注入到spring容器
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("communtiySqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.ken.dao");

        return mapperScannerConfigurer;
    }

    @Bean
    public PlatformTransactionManager communityTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(communityDataSource());
    }

}
