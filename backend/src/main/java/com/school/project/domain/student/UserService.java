package com.school.project.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;
    public void create(Long id, String username, String email, String password){
        Student student = new Student();
        student.setId(id);
        student.setName(username);
        student.setEmail(email);
        student.setPassword(password);
        userRepository.save(student);
    }
}
