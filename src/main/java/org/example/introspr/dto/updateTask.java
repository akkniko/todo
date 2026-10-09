package org.example.introspr.dto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public record updateTask(@RequestBody String title, @PathVariable Long id){};
