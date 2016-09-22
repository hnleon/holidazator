package ua.pp.leon.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.pp.leon.conversion.DateFormatter;

@Configuration
@ComponentScan("ua.pp.leon")
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
        super();
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(dataFormatter());
    }

    @Bean
    public DateFormatter dataFormatter() {
        return new DateFormatter();
    }
}
