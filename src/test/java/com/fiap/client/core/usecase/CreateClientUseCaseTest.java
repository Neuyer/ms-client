//package com.fiap.client.core.usecase;
//
//import com.fiap.client.core.dto.CreateClientDTO;
//import com.fiap.client.core.entity.Client;
//import com.fiap.client.core.gateway.ClientGateway;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class CreateClientUseCaseTest {
//
//    @Mock
//    private ClientGateway clientGateway;
//
//    @InjectMocks
//    private CreateClientUseCase createClientUseCase;
//
//    @Test
//    void shouldCreateProduct() {
//        var createProductDTO = new CreateClientDTO(
//                "123456",
//                "Product Name",
//                "Product Description",
//                "ELECTRONICS",
//                BigDecimal.TEN
//        );
//
//        when(clientGateway.findBySku("123456")).thenReturn(Optional.empty());
//        doNothing().when(clientGateway).save(any(Client.class));
//
//        var product = createClientUseCase.execute(createProductDTO);
//
//        verify(clientGateway, times(1)).findBySku("123456");
//        assertThat(product.getSku()).isEqualTo("123456");
//        assertThat(product.getName()).isEqualTo("Product Name");
//        assertThat(product.getDescription()).isEqualTo("Product Description");
//        assertThat(product.getCategory()).isEqualTo(Category.ELECTRONICS);
//        assertThat(product.getPrice()).isEqualTo(BigDecimal.TEN);
//    }
//
//    @Test
//    void shouldReturnSkuExists() {
//        var createProductDTO = new CreateClientDTO(
//                "123456",
//                "Product Name",
//                "Product Description",
//                "ELECTRONICS",
//                BigDecimal.TEN
//        );
//
//        var product = new Client("123456", "Product Name", BigDecimal.TEN, "Product Description", Category.ELECTRONICS);
//        when(clientGateway.findBySku("123456")).thenReturn(Optional.of(product));
//
//        var exception = catchThrowable(() -> createClientUseCase.execute(createProductDTO));
//
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Product with SKU already exists");
//    }
//}
