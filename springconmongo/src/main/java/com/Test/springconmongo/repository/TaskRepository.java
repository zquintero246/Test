package com.Test.springconmongo.repository;

import com.Test.springconmongo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}

