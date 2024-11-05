package com.codecool.askmateoop.configuration;

import com.codecool.askmateoop.dao.answerDao.AnswerDAO;
import com.codecool.askmateoop.dao.answerDao.AnswerDaoJdbc;
import com.codecool.askmateoop.dao.questionDao.QuestionsDAO;
import com.codecool.askmateoop.dao.questionDao.QuestionsDaoJdbc;
import com.codecool.askmateoop.dao.userDao.UserDAO;
import com.codecool.askmateoop.dao.userDao.UserDaoJdbc;
import com.codecool.askmateoop.database.DatabaseConnection;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Configuration {
    private static final String DB_URL = System.getenv("SPRING_DATASOURCE_URL");
    private static final String DB_USERNAME= System.getenv("SPRING_DATASOURCE_URL_DATABASE_USERNAME");
    private static final String DB_PASSWORD = System.getenv("SPRING_DATASOURCE_PASSWORD");

    @Bean
    public DatabaseConnection createDatabaseConnection() {
        return new DatabaseConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    @Bean
    public QuestionsDAO questionsDAO() {
        return new QuestionsDaoJdbc(createDatabaseConnection());
    }

    @Bean
    public AnswerDAO answerDAO() { return new AnswerDaoJdbc(createDatabaseConnection()); }

    @Bean
    public UserDAO userDAO(){return new UserDaoJdbc(createDatabaseConnection());}


}
