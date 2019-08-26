package com.infoshareacademy.properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;

import java.io.File;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {

  @Test
  void loadAppConfig() {
    File file = new File("confg.properties");
    if (!file.exists()) {
      assertThatIOException();
    } else {
      assertThat(file.exists());
    }

  }
}
