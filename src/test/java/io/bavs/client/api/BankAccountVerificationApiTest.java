package io.bavs.client.api;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.bavs.client.ApiClient;
import io.bavs.client.model.AccountValidator;
import io.bavs.client.model.AccountValidator.AccountTypeEnum;
import io.bavs.client.model.AccountValidator.IdentifierTypeEnum;
import io.bavs.client.model.AccountValidatorWithPrivacyNotice;
import io.bavs.client.model.AckEVRequest;
import io.bavs.client.model.AckSuccessEVConsumption;
import io.bavs.client.model.CatalogBank;
import okhttp3.OkHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BankAccountVerificationApiTest {
	
	private final BankAccountVerificationApiApi api = new BankAccountVerificationApiApi();
	
	private Logger logger = LoggerFactory.getLogger(BankAccountVerificationApiTest.class.getName());
	private ApiClient apiClient = null;
	
	private String xApiKey = "your_api_key";
    private String url = "https://circulodecredito-dev.apigee.net/sandbox/v1/bavs/accountValidator";
    
    private UUID uuid = UUID.randomUUID();
    
	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build();
		apiClient.setHttpClient(okHttpClient);
	}
	
	
	
	@Test
	public void accountValidatorAPITest() throws Exception {
		
		String xApiKey = this.xApiKey;
		AccountValidatorWithPrivacyNotice request = new AccountValidatorWithPrivacyNotice() ;
		AccountValidator accountValidator = new AccountValidator();
		
		accountValidator.setExternalId(uuid);
		accountValidator.setSubscriptionId(UUID.fromString("d7b3a117-4cf4-46ce-b255-03e895bef671"));
		accountValidator.setBankId(CatalogBank.NUMBER_40012);
		
		accountValidator.setAccountType(AccountTypeEnum.PERSONAFISICA);
		accountValidator.setIdentifierType(IdentifierTypeEnum.CLABE);
		accountValidator.setAccountIdentifier("012180015543448001");
		accountValidator.setName("ANGEL");
		accountValidator.setSecondName("JESUS");
		accountValidator.setLastName("PEREZ");
		accountValidator.setSecondLastName("CORDONA");
		
		accountValidator.setTaxPayerIdentificationNumber("PECA881229HG9");
		accountValidator.setVerifierCompany("CDC");
		
		request.setAccountValidator(accountValidator);
		
		
		AckEVRequest response = api.accountValidatorAPI(xApiKey, request);
		
		logger.info(response.toString());
		
		Assert.assertTrue(response != null);
		
		
	}
	
	
	@Test
	public void getAcountValidatorTest() throws Exception {
		String xApiKey =this.xApiKey;
		String inquiryId = this.uuid.toString();
		AckSuccessEVConsumption response = api.getAcountValidator(xApiKey, inquiryId);
		
		logger.info(response.toString());
		
		Assert.assertNotNull(response);
	}
	

}
