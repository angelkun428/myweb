package com.kun.ranch.controller;

import com.kun.ranch.model.Pig;
import com.kun.ranch.model.RanchState;
import com.kun.ranch.service.RanchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 牧场 REST API
 *
 * GET    /api/ranch/state       获取牧场全部状态（猪列表 + 小麦）
 * POST   /api/ranch/pigs        添加一只猪
 * DELETE /api/ranch/pigs        移除一只随机猪
 * POST   /api/ranch/wheat       添加一份小麦
 * DELETE /api/ranch/wheat       消耗一口小麦（返回剩余 bites）
 */
@RestController
@RequestMapping("/api/ranch")
public class RanchController {

    private final RanchService ranchService;

    public RanchController(RanchService ranchService) {
        this.ranchService = ranchService;
    }

    @GetMapping("/state")
    public RanchState getState() {
        return ranchService.getState();
    }

    @PostMapping("/pigs")
    public ResponseEntity<?> addPig() {
        try {
            Pig pig = ranchService.addPig();
            return ResponseEntity.ok(pig);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/pigs")
    public ResponseEntity<?> removePig() {
        try {
            Pig pig = ranchService.removePig();
            return ResponseEntity.ok(pig);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("/wheat")
    public ResponseEntity<?> addWheat() {
        try {
            int count = ranchService.addWheat();
            return ResponseEntity.ok(Map.of("wheatCount", count));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/wheat")
    public ResponseEntity<?> consumeWheat() {
        int bites = ranchService.consumeWheat();
        return ResponseEntity.ok(Map.of("wheatBites", bites));
    }

    /**
     * 重置牧场状态（打开弹窗时调用）
     */
    @PostMapping("/reset")
    public ResponseEntity<?> reset() {
        ranchService.reset();
        return ResponseEntity.ok(Map.of("message", "牧场已重置"));
    }
}
