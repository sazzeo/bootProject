package org.example.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {


    //JpaRepository에서 findBy 로시작하며 뒤가 Entity에 등록된 필드변수 이름이면 알아서 찾아주는 기능이 있음.
    Optional<Users> findByEmail(String email);

}
