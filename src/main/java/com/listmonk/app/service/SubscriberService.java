package com.listmonk.app.service;

import com.listmonk.app.dto.SubscriberRequest;
import com.listmonk.app.dto.SubscriberResponse;
import com.listmonk.app.entity.Subscriber;
import com.listmonk.app.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    public SubscriberResponse createSubscriber(SubscriberRequest request) {

        subscriberRepository.findByEmail(request.getEmail()).ifPresent(
                s -> {
                    throw new RuntimeException("Email already exists");
                });


        Subscriber subscriber = Subscriber.builder()
                .email(request.getEmail())
                .name(request.getName())
                .status("ACTIVE")
                .build();

        Subscriber saved = subscriberRepository.save(subscriber);

        return mapToResponse(saved);
    }

    private SubscriberResponse mapToResponse(Subscriber subscriber) {
        return SubscriberResponse.builder()
                .id(subscriber.getId())
                .email(subscriber.getEmail())
                .name(subscriber.getName())
                .status(subscriber.getStatus())
                .build();
    }
}
