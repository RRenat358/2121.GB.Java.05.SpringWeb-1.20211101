package ru.rrenat358;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User findById(Long id);
    User findByName(String name);
    List<User> findAll();
    void save(User user);
    void updateNameById(Long id, String newName);
    void testCaching();
}
