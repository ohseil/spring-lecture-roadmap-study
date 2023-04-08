package seil.springroadmap2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 보통은 제외하지 않는데,
        // 기존에 예제로 작성해 놓은 @Configuration 설정 정보들을 사용하지 않고 이 설정 정보로만 확인하기 위해 임시로 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
