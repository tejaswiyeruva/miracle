package com.product.product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class test {
    private productservice cubeService = new productservice();

    @Test
    public void testCalculateCube() {
        assertEquals(8, cubeService.calculateCube(2));
        assertEquals(27, cubeService.calculateCube(3));
        assertEquals(64, cubeService.calculateCube(4));
    }
    public void testing(){
        assertEquals(cubeService, cubeService);
    }

}

