package vn.iotstar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.iotstar.entity.Product;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContaining(String name);

    Page<Product> findByProductNameContaining(String name, Pageable
            pageable);

    Optional<Product> findByProductName(String name);

    Optional<Product> findByCreateDate(Date createAt);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT p FROM Product p ORDER BY p.quantity DESC LIMIT :limit")
    List<Product> findTopSellingProducts(@Param("limit") int limit);

    @Query("SELECT p FROM Product p WHERE p.createDate >= :startDate ORDER BY p.createDate DESC")
    List<Product> findRecentProducts(@Param("startDate") Date startDate);

}
