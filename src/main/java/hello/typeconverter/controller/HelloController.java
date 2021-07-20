package hello.typeconverter.controller;

import hello.typeconverter.converter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest req) {
        String data = req.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("data =" + intValue);

        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        log.info("data : {}", data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public ResponseEntity<?> ipPort(@RequestParam IpPort ipPort) {
        log.info("ip : {}", ipPort);
        return ResponseEntity.ok().body(ipPort);
    }

}
