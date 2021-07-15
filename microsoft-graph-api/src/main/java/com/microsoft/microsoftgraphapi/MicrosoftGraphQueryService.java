package com.microsoft.microsoftgraphapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MicrosoftGraphQueryService {

    @Autowired
    RestTemplate restTemplate;
    private static final String BASE_URL = "https://graph.microsoft.com/v1.0/sites/580df74a-2f5f-4259-82b6-4fbed8c2ca2d/drive/list/items?expand=fields&$filter=";

    public String getData(List<Input> inputList) {
        String url = BASE_URL+ getURL(inputList);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Prefer", "HonorNonIndexedQueriesWarningMayFailRandomly");
        //try to add authorization token
        //headers.set("Prefer", "HonorNonIndexedQueriesWarningMayFailRandomly");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    //this method generates dynamic url for microsoft graph api with filters
    private String getURL(List<Input> inputList) {
        StringBuilder url = new StringBuilder();
        url.append("(");
        int size = inputList.size();
        for(int i=0 ; i < size ; i++) {
            if(i >= 1) {
                url.append(" and ");
            }
            url.append("(")
                    .append("fields/")
                    .append(inputList.get(i).getKey())
                    .append(" eq '")
                    .append(inputList.get(i).getValue())
                    .append("')");

        }
        url.append(")");
        return url.toString();
    }

}
