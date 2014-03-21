package com.github.fabito.js.infrastructure;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.google.appengine.api.utils.SystemProperty;

/**
 * To further reduce the application loading time. This
 * {@link XmlWebApplicationContext} disables XML validation.
 * 
 * @author fabio
 * @see https://developers.google.com/appengine/articles/spring_optimization#
 *      Disable_XML_Validation
 */
public class OptimizedGaeXmlWebApplicationContext extends
		XmlWebApplicationContext {

	protected void initBeanDefinitionReader(
			XmlBeanDefinitionReader beanDefinitionReader) {
		super.initBeanDefinitionReader(beanDefinitionReader);
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			beanDefinitionReader.setValidating(false);
			beanDefinitionReader.setNamespaceAware(true);
		}
	}

}
