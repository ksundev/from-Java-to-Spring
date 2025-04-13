package hello.core.scope;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SingletonWithPrototypeTest1 {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        PrototypeScope.class);
    PrototypeScope prototypeBean1 = ac.getBean(PrototypeScope.class);
    prototypeBean1.addCount();
    assertThat(prototypeBean1.getCount()).isEqualTo(1);

    PrototypeScope prototypeBean2 = ac.getBean(PrototypeScope.class);
    prototypeBean2.addCount();
    assertThat(prototypeBean2.getCount()).isEqualTo(1);
  }

  @Test
  void singletonClientUsePrototype() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        ClientBean.class, PrototypeScope.class);

    ClientBean clientBean1 = ac.getBean(ClientBean.class);
    ClientBean clientBean2 = ac.getBean(ClientBean.class);
    int count1 = clientBean1.logic();
    assertThat(count1).isEqualTo(1);
    int count2 = clientBean2.logic();
    assertThat(count2).isEqualTo(2);
  }

  @Component
  @Scope("singleton")
  static class ClientBean {

    private final PrototypeScope prototypeBean; // 생성시점에 주입

    @Autowired
    public ClientBean(PrototypeScope prototypeBean) {
      this.prototypeBean = prototypeBean;
    }

    public int logic() {
      prototypeBean.addCount();
      return prototypeBean.getCount();
    }
  }

  @Component
  @Scope("prototype")
  static class PrototypeScope {

    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init" + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }
}
