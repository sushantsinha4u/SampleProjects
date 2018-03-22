package com.example.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private MongoClient mongoClient;
  
    @Value("${spring.data.mongodb.database}")
    private String mongoDBDetails;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        MongoDatabase database = mongoClient.getDatabase(mongoDBDetails);
        MongoCollection<Document> collection = database.getCollection("users");
        Document document = collection.find(Filters.eq("email",email)).first();
        if(document!=null) {
            String name = document.getString("name");
            String surname = document.getString("surname");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");          
            MongoUserDetails mongoUserDetails = new MongoUserDetails(email,passwordEncoder.encode(password),authorities.toArray(new String[authorities.size()]));
            return mongoUserDetails;
        }
        return null;
    }
}