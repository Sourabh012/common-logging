package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@Service
public class VaultService {
    @Value("${vault.splunk.path}")
    private String vaultPath;

    @Autowired
    private VaultTemplate vaultTemplate;

    public String getSplunkToken() {
        VaultResponse response = vaultTemplate.read(vaultPath);
        return response.getData().get("splunk-token").toString();
    }
}
