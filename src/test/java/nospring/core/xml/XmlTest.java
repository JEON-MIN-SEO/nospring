package nospring.core.xml;

import nospring.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlTest {
    @Test
    void XmlTest1() {
        ApplicationContext ga = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ga.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
