package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class GreetingController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${name}")
    private String name;

    @Value("${country}")
    private String country;



    @RequestMapping("/greeting/{pathVariable}")
    public Greeting greeting(@PathVariable("pathVariable") String pathVariable) {
        System.out.println(name);
        String value = "default value";
        if(pathVariable.equalsIgnoreCase("name")) value = name;
        else if (pathVariable.equalsIgnoreCase("country")) value = country;
        return new Greeting(counter.incrementAndGet(),String.format(template, value));
    }
}
