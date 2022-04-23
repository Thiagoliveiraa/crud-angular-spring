package com.thiago.crudspring.controllers;

import java.util.List;

import com.thiago.crudspring.model.Course;
import com.thiago.crudspring.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/courses")
// @AllArgsConstructor
public class CourseController {
  

  //outra boa prática é que se não estamos modificando a instancia, apenas injetando então podemos considerar este atributo como final para que não ocorra nenhum acidente nele na hora de codificar que vai alterar esta instancia

  @Autowired
  private CourseRepository courseRepository;

  /*TODO: BOA prática segundo Loiane atualmente é melhor o spring fazer uma injeção via construtor quando há um atributo obrigatorio pois na hora que instanciar um controller terá a necessidade de ter uma  instancia do repository também, no caso via construtor não precisa ter a anotation autowired para o spring instanciar e cuidar do ciclo de vida desta instancia
  */

  @GetMapping
  public List<Course> list(){
    return courseRepository.findAll();
  }
}
