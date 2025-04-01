package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private BinarySearchService binarySearchService;

    @PostMapping("/binary-search")
    public ResponseEntity<?> binarySearch(@RequestBody SearchRequest request) {
        int result = binarySearchService.binarySearch(request.getArray(), request.getTarget());
        return ResponseEntity.ok(Map.of(
            "result", result == -1 ? "Not Found" : "Found at index " + result
        ));
    }
}

class SearchRequest {
    private int[] array;
    private int target;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
