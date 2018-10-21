package com.winxuan.vo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@EnableAutoConfiguration // somewhere
public class ExampleBeanWithSpel {

	@Value("#{propertyGroup1.string_property_key}")
	private String stringProperty;

	@Value("#{propertyGroup1.int_property_key}")
	private int intProperty;

	private String computedValue;

	@PostConstruct
	private void init() {
		computedValue = stringProperty + intProperty;
	}

	public void someMethod() {
		System.out.println(String.format("My properties: [%s] - [%s] - [%s]", stringProperty, intProperty, computedValue));
	}

	public String getStringProperty() {
		return stringProperty;
	}
	
	public void setStringProperty(String stringProperty) {
		System.out.println("stringProperty:被刷新了==================================");
		this.stringProperty = stringProperty;
	}

	public int getIntProperty() {
		return intProperty;
	}

	public void setIntProperty(int intProperty) {
		this.intProperty = intProperty;
	}

	public String getComputedValue() {
		return computedValue;
	}

	public void setComputedValue(String computedValue) {
		this.computedValue = computedValue;
	}
	
	
}
