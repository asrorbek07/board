/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = { "io.vizend.board" }, exclude = DataSourceAutoConfiguration.class)
@EnableMongoRepositories(basePackages = { "io.vizend.board" })
public class BoardBootApplication {
    /* Gen by Vizend Studio v5.1.0 */

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        SpringApplication.run(BoardBootApplication.class, args);
    }
}
