package com.jianli.SpringRest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jianli.Model.Greeting;


@RestController
public class APIController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    //first hello world example
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    //using get
    @RequestMapping(value="/greeting/{content}/{id}",method=RequestMethod.GET, produces="application/json")
    public Greeting greetingGet(@PathVariable String content,@PathVariable long id) {
        return new Greeting(id,content);
    }

    //using post  
	@RequestMapping(value="/greetingPost/hello", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Greeting  greetingPost(@RequestBody Greeting greeting){
		
		greeting.setContent("jianliPost");	
		return greeting;
		
	}
}
	