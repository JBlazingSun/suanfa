package com.blazings.suanfa.component.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LogTestTest {

  /**
  * Method under test: {@link LogTest#PublicMethod()}
  */
  @Test
  void testPublicMethod() {
    // TODO: Complete this test.
    //   Diffblue AI was unable to find a test
    log.info( "This is a log message");
    (new LogTest()).PublicMethod();
  }
}

