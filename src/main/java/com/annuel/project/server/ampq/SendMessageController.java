package com.annuel.project.server.ampq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    //public String sendMessage(@PathVariable("message") String message) {
    public String sendMessage(@RequestBody Message message) {
        rabbitTemplate.convertAndSend("annuel_project_queue", message);
        return "This is a Message to send! :" + message;
    }
}