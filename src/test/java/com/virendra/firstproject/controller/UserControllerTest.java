package com.virendra.firstproject.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.virendra.firstproject.entity.Users;
import com.virendra.firstproject.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService service;

    @Test 
    public void testAddNewUser() throws Exception{
        
        Users user = new Users(2, "testuser", "6598745632", "test@example.com", "5", "Banglore");


        doNothing().when(service).saveUser(user);

    }

    @Test
    void testDeleteUser() {

        doNothing().when(service).deleteUserById(2);
    }

    @Test
    void testGetAllUsers() {
        
        Users user1 = new Users(2, "testuser", "6598745632", "test@example.com", "5", "Banglore");
        
        Users user2 = new Users(3, "testuser2", "6598745662", "test2@example.com", "5", "Banglore");

        List<Users> users = new ArrayList<Users>();
        users.add(user1);
        users.add(user2);

        when(service.getAllUser()).thenReturn(users);
    }

    @Test
    void testSaveUser() {

        Users user = new Users(2, "testuser", "6598745632", "testUpdated@example.com", "5", "Banglore");


        doNothing().when(service).saveUser(user);
    }
}
