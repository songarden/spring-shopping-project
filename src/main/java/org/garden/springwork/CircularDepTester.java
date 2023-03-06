package org.garden.springwork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Circular Dependencies 예외 코드 확인을 위한 Tester 코드


//B를 생성자로 갖는 클래스 A
class A {
    private final B b;

    A(B b) {
        this.b = b;
    }
}

//A를 생성자로 갖는 클래스 B
class B{
    private final A a;

    B(A a) {
        this.a = a;
    }
}

//A와 B의 관계를 Bean으로 명시
@Configuration
class CircularAppConfig{
    @Bean
    public A a(B b){
        return new A(b);
    }
    @Bean
    public B b(A a){
        return new B(a);
    }
}

//순환 관계로 인해 예외 코드 BeanCurrentlyInCreationException 발생 확인
public class CircularDepTester {
    public static void main(String[] args) {
        var annotationConfigApplicationContext = new AnnotationConfigApplicationContext(CircularAppConfig.class);
    }
}
