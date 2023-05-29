package ru.rrenat358.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rrenat358.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
