package com.example.beanvalidation.ds;

import com.example.beanvalidation.validation.NameNotAdmin;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NameNotAdmin(message = "Firstname Cannot Be Admin!")
    @NotEmpty(message = "{myapp.validation.msg.firstname}")
    private String firstName;
    @NotEmpty(message = "{myapp.validation.msg.lastname}")
    private String lastName;
    @Min(value = 18, message = "{myapp.validation.msg.minage}")
    @Max(value = 60, message = "{myapp.validation.msg.maxage}")
    private int age;
    @Email(message = "Invalid Email Format!")
    @NotEmpty(message = "{myapp.validation.msg.email}")
    private String email;
    private LocalDate orderDate;
    private LocalDate paymentDate;
}
