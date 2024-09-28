package com.kyle;

import com.kyle.base.BootAdminApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kyle
 * @date 2024/5/1
 */
@SpringBootApplication
public class JobApplication extends BootAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
