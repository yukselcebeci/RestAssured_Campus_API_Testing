import Models.DocumentType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DocumentTypeTest extends Hooks{
    DocumentType documentType;
    Response response;

    @Test(priority = 1)
    public void createDocumentType(){
        documentType=new DocumentType();
        documentType.setName(randomDocumentTypeName());
        response = given()
                .contentType(ContentType.JSON)
                .spec(requestSpec)
                .body(documentType)
                .when()
                .post("/school-service/api/attachments/create")
                .then()
                .statusCode(201)
                .spec(responseSpec)
                .extract().response();
    }


    @Test(priority = 2)
    public void createDocumentTypeNegative(){
        documentType.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(documentType)
                .when()
                .post("/school-service/api/attachments/create")
                .then()
                .statusCode(400)
                .spec(responseSpec);

    }

    @Test(priority = 3)
    public void getDocumentType(){
        documentType.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(documentType)
                .when()
                .post("/school-service/api/attachments/search")
                .then()
                .statusCode(200)
                .spec(responseSpec);


    }

    @Test(priority = 4)
    public void updateDocumentType(){
        documentType.setName(randomDocumentTypeName());
        documentType.setId(response.jsonPath().getString("id"));
       given()
                .spec(requestSpec)
                .body(documentType)
                .when()
                .put("/school-service/api/attachments")
                .then()
                .statusCode(200)
                .spec(responseSpec);
    }

    @Test(priority = 5)
    public void deleteDocumentType(){
        given()
                .pathParam("DocumentTypeId",response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attachments/{DocumentTypeId}")
                .then()
                .statusCode(200)
                .log().body();
    }


    @Test(priority = 6)
    public void deleteDocumentNegative(){
        given()
                .pathParam("DocumentTypeId",response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attachments/{DocumentTypeId}")
                .then()
                .statusCode(400)
                .log().body();



    }
    @Test(priority = 7)
    public void getDocumentTypeAfterDelete(){
        documentType.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(documentType)
                .when()
                .post("/school-service/api/attachments/search")
                .then()
                .statusCode(200)
                .spec(responseSpec);
    }
    public String randomDocumentTypeName() {
        return RandomStringUtils.randomAlphabetic(7);
    }
}
