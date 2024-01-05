package Test.project.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {

    private String mobilenumber;

    private String password;
}