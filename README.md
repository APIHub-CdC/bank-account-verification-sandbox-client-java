# Bank Account Verification Sandbox

Acccount validator sandboox

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/bavs/client/api/BankAccountVerificationApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
private String url = "https://circulodecredito-dev.apigee.net/sandbox/v1/bavs/accountValidator";

 @Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath(url);
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build();
		apiClient.setHttpClient(okHttpClient);
	}
```

En el archivo **BankAccountVerificationApiTest.java**, que se encuentra en ***src/test/java/io/bavs/client/api/BankAccountVerificationApiTest.java*** se deberá modificar el siguiente fragmento de código con los datos correspondientes:

```java

  @Test
	public void accountValidatorAPITest() throws Exception {
		
		String xApiKey = this.xApiKey;
		AccountValidatorWithPrivacyNotice request = new AccountValidatorWithPrivacyNotice() ;
		AccountValidator accountValidator = new AccountValidator();
		
		accountValidator.setExternalId(uuid);
		accountValidator.setSubscriptionId(UUID.fromString("your_suscription_id"));
		accountValidator.setBankId(CatalogBank.NUMBER_40012);
		accountValidator.setAccountType(AccountTypeEnum.CLABE);
		accountValidator.setAccountIdentifier("012180015543448001");
		accountValidator.setFirstName("ANGEL");
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
		String inquiryId = "your_inquiry_id";
		AckSuccessEVConsumption response = api.getAcountValidator(xApiKey, inquiryId);
		
		logger.info(response.toString());
		
		Assert.assertNotNull(response);
	}
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```