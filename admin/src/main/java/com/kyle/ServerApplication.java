package com.kyle;

import com.kyle.base.BootAdminApp;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kyle
 * @date 2024/4/28
 */
@SpringBootApplication
public class ServerApplication extends BootAdminApp {

    public static void main(String[] args) {
        bootstrap(ServerApplication.class, args);
    }
}
