package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public List<Credential> getCredentialListByUserId(Integer userId) {
        return this.credentialMapper.findAllByUserId(userId);
    }


    public Credential getByCredentialId(Integer credentialId) {
        return this.credentialMapper.findByCredentialId(credentialId);
    }


    public Credential getByUrlAndUsername(String url, String username) {
        return this.credentialMapper.findByUrlAndUsername(url, username);
    }


    public void createCredentialByUserId(Credential credential, Integer userId) {
        credential.setUserId(userId);
        credential.setKey(KeyService.generateKey());
        credential.setPassword(encryptionService.encryptValue(credential.getPassword(), credential.getKey()));
        this.credentialMapper.save(credential);
    }

    public void updateCredentialByUserId(Integer credentialId, String url, String username, String password, Integer userId) {
        this.credentialMapper.updateCredentialByUserId(credentialId, url, username, password, userId);
    }

    public void deleteByCredentialIdAndUserId(Integer credentialId, Integer userId) {
        this.credentialMapper.delete(credentialId, userId);
    }
}