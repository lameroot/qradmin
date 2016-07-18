package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

@Repository
public interface MerchantOrderRepository extends GenericRepository<MerchantOrder> {
}
