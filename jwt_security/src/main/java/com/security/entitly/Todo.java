package com.security.entitly;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;

     @Schema(name ="title",example = "should be a string")
     String title;
   

 
     String description;
     Boolean isCompleted;
}


//@min and max for number

//package com.security.entitly;
//
//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Todo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//	Long id;
//    @NotBlank
//    @NotNull
//     @Schema(name ="title",example = "should be a string")
//     String title;
//    @NotBlank
//    @NotNull
////    should use size for string
//    @Size(min = 1,max = 100)
//     String description;
//     Boolean isCompleted;
//}
//
//
////@min and max for number