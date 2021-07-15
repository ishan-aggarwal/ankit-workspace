package com.james.sprintbatch.demo.config;
 
import javax.sql.DataSource;

import com.james.sprintbatch.demo.model.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
//    private static final String DROP_SCRIPT = "IF EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.TABLES "
//            + "WHERE TABLE_NAME = 'some_table') "
//            + "BEGIN "
//            + " DROP TABLE employee "
//            + "END";
    //private static final String DROP_SCRIPT = "truncate TABLE_NAME employee";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
 
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
 
    @Value("classPath:/input/inputData.csv")
    private Resource inputResource;
 
//    @Bean
//    public Job readCSVFileJob() {
//        return jobBuilderFactory
//                .get("readCSVFileJob")
//                .incrementer(new RunIdIncrementer())
//                .start(step())
//                .build();
//    }

//    @Bean
//    public Job readCSVFileJob() {
//        return jobBuilderFactory
//                .get("readCSVFileJob")
//                .incrementer(new RunIdIncrementer())
//                .start(step())
//                .build();
//    }

    @Bean
    public Job readCSVFileJob() {
        return jobBuilderFactory
                .get("readCSVFileJob")
                .incrementer(new RunIdIncrementer())
                .flow(truncateTable("employee")).next(step()).end()
                .build();
    }

    @Bean
    public Step truncateTable(String tableName) {
        return stepBuilderFactory
                .get("truncateTable")
                .tasklet(truncateTableTasklet(tableName))
                .build();
    }

    public Tasklet truncateTableTasklet(String tableName) {
        return (contribution, chunkContext) -> {
            String query = "truncate table TABLE_NAME";
            query =query.replace("TABLE_NAME", tableName);
            new JdbcTemplate(dataSource()).execute(query);
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Step step() {
        return stepBuilderFactory
                .get("step")
                .<Employee, Employee>chunk(5)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
     
    @Bean
    public ItemProcessor<Employee, Employee> processor() {
        return new DBLogProcessor();
    }
     
    @Bean
    public FlatFileItemReader<Employee> reader() {
        FlatFileItemReader<Employee> itemReader = new FlatFileItemReader<Employee>();
        itemReader.setLineMapper(lineMapper());
        itemReader.setLinesToSkip(1);
        itemReader.setResource(inputResource);
        return itemReader;
    }
 
    @Bean
    public LineMapper<Employee> lineMapper() {
        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[] { "id", "firstName", "lastName" });
        lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
        BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
        fieldSetMapper.setTargetType(Employee.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
 
    @Bean
    public JdbcBatchItemWriter<Employee> writer() {
        JdbcBatchItemWriter<Employee> itemWriter = new JdbcBatchItemWriter<Employee>();
        itemWriter.setDataSource(dataSource());
        itemWriter.setSql("INSERT INTO EMPLOYEE (ID, FIRSTNAME, LASTNAME) VALUES (:id, :firstName, :lastName)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
        return itemWriter;
    }
     
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
                .addScript("classpath:employee.sql")
                .setType(EmbeddedDatabaseType.H2) 
                .build();
    }
}