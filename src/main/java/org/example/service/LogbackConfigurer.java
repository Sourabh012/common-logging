package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LogbackConfigurer {

    @Autowired
    private VaultService vaultService;

    @PostConstruct
    public void configureLogback() {
        String splunkToken = vaultService.getSplunkToken();
        System.setProperty("splunk.token", splunkToken);
    }
}
