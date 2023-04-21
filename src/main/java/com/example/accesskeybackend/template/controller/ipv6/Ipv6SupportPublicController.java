package com.example.accesskeybackend.template.controller.ipv6;

import com.example.accesskeybackend.template.service.ipv6.Ipv6SupportService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/web")
@RequiredArgsConstructor
public class Ipv6SupportPublicController {

    private final Ipv6SupportService ipv6SupportService;

    @GetMapping("/checkIpv6Support")
    @SecurityRequirement(name = "permitAll")
    public ResponseEntity<Object> checkIpv6Support(@RequestParam(value = "siteUrl") String siteUrl) {
        return ResponseEntity.ok().body(Map.of("success", ipv6SupportService.checkIpv6Support(siteUrl)));
    }


}
