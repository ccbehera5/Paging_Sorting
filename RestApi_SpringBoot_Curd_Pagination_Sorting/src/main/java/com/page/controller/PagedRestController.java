package com.page.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.entity.UserEntity;
import com.page.repository.UserRepository;
 
@RestController
@RequestMapping("/get")
public class PagedRestController {
 
    // links automatically created repository bean in
    // Spring Application context
    @Autowired UserRepository data;
 
    @GetMapping("/page-One")
    public List<UserEntity> getPageOne()
    {
 
        // First page with 5 items
        Pageable paging = PageRequest.of(0, 5, Sort.by("id").ascending());
        Page<UserEntity> page = data.findAll(paging);
 
        // Retrieve the items
        return page.getContent();
    }
 
    @GetMapping("/page-Two")
    public List<UserEntity> getPageTwo()
    {
 
        // Second page with another 5 items
        Pageable paging = PageRequest.of(1, 5, Sort.by("id").ascending());
        Page<UserEntity> page = data.findAll(paging);
 
        // Retrieve the items
        return page.getContent();
    }
}
