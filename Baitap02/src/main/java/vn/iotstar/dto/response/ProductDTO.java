package vn.iotstar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private String images;
    private String description;
    private double discount;
    private short status;
    private Date createDate;
}

