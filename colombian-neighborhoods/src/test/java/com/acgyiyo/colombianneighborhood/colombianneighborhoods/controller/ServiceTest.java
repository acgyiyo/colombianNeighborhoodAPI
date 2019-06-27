package com.acgyiyo.colombianneighborhood.colombianneighborhoods.controller;

import com.acgyiyo.colombianneighborhood.controller.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest{

  @Autowired
  Service service;

  @Test
  public void testWelcome(){
    
  }

}