package hu.consumeSoldierAPI.services;

import hu.consumeSoldierAPI.domain.Soldier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SoldierService {

    @Autowired
    private RestTemplate restTemplate;
    private final String REST_URL = "http://localhost:8080/soldiers";

    public List<Soldier> getSoldiers() {
        String url = REST_URL;
        Soldier[] soldiers = restTemplate.getForObject(url, Soldier[].class);
        return Arrays.asList(soldiers);
    }

    public Soldier getSoldier(int id) {
        String url = REST_URL+"/{id}";
        Soldier soldier = restTemplate.getForObject(url, Soldier.class, id);
        return soldier;
    }

    public int addSoldier(String rank, String birth, String weapon, int shotpeople) {
        String url = REST_URL;
        Soldier soldier = new Soldier(rank, birth, weapon, shotpeople);
        HttpEntity<Soldier> requestEntity = new HttpEntity<>(soldier);
        ResponseEntity<Soldier> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Soldier.class);
        return responseEntity.getStatusCodeValue();
    }
}
