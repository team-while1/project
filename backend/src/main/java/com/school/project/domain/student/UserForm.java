package com.school.project.domain.student;


import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserForm {
    @Min(value = 1000000, message = "학번은 7자리여야 합니다.")
    @Max(value = 9999999, message = "학번은 7자리여야 합니다.")
    @NotEmpty(message = "학번을 입력해주세요.")
    private Long id;

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotEmpty(message = "비밀번호 확인을 위해 입력해주세요.") // TODO : 일단 이렇게 하고 -> 프론트 단에서 입력값 바로바로 확인
    private String password2;

    @Email(message = "이메일은 입력해주세요.")
    private String email;
}
