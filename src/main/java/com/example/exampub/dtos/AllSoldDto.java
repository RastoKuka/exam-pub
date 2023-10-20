package com.example.exampub.dtos;

import com.example.exampub.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class AllSoldDto {
private List<Product> productsSold;
}
