package com.qr.qradmin.utils;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.GeneralException;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static String getFileMd5(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return DigestUtils.md5Hex(fis);
        } catch (Exception e) {
            logger.error("error during getting md5 hash", e);
            throw new GeneralException(ErrorCode.INTERNAL_ERROR);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                logger.error("error during getting md5 hash", e);
                throw new GeneralException(ErrorCode.INTERNAL_ERROR);
            }
        }
    }

    public static boolean checkImage(InputStream iis, String extension) {
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(extension);
        while (readers.hasNext()) {
            try {
                ImageReader reader = readers.next();
                reader.setInput(new MemoryCacheImageInputStream(iis));
                reader.read(0);
                return true;
            } catch (IOException exp) {
            }
        }
        return false;
    }
}
