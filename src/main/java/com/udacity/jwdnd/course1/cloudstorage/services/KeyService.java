package com.udacity.jwdnd.course1.cloudstorage.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class KeyService {
    public static String generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String keyString = Base64.getEncoder().encodeToString(key);
        return keyString;
    }
}
