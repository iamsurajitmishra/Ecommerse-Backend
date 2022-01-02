package com.surajit.ecommerce.config;

import com.surajit.ecommerce.entity.Product;
import com.surajit.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedAction ={HttpMethod.POST,HttpMethod.DELETE,HttpMethod.PUT,HttpMethod.PATCH};

        //for product
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedAction)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedAction)));

        //for product category
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedAction)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedAction)));

    }
}
