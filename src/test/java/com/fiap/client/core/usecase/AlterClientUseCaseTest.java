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
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class AlterClientUseCaseTest {
//
//    @Mock
//    private ClientGateway clientGateway;
//
//    @InjectMocks
//    private AlterClientUseCase alterClientUseCase;
//
//    @Test
//    void shouldAlterProduct() {
//        var createProductDTO = new CreateClientDTO(
//                "123456",
//                "Video Game",
//                "Playstation 5 Serie X",
//                "ELECTRONICS",
//                BigDecimal.TEN
//        );
//
//        var product = new Client(
//                "idProduct",
//                "123456",
//                "Video Game",
//                BigDecimal.ONE,
//                "Playstation 5",
//                Category.ELECTRONICS
//        );
//
//        when(clientGateway.findBySku("123456")).thenReturn(Optional.of(product));
//
//        var result = alterClientUseCase.execute(createProductDTO);
//
//        verify(clientGateway, times(1)).save(any(Client.class));
//        assertThat(result.getId()).isEqualTo("idProduct");
//        assertThat(result.getSku()).isEqualTo("123456");
//        assertThat(result.getName()).isEqualTo("Video Game");
//        assertThat(result.getPrice()).isEqualTo(BigDecimal.TEN);
//        assertThat(result.getDescription()).isEqualTo("Playstation 5 Serie X");
//        assertThat(result.getCategory()).isEqualTo(Category.ELECTRONICS);
//    }
//
//    @Test
//    void shouldReturnProductNotFoundException() {
//        var createProductDTO = new CreateClientDTO(
//                "123456",
//                "Video Game",
//                "Playstation 5 Serie X",
//                "ELECTRONICS",
//                BigDecimal.TEN
//        );
//
//        when(clientGateway.findBySku("123456")).thenReturn(Optional.empty());
//
//        var exception = catchThrowable(() -> alterClientUseCase.execute(createProductDTO));
//
//        verify(clientGateway, times(0)).save(any(Client.class));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Product not found with SKU: 123456");
//    }
//}
