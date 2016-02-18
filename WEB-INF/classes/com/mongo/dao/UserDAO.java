package com.mongo.dao;

import java.util.ArrayList;
import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mongo.utility.GlobalResources;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserDAO {
	private MongoDatabase mongoDatabase=GlobalResources.getDatabase("mydb");
	private MongoCollection<Document> userCollection = mongoDatabase.getCollection("users");
	private Gson gson=new Gson();
	
    public String getAll(String collectionName){
		StringBuffer data=new StringBuffer();
		data.append("[");
		String listData="";
		try {
			FindIterable<Document> users=userCollection.find();
			ArrayList<Document> usersTwo=new ArrayList<Document>();
			for(Document d: users){
				data.append(d.toJson()).append(",");
				usersTwo.add(d);
			}
			data.append("]");
			JsonElement je=gson.toJsonTree(usersTwo, new TypeToken<ArrayList<Document>>(){}.getType());
			JsonArray ja=null;
			if(je.isJsonNull()){
				listData="Got new impl as null";
			}else if(je.isJsonObject()){
				listData="Got new impl as jsonobject";
			}else if(je.isJsonArray()){
				ja=je.getAsJsonArray();
				listData="Got as json array : "+ja.get(0).toString();
			}
		} catch (MongoException me) {
			System.out.println("Exception in class : UserDAO : method : [getAll(String)]"+me);
		} 
		//return data.toString();
		return listData;
	}
    
    public Document getByUsername(String username){
    	Document user=null;
    	try{
    		Document query=new Document();
    		query.append("username", username);
    		FindIterable<Document> users=userCollection.find(query);
    		for(Document d:users){
    			user=d;
    		}
    	}catch(MongoException me){
    		System.out.println("Exception in class : UserDAO : method : [getByUsername(String)]"+me);
    	}
    	return user;
    }
    
}
