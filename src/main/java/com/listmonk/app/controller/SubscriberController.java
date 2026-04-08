package com.listmonk.app.controller;


import com.listmonk.app.dto.SubscriberRequest;
import com.listmonk.app.dto.SubscriberResponse;
import com.listmonk.app.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscribers")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService;

    @PostMapping
    public SubscriberResponse createSubscriber(@RequestBody SubscriberRequest request) {
        return subscriberService.createSubscriber(request);
    }
}
