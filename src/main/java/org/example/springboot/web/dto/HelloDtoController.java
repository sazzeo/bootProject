package org.example.springboot.web.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDtoController {

    @GetMapping("/hello/dto")
    public HelloResponseDto returnDto(@RequestParam("name") String name
                        , @RequestParam("age") int age) {

        HelloResponseDto dto = new HelloResponseDto(name, age);

        return dto;
    }


}
