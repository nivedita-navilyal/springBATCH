package com.demo.springbatchdemo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.demo.springbatchdemo.vo.ProductVoBatch;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,ItemReader<ProductVoBatch> itemReader,
			ItemProcessor<ProductVoBatch, ProductVoBatch> itemProcessor ,ItemWriter<ProductVoBatch> itemWriter) {
		
		Step step = stepBuilderFactory.get("ETL-STEP")
				.<ProductVoBatch ,ProductVoBatch>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();
		
		Job job=jobBuilderFactory.get("ETL-JOB")
						.incrementer(new RunIdIncrementer())
						.start(step)
						.build();
		
		return job;
		
	}
	
	@Bean
	public FlatFileItemReader<ProductVoBatch> itemReader(@Value("${input}") Resource resource){
		
		FlatFileItemReader<ProductVoBatch> flatFileItemReader =new FlatFileItemReader<ProductVoBatch>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-READER");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<ProductVoBatch> lineMapper() {
		DefaultLineMapper<ProductVoBatch> lineMapper =new DefaultLineMapper<ProductVoBatch>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] {"id","name","description","price","quantity","company"});
		
		BeanWrapperFieldSetMapper<ProductVoBatch> feildSetMapper = new BeanWrapperFieldSetMapper<ProductVoBatch>();
		feildSetMapper.setTargetType(ProductVoBatch.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(feildSetMapper);
		return lineMapper;
	}

}
