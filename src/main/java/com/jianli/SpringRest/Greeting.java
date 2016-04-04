package com.jianli.SpringRest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hello world!
 *
 */
public class Greeting 
{
	@JsonProperty("id")
	private  long id;
	
	@JsonProperty("content")
    private  String content;

 
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Greeting(){
		
	}
	
    @JsonCreator
    public Greeting(@JsonProperty("id") long id, @JsonProperty("content") String content) {
    	this.id = id;
		this.content = content;
    } 

	
	
	
	

    
    
}
