package com.imgtransfer.backend;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImgController {

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImg(HttpServletResponse response) throws IOException {

        ClassPathResource image = new ClassPathResource("image/shiba.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(image.getInputStream(), response.getOutputStream());
        log.info("Image retrived");
    }

}
