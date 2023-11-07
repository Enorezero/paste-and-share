package ru.enorezero.paste.and.share.pasteservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.enorezero.paste.and.share.pasteservice.payload.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.payload.response.PasteResponse;
import ru.enorezero.paste.and.share.pasteservice.service.PasteService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@Data
@RequestMapping("/paste")
public class PasteController {

    @Autowired
    PasteService service;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("succesfully!");
    }

    @GetMapping("/{hash}")
    public ResponseEntity<PasteResponse> getByHash(@PathVariable String hash){
        return ResponseEntity.ok(service.getByHash(hash));
    }

    @GetMapping("/")
    public ResponseEntity<List<PasteResponse>> getLastPublic(){
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<String> createPaste(@RequestBody PasteRequest request){
        return ResponseEntity.ok(service.createPaste(request));
    }
}
