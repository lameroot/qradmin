package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;

import java.util.Set;

@Repository
public interface TerminalRepository extends GenericRepository<Terminal> {
    Terminal findByAuthName(String authName);
    Set<Terminal> findByMerchant(Merchant merchant);
}
