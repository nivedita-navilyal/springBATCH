package com.demo.springbatchdemo.processor;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.demo.springbatchdemo.vo.ProductVoBatch;

@Component
public class Processor implements ItemProcessor<ProductVoBatch, ProductVoBatch>{

	@Override
	public ProductVoBatch process(ProductVoBatch productVoBatch) throws Exception {
		productVoBatch.setTimestamp(new Date());
		return productVoBatch;
	}


}
