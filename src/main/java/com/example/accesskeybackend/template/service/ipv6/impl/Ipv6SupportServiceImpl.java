package com.example.accesskeybackend.template.service.ipv6.impl;

import com.example.accesskeybackend.template.service.ipv6.Ipv6SupportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.*;
import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class Ipv6SupportServiceImpl implements Ipv6SupportService {
    @Override
    public boolean checkIpv6Support(String domain) {
        if (!domain.matches("^https?://.*")) domain = "https://" + domain;
        try {
            InetAddress[] inetAddress = InetAddress.getAllByName(new URI(domain).getHost());
            return Arrays.stream(inetAddress).anyMatch(x -> x instanceof Inet6Address);
        } catch (URISyntaxException | UnknownHostException var) {
            log.error(var.getMessage());
        }
        return false;
    }

}
