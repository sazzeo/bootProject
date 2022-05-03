package org.example.springboot.web.test;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.test.TestServcie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final TestServcie testServcie;

    @GetMapping("/test/get")
    @ResponseBody
    public List<TestDto> getTest() {

        List<TestDto> testDto = testServcie.findAllDesc();
        System.out.println(testDto);
        return testDto;
    }

}
