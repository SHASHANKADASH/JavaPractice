package com.example.learndb.SpringDbIntegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //this will ask spring to create the instance of the class
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepo.findAll().forEach(x->topics.add(x));
        return topics;
    }

    public Topic getTopicById(String id){
        //return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
        return topicRepo.findById(id).get();
    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepo.save(topic);
    }

    public  void updateTopic(String id,Topic topic){
        topicRepo.save(topic);
    }

    public void delTopic(String id){
        topicRepo.deleteById(id);
    }
}
