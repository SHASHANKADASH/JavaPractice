package org.example.myspring;

import models.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //this will ask spring to create the instance of the class
public class TopicService {

    private List<Topic> topics= new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framework Description"),
                new Topic("java","Core Java","Core Java Description"),
                new Topic("javaScript","Javascript","JavaScript Description")

        ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicById(String id){
        return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public  void updateTopic(String id,Topic topic){
        for(Topic i : topics )
        {
            if(i.getId().equals(id))
            {
                 Logger logger = LoggerFactory.getLogger(TopicService.class);
                logger.debug(topic.getId());
                System.out.println(topic.getId());
                i.setId(topic.getId());
                i.setName(topic.getName());
                i.setDesc(topic.getDesc());
                return;
            }
        }
    }

    public void delTopic(String id){
        for(int i=0;i<topics.size();i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.remove(i);
                return;
            }
        }
    }
}
