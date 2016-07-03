package com.qr.qradmin.utils;


import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.GeneralException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.UUID;

public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    public static void updateBean(Object source, Object target) {
        try {
            Assert.assertTrue(source.getClass().isAssignableFrom(source.getClass()));
            for (Field field : source.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fieldValue = field.get(source);
                if (fieldValue != null) {
                    field.set(target, fieldValue);
                }
            }
        } catch (IllegalAccessException e) {
            String uuid = UUID.randomUUID().toString();
            logger.error("Error while bean updating UUID=[{}], {}", uuid, e);
            throw new GeneralException(ErrorCode.INTERNAL_ERROR_N, uuid);
        }
    }
}
