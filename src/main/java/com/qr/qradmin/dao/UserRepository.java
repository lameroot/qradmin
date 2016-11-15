package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends GenericRepository<User> {
    User findByUsername(String username);
}
