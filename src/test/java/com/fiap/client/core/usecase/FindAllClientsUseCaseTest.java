//package com.fiap.client.core.usecase;
//
//import com.fiap.client.core.entity.Client;
//import com.fiap.client.core.gateway.ClientGateway;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class FindAllClientsUseCaseTest {
//
//    @Mock
//    private ClientGateway clientGateway;
//
//    @InjectMocks
//    private FindAllClientsUseCase findAllClientsUseCase;
//
//    @Test
//    void shouldFindAllProducts() {
//        var product1 = new Client("123456", "Product Name", BigDecimal.TEN, "Product Description", Category.ELECTRONICS);
//        var product2 = new Client("654321", "Product Name 2", BigDecimal.TWO, "Product Description 2", Category.BOOKS);
//        var products = Set.of(product1, product2);
//
//        when(clientGateway.findAll()).thenReturn(products);
//
//        var result = findAllClientsUseCase.execute();
//        verify(clientGateway).findAll();
//        assertThat(result).hasSize(2);
//    }
//}
