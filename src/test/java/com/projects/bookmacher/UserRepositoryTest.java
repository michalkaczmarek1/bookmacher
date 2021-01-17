package com.projects.bookmacher;

import com.projects.bookmacher.domain.User;
import com.projects.bookmacher.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldUserRepositorySave() {
        //Given
        User user = new User("Michał", "Kaczmarek", "michal1988", "mitest@gmail.com");
        userRepository.save(user);
        //When
        Long id = user.getId();
        Optional<User> readUser= userRepository.findById(id);
        //Then
        assertTrue(readUser.isPresent());
        //clean up
        userRepository.deleteAll();
    }

    @Test
    void shouldUserRepositoryDeleteById() {
        //Given
        User user = new User("Michał", "Kaczmarek", "michal1988", "mitest@gmail.com");
        userRepository.save(user);
        //When
        Long id = user.getId();
        userRepository.deleteById(id);
        //Then
        assertFalse(userRepository.findById(id).isPresent());
    }

    @Test
    void shouldUserRepositoryfindAll() {
        //Given
        User user1 = new User("Michał", "Kaczmarek", "michal1988", "mitest@gmail.com");
        userRepository.save(user1);
        User user2 = new User("Jan", "Kowalski", "jan1988", "jantest@gmail.com");
        userRepository.save(user2);
        //When
        List<User> users = userRepository.findAll();
        //Then
        assertEquals(2, users.size());
        //clean up
        userRepository.deleteAll();
    }

    @Test
    void shouldUserRepositoryfindById() {
        //Given
        User user1 = new User("Michał", "Kaczmarek", "michal1988", "mitest@gmail.com");
        userRepository.save(user1);
        //When
        Long id = user1.getId();
        Optional<User> readUser = userRepository.findById(id);
        //Then
        assertTrue(readUser.isPresent());
        //clean up
        userRepository.deleteAll();
    }

}
