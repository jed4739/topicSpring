package com.example.topicSpring.service;

import com.example.topicSpring.DTO.UserForm;
import com.example.topicSpring.model.User;
import com.example.topicSpring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long createUser(UserForm form) {
        User user = form.toEntity();
        userRepository.save(user);
        return user.getId();
    }
}
