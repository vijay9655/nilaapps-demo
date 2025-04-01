package src.main.java.com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import src.main.java.com.example.demo.model.PriceGridmodal;
import src.main.java.com.example.demo.service.PriceGridService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prices")
// @CrossOrigin(origins = "http://localhost:3000")  // Allow React frontend
public class PriceController {
    @Autowired
    private PriceGridService priceGridService;

    @GetMapping("/test/{id}")
    public ResponseEntity<Map<String, Object>> getPrice(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("message", "Price details for ID: " + id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPrices() {
        List<PriceGridmodal> prices = priceGridService.getAllPrices();
        Map<String, Object> response = new HashMap<>();
        response.put("status", 200);
        response.put("response", prices);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{heightTo}")
    public ResponseEntity<Map<String, Object>> getPricesByHeight(@PathVariable int heightTo) {
        List<PriceGridmodal> prices = priceGridService.getPricesByHeight(heightTo);
        Map<String, Object> response = new HashMap<>();
        if (prices.isEmpty()) {
            response.put("status", 404);
            response.put("message", "No prices found for height: " + heightTo);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("status", 200);
        response.put("response", prices);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addPrice(@RequestBody PriceGridmodal priceGrid) {
        PriceGridmodal savedPrice = priceGridService.addPrice(priceGrid);
        Map<String, Object> response = new HashMap<>();
        response.put("status", 201);
        response.put("response", savedPrice);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
