package com.efun.web.config;

import org.springframework.context.annotation.Configuration;
import java.util.regex.Pattern;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ImportResource("classpath:dubbo/dubbo_consumer.xml")
@ComponentScan(basePackages = {"com.efun.web"},
		excludeFilters = {
				@Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
		}
)
public class RootConfig {
	public static class WebPackage extends RegexPatternTypeFilter {
	    public WebPackage() {
	      super(Pattern.compile("com\\.efun\\.web"));
	    }
	  }
}
