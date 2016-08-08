package com.example.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sumi on 2/8/16.
 */
//@org.springframework.stereotype.Service
@Service
public class DatabaseService {

    @Autowired
    DatabaseRepository databaseRepository;
}
