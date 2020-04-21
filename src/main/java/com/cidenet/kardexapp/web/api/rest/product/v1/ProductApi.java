package com.cidenet.kardexapp.web.api.rest.product.v1;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.product.IEndpointProduct;
import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.commons.domains.response.builder.ResponseBuilder;
import com.cidenet.kardexapp.commons.enums.TransactionState;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.service.product.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EnpointApi.BASE_PATH)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ProductApi {
    private final IProductService productService;

    public ProductApi(IProductService productService) {
        this.productService = productService;
    }

    @ResponseBody
    @PostMapping(IEndpointProduct.CREATE_PRODUCT)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) throws SystemException {
        ProductEntity productReponse = productService.createProduct(productDTO);
        return ResponseBuilder.newBuilder()
                .withResponse(productReponse)
                .withPath(IEndpointProduct.CREATE_PRODUCT)
                .withMessage("successfully created")
                .withStatus(HttpStatus.CREATED)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }

    @ResponseBody
    @GetMapping(IEndpointProduct.GET_PRODUCTS)
    public ResponseEntity<?> getAll() {
        List<ProductEntity> productsReponse = productService.getAllProducts();
        return ResponseBuilder.newBuilder()
                .withResponse(productsReponse)
                .withPath(IEndpointProduct.GET_PRODUCTS)
                .withMessage("successful consultation")
                .withStatus(HttpStatus.OK)
                .withTransactionState(TransactionState.OK)
                .buildResponse();
    }
}
