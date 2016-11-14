package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.OrderTemplate;
import ru.qrhandshake.qrpos.domain.Terminal;

@Repository
public interface TerminalRepository extends GenericRepository<Terminal> {
    Terminal findByAuthName(String authName);
}
