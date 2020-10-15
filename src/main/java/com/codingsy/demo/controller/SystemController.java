package com.codingsy.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口探活
 *
 * @author shaoying
 */
@RestController
@RequestMapping("/system")
@Slf4j
public class SystemController {

    /**
     * 服务探活检查
     *
     * @return
     */
    @GetMapping("/health")
    public String checkServerHealth() {
        log.info("web template checkServerHealth ok");
        return "ok";
    }
}
