package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    // 실습에서 만들었던 Config들은 스캔 대상에서 제외.
    // 보통 설정정보(Config)를 스캔 대상에서 제외하지는 않지만, 기존의 예제 코드를 최대한 살리기 위해 이 방법을 선택.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
    basePackages = "hello.core"
)
public class AutoAppConfig {

}
