package microservicetest.anis;
//
//import acclime.account.api.config.OpenAPIConfiguration;
//import acclime.account.api.document.model.DocResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import nomad.npe.common.exceptions.ModelNotFoundException;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/document")
//@Slf4j
//public class DocumentController {
//
//  private final DocumentService documentService;
//
//  @Operation(security = { @SecurityRequirement(name = OpenAPIConfiguration.securitySchemeName) })
//  @GetMapping()
//  public @ResponseBody
//  List<DocResponse> getDocumentList(Authentication authentication) throws ModelNotFoundException {
//    log.debug("Getting document list user={}", authentication.getName());
//    return documentService.getDocumentList();
//  }
//
////  @Operation(security = { @SecurityRequirement(name = OpenAPIConfiguration.securitySchemeName) })
////  @GetMapping(path = "/{key}")
////  public @ResponseBody
////  CreditCard getCreditCardByKey(@PathVariable String key) throws ModelNotFoundException {
////    log.debug("Getting credit card by key={}", key);
////    return documentService.getCreditCardByKey(key);
////  }
////
////  @Operation(security = { @SecurityRequirement(name = OpenAPIConfiguration.securitySchemeName) })
////  @PutMapping()
////  public @ResponseBody
////  CreditCardCreated addCreditCard(Authentication authentication,
////                                  @RequestBody CreateCreditCard createCreditCard) {
////    log.debug("Getting creditCard={}", createCreditCard);
////    return documentService.createCreditCard(authentication.getName(), createCreditCard);
////  }
////
////  @Operation(security = { @SecurityRequirement(name = OpenAPIConfiguration.securitySchemeName) })
////  @PostMapping(value = "/search")
////  public @ResponseBody
////  SearchResult<CreditCard> search(@RequestBody SearchRequest searchRequest) {
////    log.debug("Searching credit cards searchRequest={}", searchRequest);
////    return documentService.searchCreditCard(searchRequest);
////  }
////
////  @Operation(security = { @SecurityRequirement(name = OpenAPIConfiguration.securitySchemeName) })
////  @PostMapping
////  @ResponseStatus(HttpStatus.CREATED)
////  public @ResponseBody
////  CreditCardCreated createCreditCard(Authentication authentication,
////                               @RequestBody CreateCreditCard createCreditCard)
////      throws NomadValidationFailedException, NomadCommonException {
////    log.debug("Creating credit card={} user={}", createCreditCard, authentication.getName());
////    return documentService.createCreditCard(authentication.getName(), createCreditCard);
////  }
//
//
//}
