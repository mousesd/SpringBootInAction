package net.homenet.intellijh2client;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
@Profile("local")
public class H2ServerConfiguration {
    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }

    //@Bean
    //@ConfigurationProperties("spring.datasource")
    //public DataSource dataSource() throws SQLException {
    //    Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
    //    return new org.apache.tomcat.jdbc.pool.DataSource();
    //}
}
