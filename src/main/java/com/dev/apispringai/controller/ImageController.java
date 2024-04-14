package com.dev.apispringai.controller;

import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageClient imageClent;

    public ImageController(ImageClient imageClent) {
        this.imageClent = imageClent;
    }
    @GetMapping
    public String getUrlImage(@RequestParam("message") String message){
        return this.imageClent
                .call(new ImagePrompt(message))
                .getResult()
                .getOutput().getUrl();
    }
}
