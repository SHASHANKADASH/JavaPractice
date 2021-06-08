package com.example.learndb.SpringDbIntegration;

import org.springframework.data.repository.CrudRepository;


public interface TopicRepo extends CrudRepository<Topic,String> {
}
