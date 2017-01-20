package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.TerminalRepository;
import com.qr.qradmin.filter.TerminalFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.Terminal_;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Set;

@Service
public class TerminalService extends GenericEntityService<Terminal, TerminalFilter> {

    @Resource
    private TerminalRepository terminalRepository;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    protected Specification<Terminal> buildSpecification(final TerminalFilter filter) {
        final Specification<Terminal> specification = new Specification<Terminal>() {
            @Override
            public Predicate toPredicate(Root<Terminal> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate predicate = buildPredicate(root, cb, filter);

                if (!CollectionUtils.isEmpty(filter.getTerminalIds())) {
                    predicate.getExpressions().add(root.get(Terminal_.id).in(filter.getTerminalIds()));
                }

                return predicate;
            }
        };
        return specification;
    }

    @Override
    public Terminal create(Terminal terminal) {
        if (terminalRepository.findByAuthName(terminal.getAuthName()) != null) {
            throw new RuntimeException("terminal already exist");
        }
        terminal.setAuthPassword(passwordEncoder.encode(terminal.getAuthPassword()));           //TODO вынести в общий модуль с прокси
        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal update(Long id, Terminal source) {
        if (StringUtils.isNotBlank(source.getAuthPassword())) {
            source.setAuthPassword(passwordEncoder.encode(source.getAuthPassword()));
        }
        source.setAuthName(null);
        return super.update(id, source);
    }

    @Override
    protected GenericRepository<Terminal> getRepository() {
        return terminalRepository;
    }

    public Set<Terminal> findByMerchant(Merchant merchant) {
        return terminalRepository.findByMerchant(merchant);
    }
}
