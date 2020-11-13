package com.killvung.frontsyncstrava.repository;

import com.killvung.frontsyncstrava.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {}
