package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.Merchant;

@Repository
public interface MerchantRepository extends GenericRepository<Merchant> {

    Merchant findByName(String name);
}
