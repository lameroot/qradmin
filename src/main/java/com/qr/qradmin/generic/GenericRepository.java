package com.qr.qradmin.generic;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Smirnov_Y on 18.06.2015.
 */
public interface GenericRepository<E> extends CrudRepository<E, Long>, JpaSpecificationExecutor {
}
