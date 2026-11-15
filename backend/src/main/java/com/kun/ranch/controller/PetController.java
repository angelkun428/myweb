package com.kun.ranch.controller;

import com.kun.ranch.model.Pet;
import com.kun.ranch.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 页面宠物 REST API
 *
 * GET  /api/pets              获取所有宠物
 * GET  /api/pets/current      获取当前选中的宠物
 * POST /api/pets/select/{id}  选择某个宠物
 * GET  /api/pets/bubble       获取一句随机对话气泡
 */
@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping("/current")
    public Pet getCurrentPet() {
        return petService.getCurrentPet();
    }

    @PostMapping("/select/{petId}")
    public ResponseEntity<?> selectPet(@PathVariable String petId) {
        try {
            Pet pet = petService.selectPet(petId);
            return ResponseEntity.ok(pet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/bubble")
    public Map<String, String> getBubble() {
        return Map.of("text", petService.getRandomBubble());
    }
}
