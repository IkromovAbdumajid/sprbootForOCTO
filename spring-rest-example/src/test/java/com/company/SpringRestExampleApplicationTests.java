package com.company;

import com.company.controller.CardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringRestExampleApplicationTests {
//    @Autowired
//    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9090/card/test/str", String.class);
        System.out.println(result);
    }

    @Test
    void getCardByNumber() {
        // 123123128
        RestTemplate restTemplate = new RestTemplate();
        CardDTO result = restTemplate.getForObject("http://localhost:9090/card/number/123123128",
                CardDTO.class);
        System.out.println(result);
    }

    @Test
    void requestParamTest() {
        // 123123128
        int pegajon = 1;
        int s = 10;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9090/card/test/" +
                "param?size={s}&page={p}", String.class, s, pegajon);
        System.out.println(result);
    }


    @Test
    void getCardByNumber_2() {
        // 123123128
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CardDTO> result = restTemplate.getForEntity("http://localhost:9090/card/number/123123128",
                CardDTO.class);

        System.out.println(result.getBody());
        System.out.println(result.getStatusCode());
        System.out.println(result.getStatusCodeValue());
        System.out.println(result.getHeaders());
    }

    @Test
    void create_card() {
        // 123123128
        CardDTO dto = new CardDTO();
        dto.setExpDate("12/12");
        dto.setProfileId(1L);
        dto.setNumber("1233545745");

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject("http://localhost:9090/card/",
                dto,
                String.class);

        System.out.println(result);
    }

    @Test
    void create_card2() {
        // 123123128
        CardDTO dto = new CardDTO();
        dto.setExpDate("12/12");
        dto.setProfileId(1L);
        dto.setNumber("1233545745");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CardDTO> result = restTemplate.postForEntity("http://localhost:9090/card/",
                dto,
                CardDTO.class);

        System.out.println(result.getBody());
    }

    @Test
    void update_card() {
        // 123123128
        CardDTO dto = new CardDTO();
        dto.setExpDate("12/12");
        dto.setProfileId(1L);
        dto.setNumber("1233545745");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:9090/card/19", dto);
    }

    @Test
    void delete_card() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:9090/card/19");
    }

    @Test
    void header_test() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        int pagejon=1;
        int s=10;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:9090/card/test/" +
                        "param?size={s}&page={p}",
                HttpMethod.GET,
                entity,
                String.class,s,pagejon);
        System.out.println(result);
    }
}
