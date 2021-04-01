package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:common.properties"})
public interface TestConfig extends Config {
    @Key("email")
    String email();

    @Key("email.login")
    String emailLogin();

    @Key("email.password")
    String emailPassword();
}
