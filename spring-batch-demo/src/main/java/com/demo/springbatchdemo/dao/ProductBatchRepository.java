package com.demo.springbatchdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springbatchdemo.vo.ProductVoBatch;

@Repository
public interface ProductBatchRepository extends JpaRepository<ProductVoBatch,Integer>{

}
