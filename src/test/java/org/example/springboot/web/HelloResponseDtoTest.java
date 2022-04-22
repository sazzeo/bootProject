package org.example.springboot.web;


import org.example.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {


    @Test
    public void lombokTest() {

        String name = "jee";
        int age = 27;

        HelloResponseDto dto = new HelloResponseDto(name , age);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAge()).isEqualTo(age);


    }


}
