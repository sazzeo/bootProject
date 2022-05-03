package org.example.springboot.service.test;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.test.MyTestTable;
import org.example.springboot.domain.test.MyTestTableRepository;
import org.example.springboot.web.dto.PostsListResponseDto;
import org.example.springboot.web.test.TestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TestServcie {

    private final MyTestTableRepository testRepository;


    @Transactional
    public List<TestDto> findAllDesc() {

        List<MyTestTable> testTable = testRepository.findAllDesc();
        return testRepository.findAllDesc().stream().map(TestDto::new).collect(Collectors.toList());

    }

}
