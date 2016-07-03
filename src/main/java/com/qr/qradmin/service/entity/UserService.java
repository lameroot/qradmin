package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.UserRepository;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserService extends GenericEntityService<User> implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    protected Specification<User> buildSpecification(final EntityFilter filter) {
        final Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate predicate = buildPredicate(root, cb, filter);
                return predicate;
            }
        };
        return specification;
    }

    @Override
    protected GenericRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    public User loadUserByUsername(String login) throws UsernameNotFoundException {
        List<User> users = userRepository.findByUsername(login);
        if (users.isEmpty() || users.get(0) == null)
            throw new UsernameNotFoundException("User [" + login + "] is not found");
        return users.get(0);
    }

    public User getByLogin(String login) {
        List<User> users = userRepository.findByUsername(login);
        if (users.isEmpty() || users.get(0) == null) return null;
        return users.get(0);
    }

    public User update(String username, List<String> authorities) {
        User user = loadUserByUsername(username);
        if (authorities != null) {
            user.setAuthorities(SecurityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()])));
        }
        userRepository.save(user);
        return user;
    }
}
