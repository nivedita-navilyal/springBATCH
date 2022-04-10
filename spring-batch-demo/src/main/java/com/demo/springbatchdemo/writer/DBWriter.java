package com.demo.springbatchdemo.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.springbatchdemo.dao.ProductBatchRepository;
import com.demo.springbatchdemo.vo.ProductVoBatch;

@Component
public class DBWriter implements ItemWriter<ProductVoBatch>{

	@Autowired
	private ProductBatchRepository productBatchRepository;
	
	@Override
	public void write(List<? extends ProductVoBatch> ProductVoBatch) throws Exception {
		productBatchRepository.saveAll(ProductVoBatch);
		
	}

}
