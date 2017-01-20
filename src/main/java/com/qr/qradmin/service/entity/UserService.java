package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.UserRepository;
import com.qr.qradmin.filter.UserFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.User;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Set;

@Service
public class UserService extends GenericEntityService<User, UserFilter> implements UserDetailsService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    protected Specification<User> buildSpecification(final UserFilter filter) {
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
        User user = userRepository.findByUsername(login);
        if (user == null) {
            throw new UsernameNotFoundException("User [" + login + "] is not found");
        }
        return user;
    }

    @Override
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("user already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setExpired(false);
        user.setEnabled(true);
        user.setLocked(false);
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User source) {
        if (StringUtils.isNotBlank(source.getPassword())) {
            source.setPassword(passwordEncoder.encode(source.getPassword()));
        }
        source.setUsername(null);
        return super.update(id, source);
    }

    public Set<User> findByMerchant(Merchant merchant) {
        return userRepository.findByMerchant(merchant);
    }
}
