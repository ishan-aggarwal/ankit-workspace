//package microservicetest.anis;
//
//import acclime.account.api.document.model.DocResponse;
//import acclime.account.api.document.model.SharepointDocumentResponse;
//import com.google.common.collect.Lists;
//import java.util.Collections;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//import org.apache.commons.logging.Log;
//import org.jooq.DSLContext;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class DocumentService {
//
//  private final DSLContext dsl;
//  private final ModelMapper modelMapper;
//
//  @Value("${ms.o365.accessToken}")
//  private String accessKey;
//
//  private HttpHeaders headers(String accessKey) {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setBearerAuth(accessKey);
//    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//    return headers;
//  }
//
//  public List<DocResponse> getDocumentList() {
//    String url = "https://graph.microsoft.com/v1.0/sites/580df74a-2f5f-4259-82b6-4fbed8c2ca2d/lists/Documents/items?expand=fields";
//
//    final RestTemplate restTemplate = new RestTemplate();
//
//    HttpEntity<String> entity = new HttpEntity<>(headers(accessKey));
//    ResponseEntity<SharepointDocumentResponse> exchange =
//        restTemplate.exchange(url, HttpMethod.GET, entity, SharepointDocumentResponse.class);
//
//    if (exchange.getBody() != null) {
//      return exchange.getBody().getValue();
//    } else {
//      // TODO - should we throw a error here instead?
//      log.error("The response was null, returning null");
//      return Lists.newArrayList();
//    }
//
//  }
//
//}
