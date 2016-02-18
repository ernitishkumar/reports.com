package com.mongo.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mongo.utility.GlobalResources;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CollectionDAO {
	private MongoDatabase mongoDatabase=GlobalResources.getDatabase("mydb");
	private MongoCollection<Document> userCollection = null;
	private Gson gson=new Gson();
	public String getAll(String collectionName){
		StringBuffer data=new StringBuffer();
		data.append("[");
		String listData="";
		try {
			userCollection=mongoDatabase.getCollection(collectionName);
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
			System.out.println("Exception in class : CollectionDAO : method : [getAll(String)]"+me);
		} 
		//return data.toString();
		return listData;
	}
}
