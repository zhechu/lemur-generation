package cn.afterturn.gen;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringBoot方式启动类
 *
 * @author stylefeng
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class GenApplication extends WebMvcConfigurerAdapter {

    protected final static Logger logger = LoggerFactory.getLogger(GenApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
    }

    @Value("${server.port}")
    private String port;
    
    @PostConstruct
    public void finishInit(){
        logger.info("Start {} with port:{}", GenApplication.class.getSimpleName(), port);
    }
    
}
