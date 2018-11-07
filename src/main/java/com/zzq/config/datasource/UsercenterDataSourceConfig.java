package com.zzq.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(
        basePackages = {"com.zzq.usercenter.mapper"},
        sqlSessionFactoryRef = "usercenterSqlSession"
)
public class UsercenterDataSourceConfig {

    @Value("${spring.datasource.usercenter.url}")
    private String url;

    @Value("${spring.datasource.usercenter.username}")
    private String user;

    @Value("${spring.datasource.usercenter.password}")
    private String password;

    @Value("${spring.datasource.usercenter.driver-class-name}")
    private String driverClass;

    @Bean(name = "usercenterDataSource")
    public DataSource setDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "usercenterTransation")
    public DataSourceTransactionManager setTransationManager(){
        return new DataSourceTransactionManager(setDataSource());
    }

    @Bean(name = "usercenterSqlSession")
    public SqlSessionFactory setSqlSession() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        bean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:com/zzq/usercenter/mapper/*.xml"));
        return bean.getObject();
    }

}
